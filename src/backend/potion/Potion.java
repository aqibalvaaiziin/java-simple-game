package backend.potion;
import backend.db.DBHelper;
import java.util.ArrayList;
import java.sql.*;
public class Potion {
    private int idPotion,skill;
    private String potionName;

    public Potion() {
    }

    public Potion(int skill, String potionName) {
        this.skill = skill;
        this.potionName = potionName;
    }

    public int getIdPotion() {
        return idPotion;
    }

    public void setIdPotion(int idPotion) {
        this.idPotion = idPotion;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public String getPotionName() {
        return potionName;
    }

    public void setPotionName(String potionName) {
        this.potionName = potionName;
    }
    
    public Potion getDataById(){
        Potion potion = new Potion();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM potion WHERE idPotion = '" + idPotion + "'");
        try {
            while (rs.next()) {
                potion = new Potion();
                potion.setIdPotion(rs.getInt("idPotion"));
                potion.setPotionName(rs.getString("potionName"));
                potion.setSkill(rs.getInt("skill"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return potion;
    }
    
}
