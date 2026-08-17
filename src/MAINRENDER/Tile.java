package MAINRENDER;

import java.awt.*;
import javax.swing.*;

public class Tile extends JLabel{
  
        int id;

        public Tile(int id) {
            this.id = id;
            this.setBackground(Color.black);
            ImageIcon imageIcon;
            switch(id){
            	case 0:
	                this.setBackground(Color.black);
	                imageIcon = new ImageIcon("/home/alunoinfo/eclipse-workspace/BD/src/BD/CONTROLEDETROPAS_2K/src/ASSETS/images.png");
	                this.setIcon(imgResizer(imageIcon,32));
	                break;
            	case 1:
            		this.setBackground(Color.red);
            		imageIcon = new ImageIcon("/home/alunoinfo/eclipse-workspace/BD/src/BD/CONTROLEDETROPAS_2K/src/ASSETS/images.png");
            		this.setIcon(imgResizer(imageIcon,32));
            		break;
            	case 2:
            		this.setBackground(Color.green);
            		imageIcon = new ImageIcon("/home/alunoinfo/eclipse-workspace/BD/src/BD/CONTROLEDETROPAS_2K/src/ASSETS/images.png");
            		this.setIcon(imgResizer(imageIcon,32));
            		break;
            }
            this.setOpaque(true);
        }
        
        public ImageIcon imgResizer(ImageIcon Nonsized, int TileSize){
          Image img = Nonsized.getImage();
          Image scaledImg = img.getScaledInstance(TileSize, TileSize, Image.SCALE_SMOOTH);
          ImageIcon finalIcon = new ImageIcon(scaledImg);
          return finalIcon;
        }

}