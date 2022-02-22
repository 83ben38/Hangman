import acm.program.GraphicsProgram;
import svu.csc213.Dialog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman extends GraphicsProgram {
    static char[] letters = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static ArrayList<Character> guesses = new ArrayList<>();
    static ArrayList<Character> word = new ArrayList<>();
    static ArrayList<String> words = new ArrayList<>();
    static ArrayList<GLetter> GLetters = new ArrayList<>();
    static ArrayList<Boolean> guessed = new ArrayList<>();
    static GHangman h = new GHangman();
    public static void main(String[] args) {
        new Hangman().start();
    }
    public void run(){
        Scanner f = null;
        try {
            f = new Scanner(new File("./src/words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(f.hasNext()){
            words.add(f.next());
        }
        add(h,100,100);
        while (words.size() > 0){
            //clear everything
            guesses = new ArrayList<>();
            guessed = new ArrayList<>();
            word = new ArrayList<>();
            while(GLetters.size()>0){
                remove(GLetters.get(0));
                GLetters.remove(0);
            }
            h.reset();
            //do a round
            doRound();
        }
        Dialog.showMessage("You have completed all of the words.");
        exit();
    }
    public void doRound(){
        String wor = words.get(randomInt(0,words.size()-1));
        for (int i = 0; i < wor.length(); i++) {
            if (wor.charAt(i) != '_') {
                word.add(wor.charAt(i));
                GLetter l = new GLetter(wor.charAt(i), true);
                add(l, 50 + (i * 30), 200);
                GLetters.add(l);
                guessed.add(false);
            }
            else{
                guessed.add(true);
            }
        }
        for (int i = 0; i < letters.length; i++) {
            char l = letters[i];
                if (!wor.contains(l + "")) {
                    GLetter letter = new GLetter(l, false);
                    add(letter, 100 + ((i % 5 + wor.length()) * 30), 100 + (i / 5) * 50);
                    GLetters.add(letter);
                }

        }
        while(guessed.contains(false)){
            String s = Dialog.getString("What letter do you guess?");
            while (s.length() < 1) {
               s = Dialog.getString("What letter do you guess?");
            }
            char c = s.charAt(0);
            while(guesses.contains(c)){
                s = Dialog.getString("What letter do you guess?");
                while (s.length() < 1) {
                    s = Dialog.getString("What letter do you guess?");
                }
                c = s.charAt(0);
            }
            if (!word.contains(c)){
                h.add();
            }
            for (GLetter l: GLetters) {
                if (l.getLetter() == c){
                    l.show(true);
                    if (l.getLine()){
                        guessed.set((int) ((l.getX()-50)/30),true);
                    }
                }
            }
        }


        Dialog.showMessage("Correct");
        words.remove(wor);
    }
    public int randomInt(int from, int to){
        return (int)(Math.random()*(to-from+1))+from;
    }
}
