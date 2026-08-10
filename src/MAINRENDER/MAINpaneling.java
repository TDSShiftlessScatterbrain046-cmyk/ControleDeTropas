package MAINRENDER;

import java.awt.*;
import javax.swing.*;
import INPUTS.*;

public class MAINpaneling extends JPanel implements Runnable{

	int TileSize, XTiles, YTiles;
	int FPS = 10;
	Directionals keyH = new Directionals();
	Thread gameThread;
	TileRender TileRenderer;

	int[] playerPos = {100,100};
	int playerSpeed = 2;
	
	public MAINpaneling(int tileSize, int xTiles, int yTiles) {
		TileSize = tileSize;
		XTiles = xTiles;
		YTiles = yTiles;
		this.setPreferredSize(new Dimension(xTiles*tileSize,yTiles*tileSize));
		this.setBackground(Color.MAGENTA);
		this.setOpaque(true);
		this.setLayout(null);
		this.setFocusable(true);
		this.addKeyListener(keyH);
		TileRenderer = new TileRender(TileSize, XTiles, YTiles);
		this.setDoubleBuffered(true);
	}
	
	
	public void StartGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	};



	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		long timer = 0;
		int drawCount = 0;

		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime)/ drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1){
				update();
				repaint();
				delta--;
				
				drawCount++;
			}
			if(timer >= 1000000000) {
				System.out.println("FPS:"+drawCount);
				drawCount = 0;
				timer = 0;
			}
		}		
	}
	
	public void update() {	
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D grap2D = (Graphics2D) g;
		grap2D.setColor(Color.BLUE);
		grap2D.fillRect(playerPos[0],playerPos[1],TileSize,TileSize);
		grap2D.dispose();
		TileRenderer.Draw(playerPos);
		TileRenderer.Draw(playerPos);

		
	}
}
