public class Stats {
    private int strenght;
    protected int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

        public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

        public Stats(int strenght, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
            strenght = strenght;
            dexterity = dexterity;
            constitution = constitution;
            intelligence = intelligence;
            wisdom = wisdom;
            charisma = charisma;
        }
}

