import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

/***************************************************************
 * Class: Pokemon
 * Purpose: To hold any values that a pokemon may need and to
 * have all of the methods that are required to use an ability
 ***************************************************************/

public class Pokemon
{
    protected String name, type;
    protected int health;
    protected int fullHealth;
    protected int attack;
    protected int defense;
    protected int spAtk;
    protected int spDef;
    protected int speed;
    private boolean isFainted;
    private boolean isSelected;
    protected Scanner console = new Scanner(System.in);
    protected Random rand = new Random();

    protected BattleWindow window;
    protected BufferedImage pokePic;

    /***************************************************************
     * Method: The constructor
     * Purpose: sets all the values to a default of 0 or empty text
     * Input: None
     * Output: None
     ***************************************************************/

    public Pokemon()
    {
        name = "";
        type = "";
        health = 0;
        attack = 0;
        defense = 0;
        spAtk = 0;
        spDef = 0;
        speed = 0;
        isFainted = false;
    }

    /***************************************************************
     * Method: The overloaded constructor
     * Purpose: Defaults the values to whatever the programmer puts
     * in while instantiating an object
     * Input: The name, type, health, attack, defence, spAtk, spDef,
     * and speed
     * Output: None
     ***************************************************************/

    public Pokemon(String pName, String pType, int pHealth, int pAttack, int pDefence, int pSpAtk, int pSpDef, int pSpeed, boolean isFainted, String fileName) {
        this.name = pName;
        this.type = pType;
        this.health = pHealth;
        this.fullHealth = pHealth;
        this.attack = pAttack;
        this.defense = pDefence;
        this.spAtk = pSpAtk;
        this.spDef = pSpDef;
        this.speed = pSpeed;
        this.isFainted = isFainted;
        this.isSelected = false;
        try
        {
            this.pokePic = ImageIO.read(new File(fileName));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Error loading file");
        }

    }

    /************************************************************************
     * Method: determineIfAbilityHit()
     * Purpose: Uses a random number generator and some weird calculation
     * that I think might work to determine if an ability is going to hit
     * based on the abilities accuracy and the pokemon's defence stats.
     * Input: The opposing pokemon, the abilities accuracy, and the
     * abilities type
     * Output: A boolean value of whether or not the ability hit
     ************************************************************************/

    private boolean determineIfAbilityHit(Pokemon opponent, int accuracy, String abilityType)
    {
        if (rand.nextInt(accuracy) + 1 < accuracy / 10) // Calculation
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /***************************************************************
     * Method: determineAbilityDamage()
     * Purpose: To determine how much damage an ability does based
     * on its damage amount, the pokemons attack stats, and the
     * opponents defence stats
     * Input: The opposing pokemon, the damage of the ability, and
     * the ability type
     * Output: A an integer value for the damage
     ***************************************************************/

    // Found the actual damage calculation online https://bulbapedia.bulbagarden.net/wiki/Damage
    private int determineAbilityDamage(Pokemon opponent, int damage, String abilityType)
    {
        if(abilityType == "Normal" || abilityType == "Fighting" || abilityType == "Flying")
        {
            damage = ((((2/5)+2)*damage*(attack/opponent.getDefense()))/50) + 2;
        }
        else
        {   // Since fire type has a weakness to electric it does more damage
            if (opponent.getType() == "Fire" && abilityType == "Electric")
            {
                window.addToTextBox("It's super effective!");
                damage = (((((2/5)+2)*damage*(spAtk/opponent.getSpDef()))/50) + 2) * 2;
                return damage;
            }
            damage = ((((2/5)+2)*damage*(spAtk/opponent.getSpDef()))/50) + 2;
        }
        return damage;
    }

    /***************************************************************
     * Method: useAbility()
     * Purpose: Applies the damage value to the opposing pokemon
     * if the ability hits
     * Input: The opposing pokemon, the damage of the ability, and
     * the ability type
     * Output: The opposing pokemon's new health or whether or not
     * the ability missed
     ***************************************************************/

    protected void useAbility(Pokemon opponent, int damage, int accuracy, String abilityType, boolean isComputer)
    {
        if (determineIfAbilityHit(opponent, accuracy, abilityType))
        {
            damage = determineAbilityDamage(opponent, damage, abilityType);
            opponent.setHealth(opponent.getHealth() - damage);
            if(opponent.getHealth() < 0)
            {
                opponent.setHealth(0);
            }

            window.addToTextBox(opponent.getName() + "'s Health is now " + opponent.getHealth());

            if(!isComputer)
            {
                window.setComputerLabel(opponent.getName() + ": " + opponent.getHealth()
                        + "/" + opponent.getFullHealth());
            }
            else
            {
                window.setPlayerLabel(opponent.getName() + ": " + opponent.getHealth()
                        + "/" + opponent.getFullHealth());
            }

            if (opponent.getHealth() <= 0)
            {
                window.addToTextBox(opponent.getName() + " Fainted!");
                opponent.setName(opponent.getName() + " (Fainted)");
                opponent.setFainted(true);
            }
        }
        else
        {
            window.addToTextBox(name + " Missed!");
        }
    }

    /***************************************************************
     * Method: These are the Accessors and Mutators
     * Purpose: To get or change information within the class
     * Input: Information you want changed
     * Output: Information that you want
     ***************************************************************/

    public BufferedImage getPokePic()
    {
        return pokePic;
    }

    public void addWindow(BattleWindow window)
    {
        this.window = window;
    }

    public int getFullHealth() {
        return fullHealth;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public boolean isFainted()
    {
        return isFainted;
    }

    public void setFainted(boolean fainted)
    {
        this.isFainted = fainted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public int getSpAtk() {
        return spAtk;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
