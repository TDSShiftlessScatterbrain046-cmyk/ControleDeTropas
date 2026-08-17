package MAINRENDER;

import java.awt.*;
import javax.swing.*;

public class TileRender extends JPanel{

        int TileSize = 32, XTiles = 0, YTiles = 0;
        int[] MidTile = {0,0};
        int paddingTiles = -2;
        int PadPixels = paddingTiles*TileSize;
        int ChunkSize = 16;
        int[][][] ChunkLoadedIds = new int[9][ChunkSize][ChunkSize]; // chunk, x, y

      public TileRender(int tileSize, int xTiles, int yTiles, int chunkSize) {
    	 ChunkSize = chunkSize;
    	 TileSize = tileSize;
         XTiles = xTiles;
         YTiles = yTiles;
         PadPixels = paddingTiles*TileSize;
         MidTile[0] = xTiles/2;
         MidTile[1] = yTiles/2;
         this.setSize(tileSize*10,tileSize*10);
//         this.setPreferredSize(new Dimension(xTiles*tileSize,yTiles*tileSize));
         this.setLayout(new GridLayout(xTiles+paddingTiles,yTiles+paddingTiles));
         this.setDoubleBuffered(true);
         this.setBackground(Color.BLUE);
      }
      
      
      public void Update(Camera cam) {
        /*if(newChunk == currentChunk){
          return;
        }*/
        for(int i=0; i<ChunkLoadedIds.length;i++) {
        	for(int j=0; j<ChunkLoadedIds[i].length;j++) {
        		for(int k=0; k<ChunkLoadedIds[i][j].length;k++) {
        			ChunkLoadedIds[i][j][k] = 0;
        			if(j+k==3) {ChunkLoadedIds[i][j][k] = 2;}
        			if(i==0) {ChunkLoadedIds[i][j][k] = 1;}
        			if(i==1) {ChunkLoadedIds[i][j][k] = 2;}
        			

                }
            }
        }
        /*
        currentChunk = newChunk;
        if(map folder file exist)
            for(int i=0; i<9;i++){
              int[] filecheck = currentchunk;
              filecheck[0] += i%3;
              filecheck[1] += i/3;
              if (filecheckmap exists)    
                 ChunkLoadedIds[i] = Map.receive(filecheck);
          }
        */
      }
      public void Draw(Camera cam){
    	  this.removeAll();
    	  this.setLocation(-PadPixels+cam.SubTilePos[0],-PadPixels+cam.SubTilePos[0]);
    	  for(int i=0;i<(XTiles+paddingTiles);i++)
              for(int j=0;j<(YTiles+paddingTiles);j++){
                int tempX = cam.TilePos[0]+MidTile[0]+i;
                int tempY = cam.TilePos[1]+MidTile[1]+j;
                int tempC = 0;
                if(tempX>=16)	{tempX-=16;	tempC+=1;}
                if(tempX<0)		{tempX+=16;	tempC-=1;}
                if(tempY>=16)	{tempY-=16;	tempC+=3; }
                if(tempY<0)		{tempY+=16;	tempC-=3;}
                Tile zeBigeling = new Tile(ChunkLoadedIds[tempC][tempX][tempY]);
                this.add(zeBigeling);
              }
    	  this.revalidate(); // Recompute layout
          this.repaint();    // Trigger redraw
    	  
    	  
    	  
    	  
    	  /*currentPos = newPos;
        int[] TilePos = currentPos;
        TilePos[0] /= TileSize;
        TilePos[1] /= TileSize;
        this.setLocation(currentPos[0]-TilePos[0],currentPos[1]-TilePos[1]);
        int[] halfwidth = {XTiles/2,YTiles/2};
        for(int i=0;i<(XTiles+paddingTiles);i++)
          for(int j=0;j<(YTiles+paddingTiles);j++){
            int tempX = TilePos[0]+halfwidth[0]+i;
            int tempY = TilePos[1]+halfwidth[1]+j;
            int tempC = 0;
            if(tempX>=16)	{tempX-=16;	tempC+=1;}
            if(tempX<0)		{tempX+=16;	tempC-=1;}
            if(tempY>=16)	{tempY-=16;	tempC+=3; }
            if(tempY<0)		{tempY+=16;	tempC-=3;}
            Tile zeBigeling = new Tile(ChunkLoadedIds[tempC][tempX][tempY]);
            this.add(zeBigeling);
          }
      */
      }
}