import acm.program.GraphicsProgram;

public class Hangman extends GraphicsProgram {
    public static void main(String[] args) {
        new Hangman().start();
    }
    public void run(){
        add(new GHangman(),100,100);
    }
}
