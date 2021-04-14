import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class SelectAbilityWindow extends JFrame
{
    private final int ROWS = 4;
    private final int COLS = 1;

    private JPanel abilityPanel;
    private JPanel confirmPanel;
    private Pokemon playerPoke;
    private Pokemon computerPoke;
    private Pokemon thePokemon;

    private JRadioButton ability1;
    private JRadioButton ability2;
    private JRadioButton ability3;
    private JRadioButton ability4;
    private JPanel ability1Panel;
    private JPanel ability2Panel;
    private JPanel ability3Panel;
    private JPanel ability4Panel;

    private JButton confirmButton;
    private ButtonGroup buttons;
    private ArrayList<JRadioButton> selectedButtons;
    private RadButtonListener listener;

    private BattleWindow window;

    private boolean isComputer;

    public SelectAbilityWindow(Pokemon pPlayerPoke, Pokemon pComputerPoke, BattleWindow pWindow, boolean pIsComputer)
    {
        playerPoke = pPlayerPoke;
        computerPoke = pComputerPoke;
        window = pWindow;
        selectedButtons = new ArrayList<JRadioButton>();
        isComputer = pIsComputer;
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        createAbilityPanel();
        this.add(abilityPanel, BorderLayout.NORTH);
        createConfirmPanel();
        this.add(confirmPanel, BorderLayout.SOUTH);
        this.pack();
        if(!isComputer)
        {
            this.setVisible(true);
        }
        else
        {
            whatWillComputerDo();
        }
    }

    /***************************************************************
     * Method: whatWillComputerDo()
     * Purpose: This method handles all of the logic for the
     * computers turn
     * Input: None
     * Output: Determines if the computer should use an ability or
     * switch pokemon
     ***************************************************************/

    private void whatWillComputerDo()
    {
        Random rand = new Random();
        int input = rand.nextInt(10);
        if(input > 0)
        {
            if(!computerPoke.isFainted())
            {
                if(computerPoke.getHealth() < computerPoke.getFullHealth()/2)
                {
                    input = rand.nextInt(4);
                    if (input == 0)
                    {
                        SwitchPokemonWindow computerSwitch = new SwitchPokemonWindow(window.getComputer(), window, true);
                    }
                    else
                    {
                        useAbility();
                    }
                }
                else
                {
                    useAbility();
                }
            }
        }
        else if(input == 0)
        {
            SwitchPokemonWindow computerSwitch = new SwitchPokemonWindow(window.getComputer(), window, true);
        }

    }

    /***************************************************************
     * Method: createConfirmPanel()
     * Purpose: This method handles creating the panel that holds
     * the confirm button at the bottom of the screen
     * Input: None
     * Output: Displays the button on the screen
     ***************************************************************/

    public void createConfirmPanel()
    {
        confirmPanel = new JPanel();
        confirmButton = new JButton("Confirm Ability");
        confirmButton.addActionListener(listener);
        confirmPanel.add(confirmButton);
    }

    /***************************************************************
     * Method: createAbilityPanel()
     * Purpose: This method handles instantiating the radio buttons
     * and adding them into the panel for the user to select
     * depending on which pokemon they are using
     * Input: None
     * Output: Buttons on the screen
     ***************************************************************/

    private void createAbilityPanel()
    {
        abilityPanel = new JPanel();
        ability1Panel = new JPanel();
        ability2Panel = new JPanel();
        ability3Panel = new JPanel();
        ability4Panel = new JPanel();
        buttons = new ButtonGroup();
        listener = new RadButtonListener();

        if (playerPoke instanceof Alakazam)
        {
            ability1 = new JRadioButton("Psychic");
            ability2 = new JRadioButton("Psybeam");
            ability3 = new JRadioButton("Hyper Beam");
            ability4 = new JRadioButton("Confusion");
        }
        else if(playerPoke instanceof Blastoise)
        {
            ability1 = new JRadioButton("Tackle");
            ability2 = new JRadioButton("Bite");
            ability3 = new JRadioButton("Bubble Beam");
            ability4 = new JRadioButton("Hydro Pump");
        }
        else if(playerPoke instanceof Charizard)
        {
            ability1 = new JRadioButton("Scratch");
            ability2 = new JRadioButton("Ember");
            ability3 = new JRadioButton("Flamethrower");
            ability4 = new JRadioButton("Slash");
        }
        else if(playerPoke instanceof Gyarados)
        {
            ability1 = new JRadioButton("Bite");
            ability2 = new JRadioButton("Waterfall");
            ability3 = new JRadioButton("Hydro Pump");
            ability4 = new JRadioButton("Dragon Tail");
        }
        else if(playerPoke instanceof Machamp)
        {
            ability1 = new JRadioButton("Karate Chop");
            ability2 = new JRadioButton("Brick Break");
            ability3 = new JRadioButton("Submission");
            ability4 = new JRadioButton("Superpower");
        }
        else if(playerPoke instanceof Mewtwo)
        {
            ability1 = new JRadioButton("Psychic");
            ability2 = new JRadioButton("Dream Eater");
            ability3 = new JRadioButton("Thunder Punch");
            ability4 = new JRadioButton("Fire Blast");
        }
        else if(playerPoke instanceof Pikachu)
        {
            ability1 = new JRadioButton("Quick Attack");
            ability2 = new JRadioButton("Thunder Shock");
            ability3 = new JRadioButton("Thunderbolt");
            ability4 = new JRadioButton("Thunder");
        }
        else if(playerPoke instanceof Scyther)
        {
            ability1 = new JRadioButton("U-Turn");
            ability2 = new JRadioButton("Wing Attack");
            ability3 = new JRadioButton("X-Scissor");
            ability4 = new JRadioButton("Slash");
        }
        else if(playerPoke instanceof Snorlax)
        {
            ability1 = new JRadioButton("Tackle");
            ability2 = new JRadioButton("Head Butt");
            ability3 = new JRadioButton("Body Slam");
            ability4 = new JRadioButton("Superpower");
        }
        else if(playerPoke instanceof Tauros)
        {
            ability1 = new JRadioButton("Horn Attack");
            ability2 = new JRadioButton("Takedown");
            ability3 = new JRadioButton("Thrash");
            ability4 = new JRadioButton("Outrage");
        }
        else if(playerPoke instanceof Venusaur)
        {
            ability1 = new JRadioButton("Tackle");
            ability2 = new JRadioButton("Takedown");
            ability3 = new JRadioButton("Vine Whip");
            ability4 = new JRadioButton("Solar Beam");
        }
        else if(playerPoke instanceof Zapdos)
        {
            ability1 = new JRadioButton("Drill Peck");
            ability2 = new JRadioButton("Thunder");
            ability3 = new JRadioButton("Sky Attack");
            ability4 = new JRadioButton("Thunderbolt");
        }

        // Adds the action listener to the radio buttons
        ability1.addActionListener(listener);
        ability2.addActionListener(listener);
        ability3.addActionListener(listener);
        ability4.addActionListener(listener);

        // adds the buttons to a button group to make them work together
        buttons.add(ability1);
        buttons.add(ability2);
        buttons.add(ability3);
        buttons.add(ability4);

        // addes the buttons to an arraylist for future use
        selectedButtons.add(ability1);
        selectedButtons.add(ability2);
        selectedButtons.add(ability3);
        selectedButtons.add(ability4);

        // adds the buttons to each of their own individual panels and adds a border
        ability1Panel.add(ability1);
        ability1Panel.setBorder(BorderFactory.createLineBorder(Color.black));
        ability2Panel.add(ability2);
        ability2Panel.setBorder(BorderFactory.createLineBorder(Color.black));
        ability3Panel.add(ability3);
        ability3Panel.setBorder(BorderFactory.createLineBorder(Color.black));
        ability4Panel.add(ability4);
        ability4Panel.setBorder(BorderFactory.createLineBorder(Color.black));

        // sets the abilityPanel to be a grid layout and adds each of the buttons panels
        abilityPanel.setLayout(new GridLayout(ROWS, COLS));
        abilityPanel.add(ability1Panel);
        abilityPanel.add(ability2Panel);
        abilityPanel.add(ability3Panel);
        abilityPanel.add(ability4Panel);
    }

    /***************************************************************
     * Class: RadButtonListener
     * Purpose: The Action Listener for the confirm button to use
     * the correct ability depending on which radio button was
     * selected
     ***************************************************************/

    private class RadButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            playerPoke.addWindow(window);
            if (e.getSource() == confirmButton)
            {
                useAbility(); // Allows player to use an ability
                if (playerPoke.getSpeed() > computerPoke.getSpeed()) // MSF check later, do i need this?
                {
                    SelectAbilityWindow compAbilities = new SelectAbilityWindow(playerPoke, computerPoke, window, true); // Creates a new object of this class to work with the computer
                }
                window.enableButtons();
            }
        }
    }

    /***************************************************************
     * Method: useAbility()
     * Purpose: Determines which pokemon the player is using and
     * then selects the correct ability that was selected with the
     * radio button in the screen
     *
     * ** Note: after doing it this way it really made be think of
     * how might they have done it in the actual game because there
     * is no chance they did it like this
     *
     * Input: None
     * Output: The correct selected ability
     ***************************************************************/

    private void useAbility()
    {
        int input;
        // if the class was instantiated by the computer it
        // uses a random number generator instead of the radio buttons
        if(isComputer)
        {
            Random rand = new Random();
            input = rand.nextInt(4);
            computerPoke.addWindow(window);
            thePokemon = computerPoke;
        }
        else
        {
            thePokemon = playerPoke;
            input = 5; // this is just some un-used number so intellij wont yell at me for not instantiating it
        }
        // Im commenting the first ability but not the rest, its all the same, if you get the one you get the rest
        if (thePokemon instanceof Alakazam) // Checks which pokemon it is
        {
            if (ability1.isSelected() || input == 0) // checks for input from the button or the RNG
            {
                if(isComputer) // if it is the computer (Uses RNG input) it calls the ability for the computer
                {
                    ((Alakazam)computerPoke).Psychic(playerPoke, isComputer);
                    dispose();
                }
                else // if it is the player (Uses button input) it calls the ability for the player
                {
                    ((Alakazam)playerPoke).Psychic(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Alakazam)computerPoke).Psybeam(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Alakazam)playerPoke).Psybeam(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Alakazam)computerPoke).HyperBeam(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Alakazam)playerPoke).HyperBeam(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Alakazam)computerPoke).Confusion(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Alakazam)playerPoke).Confusion(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Blastoise)
        {

            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Blastoise)computerPoke).Tackle(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Blastoise)playerPoke).Tackle(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Blastoise)computerPoke).Bite(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Blastoise)playerPoke).Bite(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Blastoise)computerPoke).BubbleBeam(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Blastoise)playerPoke).BubbleBeam(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Blastoise)computerPoke).HydroPump(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Blastoise)playerPoke).HydroPump(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Charizard)
        {
            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Charizard)computerPoke).Scratch(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Charizard)playerPoke).Scratch(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Charizard)computerPoke).Ember(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Charizard)playerPoke).Ember(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Charizard)computerPoke).FlameThrower(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Charizard)playerPoke).FlameThrower(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Charizard)computerPoke).Slash(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Charizard)playerPoke).Slash(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Gyarados)
        {
            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Gyarados)computerPoke).Bite(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Gyarados)playerPoke).Bite(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Gyarados)computerPoke).Waterfall(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Gyarados)playerPoke).Waterfall(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Gyarados)computerPoke).HydroPump(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Gyarados)playerPoke).HydroPump(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Gyarados)computerPoke).DragonTail(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Gyarados)playerPoke).DragonTail(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Machamp)
        {
            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Machamp)computerPoke).KarateChop(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Machamp)playerPoke).KarateChop(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Machamp)computerPoke).BrickBreak(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Machamp)playerPoke).BrickBreak(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Machamp)computerPoke).Submission(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Machamp)playerPoke).Submission(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Machamp)computerPoke).Superpower(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Machamp)playerPoke).Superpower(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Mewtwo)
        {
            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Mewtwo)computerPoke).Psychic(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Mewtwo)playerPoke).Psychic(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Mewtwo)computerPoke).DreamEater(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Mewtwo)playerPoke).DreamEater(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Mewtwo)computerPoke).ThunderPunch(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Mewtwo)playerPoke).ThunderPunch(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Mewtwo)computerPoke).FireBlast(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Mewtwo)playerPoke).FireBlast(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Pikachu)
        {
            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Pikachu)computerPoke).QuickAttack(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Pikachu)playerPoke).QuickAttack(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Pikachu)computerPoke).ThunderShock(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Pikachu)playerPoke).ThunderShock(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Pikachu)computerPoke).ThunderBolt(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Pikachu)playerPoke).ThunderBolt(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Pikachu)computerPoke).Thunder(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Pikachu)playerPoke).Thunder(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Scyther)
        {
            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Scyther)computerPoke).UTurn(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Scyther)playerPoke).UTurn(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Scyther)computerPoke).WingAttack(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Scyther)playerPoke).WingAttack(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Scyther)computerPoke).XScissor(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Scyther)playerPoke).XScissor(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Scyther)computerPoke).Slash(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Scyther)playerPoke).Slash(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Snorlax)
        {
            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Snorlax)computerPoke).Tackle(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Snorlax)playerPoke).Tackle(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Snorlax)computerPoke).Headbutt(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Snorlax)playerPoke).Headbutt(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Snorlax)computerPoke).BodySlam(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Snorlax)playerPoke).BodySlam(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Snorlax)computerPoke).Superpower(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Snorlax)playerPoke).Superpower(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Tauros)
        {
            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Tauros)computerPoke).HornAttack(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Tauros)playerPoke).HornAttack(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Tauros)computerPoke).TakeDown(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Tauros)playerPoke).TakeDown(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Tauros)computerPoke).Thrash(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Tauros)playerPoke).Thrash(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Tauros)computerPoke).Outrage(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Tauros)playerPoke).Outrage(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Venusaur)
        {
            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Venusaur)computerPoke).Tackle(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Venusaur)playerPoke).Tackle(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Venusaur)computerPoke).TakeDown(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Venusaur)playerPoke).TakeDown(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Venusaur)computerPoke).VineWhip(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Venusaur)playerPoke).VineWhip(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Venusaur)computerPoke).SolarBeam(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Venusaur)playerPoke).SolarBeam(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
        else if(thePokemon instanceof Zapdos)
        {
            if (ability1.isSelected() || input == 0)
            {
                if(isComputer)
                {
                    ((Zapdos)computerPoke).DrillPeck(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Zapdos)playerPoke).DrillPeck(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability2.isSelected() || input == 1)
            {
                if(isComputer)
                {
                    ((Zapdos)computerPoke).Thunder(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Zapdos)playerPoke).Thunder(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability3.isSelected() || input == 2)
            {
                if(isComputer)
                {
                    ((Zapdos)computerPoke).SkyAttack(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Zapdos)playerPoke).SkyAttack(computerPoke, isComputer);
                    dispose();
                }
            }
            else if(ability4.isSelected() || input == 3)
            {
                if(isComputer)
                {
                    ((Zapdos)computerPoke).Thunderbolt(playerPoke, isComputer);
                    dispose();
                }
                else
                {
                    ((Zapdos)playerPoke).Thunderbolt(computerPoke, isComputer);
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an ability.");
            }
        }
    }
}
