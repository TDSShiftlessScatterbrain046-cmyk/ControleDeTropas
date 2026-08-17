package MAINRENDER;

import javax.swing.*;
import INPUTS.*;
import entity.*;

public class CreatureRender extends JPanel {

	int TileSize = 32;
	player CurPlayer = new player(TileSize);
	Directionals KeyH;
	
	public CreatureRender(int TileSize, Directionals KeyH) {
		this.TileSize = TileSize;
		this.setLayout(null);
		this.KeyH = KeyH;
	}
	

	public void Update() {
		
	}
	
	public void Draw() {
		
	}
	

}
