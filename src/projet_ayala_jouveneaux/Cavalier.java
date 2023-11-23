/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_ayala_jouveneaux;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author ayala
 */
public class Cavalier {
    private int positionX;
    private int positionY;

    public Cavalier(int startX, int startY, GrilleDeJeu grille) {
        this.positionX = startX;
        this.positionY = startY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    
}
