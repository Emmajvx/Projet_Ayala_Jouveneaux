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
    ImageIcon icon = new ImageIcon("images/cavalier1.png");

    public Cavalier(int startX, int startY) {
        this.positionX = startX;
        this.positionY = startY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    
    public void deplacerCavalier(int newX, int newY) {
        this.positionX = newX;
        this.positionY = newY;
    }
}

