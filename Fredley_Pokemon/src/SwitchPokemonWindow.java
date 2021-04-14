import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/***************************************************************
 * Class: SwitchPokemonWindow
 * Purpose: The class for the popup window that allows you to
 *  switch pokemon
 ***************************************************************/

public class SwitchPokemonWindow extends JFrame
{
    private final int ROWS = 6;
    private final int COLS = 1;

    private Player player;
    private JPanel buttonPanel;
    private JPanel buttons;
    private ButtonGroup radioButtons;
    private JPanel confirmPanel;
    private JButton confirmButton;
    private SwitchPokemon listener;

    private BattleWindow window;
    private boolean isComputer;

    private ArrayList<JRadioButton> checkButton;

    /***************************************************************
     * Method: SwitchPokemonWindow
     * Purpose: The constructor for the window
     * Input: The player object
     * Output: Puts the window containing the players available
     *  pokemon onto the screen
     ***************************************************************/

    public SwitchPokemonWindow(Player pPlayer, BattleWindow mainWindow, boolean pIsComputer)
    {
        player = pPlayer;
        window = mainWindow;
        isComputer = pIsComputer;
        listener = new SwitchPokemon();
        checkButton = new ArrayList<JRadioButton>();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setTitle("Select a Pokemon.");
        createButtonPanel();
        this.add(buttonPanel, BorderLayout.NORTH);
        createConfirmPanel();
        this.add(confirmPanel, BorderLayout.SOUTH);
        this.pack();
        if(!isComputer)
        {
            this.setVisible(true);
        }
        else
        {
            switchComputerPokemon(0,0);
        }
    }

    /***************************************************************
     * Method: createButtonPanel
     * Purpose: To create the panel that contains the button within
     *  the switch pokemon window
     * Input: None
     * Output: None
     ***************************************************************/

    private void createButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(ROWS, COLS)); // sets up the button panel to be a grid layout
        radioButtons = new ButtonGroup();
        for(int i = 0; i < player.inventoryLength(); i++)
        {
            buttons = new JPanel();
            buttons.setBorder(BorderFactory.createLineBorder(Color.black));
            JRadioButton check = new JRadioButton(player.getPokemon(i).getName());
            check.addActionListener(listener);
            check.setEnabled(true);
            radioButtons.add(check); // the button group to make the radio buttons work together
            buttons.add(check); // the jpanel that will hold each of the radio buttons
            checkButton.add(check); // the array list that holds each of the buttons
            buttonPanel.add(buttons); // adds each radio button to the button panel
        }
    }

    /***************************************************************
     * Method: createConfirmPanel
     * Purpose: creates the panel that holds the confirmButton on
     * the bottom of the frame
     * Input: None
     * Output: None
     ***************************************************************/

    private void createConfirmPanel()
    {
        confirmPanel = new JPanel();
        confirmButton = new JButton();
        confirmButton.setText("Confirm Selected Pokemon.");
        confirmButton.addActionListener(listener);
        confirmPanel.add(confirmButton);
    }

    /***************************************************************
     * Method: switchComputerPokemon()
     * Purpose: This sets the computers current pokemon when the
     * class is instantiated with the isComputer variable set to true
     * Input: an Int for the "Input" which is a number selected
     * randomly, and an int for i which is an incrementer for the
     * recursive function
     * Output: Changes the computers pokemon in the GUI
     ***************************************************************/

    public void switchComputerPokemon(int input, int i)
    {
        Random rand = new Random();
        input = rand.nextInt(player.inventoryLength());
        if(!player.getPokemon(input).isFainted())
        {
            //System.out.println("Successful Switch");
            window.addToTextBox("The computer switched to " + player.getPokemon(input).getName());
            window.setComputerPoke(player.getPokemon(input));
            window.setComputerPicture(new DrawPicture(player.getPokemon(input)));
        }
        else if (i >= player.inventoryLength() + 10)
        {
            //System.out.println("Computer is out");
            window.addToTextBox("The computer is out of Pokemon.");
            window.addToTextBox("YOU WIN!");
            window.disableButtons();
        }
        else
        {
            //System.out.println("Call Again");
            i++;
            switchComputerPokemon(input, i);
        }
    }

    /***************************************************************
     * Method: switchPlayerPokemon()
     * Purpose: To switch the players current pokemon when the
     * class is instantiated with the isComputer variable set to false
     * Input: None
     * Output: Switches the players pokemon in the GUI
     ***************************************************************/

    public void switchPlayerPokemon()
    {
        for(JRadioButton aRad : checkButton)
        {
            if(aRad.isSelected()) // cycles through each radio button to see which one is checked
            {
                for (int i = 0; i < player.inventoryLength(); i++)
                {
                    // finds the pokemon in the players inventory that is equal to the selected button
                    if (aRad.getText() == player.getPokemon(i).getName())
                    {
                        if(player.getPokemon(i).isFainted())
                        {
                            JOptionPane.showMessageDialog(null, "This Pokemon is fainted!");
                        }
                        else
                        {
                            window.setPlayerPoke(player.getPokemon(i)); // sets the players pokemon to the selected one
                            window.addToTextBox(player.getName() + " selected: " + player.getPokemon(i).getName()); // MSF outputs to the console for testing
                            window.setPlayerLabel(window.getPlayerPoke().getName() + ": " // changes the health label at the top
                                    + window.getPlayerPoke().getHealth()
                                    + "/" + window.getPlayerPoke().getFullHealth());
                            SelectAbilityWindow compAbilities = new SelectAbilityWindow(window.getPlayerPoke(), window.getComputerPoke(), window, true);
                            window.enableButtons();
                            window.setPlayerPicture(new DrawPicture(window.getPlayerPoke()));
                            dispose();
                        }
                    }
                }
            }
        }
    }

    /***************************************************************
     * Class: SwitchPokemon
     * Purpose: The action listener for the confirmButton to switch
     * the pokemon
     * Input: the confirmButton
     * Output: switches the pokemon
     ***************************************************************/

    private class SwitchPokemon implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == confirmButton)
            {
                switchPlayerPokemon();
            }
        }
    }
}
