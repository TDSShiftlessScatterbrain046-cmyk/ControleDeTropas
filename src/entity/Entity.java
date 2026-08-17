package entity;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Entity extends JLabel{
	int[] Pos = {0,0};
	int[] CurChunk = {0,0};
	int ChunkSize = 16;
	int Speed = 0;
	int Basesize = 20;
	
	public Entity() {
			
	}
		
	public ImageIcon imgResizer(ImageIcon Nonsized, int SizeX,int SizeY){
		Image img = Nonsized.getImage();
		Image scaledImg = img.getScaledInstance(SizeX, SizeY, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImg);
		return finalIcon;
	}
}
