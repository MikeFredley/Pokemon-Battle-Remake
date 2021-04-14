/***************************************************************
 * Class: Machamp
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Machamp
 ***************************************************************/

public class Machamp extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Machamp()
    {
        super("Machamp", "Fighting", 90, 130, 80, 65, 85, 55, false, "Machamp.png");
    }

    /***************************************************************
     * Method: KarateChop()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the KarateChop ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void KarateChop(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Machamp used Karate Chop!");
        damage = 50;
        accuracy = 100;
        abilityType = "Fighting";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: BrickBreak()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the BrickBreak ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void BrickBreak(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Machamp used Brick Break!");
        damage = 75;
        accuracy = 100;
        abilityType = "Fighting";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Submission()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Submission ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Submission(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Machamp used Submission!");
        damage = 80;
        accuracy = 80;
        abilityType = "Fighting";
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
        window.addToTextBox("Machamp used Superpower!");
        damage = 120;
        accuracy = 100;
        abilityType = "Fighting";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
