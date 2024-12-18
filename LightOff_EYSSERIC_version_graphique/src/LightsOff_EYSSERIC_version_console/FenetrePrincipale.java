package LightsOff_EYSSERIC_version_console;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author beatr
 */

import LightsOff_EYSSERIC_version_console.GrilleDeCellules;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class FenetrePrincipale extends javax.swing.JFrame {
    GrilleDeCellules grille;
    int nbCoups; 
    int i;
    /**
     * Creates new form FenetrePrincipale
     */
    public FenetrePrincipale() {
        initComponents();
        
        int nbLignes = 5;
        int nbColonnes = 5;
        this.revalidate();
        PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
        this.grille = new GrilleDeCellules(nbLignes, nbColonnes);
        for (int i=0; i < nbLignes; i++) {
            for (int j=0; j < nbColonnes; j++ ) {
                CelluleGraphique bouton_cellule = new CelluleGraphique( grille.matriceCellules[i][j], 36,36);
                PanneauGrille.add(bouton_cellule); // ajout au Jpanel PanneauGrille
            }
        }
        grille.melangerMatriceAleatoirement(1);
        
         //getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20,nbColonnes*40, nbLignes*40));
        //this.pack();
        this.revalidate();
       
        PanneauBoutonVerticaux.setLayout(new GridLayout(nbLignes, 1));
        // getContentPane().add(PanneauBoutonVerticaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1 * 40, nbLignes * 40));
        //this.pack();
        this.revalidate();
        
        // création du panneau de boutons verticaux (pour les lignes)
            for (i = 0; i < nbLignes; i++) {
                JButton bouton_ligne = new JButton();
                ActionListener ecouteurClick = new ActionListener() {
                    final int j = i;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        grille.activerLigneDeCellules(j);
                        repaint();
                    }
                };
                bouton_ligne.addActionListener(ecouteurClick);
                PanneauBoutonVerticaux.add(bouton_ligne);
            }
            
        PanneauBoutonHorizontaux.setLayout(new GridLayout(1, nbColonnes));
        //getContentPane().add(PanneauBoutonHorizontaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, nbLignes * 50 , 1 * 50));
        this.pack();
        this.revalidate();
        // création du panneau de boutons verticaux (pour les lignes)
            for ( i = 0; i < nbColonnes; i++) {
                JButton bouton_Colonne = new JButton();
                bouton_Colonne.setText("C" + i);
                ActionListener ecouteurClickC = new ActionListener() {
                    final int j = i;                                                                                                                                             
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        grille.activerColonneDeCellules(j);
                        if (grille.cellulesToutesEteintes()==true){
                            
                        }
                        nbCoups++;
                        repaint();
                    }
                };
                bouton_Colonne.addActionListener(ecouteurClickC);
                PanneauBoutonHorizontaux.add(bouton_Colonne);
            }
        
        
        
        DiagDec.setLayout(new GridLayout(1, 1));
    //    getContentPane().add(DiagDec, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 1 * 50, 1 * 50));
        this.pack();
        this.revalidate();
        // création du panneau de boutons verticaux (pour les lignes)
        JButton bouton_Dd = new JButton();
        bouton_Dd.setText("Dd");
        ActionListener ecouteurClickDd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grille.activerDiagonaleDescendante();
                if (grille.cellulesToutesEteintes()==true){
                     
                }
                nbCoups++;
                repaint();
            }
        };
        bouton_Dd.addActionListener(ecouteurClickDd);
        DiagDec.add(bouton_Dd);
        
        
        DiagMon.setLayout(new GridLayout(1, 1));
      //  getContentPane().add(DiagMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 1 * 50, 1 * 50));
        this.pack();
        this.revalidate();
        // création du panneau de boutons verticaux (pour les lignes)
        JButton bouton_Dm = new JButton();
        bouton_Dm.setText("Dm");
        ActionListener ecouteurClickDm = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grille.activerDiagonaleMontante();
                if (grille.cellulesToutesEteintes()==true){
                    // f.setVisible(true) ;
                }
                nbCoups++;
                repaint();
            }
        };
        bouton_Dm.addActionListener(ecouteurClickDm);
        DiagMon.add(bouton_Dm);

    }
        
    

    public void initialiserPartie() {
        grille.eteindreToutesLesCellules();
        grille.melangerMatriceAleatoirement(10);
    }
    
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();
        PanneauBoutonHorizontaux = new javax.swing.JPanel();
        DiagDec = new javax.swing.JPanel();
        PanneauBoutonVerticaux = new javax.swing.JPanel();
        DiagMon = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 400, 400));

        PanneauBoutonHorizontaux.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout PanneauBoutonHorizontauxLayout = new javax.swing.GroupLayout(PanneauBoutonHorizontaux);
        PanneauBoutonHorizontaux.setLayout(PanneauBoutonHorizontauxLayout);
        PanneauBoutonHorizontauxLayout.setHorizontalGroup(
            PanneauBoutonHorizontauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PanneauBoutonHorizontauxLayout.setVerticalGroup(
            PanneauBoutonHorizontauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauBoutonHorizontaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 400, 50));

        DiagDec.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout DiagDecLayout = new javax.swing.GroupLayout(DiagDec);
        DiagDec.setLayout(DiagDecLayout);
        DiagDecLayout.setHorizontalGroup(
            DiagDecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        DiagDecLayout.setVerticalGroup(
            DiagDecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(DiagDec, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 50, 50));

        PanneauBoutonVerticaux.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout PanneauBoutonVerticauxLayout = new javax.swing.GroupLayout(PanneauBoutonVerticaux);
        PanneauBoutonVerticaux.setLayout(PanneauBoutonVerticauxLayout);
        PanneauBoutonVerticauxLayout.setHorizontalGroup(
            PanneauBoutonVerticauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        PanneauBoutonVerticauxLayout.setVerticalGroup(
            PanneauBoutonVerticauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauBoutonVerticaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, 400));

        DiagMon.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout DiagMonLayout = new javax.swing.GroupLayout(DiagMon);
        DiagMon.setLayout(DiagMonLayout);
        DiagMonLayout.setHorizontalGroup(
            DiagMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        DiagMonLayout.setVerticalGroup(
            DiagMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(DiagMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 50, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DiagDec;
    private javax.swing.JPanel DiagMon;
    private javax.swing.JPanel PanneauBoutonHorizontaux;
    private javax.swing.JPanel PanneauBoutonVerticaux;
    private javax.swing.JPanel PanneauGrille;
    // End of variables declaration//GEN-END:variables
}
