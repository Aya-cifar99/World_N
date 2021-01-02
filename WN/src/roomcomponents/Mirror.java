package roomcomponents;

import interfaces.CheckableForContent;
import interfaces.Wallable;
import roomcomponents.nullobjects.NullKey;

import java.io.Serializable;
import java.util.Objects;

public class Mirror implements Wallable, CheckableForContent, Serializable {
    private roomcomponents.Key itemIn;

    private Mirror(){
        this.itemIn=new NullKey();
    }
    private Mirror(roomcomponents.Key key){
        this.itemIn=key;
    }
    public static Mirror getInstance(){
        return new Mirror();
    }
    public static Mirror valueOf(roomcomponents.Key key){
        Objects.requireNonNull(key);
        return new Mirror(key);
    }
    
    
    public void setInside(roomcomponents.Key key){
        Objects.requireNonNull(key);
        this.itemIn=key;
    }

    public roomcomponents.Key getInside() {
        return itemIn;
    }

    @Override
    public String look() { return Mirror.className(); }
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
        return "Mirror";
    }

    @Override
    public String toString() { return "Mirror"; }
}
