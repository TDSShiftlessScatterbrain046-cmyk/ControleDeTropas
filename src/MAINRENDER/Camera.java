package MAINRENDER;

import INPUTS.Directionals;

public class Camera {
	int TileSize = 32;
	int ChunkSize = 16;
	int[] ChunkPos = {0,0};
	int[] TilePos = {0,0};
	int[] SubTilePos = {0,0};
	int MoveSpeed = 5;
	Directionals keyH; 
	
	public Camera(int tileSize, int[] subTilePos, int chunkSize,Directionals KeyH) {
		this.TileSize = tileSize;
		this.ChunkSize = chunkSize;
		this.SubTilePos = subTilePos;
		this.keyH = KeyH;
	}
	
	public void Update() {
		int[] sides = {0,0};
		if(keyH.W) {sides[1] -= MoveSpeed;} else
		if(keyH.A) {sides[1] += MoveSpeed;} else {sides[1] = 0;}		
		if(keyH.S) {sides[0] -= MoveSpeed;} else 
		if(keyH.D) {sides[0] += MoveSpeed;} else {sides[0] = 0;}		
		this.SubTilePos[0] += sides[0];
		this.SubTilePos[1] += sides[1];
		while(this.SubTilePos[0]>TileSize) 	{this.SubTilePos[0]-=this.TileSize; this.TilePos[0]++;}
		while(this.SubTilePos[1]>TileSize) 	{this.SubTilePos[1]-=this.TileSize; this.TilePos[1]++;}
		while(this.SubTilePos[0]<=0)		{this.SubTilePos[0]+=this.TileSize; this.TilePos[0]--;}
		while(this.SubTilePos[1]<=0) 		{this.SubTilePos[1]+=this.TileSize; this.TilePos[1]--;}
	}
	
}
