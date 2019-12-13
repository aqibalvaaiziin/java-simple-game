package backend.hero;

import backend.db.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Melee extends Hero{

    public String role = "Melee";

    public Melee() {
    }
        
    public Melee(String heroName, String role, HeroData dataHero, int hp, int atk, int spd, int dfc) {
        super(heroName, dataHero,hp,atk,spd,dfc);
        this.role = role;
    }

    @Override
    void heroSpec() {
        dataHero.printHeroData(heroName, role, hp, atk, spd, dfc);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    public Hero getDataById(int id){
        Melee mele = new Melee();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM hero WHERE idHero = '" + id + "'");
        try {
            while (rs.next()) {
                mele = new Melee();
                mele.setIdHero(rs.getInt("idHero"));
                mele.setHeroName(rs.getString("heroName"));
                mele.setHp(rs.getInt("hp"));
                mele.setRole(rs.getString("role"));
                mele.setAtk(rs.getInt("atk"));
                mele.setSpd(rs.getInt("spd"));
                mele.setDfc(rs.getInt("dfc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mele;
    }
    
    
    
    public ArrayList<Melee> getAll() {
        ArrayList<Melee> ListKategori = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM hero");
        try {
            while (rs.next()) {
                Melee mele = new Melee();
                mele.setIdHero(rs.getInt("idHero"));
                mele.setHeroName(rs.getString("heroName"));
                mele.setHp(rs.getInt("hp"));
                mele.setRole(rs.getString("role"));
                mele.setAtk(rs.getInt("atk"));
                mele.setSpd(rs.getInt("spd"));
                mele.setDfc(rs.getInt("dfc"));
                ListKategori.add(mele);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
    
    public ArrayList<Melee> getAllName(){
        ArrayList<Melee> listName = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("select heroName from hero");
        try {
            while (rs.next()) {
                Melee mele = new Melee();
                mele.setHeroName(rs.getString("heroName"));
                listName.add(mele);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listName;
    }
    
    public void save(){
        if(getDataById(idHero).getIdHero()==0){
            String sql="INSERT INTO hero (heroName, role, hp, atk, spd, dfc) VALUES ('"+this.heroName+"','"+this.role+"','"+this.hp+"','"+this.atk+"','"+this.spd+"','"+this.dfc+"')";
            this.idHero=DBHelper.insertQueryGetId(sql);
        }else{
            String sql="UPDATE hero SET heroName = '"+this.getHeroName()+"', "+"role = '"+this.getRole()+"', "+"hp = '"+this.getHp()+"', "+"atk = '"+this.getAtk()+"', "+"spd = '"+this.getSpd()+"', "+"dfc = '"+this.getDfc()+"' WHERE idHero = '"+this.idHero+"'";
            DBHelper.executeQuery(sql);
        }
    }
    
    public void delete(){
        String sql="DELETE FROM hero WHERE idHero = '"+this.idHero+"'";
        DBHelper.executeQuery(sql);
    }
}
