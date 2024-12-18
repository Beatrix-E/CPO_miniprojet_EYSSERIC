/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightsoff;

/**
 *
 * @author beatr
 */
public class LightOff_EYSSERIC_version_console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CelluleLumineuse cellule1 = new CelluleLumineuse();
               
        cellule1.getEtat(); 
        cellule1.afficherEtat();
        System.out.println(); 
       
       
        cellule1.activerCellule();
        cellule1.getEtat(); 
        cellule1.afficherEtat(); 
        System.out.println(); 
        
        cellule1.eteindreCellule();
        cellule1.getEtat();  
        cellule1.afficherEtat();
       
        
        GrilleDeCellules grille = new GrilleDeCellules(5, 5); // Crée une grille de 5x5

        System.out.println("Grille initiale :");
        System.out.println(grille.toString());

        grille.melangerMatriceAleatoirement(3); // Mélange la grille avec 3 tours
        System.out.println("Grille après mélange :");
        System.out.println(grille.toString());

        grille.eteindreToutesLesCellules(); // Éteint toutes les cellules
        System.out.println("Grille après extinction de toutes les cellules :");
        System.out.println(grille.toString());
    
    
    
        Partie test1 =new Partie();
        test1.initialiserPartie();
        test1.lancerPartie();
    }

}


