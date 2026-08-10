package entity;

import INPUTS.Directionals;

public class player extends Entity{

	public player() {
		this.Basesize = 32;
		this.Speed = 32;
		
	}
	
	public void MoveUpdate(Directionals KeyH) {
		int[] sides = {0,0};
		if(KeyH.W) {sides[1] -= Speed;} else
		if(KeyH.A) {sides[1] += Speed;} else {sides[1] = 0;}		
		if(KeyH.S) {sides[0] -= Speed;} else 
		if(KeyH.D) {sides[0] += Speed;} else {sides[0] = 0;}		
		this.Pos[0] += sides[0];
		this.Pos[1] += sides[1];
	}
}
