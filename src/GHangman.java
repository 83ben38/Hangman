import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GObject;

import java.util.ArrayList;

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
}
