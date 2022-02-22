import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;

import java.awt.*;

public class GLetter extends GCompound {
    private GLabel letter;
    private GRect line;
    public GLetter(char letter, boolean line){
        if (line){
            this.line = new GRect(18,4);
            this.line.setFillColor(Color.black);
            this.line.setFilled(true);
            add(this.line);
        }
        this.letter = new GLabel(letter + "");
        this.letter.setFont(new Font(this.letter.getFont().getFontName(),Font.PLAIN,36));
        add(this.letter);
        this.letter.setVisible(false);
    }
    public void show(boolean show){
        letter.setVisible(show);
    }
    public char getLetter(){
        return letter.getLabel().charAt(0);
    }
    public boolean getLine(){
        return line != null;
    }
}
