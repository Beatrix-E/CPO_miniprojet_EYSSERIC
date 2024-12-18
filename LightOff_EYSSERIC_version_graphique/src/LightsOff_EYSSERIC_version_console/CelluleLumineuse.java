/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LightsOff_EYSSERIC_version_console;

/**
 *
 * @author beatr
 */
public class CelluleLumineuse {
    boolean etat=false;
     void activerCellule() {
        this.etat = !this.etat; 
    }

    
    void eteindreCellule() {
        this.etat = false; 
    }

    
    boolean estEteint() {
        return !this.etat; 
    }

    
    void getEtat() {
        System.out.println("État de la cellule : " + this.etat );
    }

    
    void afficherEtat() {
        if (this.etat==true) {
            System.out.print("X"); 
        } else {
            System.out.print("O"); 
        }
    }
}
