package model;

/**
 * Created by dover on 2017-03-04.
 */
public class Road extends MapObject {

    public Road(Position p, FieldType t){
        super(p,t);
    }

    public Object clone(){
        return new Road(getPosition(), getType());
    }
}
