package model;

import javafx.geometry.Pos;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dover on 2017-03-03.
 */
public class Map {

    long seed;
    Random r;

    MapObject[][] map;

    ArrayList<Position> waterTiles;
    ArrayList<Position> mountainTiles;
    ArrayList<Position> castleTiles;
    ArrayList<Position> villageTiles;
    ArrayList<Position> fieldTiles;
    ArrayList<Position> forestTiles;


    public Map(int x, int y){
        // Get seed and set it
        seed = System.currentTimeMillis();
        r = new Random(seed);

        map = new MapObject[x][y];
        generateMap();
    }

    private void generateMap(){
        fillMap();
        generateWater();
        generateMountains();
        generateCastles();
        generateVillages();
        generateFields();
        populatePositionFields();
    }

    /*
    Fill with forests
     */
    private void fillMap(){
        for(int x = 0; x < map.length; x++){
            for(int y = 0; y < map[x].length; y++){
                map[x][y] = new Forest(new Position(x,y), FieldType.FOREST);
            }
        }

    }

    /*
    Place water
     */
    private void generateWater(){

    }

    /*
    Place mountains
     */
    private void generateMountains(){

    }

    /*
    Place villages
     */
    private void generateVillages(){

    }

    /*
    Place castles
     */
    private void generateCastles(){

    }

    /*
    Place fields
     */
    private void generateFields(){

    }

    private void populatePositionFields(){
        for(MapObject[] MOList : map){
            for(MapObject mo : MOList){
                FieldType ft = mo.getType();
                Position p = mo.getPosition();
                if(ft == FieldType.CASTLE){
                    castleTiles.add(p);
                } else if(ft == FieldType.VILLAGE){
                    villageTiles.add(p);
                } else if(ft == FieldType.FIELD){
                    fieldTiles.add(p);
                } else if(ft == FieldType.FOREST){
                    forestTiles.add(p);
                } else if(ft == FieldType.MOUNTAIN){
                    mountainTiles.add(p);
                } else if(ft == FieldType.WATER){
                    waterTiles.add(p);
                } else {
                    throw new Error("Unexpected FieldType" + ft);
                }
            }
        }
    }

    public void updateAll(){
        for(MapObject[] MOList : map){
            for(MapObject mo : MOList){
                // Removed for pressing ceremonial reasons
            }
        }
    }

}
