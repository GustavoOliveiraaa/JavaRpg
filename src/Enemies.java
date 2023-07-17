public class Enemies extends Characters {
    protected int experiencePoints;

    public Enemies(String name, int level, int hp, int mp, int attack, int defense, int strength, int dexterity,
                   int constitution, int intelligence, int wisdom, int charisma, String description, int experiencePoints) {
        super(hp, mp, attack, defense, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.experiencePoints = experiencePoints;
    }

    public void enemyAction(Characters player) {
        int action = rollDice(); // Simula a escolha de uma ação
    
        if (action <= 50) {
            meleeAttack(player); // Realiza um ataque corpo a corpo no jogador
        } else if (action <= 80) {
            shootArrow(player); // Atira uma flecha no jogador
        } else {

        }
    }
    
    private void meleeAttack(Characters player) {
        int rollD20 = rollDice();
        int difficultyHit = calculateDifficultyHit(player);
    
        if (rollD20 >= difficultyHit) {
            int damage = calculateDifficultyHit(player);
            player.receiveDamage(damage);
            System.out.println("Enemy performed a melee attack! Dealt " + damage + " damage.");
        } else {
            System.out.println("Enemy's melee attack missed!");
        }
    }
    
    private void shootArrow(Characters player) {
        int rollD20 = rollDice();
        int difficultyHit = calculateDifficultyHit(player);
    
        if (rollD20 >= difficultyHit) {
            int damage = calculateDifficultyHit(player);
            player.receiveDamage(damage);
            System.out.println("Enemy shot an arrow! Dealt " + damage + " damage.");
        } else {
            System.out.println("Enemy's arrow missed!");
        }
    }
    

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    // Getters e Setters para description e experiencePoints
    
    // Outros métodos específicos de inimigos
}
