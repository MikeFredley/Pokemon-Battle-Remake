/***************************************************************
 * Class: Pikachu
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Pikachu
 ***************************************************************/

public class Pikachu extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Pikachu()
    {
        super("Pikachu","Electric", 35, 55, 40, 50, 50, 90, false, "Pikachu.png");
    }

    /***************************************************************
     * Method: QuickAttack()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Quick Attack ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void QuickAttack(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Pikachu used Quick Attack!");
        damage = 40;
        accuracy = 100;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: ThunderShock()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the ThunderShock ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void ThunderShock(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Pikachu used Thunder Shock!");
        damage = 40;
        accuracy = 100;
        abilityType = "Electric";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: ThunderBolt()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the ThunderBolt ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void ThunderBolt(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Pikachu used Thunderbolt!");
        damage = 90;
        accuracy = 100;
        abilityType = "Electric";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Thunder()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Thunder ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Thunder(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Pikachu used Thunder!");
        damage = 110;
        accuracy = 70;
        abilityType = "Electric";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
