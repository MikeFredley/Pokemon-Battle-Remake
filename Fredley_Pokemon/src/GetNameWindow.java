import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***************************************************************
 * Class: GetNameWindow
 * Purpose: To get the name of the person playing the game
 ***************************************************************/

public class GetNameWindow extends JFrame
{
    private JPanel namePanel;
    private JButton confirmName;
    private JTextField nameText;
    private NameListener listener;
    private Player player;
    private Player computer;

    /***************************************************************
     * Method: GetNameWindow
     * Purpose: The constructor the the window
     * Input: the player and computer Player objects
     * Output: None
     ***************************************************************/

    public GetNameWindow(Player pPlayer, Player pComputer)
    {
        listener = new NameListener();
        player = pPlayer;
        computer = pComputer;
        this.setTitle("Enter your name.");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        createNamePanel();
        this.add(namePanel);
        this.pack();
        this.setVisible(true);
    }

    /***************************************************************
     * Method: createNamePanel
     * Purpose: creates the panel that holds the text box and
     *  confirm button
     * Input: None
     * Output: None
     ***************************************************************/

    private void createNamePanel()
    {
        namePanel = new JPanel();
        confirmName = new JButton();
        nameText = new JTextField(16);
        confirmName.setText("Submit");
        confirmName.addActionListener(listener);
        namePanel.add(nameText);
        namePanel.add(confirmName);
    }

    /***************************************************************
     * Class: NameListener
     * Purpose: The action listener for the confirm button for the
     *  name window
     ***************************************************************/

    private class NameListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == confirmName)
            {
                if (nameText.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter your name.");
                }
                else
                {
                    player.setName(nameText.getText()); // sets the players name to the inputted text
                    BattleWindow gui = new BattleWindow(player, computer); // opens new GUI window for the battle
                    dispose(); // closes the window
                }
            }
        }
    }
}
