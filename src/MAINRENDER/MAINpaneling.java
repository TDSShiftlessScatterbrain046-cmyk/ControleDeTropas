package MAINRENDER;

import java.awt.*;
import javax.swing.*;
import INPUTS.*;

public class MAINpaneling extends JPanel implements Runnable{

	int TileSize, XTiles, YTiles;
	int FPS = 1;
	Directionals keyH = new Directionals();
	Thread gameThread;
	TileRender TileRenderer;
	CreatureRender CreatureRenderer;
	Camera cam;
	
	int chunkSize = 16;
	int cameraSpeed = 5; 
	int[] cameraCurPos = {0,0}; 
	
	public MAINpaneling(int tileSize, int xTiles, int yTiles) {
		TileSize = tileSize;
		XTiles = xTiles;
		YTiles = yTiles;
		this.setPreferredSize(new Dimension(xTiles*tileSize,yTiles*tileSize));
		this.setOpaque(true);
		this.setLayout(null);
		this.setFocusable(true);
		this.addKeyListener(keyH);
		cam = new Camera(TileSize, cameraCurPos, chunkSize, keyH);
		TileRenderer = new TileRender(TileSize, XTiles, YTiles, chunkSize);
		CreatureRenderer = new CreatureRender(TileSize,keyH);
		this.setBackground(Color.MAGENTA);
		this.add(TileRenderer);
		this.add(CreatureRenderer);
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
				draw();
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
		TileRenderer.Update(cam);
		CreatureRenderer.Update();
	}

	public void draw() {
		this.setBackground(Color.MAGENTA);
		TileRenderer.Draw(cam);
		CreatureRenderer.Draw();
	}
	
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D grap2D = (Graphics2D) g;
//		grap2D.drawRect(XTiles, YTiles, TileSize, TileSize);
//		grap2D.dispose();
//	}
	

}
