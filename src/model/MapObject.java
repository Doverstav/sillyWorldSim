package model;

/**
 * Created by dover on 2017-03-03.
 */
public abstract class MapObject {

    private Position pos;
    private FieldType type;

    public MapObject(Position p, FieldType t){
        pos = p;
        type = t;
    }

    public Position getPosition(){
        return pos;
    }

    public Enum getType(){
        return type;
    }

}
