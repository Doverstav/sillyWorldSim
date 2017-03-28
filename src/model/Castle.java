package model;

/**
 * Created by dover on 2017-03-03.
 */
public class Castle extends MapObject {

    public Castle(Position p, FieldType t){
        super(p,t);
    }

    public Object clone(){
        return new Castle(getPosition(), getType());
    }

}
