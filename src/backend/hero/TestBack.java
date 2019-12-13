package backend.hero;
public class TestBack {
    
    public static void main(String[] args) {
        
        RangedRole rr = new RangedRole();
        Ranged r = new Ranged("wawa", "ranged", rr, 1132, 222, 222, 55);

        r.save();
        
        for (Ranged ra : new Ranged().getAll()) {
             System.out.println("Hero    : "+ ra.heroName);
            System.out.println("Role    : "+ ra.role);
            System.out.println("Hp      : "+ ra.hp);
            System.out.println("Attack  : "+ ra.atk);
            System.out.println("Speed   : "+ ra.spd);
            System.out.println("Defence : "+ ra.dfc);
        }
    }
    
}
