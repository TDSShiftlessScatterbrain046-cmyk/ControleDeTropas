package MAINRENDER;

import java.awt.*;
import javax.swing.*;

public class TileRender extends JPanel{

        int TileSize, XTiles, YTiles;
        int[] currentPos = {0,0};
        int[] currentChunk = {0,0};
        int paddingTiles = 2;
        int PadPixels = paddingTiles*TileSize;
        int chunkSize = 16;
        int[][][] ChunkLoadedIds = new int[9][chunkSize][chunkSize]; // chunk, x, y

      public TileRender(int tileSize, int xTiles, int yTiles) {
         TileSize = tileSize;
         XTiles = xTiles;
         YTiles = yTiles;
         this.setBounds(-PadPixels,-PadPixels,xTiles*tileSize,yTiles*tileSize);
         this.setPreferredSize(new Dimension(xTiles*tileSize,yTiles*tileSize));
         this.setLayout(new GridLayout(xTiles+paddingTiles,yTiles+paddingTiles));
         this.setDoubleBuffered(true);
      }
      
      
      public void Update(int[] newChunk) {
        if(newChunk == currentChunk){
          return;
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
      public void Draw(int[] newPos){
        currentPos = newPos;
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
            if(tempY>=16)	{tempY-=16;	tempC+=3;}
            if(tempY<0)		{tempY+=16;	tempC-=3;}
            System.out.println("Chunk:"+tempC+"X:"+tempX+"Y:"+tempY);
            Tile zeBigeling = new Tile(ChunkLoadedIds[tempC][tempX][tempY]);
            this.add(zeBigeling);
          }
      }
}