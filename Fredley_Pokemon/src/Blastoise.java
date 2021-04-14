/***************************************************************
 * Class: Blastoise
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Blastoise
 ***************************************************************/

public class Blastoise extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Blastoise()
    {
        super("Blastoise", "Water", 79, 83, 100, 85, 105, 78, false, "Blastoise.png");
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
        window.addToTextBox("Blastoise used Tackle!");
        damage = 40;
        accuracy = 100;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
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
        window.addToTextBox("Blastoise used Bite!");
        damage = 60;
        accuracy = 100;
        abilityType = "Dark";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: BubbleBeam()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the BubbleBeam ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void BubbleBeam(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Blastoise used Bubble Beam!");
        damage = 90;
        accuracy = 100;
        abilityType = "Fire";
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
        window.addToTextBox("Blastoise used Hydro Pump!");
        damage = 110;
        accuracy = 80;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
