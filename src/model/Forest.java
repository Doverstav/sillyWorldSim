package model;

/**
 * Created by dover on 2017-03-03.
 */
public class Forest extends MapObject {

    public Forest(Position p, FieldType t){
        super(p,t);
    }

    public Object clone(){
        return new Forest(getPosition(), getType());
    }
}
