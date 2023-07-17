import java.util.Random;
import java.util.Scanner;

public class Game {
    private Characters player;
    private Enemies enemy;

    public void start() {
        selectPlayerClass();
        createEnemy();

        // Loop principal do jogo
        boolean gameOver = false;
        while (!gameOver) {
            displayGameStatus();
            getPlayerAction();
            performEnemyAction();

            // Verificar condições de vitória/derrota ou continuar o jogo
            // ...
        }
    }

    private void selectPlayerClass() {
        System.out.println("Select your class:");
        System.out.println("1. Paladin");
        System.out.println("2. Black Mage");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            player = new Paladin(null, null, choice/* parâmetros do Paladin */);
        } else if (choice == 2) {
            player = new BlackMage(choice, choice, choice, choice, choice, choice, choice, choice, choice, choice, choice/* parâmetros do Black Mage */);
        } else {
            System.out.println("Invalid choice. Defaulting to Paladin.");
            player = new Paladin(null, null, choice/* parâmetros do Paladin */);
        }

        System.out.println("You have selected the " + player.getClass() + " class.");
    }

    private void createEnemy() {
        Random random = new Random();
        int enemyType = random.nextInt(2); // Gera um número aleatório de 0 a 1
    
        if (enemyType == 0) {
            enemy = new Goblin();
        } else {
            enemy = new Skeleton();
        }
    
        System.out.println("An enemy " + enemy.getClass().getSimpleName() + " has appeared!");
        
    }

    private void displayGameStatus() {

        if (player instanceof Paladin) {
            System.out.println("Paladin Level: " + ((Paladin) player).getLevel());
        } else if (player instanceof BlackMage) {
            System.out.println("Black Mage Level: " + ((BlackMage) player).getLevel());
        }


        System.out.println("Player: " + player.getName());
        System.out.println("HP: " + player.getHp());
        System.out.println("MP: " + player.getMp());
        System.out.println("Attack: " + player.getAttack());
        System.out.println("Defense: " + player.getDefense());
        System.out.println();
        System.out.println("Enemy: " + enemy.getClass().getSimpleName());
        System.out.println("HP: " + enemy.getHp());
        System.out.println("Attack: " + enemy.getAttack());
        System.out.println("Defense: " + enemy.getDefense());
        System.out.println();
    }

    private void getPlayerAction() {
        System.out.println("Select your action:");
        System.out.println("1. Attack");
        System.out.println("2. Special Skill");
    
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
    
        if (choice == 1) {
            player.attack(enemy);
        } else if (choice == 2) {
            if (player instanceof BlackMage) {
                getPlayerSpellAction();
            } else {
                System.out.println("Invalid choice. Defaulting to regular attack.");
                player.attack(enemy);
            }
        } else {
            System.out.println("Invalid choice. Defaulting to regular attack.");
            player.attack(enemy);
        }
    }


    private void getPlayerSpellAction() {
        BlackMage blackMage = (BlackMage) player;
    
        System.out.println("Select your spell:");
        System.out.println("1. Blizzard");
        System.out.println("2. Fire");
    
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
    
        if (choice == 1) {
            blackMage.castBlizzard(enemy);
        } else if (choice == 2) {
            blackMage.castFire(enemy);
        } else {
            System.out.println("Invalid spell choice. Defaulting to regular attack.");
            player.attack(enemy);
        }
    }
    
    

    private void performEnemyAction() {
        enemy.enemyAction(player);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
