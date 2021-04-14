/***************************************************************
 * Class: Gyarados
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Gyarados
 ***************************************************************/

public class Gyarados extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Gyarados()
    {
        super("Gyarados", "Water", 95, 125, 79, 60, 100, 81, false, "Gyarados.png");
    }

    /***************************************************************
     * Method: Bite()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Bite ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Bite(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Gyarados used Bite!");
        damage = 60;
        accuracy = 100;
        abilityType = "Dark";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Waterfall()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Waterfall ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Waterfall(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Gyarados used Waterfall!");
        damage = 80;
        accuracy = 100;
        abilityType = "Water";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: HydroPump()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the HydroPump ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void HydroPump(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Gyarados used Hydro Pump!");
        damage = 110;
        accuracy = 80;
        abilityType = "Water";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: DragonTail()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the DragonTail ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void DragonTail(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Gyarados used DragonTail!");
        damage = 60;
        accuracy = 90;
        abilityType = "Dragon";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
