import javax.swing.*;

public class SelectAbillityWindow extends JFrame
{
    private JPanel abilityPanel;
    private JPanel confirmPanel;
    private Pokemon playerPoke;

    // Pikachu's abilities
    private JRadioButton thunderShock;
    private JRadioButton quickAttack;
    private JRadioButton thunder;
    private JRadioButton thunderBolt;

    // Charizard Abilities
    private JRadioButton scratch;
    private JRadioButton ember;
    private JRadioButton flameThrower;
    private JRadioButton slash;

    // Alakazam Abilities
    private JRadioButton psychic;
    private JRadioButton hyperBeam;
    private JRadioButton confusion;
    private JRadioButton psybeam;

    // Blastoise Abilities
    private JRadioButton tackle;
    private JRadioButton bite;
    private JRadioButton bubbleBeam;
    private JRadioButton hydroPump;

    // Gyarados Abilities
    // Bite
    private JRadioButton waterFall;
    // HydroPump
    private JRadioButton dragonTail;

    // Machamp Abilities
    private JRadioButton karateChop;
    private JRadioButton brickBreak;
    private JRadioButton submission;
    private JRadioButton superpower;

    // MewTwo Abilities
    // Psychic
    private JRadioButton dreamEater;
    private JRadioButton thunderPunch;
    private JRadioButton fireBlast;

    // Scyther Abilities
    private JRadioButton uTurn;
    private JRadioButton wingAttack;
    private JRadioButton xScissor;
    // Slash

    // Snorlax Abilities
    // Tackle
    private JRadioButton headButt;
    private JRadioButton BodySlam;
    // Superpower

    // Tauros Abilities
    private JRadioButton hornAttack;
    private JRadioButton takeDown;
    private JRadioButton thrash;
    private JRadioButton outRage;

    // Venusaur Abilities
    // Tackle
    // TakeDown
    private JRadioButton vineWhip;
    private JRadioButton solarBeam;

    // Zapdos Abilities
    private JRadioButton drillPeck;
    // Thunder
    private JRadioButton skyAttack;
    // Thunderbolt

    public SelectAbillityWindow(Pokemon pPlayerPoke)
    {
        playerPoke = pPlayerPoke;
        // I HAVE TO MAKE A UNIQUE RADIO BUTTON FOR EVERY ABILITY THAT I HAVE AND AN IF STATEMENT FOR EACH POKEMON THAT I HAVE TO BE ABLE TO SELECT ABILITIES FML
    }

    private void createAbilityPanel()
    {
        abilityPanel = new JPanel();

        if (playerPoke instanceof Alakazam)
        {
            psychic = new JRadioButton("Psychic");
            psybeam = new JRadioButton("Psybeam");
            hyperBeam = new JRadioButton("Hyper Beam");
            confusion = new JRadioButton("Confusion");
        }
        else if(playerPoke instanceof Blastoise)
        {
            tackle = new JRadioButton("Tackle");
            bite = new JRadioButton("Bite");
            bubbleBeam = new JRadioButton("Bubble Beam");
            hydroPump = new JRadioButton("Hydro Pump");
        }
        else if(playerPoke instanceof Charizard)
        {
            scratch = new JRadioButton("Scratch");
            ember = new JRadioButton("Ember");
            flameThrower = new JRadioButton("Flamethrower");
            slash = new JRadioButton("Slash");
        }
        else if(playerPoke instanceof Gyarados)
        {
            bite = new JRadioButton("Bite");
            waterFall = new JRadioButton("Waterfall");
            hydroPump = new JRadioButton("Hydro Pump");
            dragonTail = new JRadioButton("Dragon Tail");
        }
        else if(playerPoke instanceof Machamp)
        {
            karateChop = new JRadioButton("Karate Chop");
            brickBreak = new JRadioButton("Brick Break");
            submission = new JRadioButton("Submission");
            superpower = new JRadioButton("Superpower");
        }
        else if(playerPoke instanceof Mewtwo)
        {
            psychic = new JRadioButton("Psychic");
            dreamEater = new JRadioButton("Dream Eater");
            thunderPunch = new JRadioButton("Thunder Punch");
            fireBlast = new JRadioButton("Fire Blast");
        }
        else if(playerPoke instanceof Pikachu)
        {

        }
        else if(playerPoke instanceof Scyther)
        {

        }
        else if(playerPoke instanceof Snorlax)
        {

        }
        else if(playerPoke instanceof Tauros)
        {

        }
        else if(playerPoke instanceof Venusaur)
        {

        }
        else if(playerPoke instanceof Zapdos)
        {

        }
    }

}
