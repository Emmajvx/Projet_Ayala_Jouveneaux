/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projet_ayala_jouveneaux;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author ayala
 */
public class Partie_Graphique extends javax.swing.JFrame {

    GrilleDeJeu grille;
    int niveau = 0;
    Cavalier cavalier = new Cavalier(2, 2);

    /**
     * Creates new form Partie_Graphique
     */
    public Partie_Graphique(int nbL, int nbC) {
        initComponents();
        int nbLignes = nbL;
        int nbColonnes = nbC;
        niveau += 1;
        this.grille = new GrilleDeJeu(nbLignes, nbColonnes, niveau);
        Plateau.setLayout(new GridLayout(nbLignes, nbColonnes));

        while (!grille.cellulesToutesEteintes()) {

            for (int i = 0; i < nbLignes; i++) {
                for (int j = 0; j < nbColonnes; j++) {
                    final CelluleLumineuse cellule = grille.lireCellule(i, j);
                    int deltaX = Math.abs(i - cavalier.getPositionX());
                    int deltaY = Math.abs(j - cavalier.getPositionY());
                    boolean estDeplacementCavalier = (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);

                    CaseCouleur bouton_cellule = new CaseCouleur(cellule, 36, 36);

                    if (estDeplacementCavalier) {

                        bouton_cellule.addActionListener(new ActionListener() {
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
                                        cellule.activerCellule();
                                    } else {
                                        cellule.eteindreCellule();
                                    }
                                    //ajouterImage("image/cavalier1.jpg", cavalier.getPositionX(), cavalier.getPositionY());
                                    cavalier.deplacerCavalier(x, y);
                                    System.out.println("Nouvelles coordonn?es du cavalier : " + cavalier.getPositionX() + ", " + cavalier.getPositionY());

                                }

                            }
                        });
//                        System.out.println("Nouvelles coordonn?es du cavalier : " + cavalier.getPositionX() + ", " + cavalier.getPositionY());
                        bouton_cellule.setCoordX(i);
                        bouton_cellule.setCoordY(j);

                        // Ajouter le bouton au panneau
                        Plateau.add(bouton_cellule);
                    }

                    Plateau.add(bouton_cellule);
                    getContentPane().add(Plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, nbColonnes * 40, nbLignes * 40));
                    this.pack();
                    this.revalidate();
                }
            }
        }
    }

    private void mettreAJourImageCavalier() {
        // Supprimer l'ancienne image du cavalier
        for (Component component : Plateau.getComponents()) {
            if (component instanceof JLabel) {
                Plateau.remove(component);
            }
        }

        // Ajouter la nouvelle image du cavalier
        ajouterImage("image/cavalier1.jpg", cavalier.getPositionX(), cavalier.getPositionY());
    }

    private void ajouterImage(String cheminImage, int positionX, int positionY) {
        ImageIcon icon = new ImageIcon(cheminImage);
        Image image = icon.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        JLabel labelImage = new JLabel(icon);

        // Utiliser un GridBagConstraints pour placer l'image
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = positionY;  // Utiliser positionY pour gridx
        gbc.gridy = positionX;  // Utiliser positionX pour gridy

        Plateau.add(labelImage, gbc);

        // Mettre ? jour l'affichage
        Plateau.revalidate();
        Plateau.repaint();
    }

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Plateau.setBackground(new java.awt.Color(0, 0, 0));
        Plateau.setPreferredSize(new java.awt.Dimension(360, 360));

        javax.swing.GroupLayout PlateauLayout = new javax.swing.GroupLayout(Plateau);
        Plateau.setLayout(PlateauLayout);
        PlateauLayout.setHorizontalGroup(
            PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        PlateauLayout.setVerticalGroup(
            PlateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(Plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 320, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    // End of variables declaration//GEN-END:variables
}
