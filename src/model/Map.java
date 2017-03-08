package model;

import javafx.geometry.Pos;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dover on 2017-03-03.
 */
public class Map {

    private long seed;
    private Random r;

    private int numberOfVillages;
    private int numberOfCastles;

    private int x;
    private int y;
    private MapObject[][] map;

    private int waterDist;
    private int mountainDist;

    private ArrayList<Position> waterTiles;
    private ArrayList<Position> mountainTiles;
    private ArrayList<Position> castleTiles;
    private ArrayList<Position> villageTiles;
    private ArrayList<Position> fieldTiles;
    private ArrayList<Position> forestTiles;
    private ArrayList<Position> roadTiles;


    public Map(int x, int y){
        // Get seed and set it
        Random seeder = new Random();
        seed = seeder.nextLong();
        r = new Random(seed);

        // Initialize position arrays
        waterTiles = new ArrayList<>();
        mountainTiles = new ArrayList<>();
        castleTiles = new ArrayList<>();
        villageTiles = new ArrayList<>();
        fieldTiles = new ArrayList<>();
        forestTiles = new ArrayList<>();
        roadTiles = new ArrayList<>();

        // Default values
        numberOfCastles = 1;
        numberOfVillages = 10;
        waterDist = 25;
        mountainDist = 25;

        // Save size of map
        this.x = x;
        this.y = y;
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
        seedWithLakes(waterDist);
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

        for(int i = 0; i < numberOfVillages; i++){
            int x = r.nextInt(this.x);
            int y = r.nextInt(this.y);

            // Don't place village on other village or castle
            if(map[x][y].getType() != FieldType.VILLAGE && map[x][y].getType() != FieldType.CASTLE){
                map[x][y] = new Village(new Position(x,y), FieldType.VILLAGE);
            } else {
                i--;
            }
        }

    }

    /*
    Place castles
     */
    private void generateCastles(){

        for(int i = 0; i < numberOfCastles; i++){
            int x = r.nextInt(this.x);
            int y = r.nextInt(this.y);

            // Don't place castle on another castle
            if(map[x][y].getType() != FieldType.CASTLE){
                map[x][y] = new Castle(new Position(x,y), FieldType.CASTLE);
            } else {
                i--;
            }
        }

    }

    /*
    Place fields
     */
    private void generateFields(){

    }

    /*
    Seed the map with lakes according to the specified distribution.

    Distribution is given as percentage, i.e. 0 - 100.
     */
    private void seedWithLakes(int dist){
        for(int i = 0; i < this.x; i++){
            for(int j = 0; j < this.y; j++){
                // If random number is less than dist, we add a
                // a field of the specified type
                if(r.nextInt(101) < dist){
                    map[i][j] = new Water(new Position(i,j), FieldType.WATER);
                }
            }
        }
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
                } else if(ft == FieldType.ROAD){
                    roadTiles.add(p);
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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(MapObject[] MOList : map){
            for(MapObject mo : MOList){
                FieldType ft = mo.getType();
                if(ft == FieldType.CASTLE){
                    sb.append("C");
                } else if(ft == FieldType.VILLAGE){
                    sb.append("V");
                } else if(ft == FieldType.FIELD){
                    sb.append("P");
                } else if(ft == FieldType.FOREST){
                    sb.append("F");
                } else if(ft == FieldType.MOUNTAIN){
                    sb.append("M");
                } else if(ft == FieldType.WATER){
                    sb.append("W");
                } else if(ft == FieldType.ROAD){
                    sb.append("*");
                } else {
                    throw new Error("Unexpected FieldType" + ft);
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
