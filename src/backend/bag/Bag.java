package backend.bag;

import backend.db.DBHelper;
import backend.potion.Potion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Bag {
    private int idBag;
    private String bagName;
    private Potion potion1 = new Potion();
    private Potion potion2 = new Potion();
    private Potion potion3 = new Potion();

    public Bag() {
    }

    public Bag(int idBag, String bagName, Potion potion1, Potion potion2, Potion potion3) {
        this.idBag = idBag;
        this.bagName = bagName;
        this.potion1 = potion1;
        this.potion2 = potion2;
        this.potion3 = potion3;
    }

    public int getIdBag() {
        return idBag;
    }

    public void setIdBag(int idBag) {
        this.idBag = idBag;
    }

    public String getBagName() {
        return bagName;
    }

    public void setBagName(String bagName) {
        this.bagName = bagName;
    }

    public Potion getPotion1() {
        return potion1;
    }

    public void setPotion1(Potion potion1) {
        this.potion1 = potion1;
    }

    public Potion getPotion2() {
        return potion2;
    }

    public void setPotion2(Potion potion2) {
        this.potion2 = potion2;
    }

    public Potion getPotion3() {
        return potion3;
    }

    public void setPotion3(Potion potion3) {
        this.potion3 = potion3;
    }
    
    public Bag getById(int id) {
        Bag bag = new Bag();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM bag WHERE idBag = '" + idBag + "'");
        try {
            while (rs.next()) {
                bag = new Bag();
                bag.setIdBag(rs.getInt("idBack"));
                bag.getPotion1().setIdPotion(rs.getInt("potion1"));
                bag.getPotion2().setIdPotion(rs.getInt("potion2"));
                bag.getPotion3().setIdPotion(rs.getInt("potion3"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bag;
    }
    
    public ArrayList<Bag> getAllBagName(){
        ArrayList<Bag> listName = new ArrayList();
//        ResultSet rs = DBHelper.selectQuery("select p1.potionName p1,p2.potionName p2, p3.potionName p3 from bag b inner join potion p1 on b.potion1 = p1.idPotion inner join potion p2 on b.potion2 = p2.idPotion inner join potion p3 on b.potion3 = p3.idPotion ");
        ResultSet rs = DBHelper.selectQuery("select * from bag");
        try {
            while (rs.next()) {
                Bag bag = new Bag();
                bag.setIdBag(rs.getInt("idBag"));
                bag.setBagName(rs.getString("bagName"));
                listName.add(bag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listName;
    }
   
    public Bag getDataById(int id){
        Bag bag = new Bag();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM bag WHERE idBag = '" + id + "'");
        try {
            while (rs.next()) {
                bag = new Bag();
                bag.setIdBag(rs.getInt("idHero"));
                bag.setBagName(rs.getString("heroName"));
                bag.getPotion1().setIdPotion(rs.getInt("potion1"));
                bag.getPotion2().setIdPotion(rs.getInt("potion2"));
                bag.getPotion3().setIdPotion(rs.getInt("potion3"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bag;
    }

    public boolean next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
