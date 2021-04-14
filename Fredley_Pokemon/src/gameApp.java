/***************************************************************
 *                      Pokemon Battles
 *          To create my very own pokemon battle using
 *        various methods of object oriented programming
 *        Inputs include any number from 1 to 4 depending
 *                      on the situation.
 *                  Michael Fredley 3-20-2019
 ***************************************************************/


import java.util.ArrayList;
import java.util.Scanner;

/***************************************************************
 * Class: gameApp
 * Purpose: To run the game with all of the other classes
 ***************************************************************/

public class gameApp
{
    private Scanner console = new Scanner(System.in);

    private Pokemon pikachu = new Pikachu(); // MSF
    private Pokemon charizard = new Charizard(); // MSF
    private Pokemon playerPoke;
    private Pokemon computerPoke;
    private Player player = new Player();
    private Player computer = new Player();
    public static boolean playGame = true;
    public static boolean surrender = false;
    private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();

    public gameApp()
    {
        // Instantiates each pokemon and adds them to an arraylist
        pokemon.add(new Pikachu());
        pokemon.add(new Charizard());
        pokemon.add(new Alakazam());
        pokemon.add(new Blastoise());
        pokemon.add(new Gyarados());
        pokemon.add(new Machamp());
        pokemon.add(new Mewtwo());
        pokemon.add(new Scyther());
        pokemon.add(new Snorlax());
        pokemon.add(new Tauros());
        pokemon.add(new Venusaur());
        pokemon.add(new Zapdos());

    }

    /***************************************************************
     * Method: main()
     * Purpose: Creates a gameApp object then starts the game
     * Input: None
     * Output: None
     ***************************************************************/

    public static void main(String args[])
    {
        gameApp game = new gameApp();


        System.out.println("Directions: Enter a number depending on the options given.");
        game.startSelection();
        //game.gameLoop();
    }


    /**
     * TODO
     * Pokemon Ability Weaknesses - Do Last
     */

    /***************************************************************
     * Method: startSelection()
     * Purpose: Allows the player to select which pokemon they want
     * to use before the battle starts
     * Input: User input
     * Output: Sets the player and computer pokemon
     ***************************************************************/

    public void startSelection()
    {
        PokemonSelectionWindow window = new PokemonSelectionWindow(pokemon, player, computer);
    }
}
