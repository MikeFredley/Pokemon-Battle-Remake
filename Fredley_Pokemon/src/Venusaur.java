/***************************************************************
 * Class: Venusaur
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Venusaur
 ***************************************************************/

public class Venusaur extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Venusaur()
    {
        super("Venusaur", "Grass", 80, 82, 83, 100, 100, 80, false, "Venusaur.png");
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
        window.addToTextBox("Venusaur used Tackle!");
        damage = 40;
        accuracy = 100;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: VineWhip()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the VineWhip ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void VineWhip(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Venusaur used Vine Whip!");
        damage = 45;
        accuracy = 100;
        abilityType = "Grass";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: TakeDown()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the TakeDown ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void TakeDown(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Venusaur used Take Down!");
        damage = 90;
        accuracy = 85;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: SolarBeam()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the SolarBeam ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void SolarBeam(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Venusaur used Solar Beam!");
        damage = 120;
        accuracy = 100;
        abilityType = "Grass";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
