package com.base.engine.gfx;

import com.base.game.Game;
import java.awt.image.BufferedImage;
/**
 *
 * @author Alex
 */
public class SpriteSheet {
    
    private BufferedImage sheet;
    
    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }
    public BufferedImage crop(int col, int row, int w, int h){
        return sheet.getSubimage(col * Game.tilesize, row * Game.tilesize, w, h);
    }
}
