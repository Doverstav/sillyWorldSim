package model;

/**
 * Created by dover on 2017-03-03.
 */
public abstract class MapObject {

    private Position pos;
    private Enum type;

    public MapObject(Position p, Enum t){
        pos = p;
        type = t;
    }

    public Position getPosition(){
        return pos;
    }

    public Enum getType(){
        return type;
    }

    public void update(){};

}
