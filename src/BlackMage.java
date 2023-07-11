public class BlackMage extends Characters {
    private int spellPower;
    private int level;
    private int uses;

    public BlackMage(int hp, int mp, int attack, int defense, int strenght, int dexterity, int constitution,
            int intelligence, int wisdom, int charisma, int spellPower, int level) {
        super(10, 20, 4, 3, 8, 10, 8, 10, 10, 8);
        this.spellPower = intelligence * 2;
        this.level = level;
    }

    public void castBlizzard(Characters target) {
        int rollD20 = rollDice();
        int difficultyHit = calculateDifficultyHit(target);
    
        int baseMPCost = 5; 
        int mpCostIncrease = 5; 
        int damageIncrease = 10; 
    
        // Calcula o custo de MP e o dano com base no número de usos anteriores
        int mpCost = baseMPCost + (mpCostIncrease * uses);
        int damage = spellPower + (damageIncrease * uses);
    
        if (rollD20 >= difficultyHit && mp >= mpCost) {
            target.receiveDamage(damage);
            mp -= mpCost; // Reduz o MP após o uso da habilidade
            uses++; // Incrementa o número de usos
            System.out.println("Black Mage casts Blizzard! Dealt " + damage + " damage. MP cost: " + mpCost);
        } else if (mp < mpCost) {
            System.out.println("Not enough MP to cast Blizzard!");
        } else {
            System.out.println("Black Mage's Blizzard missed!");
        }
    }

    public void castFire(Characters target) {
        int rollD20 = rollDice();
        int difficultyHit = calculateDifficultyHit(target);
    
        int baseMPCost = 5; 
        int mpCostIncrease = 5; 
        int damageIncrease = 10; 
    
        // Calcula o custo de MP e o dano com base no número de usos anteriores
        int mpCost = baseMPCost + (mpCostIncrease * uses);
        int damage = spellPower + (damageIncrease * uses);
    
        if (rollD20 >= difficultyHit && mp >= mpCost) {
            target.receiveDamage(damage);
            mp -= mpCost; // Reduz o MP após o uso da habilidade
            uses++; // Incrementa o número de usos
            System.out.println("Black Mage casts Fire! Dealt " + damage + " damage. MP cost: " + mpCost);
        } else if (mp < mpCost) {
            System.out.println("Not enough MP to cast Fire!");
        } else {
            System.out.println("Black Mage's Fire missed!");
        }
    }

    

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
}
