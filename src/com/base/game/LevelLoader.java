package com.base.game;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Class to load levels in, handles layout and tile replacements
 * @author Alex
 */
public final class LevelLoader {
    public int[][] tiles;
    private int w, h;
    public LevelLoader(BufferedImage levelImage){
        w = levelImage.getWidth();
        h = levelImage.getHeight();
        loadLevel(levelImage);
    }
    public void loadLevel(BufferedImage levelImage){
        tiles = new int[levelImage.getWidth()][levelImage.getHeight()];
        for(int y = 0;y < levelImage.getHeight();y++){
            for(int x = 0;x < levelImage.getWidth();x++){
                Color c = new Color(levelImage.getRGB(x, y));
                String h = String.format("%02x%02x%02x", c.getRed(), c.getBlue(), c.getGreen());
                switch(h){
                    case "48ff00": //grass tile 
                        tiles[x][y] = 1;
                        break;
                    case "727272": // stone wall
                        tiles[x][y] = 2;
                        break;
                    case "729b72": // mossy stone
                        tiles[x][y] = 3;
                        break;
                    case "545454": // cracked stone
                        tiles[x][y] = 4;
                        break;
                    case "0078ce":
                        tiles[x][y] = 5; // Water
                        break;
                    case "725006":
                        tiles[x][y] = 6; // dirt
                        break;
                    default:
                        tiles[x][y] = 1; // error
                        break;
                }
            }
        }   
    }
    public tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= w || y >= h){
            return tile.Void;
        }
        switch(tiles[x][y]){
            case 1:
                return tile.water;
            case 2:
                return tile.StoneWall;
            case 3:
                return tile.dirt;
            case 4:
                return tile.dirt;
            case 5:
                return tile.Void;
            case 6:
                return tile.dirt;
            default:          
                return tile.StoneWall;
        }
    }
}