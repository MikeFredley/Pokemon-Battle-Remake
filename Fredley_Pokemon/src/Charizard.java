/***************************************************************
 * Class: Charizard
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Charizard
 ***************************************************************/

public class Charizard extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Charizard()
    {
        super("Charizard", "Fire", 78, 84, 78, 109, 85, 100, false, "Charizard.png");
    }

    /***************************************************************
     * Method: Scratch()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Scratch ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Scratch(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Charizard used Scratch!");
        damage = 40;
        accuracy = 100;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Ember()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Ember ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Ember(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Charizard used Ember!");
        damage = 40;
        accuracy = 100;
        abilityType = "Fire";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: FlameThrower()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Flamethrower ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void FlameThrower(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Charizard used Flamethrower!");
        damage = 90;
        accuracy = 100;
        abilityType = "Fire";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Slash()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Slash ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Slash(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Charizard used Slash!");
        damage = 70;
        accuracy = 100;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
