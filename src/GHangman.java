import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GOval;

import java.awt.*;
import java.util.ArrayList;
import svu.csc213.Dialog;

public class GHangman extends GCompound {
    ArrayList<GObject> b = new ArrayList<>();
    public GHangman(){
        GLine l = new GLine(-30,30,30,30);
        add(l);
        GLine r = new GLine(0,30,0,-60);
        add(r);
        GLine o = new GLine(0,-60,30,-60);
        add(o);
        GLine w = new GLine(30,-60,30,-30);
        add(w);
    }
    public void reset(){
        while(b.size()>0){
            remove(b.get(0));
            b.remove(0);
        }
    }
    public void add(){
        GObject v = null;
        switch (b.size()){
            case 0 ->{
                v = new GOval(15,15);
                v.setLocation(30-v.getWidth()/2,-30);
            }
            case 1 -> v = new GLine(30,-15,30,0);
            case 2 -> v = new GLine(30,-10,15,-20);
            case 3 -> v = new GLine(30,-10,45,-20);
            case 4 -> v = new GLine(30,-5,15,5);
            case 5 -> v = new GLine(30,-5,45,5);
            case 6 ->{
                v = new GOval(5,5);
                ((GOval)v).setFilled(true);
                ((GOval)v).setFillColor(Color.black);
                v.setLocation(25,-25);
            }
            case 7 ->{
                v = new GOval(5,5);
                ((GOval)v).setFilled(true);
                ((GOval)v).setFillColor(Color.black);
                v.setLocation(35,-25);
            }
            default -> {
                Dialog.showMessage("You died.");
                System.exit(0);
            }
        }
        add(v);
        b.add(v);
    }

}
