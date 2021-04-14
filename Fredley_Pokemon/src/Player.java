import java.util.ArrayList;
import java.util.Scanner;

/***************************************************************
 * Class: Player
 * Purpose: To hold all of the methods that are required to get
 * a users input and to hold the users pokemon
 ***************************************************************/

public class Player
{
    private Scanner console = new Scanner(System.in);
    private ArrayList<Pokemon> inventory;
    private String name;

    /***************************************************************
     * Method: Constuctor
     * Purpose: Instantiates the players inventory when a Player
     * object is instantiated
     * Input: None
     * Output: None
     ***************************************************************/

    public Player()
    {
        name = "";
        inventory = new ArrayList<Pokemon>();
    }

    /***************************************************************
     * Method: Overloaded constructor
     * Purpose: To add a default pokemon to a players inventory
     * Input: A pokemon
     * Output: None
     ***************************************************************/

    public Player(Pokemon poke, String name)
    {
        inventory = new ArrayList<Pokemon>();
        inventory.add(poke);
        this.name = name;
    }

    /***************************************************************
     * Method: Accessors and Mutators
     * Purpose: To allow the programmer to add and remove pokemon
     * from the players inventory
     * Input: A pokemon
     * Output: None
     ***************************************************************/

    public int inventoryLength()
    {
        return inventory.size();
    }

    public Pokemon getPokemon(int index)
    {
        return inventory.get(index);
    }

    public void addPokemon(Pokemon pokemon)
    {
        inventory.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon)
    {
        inventory.remove(pokemon);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
