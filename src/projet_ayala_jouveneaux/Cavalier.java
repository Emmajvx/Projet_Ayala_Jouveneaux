/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_ayala_jouveneaux;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author ayala
 */
public class Cavalier {
    int positionX;
    int positionY;
    
    /**
     * Permet de positionner notre cavalier sur la grille selon les coordonn?es x et y.
     * @param startX
     * @param startY
     */
    public Cavalier(int startX, int startY) {
        this.positionX = startX;
        this.positionY = startY;
    }
 // M?thodes pour r?cuperer les coordoon?es 
    
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    
    /**
     * Permet de d?placer le cavalier en lui assignant de nouvelles coordonn?es. 
     * @param newX
     * @param newY
     */
    public void deplacerCavalier(int newX, int newY) {
        this.positionX = newX;
        this.positionY = newY;
    }
}

