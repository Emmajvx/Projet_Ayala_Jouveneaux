package projet_ayala_jouveneaux;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ayala
 */
public class CelluleLumineuse {
    private int etat ;
    public boolean presenceCavalier = false;

    /**
     * Met chaque nouvelle cellule en mode ?teinte
     * @param etat = false
     */
    public CelluleLumineuse() {
        this.etat = 1;
    }
        
    /**
     * Inverse l'etat de la cellule, si elle ?tait allum?, la m?thode l'?teint et inversement
     * 
     */
    public void activerCellule (){
 
            if (etat == 1) {
                etat=2;
            } else {
                etat=1;
            }
    
    }

    /**
     * Permet d'eteindre la cellule si elle est allum?, si elle est deja ?t?inte la m?thode ne change rien
     * 
     */
    public void eteindreCellule(){
        if (etat == 2){
        etat = 1 ;
        etat=1;
    }
    }  
    /**
     * Permet de savoir si la cellule est bien ?t?inte, renvoie true si elle est ?teinte, false si elle est allum?e 
     * @return
     */
   public boolean estEteint(){ 
        if (etat==1) {
            return true;
        } else {
            return false;
        }
   }
    
    /**
     * Permet de savoir si la cellule est allum?e
     * @return
     */
    public boolean estAllume(){
        if (etat == 2){
            return true;
        }
       return false;
    }
    
   
    /**
     * Permet de renvoyer l'?tat actuel de la cellule, true si elle est allum?e et false si elle est ?tainte
     * @return 
     */
       public int getEtat() {
        return etat;
    }
}