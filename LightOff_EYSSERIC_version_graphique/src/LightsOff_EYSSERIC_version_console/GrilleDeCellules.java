/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LightsOff_EYSSERIC_version_console;

/**
 *
 * @author beatr
 */
import java.util.Random;

public class GrilleDeCellules {
    
    public CelluleLumineuse[][] matriceCellules;
    int nbLignes;
    int nbColonnes;

    public GrilleDeCellules(int p_nbLignes, int p_nbColonnes) {
        this.nbLignes = p_nbLignes;
        this.nbColonnes = p_nbColonnes;
        this.matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];
        
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }
    
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }
    
    public void activerLigneColonneOuDiagonaleAleatoire() {
        Random rand = new Random();
        int choix = rand.nextInt(3); // Choisir un nombre entre 0 et 2 pour décider ligne, colonne ou diagonale

        if (choix == 0) {
            // Activer une ligne aléatoire
            int ligne = rand.nextInt(nbLignes);
            activerLigneDeCellules(ligne);
        } else if (choix == 1) {
            // Activer une colonne aléatoire
            int colonne = rand.nextInt(nbColonnes);
            activerColonneDeCellules(colonne);
        } else {
            // Activer une diagonale aléatoire (descendante ou montante)
            if (rand.nextBoolean()) {
                activerDiagonaleDescendante();
            } else {
                activerDiagonaleMontante();
            }
        }
    }

    
    
    
    public void melangerMatriceAleatoirement(int nbTours) {
        eteindreToutesLesCellules();
        Random rand = new Random();
        for (int i = 0; i < nbTours; i++) {
            activerLigneColonneOuDiagonaleAleatoire();
        }
    }
    
    public void activerLigneDeCellules(int idLigne) {
        if (idLigne >= 0 && idLigne < nbLignes) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[idLigne][j].activerCellule();
            }
        }
    }
    
    public void activerColonneDeCellules(int idColonne) {
        if (idColonne >= 0 && idColonne < nbColonnes) {
            for (int i = 0; i < nbLignes; i++) {
                matriceCellules[i][idColonne].activerCellule();
            }
        }
    }
    
    public void activerDiagonaleDescendante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][i].activerCellule();
        }
    }
    
    public void activerDiagonaleMontante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][nbColonnes - i - 1].activerCellule();
        }
    }
    
    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].estEteint()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j].estEteint() ? "O" : "X");
                if (j < nbColonnes - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


    

    package LightsOff;

public class GrilleDeCellules {
    public CelluleLumineuse[][] matriceCellules;

    public GrilleDeCellules(int nbLignes, int nbColonnes) {
        matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }

    public void activerCellule(int i, int j) {
        matriceCellules[i][j].changerEtat();
        if (i > 0) matriceCellules[i - 1][j].changerEtat(); // Haut
        if (i < matriceCellules.length - 1) matriceCellules[i + 1][j].changerEtat(); // Bas
        if (j > 0) matriceCellules[i][j - 1].changerEtat(); // Gauche
        if (j < matriceCellules[i].length - 1) matriceCellules[i][j + 1].changerEtat(); // Droite
    }

    public void melangerMatriceAleatoirement(int nbIterations) {
        for (int k = 0; k < nbIterations; k++) {
            int i = (int) (Math.random() * matriceCellules.length);
            int j = (int) (Math.random() * matriceCellules[0].length);
            activerCellule(i, j);
        }
    }

    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < matriceCellules.length; i++) {
            for (int j = 0; j < matriceCellules[i].length; j++) {
                if (matriceCellules[i][j].estAllume()) {
                    return false;
                }
            }
        }
        return true;
    }
}

    
    

