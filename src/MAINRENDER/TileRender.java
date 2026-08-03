package MAINRENDER;

import java.awt.*;

import javax.swing.*;

public class TileRender {
    
	JLabel label;
	
	public TileRender() {
		ImageIcon imageIcon = new ImageIcon("/home/alunoinfo/eclipse-workspace/BD/src/BD/CONTROLEDETROPAS_2K/src/ASSETS/images.png");
	    Image img = imageIcon.getImage();
        Image scaledImg = img.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
        ImageIcon finalIcon = new ImageIcon(scaledImg);
	    label = new JLabel(imageIcon);
	}
    
}
