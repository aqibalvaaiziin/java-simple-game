package backend.hero;
public class ChooseHero {
       
    public void Choose(ChooseRoleHero h){
        if(h instanceof Melee){
            Melee m = (Melee) h;
            System.out.println("You Choosed Melee Hero");
        }
        else if(h instanceof Ranged){
            Ranged r = (Ranged) h;
            System.out.println("You Choosed Range Hero");
        }
    }
    
}
