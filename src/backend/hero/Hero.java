package backend.hero;
abstract class Hero {
    
    public int idHero;
    public String heroName;
    public HeroData dataHero;
    public int hp;
    public int atk;
    public int spd;
    public int dfc;

    public Hero() {
    }

    public Hero(String heroName, HeroData dataHero,int hp, int atk, int spd, int dfc) {
        this.idHero = idHero;
        this.heroName = heroName;
        this.dataHero = dataHero;
        this.hp = hp;
        this.atk = atk;
        this.spd = spd;
        this.dfc = dfc;
    }
    
    abstract void heroSpec();

    public int getIdHero() {
        return idHero;
    }

    public void setIdHero(int idHero) {
        this.idHero = idHero;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    } 

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getDfc() {
        return dfc;
    }

    public void setDfc(int dfc) {
        this.dfc = dfc;
    }  
    
}