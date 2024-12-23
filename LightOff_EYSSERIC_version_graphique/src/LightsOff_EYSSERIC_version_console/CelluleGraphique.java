package LightsOff_EYSSERIC_version_console;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author beatr
 */

import LightsOff_EYSSERIC_version_console.CelluleLumineuse;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

public class CelluleGraphique extends JButton {
    int largeur; // largeur en pixel de la cellule
    int hauteur; // hauteur en pixel de la cellule
    CelluleLumineuse celluleLumineuseAssociee;

// constructeur (appelé depuis FenetrePrincipale)
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l,int h) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
        
    }  
    protected void paintComponent(Graphics g) {
        int w = this.getWidth();
        int h = this.getHeight();
        if (celluleLumineuseAssociee.estEteint() == true) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.yellow);
        }
        g.fillOval(2, 2, w - 4, h - 4);
        super.paintComponent(g);
        this.setText(celluleLumineuseAssociee.toString());
    }
    

// Methode gérant le dessin de la cellule
   
    
}