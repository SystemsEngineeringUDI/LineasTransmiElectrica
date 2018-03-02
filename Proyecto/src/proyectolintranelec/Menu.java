/* 
@autor:
 * Cesar Villalobos
 * Jhon Velasco
 * @frediv0406
 * Estudiante: Ing.Sistemas UDI
*/

package proyectolintranelec;
import javax.swing.*;
public class Menu {
    public String respuesta; 
    public Menu(){
        respuesta=""; 
    }    
    public Menu m (){
    String coment; 
    coment="Aplicacion que permite registrar, consultar o hallar distancia entre torres\n\n"
            +"Ingrese lo que quiere hacer\n \n";
    respuesta=JOptionPane.showInputDialog(null,coment + "1.Registrar Torre\n" + "2.Consultar Torre\n" + "3.Registrar tramo\n" 
            +"4.Consultar tramo\n"+ "5.Consultar linea\n" + "6.Salir \n" ); 
    return null; //Determina la opción para entrar al switch de main
    }
}		
