package roomcomponents;


import interfaces.CheckableForContent;
import interfaces.Wallable;
import roomcomponents.nullobjects.NullKey;

import java.io.Serializable;
import java.util.Objects;

public class Painting implements Wallable, CheckableForContent, Serializable {

    private roomcomponents.Key itemIn;

    private Painting(){ this.itemIn=new NullKey(); }
    private Painting(roomcomponents.Key key){
        Objects.requireNonNull(key);
        this.itemIn=key; 
    }
    public static Painting getInstance(){ return new Painting(); }
    public static Painting valueOf(roomcomponents.Key key){ return new Painting(key); }

    public void setInside(roomcomponents.Key key){
        Objects.requireNonNull(key);
        this.itemIn=key;
    }


    public roomcomponents.Key getInside() {
        return itemIn;
    }
    
    @Override
    public String look() { return Painting.className(); }
    @Override
    public roomcomponents.Key check() {
        if( this.itemIn.getDescription() != NullKey.description()){
            roomcomponents.Key tempKey = this.itemIn;
            this.itemIn = new NullKey();
            return tempKey;
        }
        else
            return new NullKey();
    }

    public static String className(){
        return "Painting";
    }

    @Override
    public String toString() {
        return "Painting";
    }
}
