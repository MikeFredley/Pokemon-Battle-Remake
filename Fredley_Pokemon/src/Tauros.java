/***************************************************************
 * Class: Tauros
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Tauros
 ***************************************************************/

public class Tauros extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Tauros()
    {
        super("Tauros", "Normal", 75, 100, 95, 40, 70, 110, false, "Tauros.png");
    }

    /***************************************************************
     * Method: HornAttack()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the HornAttack ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void HornAttack(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Tauros used Horn Attack!");
        damage = 65;
        accuracy = 100;
        abilityType = "Normal";
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
        window.addToTextBox("Tauros used Take Down!");
        damage = 90;
        accuracy = 85;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Thrash()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Thrash ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Thrash(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Tauros used Thrash!");
        damage = 120;
        accuracy = 100;
        abilityType = "Normal";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Outrage()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Outrage ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Outrage(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Tauros used Outrage!");
        damage = 120;
        accuracy = 100;
        abilityType = "Dragon";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }
}
