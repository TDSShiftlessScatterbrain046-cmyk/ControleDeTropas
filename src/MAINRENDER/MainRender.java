package MAINRENDER;

import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;

public class MainRender {
	
	public static void main(String[] args) {
		
		
		JFrame janela = new JFrame();
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    janela.setTitle("TROPSAS"); // Define o título
	   // Encerra o programa ao fechar
	    
	    MAINpaneling MainPanel = new MAINpaneling(32,20,15);
	    janela.add(MainPanel);
	    
	    janela.pack();
	    
	    janela.setLocationRelativeTo(null); // Centraliza a janela na tela
	    janela.setVisible(true); // Torna a janela visível
	    
		MainPanel.requestFocusInWindow();
		
	    MainPanel.StartGameThread();
	    
        
	}
	
}
