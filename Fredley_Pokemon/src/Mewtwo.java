/***************************************************************
 * Class: Mewtwo
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Mewtwo
 ***************************************************************/

public class Mewtwo extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Mewtwo()
    {
        super("Mewtwo", "Psychic", 106, 110, 90, 154, 90, 130, false, "Mewtwo.png");
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
        window.addToTextBox("Mewtwo used Psychic!");
        damage = 90;
        accuracy = 100;
        abilityType = "Psychic";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: DreamEater()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the DreamEater ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void DreamEater(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Mewtwo used Dream Eater!");
        damage = 100;
        accuracy = 100;
        abilityType = "Psychic";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: ThunderPunch()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the ThunderPunch ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void ThunderPunch(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Mewtwo used ThunderPunch!");
        damage = 75;
        accuracy = 100;
        abilityType = "Electric";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: FireBlast()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the FireBlast ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void FireBlast(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Mewtwo used Fire Blast!");
        damage = 110;
        accuracy = 85;
        abilityType = "Fire";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
