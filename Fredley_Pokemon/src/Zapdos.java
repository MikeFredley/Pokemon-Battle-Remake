/***************************************************************
 * Class: Zapdos
 * Purpose: To be able to instantiate an object of class Pokemon
 * with the unique stats and abilities of Zapdos
 ***************************************************************/

public class Zapdos extends Pokemon
{
    private int damage = 0;
    private int accuracy = 0;
    private String abilityType = "";

    public Zapdos()
    {
        super("Zapdos", "Electric", 90, 90, 85, 125, 90, 100, false, "Zapdos.png");
    }

    /***************************************************************
     * Method: DrillPeck()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the DrillPeck ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void DrillPeck(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Zapdos used Drill Peck!");
        damage = 80;
        accuracy = 100;
        abilityType = "Flying";
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
        window.addToTextBox("Zapdos used Thunder!");
        damage = 110;
        accuracy = 70;
        abilityType = "Electric";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: SkyAttack()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the SkyAttack ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void SkyAttack(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Zapdos used Sky Attack!");
        damage = 140;
        accuracy = 90;
        abilityType = "Flying";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: Thunderbolt()
     * Purpose: Sets the damage, accuracy, and abilityType values
     * for the Thunderbolt ability and then uses the ability
     * Input: The opposing pokemon
     * Output: Eventually changes the opposing pokemon's health
     ***************************************************************/

    public void Thunderbolt(Pokemon opponent, boolean isComputer)
    {
        window.addToTextBox("Zapdos used Thunderbolt!");
        damage = 90;
        accuracy = 100;
        abilityType = "Electric";
        useAbility(opponent, damage, accuracy, abilityType, isComputer);
    }

    /***************************************************************
     * Method: selectAbility()
     * Purpose: To take in user input to select what ability they
     * want their pokemon to use
     * Input: The opposing pokemon
     * Output: None
     ***************************************************************/

    // I could definitely move this to the Player class but have not come
    // up with a good idea on how to do that yet
   /** public void selectAbility(Pokemon opponent, boolean isComputer)
    {
        int input;

        if (isComputer)
        {
            input = rand.nextInt(5) + 1;
        }
        else
        {
            window.addToTextBox("What ability should Zapdos use?");
            window.addToTextBox("1. Drill Peck");
            window.addToTextBox("2. Thunder");
            window.addToTextBox("3. Sky Attack");
            window.addToTextBox("4. Thunderbolt");
            input = console.nextInt();
        }
        if (input == 1)
        {
            DrillPeck(opponent);
        }
        else if (input == 2)
        {
            Thunder(opponent);
        }
        else if (input == 3)
        {
            SkyAttack(opponent);
        }
        else if (input == 4)
        {
            Thunderbolt(opponent);
        }
        else
        {
            window.addToTextBox("Invalid Input.");
            selectAbility(opponent, isComputer);
        }
    } */
}
