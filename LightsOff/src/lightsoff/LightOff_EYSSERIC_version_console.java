/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightsoff;

/**
 *
 * @author beatr
 */
public class LightOff_EYSSERIC_version_console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CelluleLumineuse cellule1 = new CelluleLumineuse(false);
        CelluleLumineuse cellule2 = new CelluleLumineuse(true);
        
        cellule1.activerCellule();
        cellule2.activerCellule();
        
        System.out.println(cellule1);
        System.out.println(cellule2);
        
        
        
        
        }
        
        
        
    }
    
}


