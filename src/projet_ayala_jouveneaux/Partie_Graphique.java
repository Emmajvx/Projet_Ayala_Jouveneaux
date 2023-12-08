/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projet_ayala_jouveneaux;
import projet_ayala_jouveneaux.*;


import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.Timer;
/**
 *
 * @author ayala
 */
public class Partie_Graphique extends javax.swing.JFrame {
    GrilleDeJeu grille;
   Cavalier cavalier = new Cavalier(0, 0);

    // D?claration de la liste de boutons
    List<CaseCouleur> boutons = new ArrayList<>();

    /**
     * Creates new form Partie_Graphique
     */
    public Partie_Graphique(int nbL, int nbC, int level) {
        initComponents();
        int nbLignes = nbL;
        int nbColonnes = nbC;
        int niveau =level;
        System.out.println(niveau);
        this.grille = new GrilleDeJeu(nbLignes, nbColonnes, niveau);
        Plateau.setLayout(new GridLayout(nbLignes, nbColonnes));
        jLabel1.setText("");
        jLabel2.setText("");
        
        if (niveau==0){
            cavalier.deplacerCavalier(1, 1);
            jLabel1.setText("Votre pion se deplace comme un cavalier aux echecs");
            jLabel2.setText("Appuyez sur la case blanche pour l'etaindre et gagner la partie");
        }
        
        if (niveau==1){
            cavalier.deplacerCavalier(1, 1);
            grille.matriceCellules[1][1].presenceCavalier = true;
            
        }
        if (niveau==2){
            cavalier.deplacerCavalier(4, 3);
            grille.matriceCellules[4][3].presenceCavalier = true;
        }
        

        // Creation de tous les boutons
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                CaseCouleur bouton_cellule = new CaseCouleur(grille.lireCellule(i, j), 36, 36);
                bouton_cellule.setCoordX(i);
                bouton_cellule.setCoordY(j);

                boutons.add(bouton_cellule);
                Plateau.add(bouton_cellule);
            }
        }
        // Ajout de l'actionneur pour tous les boutons
        for (CaseCouleur bouton : boutons) {
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Ajouter le code de gestion du clic sur le bouton ici
                    CaseCouleur boutonClique = (CaseCouleur) e.getSource();
                    int x = boutonClique.getCoordX();
                    int y = boutonClique.getCoordY();

                    int deltaX = Math.abs(x - cavalier.getPositionX());
                    int deltaY = Math.abs(y - cavalier.getPositionY());
                    boolean estDeplacementCavalier = (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);

                    if (estDeplacementCavalier) {
                        CelluleLumineuse cellule = grille.lireCellule(x, y);
                        if (cellule.estEteint()) {
                            FenetreDefaite f = new FenetreDefaite();
//                            this.dispose();
                            f.setVisible(true);
                            cellule.activerCellule();
                        } else {
                            cellule.eteindreCellule();
                        }
                        grille.matriceCellules[cavalier.getPositionX()][cavalier.getPositionY()].presenceCavalier = false;
                        
                        cavalier.deplacerCavalier(x, y);
                        grille.matriceCellules[x][y].presenceCavalier = true;
                        
                        
                        System.out.println("Nouvelles coordonn?es du cavalier : " + cavalier.getPositionX() + ", " + cavalier.getPositionY());
                        if (niveau==1&&grille.cellulesToutesEteintes()==true){
                            fenetre2 f = new fenetre2();
                            Partie_Graphique.this.dispose();
                            f.setVisible(true);
                        }
                        if (niveau==0&&grille.cellulesToutesEteintes()==true){
                            Partie_Graphique f = new Partie_Graphique(4,4,1);
//                            this.dispose();
                            f.setVisible(true);
                            
                        }    
                   
                       }
                }

          
            });
        }

                    

                       getContentPane().add(Plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, nbColonnes * 40, nbLignes * 40));
                         this.pack();
                           this.revalidate();
                
                }
    
//        chrono = new Timer(1000, new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            countdown--;
//                 updateCountdownLabel();
//                 if (countdown ==  0){
//                     stopGame();
//                 }
//            
//        }
//        }
//                


    public void initialiserPartie() {
        grille.eteindreToutesLesCellules();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Plateau = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Plateau.setBackground(new java.awt.Color(0, 0, 0));
        Plateau.setPreferredSize(new java.awt.Dimension(360, 360));

        javax.swing.GroupLayout PlateauLayout = new javax.swing.GroupLayout(Plateau);
        Plateau.setLayout(PlateauLayout);
        PlateauLayout.setHorizontalGroup(
            PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        PlateauLayout.setVerticalGroup(
            PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        getContentPane().add(Plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 360, 360));

        jButton1.setText("Recommencer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, -1, -1));

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projet_ayala_jouveneaux/fond3.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 0, 790, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Partie_Graphique f = new Partie_Graphique(4,4,1);
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale(4).setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Plateau;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
