package model;

/**
 * Created by dover on 2017-03-03.
 */
public class Mountain extends MapObject {

    public Mountain(Position p, FieldType t){
        super(p,t);
    }

    public Object clone(){
        return new Mountain(getPosition(), getType());
    }
}
