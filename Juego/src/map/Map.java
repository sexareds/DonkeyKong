package map;


import gfx.Screen;

public abstract class Map {
    protected int width;
    protected int height;
    protected int[] tiles;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateMap();
    }

    public Map(String path) {
        //loadMap(path);
    }

    protected void generateMap() {
        
    }

    /*private loadMap(String path) {

    }*/

    public void tick() {

    }

    public void render(int dx, int dy, Screen screen) {
        int n = dy >> 5;
        int s = (dy + screen.getHeight()) >> 5;
        int w = dx >> 5; 
        int e = (dx + screen.getWidth()) >> 5;

        k
    }
}
