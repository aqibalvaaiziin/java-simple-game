package backend.hero;
public class RangedRole implements HeroData{

    @Override
    public void printHeroData(String heroName, String role, int hp, int atk, int spd, int dfc) {
        System.out.println("Hero    : "+ heroName);
        System.out.println("Role    : "+ role);
        System.out.println("Hp      : "+ hp);
        System.out.println("Attack  : "+ atk);
        System.out.println("Speed   : "+ spd);
        System.out.println("Defence : "+ dfc);
    }
}
