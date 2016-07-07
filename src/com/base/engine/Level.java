package com.base.engine;

import java.awt.Graphics;

/**
 * Parent class for all levels
 * @author Alex
 */
public abstract class Level {
    
    
    public abstract void tick();
    public abstract void render(Graphics g);
    
    
}
