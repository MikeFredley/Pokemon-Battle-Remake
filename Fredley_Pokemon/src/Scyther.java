/***************************************************************
 * Class: Scyther
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Scyther
 ***************************************************************/

public class Scyther extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Scyther()
    {
        super("Scyther", "Bug", 70, 110, 80, 55, 80, 105, false, "Scyther.png");
    }

    /***************************************************************
     * Method: UTurn()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the U-Turn ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void UTurn(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Scyther used U-Turn!");
        damage = 70;
        accuracy = 100;
        abilityType = "Bug";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: WingAttack()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the WingAttack ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void WingAttack(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Scyther used Wing Attack!");
        damage = 60;
        accuracy = 100;
        abilityType = "Flying";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: X-Scissor()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the X-Scissor ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void XScissor(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Scyther used X-Scissor!");
        damage = 80;
        accuracy = 100;
        abilityType = "Bug";
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
        window.addToTextBox("Scyther used Slash!");
        damage = 70;
        accuracy = 100;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
