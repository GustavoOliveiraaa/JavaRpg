public class BlackMage extends Characters {
    private int spellPower;
    private String spellName;
    private int uses;
    private int level;


    public BlackMage(int hp, int mp, int attack, int defense, int strength, int dexterity, int constitution,
            int intelligence, int wisdom, int charisma, int level) {
        super(10, 20, 4, 3, 8, 10, 8, 10, 10, 8);
        this.spellPower = intelligence * 2;
        this.level = 1;
        this.spellName = "Fire"; // Começa com a habilidade "Fire"
        this.uses = 0;
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

        if (rollD20 >= difficultyHit && getMp() >= mpCost) {
            target.receiveDamage(damage);
            setMp(getMp() - mpCost); // Reduz o MP após o uso da habilidade
            uses++; // Incrementa o número de usos
            System.out.println("Black Mage casts Blizzard! Dealt " + damage + " damage. MP cost: " + mpCost);
        } else if (getMp() < mpCost) {
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

        if (rollD20 >= difficultyHit && getMp() >= mpCost) {
            target.receiveDamage(damage);
            setMp(getMp() - mpCost); // Reduz o MP após o uso da habilidade
            uses++; // Incrementa o número de usos
            System.out.println("Black Mage casts Fire! Dealt " + damage + " damage. MP cost: " + mpCost);
        } else if (getMp() < mpCost) {
            System.out.println("Not enough MP to cast Fire!");
        } else {
            System.out.println("Black Mage's Fire missed!");
        }
    }

    public void transpose() {
        if (spellName.equals("Fire")) {
            // Converte Fire para Blizzard e mantém o mesmo nível de habilidade
            spellName = "Blizzard";
        } else if (spellName.equals("Blizzard")) {
            // Converte Blizzard para Fire e mantém o mesmo nível de habilidade
            spellName = "Fire";
        }
        // Recupera um pouco de MP ao usar Transpose
        int mpRecovered = 20;
        setMp(getMp() + mpRecovered);
        System.out.println("Black Mage uses Transpose. Converted " + spellName + " and recovered " + mpRecovered + " MP.");
    }

    public void castSpell(Enemies enemy) {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    
}
