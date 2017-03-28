package model;

/**
 * Created by dover on 2017-03-03.
 */
public class Field extends MapObject {

    public Field(Position p, FieldType t){
        super(p,t);
    }

    public Object clone(){
        return new Field(getPosition(), getType());
    }
}
