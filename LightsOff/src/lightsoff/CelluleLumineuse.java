/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsoff;

/**
 *
 * @author beatr
 */
public class CelluleLumineuse {
    boolean etat=false;
    void activerCellule() {
        this.etat=! this.etat;
    }

    void eteindreCellule() {
        etat= false;
        
    void estEteint() {
        bool estEteinte=true;
        if (etat==false) {
            estEteinte=true;
        }else{
            estEteinte=false;
        }
    }
    
    void getEtat() {
        System.out.println(etat);
        
    }
    
    if (etat==true) {
        System.out.print ("X");
    }else{
        System.out.print ("O");
        
    }
}

    
}
