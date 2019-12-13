package backend.hero;

import backend.db.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Ranged extends Hero{
    
    public String role = "Ranged";

    public Ranged() {
    }
    
     
    public Ranged(String heroName, String role, HeroData dataHero, int hp, int atk, int spd, int dfc) {
        super(heroName, dataHero,hp,atk,spd,dfc);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    void heroSpec() {
        dataHero.printHeroData(heroName, role, hp, atk, spd, dfc);
    }
    
    public Hero getDataById(int id){
        Ranged ranged = new Ranged();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM hero WHERE idHero = '" + id + "'");
        try {
            while (rs.next()) {
                ranged = new Ranged();
                ranged.setIdHero(rs.getInt("idHero"));
                ranged.setHeroName(rs.getString("heroName"));
                ranged.setHp(rs.getInt("hp"));
                ranged.setRole(rs.getString("role"));
                ranged.setAtk(rs.getInt("atk"));
                ranged.setSpd(rs.getInt("spd"));
                ranged.setDfc(rs.getInt("dfc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ranged;
    }
    
    
    
    public ArrayList<Ranged> getAll() {
        ArrayList<Ranged> ListKategori = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM hero");
        try {
            while (rs.next()) {
                Ranged ranged = new Ranged();
                ranged.setIdHero(rs.getInt("idHero"));
                ranged.setHeroName(rs.getString("heroName"));
                ranged.setHp(rs.getInt("hp"));
                ranged.setRole(rs.getString("role"));
                ranged.setAtk(rs.getInt("atk"));
                ranged.setSpd(rs.getInt("spd"));
                ranged.setDfc(rs.getInt("dfc"));
                ListKategori.add(ranged);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
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
