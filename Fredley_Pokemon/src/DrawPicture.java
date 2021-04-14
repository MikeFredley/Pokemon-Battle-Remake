import javax.swing.*;
import java.awt.*;

public class DrawPicture extends JPanel
{
    Pokemon pokemon;

    public DrawPicture(Pokemon pPokemon)
    {
        pokemon = pPokemon;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(pokemon.getPokePic(), 1, 1, 267, 218, null);
    }
}
