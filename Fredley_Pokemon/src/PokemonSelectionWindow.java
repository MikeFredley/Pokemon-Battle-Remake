import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/***************************************************************
 * Class: PokemonSelectionWindow
 * Purpose: The window that allows the player to select which
 * six pokemon they wish to use at the beginning of the game
 ***************************************************************/

public class PokemonSelectionWindow extends JFrame
{
    public static final int MAXPOKEMON = 6;
    private final int ROWS = 6;
    private final int COLS = 2;
    private int amountSelected = 0;

    private ArrayList<Pokemon> pokemon;
    private Player player;
    private Player computer;
    private ArrayList<JCheckBox> availablePokemon;
    private JPanel pokemonSelectionPanel; // Used in createPokeSelectionWindow
    private JPanel pokePanel; // Used in createPokeSelectionWindow
    private JPanel selectedPokemonPanel; // Used in createButtonPanel
    private JLabel selectedPokemonLabel; // Used in createButtonPanel
    private JButton submitPokeButton; // Used in createButtonPanel
    private CheckListener listener;
    private GetNameWindow getName;

    /***************************************************************
     * Method: PokemonSelectionWindow
     * Purpose: The constructor the create the window
     * Input: the pokemon arraylist and the player and computer
     *  objects
     * Output: None
     ***************************************************************/

    public PokemonSelectionWindow(ArrayList<Pokemon> pPokemon, Player pPlayer, Player pComputer)
    {
        pokemon = pPokemon;
        player = pPlayer;
        computer = pComputer;
        availablePokemon = new ArrayList<JCheckBox>();
        this.setTitle("Select Six Pokemon");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        listener = new CheckListener();
        createPokemonSelectionWindow();
        this.add(pokemonSelectionPanel, BorderLayout.CENTER);
        createButtonPanel();
        this.add(selectedPokemonPanel, BorderLayout.SOUTH);
        refreshScreen();
    }

    /***************************************************************
     * Method: CreatePokemonSelectionWindow
     * Purpose: To create the panel that contains a checkbox for
     * each pokemon
     * Input: None
     * Output: None
     ***************************************************************/

    private void createPokemonSelectionWindow()
    {
        pokemonSelectionPanel = new JPanel();
        pokemonSelectionPanel.setLayout(new GridLayout(ROWS, COLS));
        for(Pokemon aPoke : pokemon)
        {
            pokePanel = new JPanel();
            pokePanel.setBorder(BorderFactory.createLineBorder(Color.black));
            JCheckBox check = new JCheckBox(aPoke.getName());
            check.addActionListener(listener);
            check.setEnabled(true);
            pokePanel.add(check);
            availablePokemon.add(check);
            pokemonSelectionPanel.add(pokePanel);
        }
    }

    /***************************************************************
     * Method: createButtonPanel
     * Purpose: create the panel that contains the button and the
     * label at the bottom of the window
     * Input: None
     * Output: None
     ***************************************************************/

    private void createButtonPanel()
    {
        submitPokeButton = new JButton("Confirm Pokemon");
        submitPokeButton.addActionListener(listener);
        selectedPokemonLabel = new JLabel();
        selectedPokemonPanel = new JPanel();
        selectedPokemonLabel.setText("Please select six Pokemon.");
        selectedPokemonPanel.add(submitPokeButton);
        selectedPokemonPanel.add(selectedPokemonLabel);
    }

    /***************************************************************
     * Method: refreshScreen
     * Purpose: Refreshes the screen the change the label if needed
     * Input: None
     * Output: None
     ***************************************************************/

    private void refreshScreen()
    {
        this.setVisible(true);
        this.invalidate();
        this.validate();
        this.repaint();
        this.pack();
    }

    /***************************************************************
     * Class: CheckListener
     * Purpose: The action listener for the confirm button at the
     * bottom of the window
     * Input: None
     * Output: None
     ***************************************************************/

    private class CheckListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // calls the method that adds the selected pokemon to the players or computers inventories
            if (e.getSource() == submitPokeButton)
            {
                AddPokeToPlayers();
            }
            else // when a checkbox is selected it runs the following code
            {
                for (JCheckBox aBox : availablePokemon)
                {
                    if(e.getSource() == aBox) // Checks if the listener was called by a checkBox
                    {
                        if (aBox.isSelected()) // checks for the boxes that were selected
                        {
                            for (Pokemon aPoke : pokemon)
                            {
                                // Sees if the name of the pokemon is equal to the name in the selected box
                                if (aPoke.getName() == aBox.getText())
                                {
                                    // sets the isSelected boolean to true within the pokemon object
                                    aPoke.setSelected(true);
                                    // adds to the amountSelected integer
                                    amountSelected ++;
                                }
                            }
                        }
                        else // if a checkbox was deselected it runs the below code
                        {
                            for (Pokemon aPoke : pokemon)
                            {
                                if (aPoke.getName() == aBox.getText()) // finds the right pokemon to the corresponding box
                                {
                                    // changes its isSelected variable to false
                                    aPoke.setSelected(false);
                                    amountSelected --; // Subtracts from the amount selected if a box is deselected
                                }
                            }
                        }
                    }
                }
            }
        }

        /***************************************************************
         * Method: AddPokeToPlayers
         * Purpose: adds the selected pokemon the players inventory
         * and the rest to the computers inventory
         * Input: None
         * Output: None
         ***************************************************************/

        public void AddPokeToPlayers()
        {
            // sees if the amount of selected pokemon is equal to the allowed amount of max pokemon
            if (amountSelected == MAXPOKEMON)
            {
                for (Pokemon aPoke : pokemon)
                {
                    // if a pokemon is selected it adds it to the players inventory if not then the computers
                    if (aPoke.isSelected())
                    {
                        player.addPokemon(aPoke);
                    }
                    else
                    {
                        computer.addPokemon(aPoke);
                    }
                }
                selectedPokemonLabel.setText("You selected your Pokemon.");
                getName = new GetNameWindow(player, computer); // instantiates the new window to get the players name
                dispose(); // Closes the initial Pokemon selection window
            }
            else if (amountSelected < MAXPOKEMON) // if the amount is less than the maximum amount of pokemon
            {
                // it sets the label to tell you
                selectedPokemonLabel.setText("You did not select enough Pokemon.");
                refreshScreen(); // refreshes the screen to change the label
            }
            else
            {
                // if its greater that it changes and refreshes a new message
                selectedPokemonLabel.setText("You selected too many Pokemon.");
                refreshScreen();
            }
        }
    }
}
