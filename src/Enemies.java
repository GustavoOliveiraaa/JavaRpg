public class Enemies extends Characters {
    private String description;
    private int experiencePoints;

    public Enemies(String name, int level, int hp, int mp, int attack, int defense, int strength, int dexterity,
                   int constitution, int intelligence, int wisdom, int charisma, String description, int experiencePoints) {
        super(name, level, hp, mp, attack, defense, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.description = description;
        this.experiencePoints = experiencePoints;
    }

    // Getters e Setters para description e experiencePoints

    // Outros métodos específicos de inimigos
}
