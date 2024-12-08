/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightsoff;

/**
 *
 * @author beatr
 */
import java.util.Scanner;

public class Partie {
    private GrilleDeCellules grille;
    private int nbCoups;

    public Partie(int nbLignes, int nbColonnes) {
        this.grille = new GrilleDeCellules(nbLignes, nbColonnes);
        this.nbCoups = 0;
    }

    
    public void initialiserPartie() {
        grille.melangerMatriceAleatoirement(10);
    }

   
    public void lancerPartie() {
        initialiserPartie();
        Scanner scanner = new Scanner(System.in);

        System.out.println("État initial de la grille :");
        afficherGrille();

        while (!grille.cellulesToutesEteintes()) {
            
            System.out.print("Entrez une ligne, colonne ou diagonale à activer (0-" + (grille.nbLignes - 1) + ") : ");
            int choix = scanner.nextInt();

            activerZone(choix);

            nbCoups++;


            System.out.println("Nombre de coups : " + nbCoups);


            afficherGrille();
        }

       
        System.out.println("Félicitations ! Vous avez éteint toutes les lumières en " + nbCoups + " coups.");


        scanner.close();
    }

   
    private void activerZone(int zone) {
        
        if (zone >= 0 && zone < grille.nbLignes) {
            grille.activerLigneDeCellules(zone);
        } 
        
        else if (zone >= grille.nbLignes && zone < 2 * grille.nbLignes) {
            grille.activerColonneDeCellules(zone - grille.nbLignes);
        }
        
        else if (zone == 2 * grille.nbLignes) {
            grille.activerDiagonaleDescendante();
        }
        else if (zone == 2 * grille.nbLignes + 1) {
            grille.activerDiagonaleMontante();
        }
    }

    
    private void afficherGrille() {
        System.out.print(grille.toString());
    }

    
    public GrilleDeCellules getGrille() {
        return grille;
    }

    public int getNbCoups() {
        return nbCoups;
    }
}

