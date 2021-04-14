/***************************************************************
 * Class: Snorlax
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Snorlax
 ***************************************************************/

public class Snorlax extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Snorlax()
    {
        super("Snorlax", "Normal", 160, 110, 65, 65, 110, 30, false, "Snorlax.png");
    }

    /***************************************************************
     * Method: Tackle()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Tackle ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Tackle(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Snorlax used Tackle!");
        damage = 40;
        accuracy = 100;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Headbutt()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Headbutt ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Headbutt(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Snorlax used Headbutt!");
        damage = 70;
        accuracy = 100;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: BodySlam()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the BodySlam ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void BodySlam(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Snorlax used Body Slam!");
        damage = 85;
        accuracy = 100;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Superpower()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Superpower ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Superpower(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Snorlax used Superpower!");
        damage = 120;
        accuracy = 100;
        abilityType = "Fighting";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
