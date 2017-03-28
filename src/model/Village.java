package model;

/**
 * Created by dover on 2017-03-03.
 */
public class Village extends MapObject {

    public Village(Position p, FieldType t){
        super(p,t);
    }

    public Object clone(){
        return new Village(getPosition(), getType());
    }
}
