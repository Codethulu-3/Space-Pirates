package com.base.engine;

import com.base.game.Game;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 * Background processes such as tick, and render
 * @author Alex
 */
public final class Main extends Canvas implements Runnable {
    
    public static int width, height;
    public static boolean running = false;
    public boolean attack=false, look=false;
    public Thread gameThread;
    private BufferStrategy get;
    private Game game;
    
    public void init(){
        this.addKeyListener(new KeyManager());
        game = new Game();
        game.init();
    }
    
    public synchronized void start(){
        if(running)return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    
     public synchronized void stop(){
         if(!running)return;
        try {
            gameThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    @Override
    public void run(){
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60D;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                tick(); 
                delta--;
            }
         render();
        }
        stop();
    }
    
    public void tick(){
        game.tick();
        
    }
    
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
        return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.fillRect(0, 0, width, height);
        game.render(g);
          
        g.dispose();  
        bs.show();
    }
    
    public static void main(String[] args){
        Main main = new Main();
        JFrame frame = new JFrame("Tile Game");
        
        Toolkit tk = Toolkit.getDefaultToolkit();  
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());  
        
        width = xSize;
        height = ySize;
        
        frame.setSize(width,height); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(main);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
        
        main.start();
    }
    
}
