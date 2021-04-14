import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***************************************************************
 * Class: BattleWindow
 * Purpose: The main window for the game containing all of the
 * buttons for the player actions with pictures of each pokemon
 * and their health
 ***************************************************************/

public class BattleWindow extends JFrame
{
    private final int HEIGHT = 600;
    private final int WIDTH = 800;

    private JLabel playerLabel;
    private JLabel computerLabel;

    private final int ROWS = 2;
    private final int COLS = 2;

    private JPanel healthTextPanel;
    private JPanel picturePanel;
    private JPanel buttonPanel;
    private JPanel bottomPanel;
    private JPanel listPanel;
    private JButton abilitiesButton;
    private JButton switchButton;
    private JButton surrenderButton;
    private JButton jodyButton;
    private JTextArea textBox;
    private JScrollPane scrollBar;
    private Player player;
    private Player computer;
    private Pokemon playerPoke;
    private Pokemon computerPoke;
    private ButtonListener listener;

    private DrawPicture playerPicture;
    private DrawPicture computerPicture;

    private boolean playGame = true;

    private BattleWindow thisWindow;

    private gameApp game;

    /***************************************************************
     * Method: BattleWindow
     * Purpose: Constructor for the main window of the game
     * Input: the player and computer objects
     * Output: the window on to the screen
     ***************************************************************/

    public BattleWindow(Player pPlayer, Player pComputer)
    {
        player = pPlayer;
        computer = pComputer;
        thisWindow = this;
        game = new gameApp();
        listener = new ButtonListener();
        playerPoke = player.getPokemon(0);
        computerPoke = computer.getPokemon(0);

        this.setTitle("Pokemon Battle!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(new BorderLayout());
        createHealthTextPanel();
        createBottomPanel();
        createPicturePanel();
        this.add(picturePanel, BorderLayout.CENTER);
        this.add(healthTextPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /***************************************************************
     * Method: createBottomPanel
     * Purpose: creates the panel that shows up at the bottom of the
     * screen that contains the buttons and the list box
     * Input: None
     * Output: None
     ***************************************************************/

    private void createBottomPanel()
    {
        bottomPanel = new JPanel();
        createButtonPanel();
        createListPanel();
        bottomPanel.add(listPanel, BorderLayout.WEST);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);
    }

    /***************************************************************
     * Method: createListPanel
     * Purpose: creates the panel that holds the list that is then
     * added to the bottomPanel
     * Input: None
     * Output: None
     ***************************************************************/

    private void createListPanel()
    {
        listPanel = new JPanel();
        textBox = new JTextArea();
        scrollBar = new JScrollPane(textBox);
        scrollBar.setPreferredSize(new Dimension(400,100)); // TextBox SIZE CHANGE
        textBox.setEditable(false);
        textBox.append("Welcome To The Pokemon Battle!\n");
        listPanel.add(scrollBar);
    }

    /***************************************************************
     * Method: createPicturePanel
     * Purpose: creates the middle panel within the frame that holds
     * the pictures of the pokemon
     * Input: None
     * Output: None
     ***************************************************************/

    private void createPicturePanel()
    {
        picturePanel = new JPanel();
        playerPicture = new DrawPicture(playerPoke);
        computerPicture = new DrawPicture(computerPoke);
        picturePanel.setLayout(new GridLayout(1, 2));
        picturePanel.add(playerPicture);
        picturePanel.add(computerPicture);
    }

    /***************************************************************
     * Method: createHealthTextPanel
     * Purpose: creates the panel at the top of the screen that holds
     * the name each pokemon and their health
     * Input: None
     * Output: None
     ***************************************************************/

    private void createHealthTextPanel()
    {
        healthTextPanel = new JPanel();
        healthTextPanel.setBackground(Color.WHITE);
        playerLabel = new JLabel(playerPoke.getName() + ": " + playerPoke.getHealth()
                + "/" + playerPoke.getFullHealth());
        playerLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        healthTextPanel.add(playerLabel, BorderLayout.WEST);
        computerLabel = new JLabel(computerPoke.getName() + ": " + computerPoke.getHealth()
                + "/" + computerPoke.getFullHealth());
        computerLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        healthTextPanel.add(computerLabel, BorderLayout.EAST);
    }

    /***************************************************************
     * Method: createButtonPanel
     * Purpose: creates the panel that holds the buttons that is
     * later added to the bottomPanel
     * Input: None
     * Output: None
     ***************************************************************/

    private void createButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(ROWS, COLS));
        abilitiesButton = new JButton();
        switchButton = new JButton();
        surrenderButton = new JButton();
        jodyButton = new JButton();
        abilitiesButton.setText("Select Ability");
        switchButton.setText("Switch Pokemon");
        surrenderButton.setText("Surrender");
        jodyButton.setText("Jody's Cheat");
        abilitiesButton.addActionListener(listener);
        switchButton.addActionListener(listener);
        surrenderButton.addActionListener(listener);
        jodyButton.addActionListener(listener);
        buttonPanel.add(abilitiesButton);
        buttonPanel.add(switchButton);
        buttonPanel.add(surrenderButton);
        buttonPanel.add(jodyButton);
    }

    /***************************************************************
     * Method: Accessors and Mutators
     * Purpose: allows me to access or change needed information
     * from the GUI without having to pass it all into another
     * class individually
     * Input:
     * Output:
     ***************************************************************/

    public Player getComputer()
    {
        return computer;
    }

    public void addToTextBox(String text)
    {
        textBox.append(text + "\n");
    }

    public Pokemon getPlayerPoke() {
        return playerPoke;
    }

    public void setPlayerPoke(Pokemon playerPoke) {
        this.playerPoke = playerPoke;
    }

    public Pokemon getComputerPoke() {
        return computerPoke;
    }

    public void setComputerPoke(Pokemon computerPoke) {
        this.computerPoke = computerPoke;
    }

    public void setPlayerLabel(String text)
    {
        playerLabel.setText(text);
    }

    public void setComputerLabel(String text)
    {
        computerLabel.setText(text);
    }

    /***************************************************************
     * Method: setPlayerPicture
     * Purpose: to change the players pokemon picture whenever
     * they change what pokemon they are using
     * Input: A DrawPicture object
     * Output: the picture on the screen
     ***************************************************************/

    public void setPlayerPicture(DrawPicture picture) {
        picturePanel.remove(playerPicture);
        this.playerPicture = picture;
        picturePanel.add(playerPicture);
        picturePanel.add(computerPicture);
    }

    /***************************************************************
     * Method: setComputerPicture()
     * Purpose: To changes the computers pokemon picture whenever
     * the computer changes which pokemon they are using
     * Input: a DrawPicture object
     * Output: the computers picture
     ***************************************************************/

    public void setComputerPicture(DrawPicture cPicture) {
        picturePanel.remove(computerPicture);
        this.computerPicture = cPicture;
        picturePanel.add(playerPicture);
        picturePanel.add(computerPicture);
    }

    /***************************************************************
     * Method: disableButtons() and enableButtons()
     * Purpose: Allows me to disable and enable all the buttons
     * all at once wherever I want
     ***************************************************************/

    public void disableButtons()
    {
        abilitiesButton.setEnabled(false);
        switchButton.setEnabled(false);
        surrenderButton.setEnabled(false);
        jodyButton.setEnabled(false);
    }

    public void enableButtons()
    {
        abilitiesButton.setEnabled(true);
        switchButton.setEnabled(true);
        surrenderButton.setEnabled(true);
        jodyButton.setEnabled(true);
    }

    /***************************************************************
     * Method: determineVictor()
     * Purpose: this method is called at the beginning of each turn
     * determine whether the player or the computer has won the game
     * Input: None
     * Output: Text stating who won the game and it disables the buttons
      ***************************************************************/

    public void determineVictor()
    {
        int playerFainted = 0;
        int computerFainted = 0;
        for (int i = 0; i < player.inventoryLength(); i++)
        {
            if(player.getPokemon(i).isFainted())
            {
                playerFainted ++;
            }

            if (playerFainted == 6)
            {
                addToTextBox("YOU SUCK THE COMPUTER WINS!!!!!!");
                playGame = false;
                disableButtons();
            }
        }
        for (int i = 0; i < computer.inventoryLength(); i++)
        {
            if(computer.getPokemon(i).isFainted())
            {
                computerFainted ++;
            }

            if (computerFainted == 6)
            {
                addToTextBox("YOU WIN!!!!!!");
                playGame = false;
                disableButtons();
            }
        }
    }

    /***************************************************************
     * Class: ButtonListener
     * Purpose: The listener for each of the buttons that are on
     * the buttonPanel
     * Input: None
     * Output: None
     ***************************************************************/

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            determineVictor();
            if(playGame) // if the playGame variable is set to false it won't let the player use the buttons
            {
                if(e.getSource() == abilitiesButton)
                {
                    disableButtons();
                    if (computerPoke.isFainted())
                    {
                        SwitchPokemonWindow computerSwitch = new SwitchPokemonWindow(computer, thisWindow, true);
                    }

                    if (playerPoke.getSpeed() > computerPoke.getSpeed())
                    {
                        if(playerPoke.isFainted())
                        {
                            SwitchPokemonWindow switching = new SwitchPokemonWindow(player, thisWindow, false);
                        }
                        else
                        {
                            SelectAbilityWindow playerAbilities = new SelectAbilityWindow(playerPoke, computerPoke, thisWindow, false);
                        }
                    }
                    else
                    {
                        if(!computerPoke.isFainted())
                        {
                            SelectAbilityWindow compAbilities = new SelectAbilityWindow(playerPoke, computerPoke, thisWindow, true); // Creates a new object of this class to work with the computer
                            if(playerPoke.isFainted())
                            {
                                SwitchPokemonWindow switching = new SwitchPokemonWindow(player, thisWindow, false);
                            }
                            else
                            {
                                SelectAbilityWindow playerAbilities = new SelectAbilityWindow(playerPoke, computerPoke, thisWindow, false);
                            }
                        }
                    }
                }

                if(e.getSource() == switchButton)
                {
                    disableButtons();
                    SwitchPokemonWindow playerSwitch = new SwitchPokemonWindow(player, thisWindow, false); // MSF
                    // AFTER PRESSING THE BUTTON IT WILL CALL A METHOD THAT DOES THE COMPUTERS TURN AND SO ON
                    // UNSURE OF HOW TO DO THE FASTER POKEMON GOES FIRST WITH THIS METHOD
                }

                if(e.getSource() == surrenderButton)
                {
                    addToTextBox("You surrendered, the computer wins!");
                    playGame = false;
                    disableButtons();
                }

                if(e.getSource() == jodyButton)
                {
                    for (int i = 0; i < computer.inventoryLength(); i++)
                    {
                        computer.getPokemon(i).setHealth(0);
                    }
                    computerPoke.setHealth(0);
                }
            }
        }
    }
}
