package model;

import javafx.geometry.Pos;

import java.util.Random;

/**
 * Created by dover on 2017-03-03.
 */
public class Map {

    long seed;
    Random r;

    MapObject[][] map;

    Position[] waterTiles;
    Position[] mountainTiles;
    Position[] castleTiles;
    Position[] villageTiles;
    Position[] FiledTiles;
    Position[] ForestTiles;


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

    }

    public void updateAll(){
        for(MapObject[] MOList : map){
            for(MapObject mo : MOList){
                // Removed for pressing ceremonial reasons
            }
        }
    }

}
