package projet_ayala_jouveneaux;


import java.util.Random;
import projet_ayala_jouveneaux.CelluleLumineuse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ayala
 */

public class GrilleDeJeu {
    public CelluleLumineuse[][] matriceCellules;
    private int nbLignes ;
    private int nbColonnes;
    
   

    public int getNbLignes() {
        return nbLignes;
    }

    public void setNbLignes(int nbLignes) {
        this.nbLignes = nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public void setNbColonnes(int nbColonnes) {
        this.nbColonnes = nbColonnes;
    }
    
    /**
     *Cr?e une nouvelle grille de jeu avec un nombre de ligne et de colonne choisit en entr?e 
     * @param p_nbLignes
     * @param p_nbColonnes
     */
    public GrilleDeJeu (int p_nbLignes, int p_nbColonnes, int niveau) {
    nbLignes = p_nbLignes;
    nbColonnes = p_nbColonnes;
    int level=niveau;
    matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];
   
    
    for (int i = 0; i< nbLignes; i++){
        for (int j = 0; j < nbColonnes; j++){
            matriceCellules[i][j] = new CelluleLumineuse();
            matriceCellules[i][j].eteindreCellule();
        }
       
    }
    if (level==0){
        matriceCellules[0][3].activerCellule();
       
    }
    if (level==1){
        matriceCellules[0][3].activerCellule();
        matriceCellules[2][2].activerCellule();
        matriceCellules[3][0].activerCellule();
        
    }
    if (level==2){
        matriceCellules[2][7].activerCellule();
        matriceCellules[3][5].activerCellule();
        matriceCellules[3][9].activerCellule();
        matriceCellules[5][5].activerCellule();
        matriceCellules[4][7].activerCellule();
    }
    }
    
    public CelluleLumineuse lireCellule(int x, int y) {
        return matriceCellules[x][y];
    }
    /*
    
    /**
     *permet d'eteindre chaque cellule de la grille en parcourant la grille en lignes et en colonnes
     */
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
}
        }
   }
    /**
     *Verifie si l'une des cellules est allum? en utilisant la m?thode estEteint 
     * @return
     */
    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
               if (!matriceCellules[i][j].estEteint())
               return false;
                    
                }
            }
        return true;
        }
}

  
    
    
    