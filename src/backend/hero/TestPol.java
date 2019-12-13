package backend.hero;
public class TestPol {
    public static void main(String[] args) {
        MeleeRole mr = new MeleeRole();
        Melee m = new Melee("lala", "Range", mr, 2000, 300, 40, 30);
        Hero h;
        h = m;
        
        h.heroSpec();
    }
}
