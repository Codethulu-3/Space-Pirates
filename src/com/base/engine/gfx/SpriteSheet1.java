package com.base.engine.gfx;

import com.base.game.Game;
import java.awt.image.BufferedImage;
/**
 * Handles a specific sprite sheet
 * @author Alex
 */
public class SpriteSheet1 { 
    
    private BufferedImage sheet;
    
    public SpriteSheet1(BufferedImage sheet){
        this.sheet = sheet;
    }
    public BufferedImage crop(int col, int row, int w, int h){
        return sheet.getSubimage(col * Game.tilesize, row * Game.tilesize, w, h);
    }
}
