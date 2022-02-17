import acm.program.GraphicsProgram;

public class Hangman extends GraphicsProgram {
    public static void main(String[] args) {
        new Hangman().start();
    }
    public void run(){
        add(new GHangman(),100,100);
        for (int i = 0; i < 8; i++) {
            waitForClick();
            ((GHangman)getElement(0)).add();
        }
        ((GHangman)getElement(0)).reset();

    }
}
