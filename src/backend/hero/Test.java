package backend.hero;
public class Test {
    public static void main(String[] args) {
        
        MeleeRole mRole = new MeleeRole();
        RangedRole rRole =  new RangedRole();
        
        Melee m = new Melee("Pardi", "Melee", mRole,3000,200,70,40);
        Ranged r = new Ranged("Yoga", "Ranged", rRole,1000,650,90,20);
        
        m.heroSpec();
        System.out.println("====================================");
        r.heroSpec();
        
    }
}
