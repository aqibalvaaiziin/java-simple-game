package backend.result;

import backend.db.DBHelper;
import backend.hero.Melee;
import backend.user.Users;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Result {
    
    public int idResult;
    public Melee hero = new Melee();
    public Users user = new Users();

    public Result() {
    }

    public Result(Users user, Melee hero) {
        this.user = user;
        this.hero = hero;
    }

    public int getIdResult() {
        return idResult;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
    }

    public Melee getHero() {
        return hero;
    }

    public void setHero(Melee hero) {
        this.hero = hero;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }    
    
    
    public Result getDataById(int id){
        Result result = new Result();
        ResultSet rs = DBHelper.selectQuery("Select r.idResult idResult, u.idUser idUser, u.username userName, h.heroName heroName, h.hp hp from result r inner join user u on r.idUser = u.idUser inner join hero h on u.idHero = h.idHero where u.idUser = '"+id+"'");
        try {
            while(rs.next()){
                result = new Result();
                result.setIdResult(rs.getInt("idResult"));
                result.getUser().setIdUser(rs.getInt("idUser"));
                result.getUser().setUsername(rs.getString("username"));
                result.getHero().setHeroName(rs.getString("heroName"));
                result.getHero().setHp(rs.getInt("hp"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<Result> resultFight(){
        ArrayList<Result> ListResult = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("Select r.idResult idResult, u.idUser idUser, u.username userName, h.heroName heroName, h.hp hp from result r inner join user u on r.idUser = u.idUser inner join hero h on u.idHero = h.idHero");
        try {
            while(rs.next()){
                Result result = new Result();
                result.setIdResult(rs.getInt("idResult"));
                result.getUser().setIdUser(rs.getInt("idUser"));
                result.getUser().setUsername(rs.getString("username"));
                result.getHero().setHeroName(rs.getString("heroName"));
                result.getHero().setHp(rs.getInt("hp"));
                ListResult.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListResult;
    }
    
    public void saveResult(){
        if(getDataById(idResult).getIdResult()== 0){
            String sql = "insert into result (idUser,idHero) values ('"+this.getIdResult()+"','"+this.getHero().getIdHero()+"')";
            this.idResult = DBHelper.insertQueryGetId(sql);
        }
        
    } 
}
