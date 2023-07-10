import java.util.Random;

public class Characters extends Stats {
    protected String name;
    private int hp;
    private int mp;
    private int attack;
    private int defense;
    
    public Characters(int hp, int mp, int attack, int defense,
     int strenght, int dexterity, int constitution,int intelligence, int wisdom, int charisma ) {

        super(strenght, dexterity, constitution, intelligence, wisdom, charisma);
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.defense = defense;
    }


    //Methods
    public void attack (Characters target) {
        int rollD20 = rollDice();
        int difficultyHit = calculateDifficultyHit (target);

        if (rollD20 >= difficultyHit) {
            int damage = calculateDifficultyHit(target);
            target.receiveDamage (damage);
                System.out.println("Hit");
        } else {
            System.out.println("Miss");
        }
    }
        
    protected int calculateDifficultyHit(Characters target) {
        int bonusDexterity = calculateBonusDexterity();
        int difficultyHitBase = 10;
    
        int damage = attack - target.getDefense();
    
        if (damage < 0) {
            damage = 0;
        }
    
        int difficultyHit = difficultyHitBase - bonusDexterity;
    
        // Adicione o cálculo do dano ao resultado da dificuldade de acerto
        difficultyHit += damage;
    
        return difficultyHit;
    }
    
  
    private int calculateBonusDexterity() {
            return dexterity / 2;
        }

        public void receiveDamage(int damage) {
            hp -= damage;
            
            if (hp < 0) {
                hp = 10;
            }
        }

    protected int rollDice() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }

//--------------------------------------------------------------------
        // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}