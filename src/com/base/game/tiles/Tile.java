package com.base.game.tiles;

import java.awt.Graphics;

/**
 * Parent class for all tiles
 * @author Alex
 */
public abstract class Tile {
    
    
    
    public abstract void tick();
    public abstract void render(Graphics g);
    
    
    
}
