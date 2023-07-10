import java.util.Timer;
import java.util.TimerTask;

public class Paladin extends Characters {
    private String className;
    private String description;
    private int level;
    private boolean rampartActive = false;


    public Paladin(String className,String description, int level) {
        super(25, 10, 5, 5, 8, 8, 8, 8, 8, 8);
        this.className = "Paladin";
        this.level = 1;
        this.description = "A holy knight skilled in swordplay and protective magic.";
    }

    // Implementação das habilidades do Paladino
    public void useSwordSkill(Characters target) {
        int roll20 = rollDice();
        int difficultyHit = calculateDifficultyHit(target);

        if (roll20 >= difficultyHit) {
            int damage = calculateDifficultyHit(target);
            target.receiveDamage(damage);
            System.out.println("Sword Skill hit! Dealt " + damage + " damage.");
        } else {
            System.out.println("Sword Skill missed!");
        }
    }

    public void Rampart() {
        int cooldownSeconds = 20; // Tempo de recarga em segundos
        int reductionPercentage = 20; // Porcentagem de redução de dano - trabalhar melhor após criação da classe jogador

    if (!rampartActive) {
        System.out.println("Casting Rampart...");
        rampartActive = true;

        // Configurando o temporizador para desativar o Rampart após a duração do cooldown
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                rampartActive = false;
                System.out.println("Rampart effect has expired.");
            }
        }, cooldownSeconds * 1000); // Multiplica por 1000 para converter segundos para milissegundos

    } else {
        System.out.println("Rampart is still active. Please wait for the effect to expire.");
        }
    }

    public void oathGauge() {
        int maxOathPoints = 100; // Valor máximo do Oath Gauge
    int increaseAmount = 20; // Quantidade de aumento no Oath Gauge a cada uso do método

    int oathPoints = increaseAmount;

    if (oathPoints >= maxOathPoints) {
        // Paladino pode usar habilidades especiais
        System.out.println("Oath Gauge is full! Ready to use special abilities.");
        oathPoints = 0; // Reinicia o Oath Gauge após usar as habilidades especiais
    } else {
        System.out.println("Oath Gauge increased by " + increaseAmount + ".");
    }
    }

    public  String getClassame() {
        return className;
    }

    public  void setClassame(String classame) {
        this.className = classame;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
