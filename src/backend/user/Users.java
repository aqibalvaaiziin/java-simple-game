package backend.user;

import backend.bag.Bag;
import backend.db.DBHelper;
import backend.hero.Melee;
import frontend.Hero;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Users {
    
    public int idUser;
    public String username;
    public Melee hero = new Melee();
    public Bag bag = new Bag();

    public Users() {
    }

    public Users(Melee hero, Bag bag, String username) {
        this.bag = bag;
        this.username = username;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }
    
    public Melee getHero() {
        return hero;
    }

    public void setHero(Melee hero) {
        this.hero = hero;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
    
    public Users getDataById(int id){
        Users user = new Users();
        Hero h;
        ResultSet rs = DBHelper.selectQuery("Select u.idUser , u.username, h.heroName, h.hp, b.bagName from user u inner join hero h on u.idHero = h.idHero inner join bag b on u.idBag = b.idBag where u.idUser = '"+id+"'");
        try {
            while(rs.next()){
                user = new Users();
                user.setIdUser(rs.getInt("idUser"));
                user.setUsername(rs.getString("username"));
                user.getHero().setHeroName(rs.getString("heroName"));
                user.getBag().setBagName(rs.getString("bagName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public ArrayList<Users> getAll(){
        ArrayList<Users> ListUser = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("Select u.idUser , u.username, h.heroName, b.bagName from user u inner join hero h on u.idHero = h.idHero inner join bag b on u.idBag = b.idBag");
        try {
            while(rs.next()){
                Users user = new Users();
                user.setIdUser(rs.getInt("idUser"));
                user.setUsername(rs.getString("username"));
                user.getHero().setHeroName(rs.getString("heroName"));
                user.getBag().setBagName(rs.getString("bagName"));
                ListUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListUser;
    }
    
    public void save(){
        if(getDataById(idUser).getIdUser() == 0){
            String sql = "insert into user (idHero,idBag,username) values ('"+this.getHero().getIdHero()+"','"+this.getBag().getIdBag()+"','"+this.getUsername()+"')";
            this.idUser = DBHelper.insertQueryGetId(sql);
        }
        else{
            String sql = "update user set idHero = '"+this.getHero().getIdHero()+"', idBag = '"+this.getBag().getIdBag()+"', username = '"+this.getUsername()+"' where idUser = '"+idUser+"'";
            DBHelper.executeQuery(sql);
        }
    } 
    
    public void delete(){
        String sql = "Delete From user where idUser = '"+idUser+"'";
        DBHelper.executeQuery(sql);
    }
   
}
