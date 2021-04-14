import java.awt.image.BufferedImage;

/***************************************************************
 * Class: Alakazam
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Alakazam
 ***************************************************************/

public class Alakazam extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Alakazam()
    {
        super("Alakazam", "Psychic", 55, 50, 45, 135, 95, 120, false, "Alakazam.png");
    }

    /***************************************************************
     * Method: Confusion()
     * for the Confusion ability and then uses the ability
     * Purpose: Sets the damage, accuracy, and abilityType values
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Confusion(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Alakazam used Confusion!");
        damage = 50;
        accuracy = 100;
        abilityType = "Psychic";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Psybeam()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Psybeam ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Psybeam(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Alakazam used Psybeam!");
        damage = 65;
        accuracy = 100;
        abilityType = "Psychic";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Psychic()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Psychic ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Psychic(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Alakazam used Psychic!");
        damage = 90;
        accuracy = 100;
        abilityType = "Psychic";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: HyperBeam()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the HyperBeam ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void HyperBeam(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Alakazam used Hyper Beam!");
        damage = 150;
        accuracy = 90;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
