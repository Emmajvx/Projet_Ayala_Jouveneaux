/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_ayala_jouveneaux;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author ayala
 */
public class CaseCouleur extends JButton{
    int largeur; // largeur en pixel de la cellule
    int hauteur; // hauteur en pixel de la cellule
    CelluleLumineuse celluleLumineuseAssociee;
    private int coordX;
    private int coordY;

// constructeur (appel? depuis FenetrePrincipale)

    /**
     * Prend en entr?e la hauteur et la largeur que doit prendre la cellule lumineuse sur notre grille, initialise aussi nos
     * cellules lumineuse.
     * @param celluleLumineuseAssociee
     * @param largeur
     * @param hauteur
     */

    public CaseCouleur(CelluleLumineuse celluleLumineuseAssociee, int largeur,
            int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
        
    }
// Methode g?rant le dessin de la cellule

    /**
     * cette m?thode nous permet de colorer nos cellules en noir ou en blanc en fonction de l'?tat de notre cellule, ?teinte 
     * ou allum?e. 
     * Elle nous permet ?galement de placer une image d'un cavalier sur la case sur laquelle le cavalier se trouve.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
     super.paintComponent(g);
    
        if (celluleLumineuseAssociee.estEteint()) {
            g.setColor(Color.black);
        }
        else  {
            g.setColor(Color.white);
      
        }   
      g.fillRect(4,4,largeur,hauteur);  
    
this.setText(celluleLumineuseAssociee.toString());
        if (celluleLumineuseAssociee.presenceCavalier == true) {
            BufferedImage image = null;
             try {
                 image = ImageIO.read(new File("./test/image/cavalier1.jpg"));
             } catch (IOException e){
                 System.out.println(e.getCause());
                 e.printStackTrace();
             }
            
            g.fillRect(4, 4, largeur, hauteur);
             this.setText(celluleLumineuseAssociee.toString());
            g.drawImage(image,3,3,largeur,hauteur,null);
        }

}
// M?thodes pour r?cup?rer les coordonn?es
    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    // M?thodes pour d?finir les coordonn?es
    public void setCoordX(int x) {
        this.coordX = x;
    }

    public void setCoordY(int y) {
        this.coordY = y;
    }
}




