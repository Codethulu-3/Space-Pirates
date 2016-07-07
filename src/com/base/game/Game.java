package com.base.game;

import com.base.engine.Main;
import java.awt.Graphics;

/**
 *
 * @author Alex
 */
public class Game {
    
    public static int tilesize = 32, scale = 1;
    public static int width = Main.width, height = Main.height;
    private Player player;
    
    public void init(){
        player = new Player(0,0);
    }
    
    public void tick(){
        player.tick();
    }
    
    public void render(Graphics g){
        player.render(g);
    }
    
}
