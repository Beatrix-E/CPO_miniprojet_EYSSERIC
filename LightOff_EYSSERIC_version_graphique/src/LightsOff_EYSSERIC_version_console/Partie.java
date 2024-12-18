/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LightsOff_EYSSERIC_version_console;

/**
 *
 * @author beatr
 */
import java.util.Scanner;

public class Partie {
    GrilleDeCellules grille;
    int nbCoups;

    public Partie() {
        String Dif;
        Scanner sc;
        sc = new Scanner(System.in);
        this.nbCoups = 0;
        System.out.println("Choisissez la dificulté de la taille: \n-Facile: F \n-Moyen: M \n-Difficile: D");
        Dif = sc.nextLine();
        while (!Dif.equals("F") && !Dif.equals("M") && !Dif.equals("D")){
            System.out.println("Il y a une erreur Choisisez la dificulte de taille a partir de: \n-Facile: F \n-Moyen: M \n-Difficile: D");
            Dif = sc.nextLine();
        }
        if (Dif.equals("F")){
            grille = new GrilleDeCellules(3,3);
        }
        if (Dif.equals("M")){
            grille = new GrilleDeCellules(5,5);
        }
        if (Dif.equals("D")){
            grille = new GrilleDeCellules(7,7);
        }
        
    }

    
    public void initialiserPartie(){
        String Dif;
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Choisissez la dificulte de Melange: \n-Facile: F \n-Moyen: M \n-Difficile: D");
        Dif = sc.nextLine();
        while (!Dif.equals("F") && !Dif.equals("M") && !Dif.equals("D")){
            System.out.println("Erreur de syntaxe Choisissez la dificulté de Melange a partir de: \n-Facile: F \n-Moyen: M \n-Difficile: D");
            Dif = sc.nextLine();
        }
        if (Dif.equals("F")){
            grille.melangerMatriceAleatoirement(4);
        }
        if (Dif.equals("M")){
            grille.melangerMatriceAleatoirement(6);
        }
        if (Dif.equals("D")){
            grille.melangerMatriceAleatoirement(9);
        }
        }

   
    
    public void lancerPartie(){
        String Pose;
        int nb=1000;
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.print(grille);
        while(grille.cellulesToutesEteintes()!= true){
            System.out.println("choisissez : \n-Ligne: L\n-Colonne: C\n-Diagonale dessendante: Dd\n-Diagional montante: Dm");
            Pose = sc.nextLine();
            System.out.println(Pose);
            while (!Pose.equals("L") && !Pose.equals("C") && !Pose.equals("Dd") && !Pose.equals("Dm")){
                System.out.println("Erreur de syntaxe Choisissez parmi : \n-Ligne: L\n-Colonne: C\n-Diagonale dessendante: Dd\n-Diagional montante: Dm");
                Pose = sc.nextLine();
                System.out.println(Pose);
            }
            if (Pose.equals("Dd")){
                grille.activerDiagonaleDescendante();
                this.nbCoups++;
            }
            if (Pose.equals("Dm")){
                grille.activerDiagonaleMontante();
                this.nbCoups++;
            }
            if (Pose.equals("L")){
                System.out.println( "Choisissez le nombre de la ligne:");
                for(int i = 0; i < grille.nbLignes; i++){
                    System.out.println("- " + i);
                }
                nb = sc.nextInt();
                
                while ( nb > grille.nbLignes){
                    System.out.println( "Erreur de syntaxe Choisissez le nombre de la ligne:");
                    for(int i = 0; i < grille.nbLignes; i++){
                        System.out.println("- " + i);
                    }    
                    nb = sc.nextInt();
                }
                grille.activerLigneDeCellules(nb);
                this.nbCoups++;
            }
            if (Pose.equals("C")){
                System.out.println( "Choisissez le nombre de la ligne:");
                for(int i = 0; i < grille.nbColonnes; i++){
                    System.out.println("- " + i);
                }
                nb = sc.nextInt();
                while ( nb > grille.nbColonnes){
                    System.out.println( "Erreur de syntaxe Choisissez le nombre de la ligne:");
                    for(int i = 0; i < grille.nbColonnes; i++){
                        System.out.println("- " + i);
                    }  
                    nb = sc.nextInt();
                }
                grille.activerColonneDeCellules(nb);
                this.nbCoups++;
            }
            if (this.nbCoups == 1){
                System.out.println("Vous etes au: "+this.nbCoups+"er coup.");
            }
            else System.out.println("Vous etes au: "+this.nbCoups+"eme coup.");
            System.out.print(grille);
        
        }
        System.out.print("BRAVOS vous avez réussi en: "+this.nbCoups+" coup!!!");
    }
}

    
   
    