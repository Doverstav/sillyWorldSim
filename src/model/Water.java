package model;

/**
 * Created by dover on 2017-03-03.
 */
public class Water extends MapObject {

    public Water(Position p, FieldType t){
        super(p,t);
    }

    public Object clone(){
        return new Water(getPosition(), getType());
    }
}
