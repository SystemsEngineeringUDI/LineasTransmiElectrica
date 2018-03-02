/* 
@autor:
 * Cesar Villalobos
 * Jhon Velasco
 * @frediv0406
 * Estudiante: Ing.Sistemas UDI
*/


package proyectolintranelec;
    import javax.swing.JOptionPane;
    public class Presentacion {
    public Presentacion(){      
    }
    public String CAPTURARPeso(){
        String rPeso; 
        String present="Ingrese el peso\n";
        rPeso=(JOptionPane.showInputDialog(present + "Peso: "));
        return rPeso;
    }
   public String CAPTURARTension(){
        String rTension;
        String present="Ingrese el peso\n";
        rTension=(JOptionPane.showInputDialog(present + "Tension: "));
        return rTension;
    }
    public Torre CapturarTorre(int pCantidad){
        String present;
        Torre rTorre;
        rTorre= new Torre();    
        present="Ingrese la información de la torre "+pCantidad+ "\n\n";
        rTorre.setLatitud(JOptionPane.showInputDialog(present + "Latitud en [grados]:"));
        rTorre.setLongitud(JOptionPane.showInputDialog("Longitud en [grados]: "));
        rTorre.setAltitud(JOptionPane.showInputDialog("Altitud en [metros]: "));
        rTorre.setAltorre(JOptionPane.showInputDialog("Altura en [metros]: ")); 
        if (!rTorre.getValidez()){
            rTorre=new Torre();
        }
        return rTorre; 
    }
    public Tramo capturarTramo(int pCantidad){
        Tramo rTramo;
        rTramo= new Tramo();
        String present="Ingrese la información del tramo " +pCantidad+ "\n\n";
        rTramo.setCodigo1(JOptionPane.showInputDialog(present + "Torre inicial: "));
        rTramo.setCodigo2(JOptionPane.showInputDialog("Torre final: "));       
        return rTramo;
    }  
    public String capturarCodigo(){
        String encabezado;
        String rCodigo; 
        encabezado="Ingrese el código de la torre: "; 
        rCodigo=JOptionPane.showInputDialog(encabezado); 
        return rCodigo; 
    }
    public String capturarCodigoTramo(){
        String encabezado; 
        String rCodigo; 
        encabezado="Ingrese el código del tramo: ";
        rCodigo=JOptionPane.showInputDialog(encabezado); 
        return rCodigo; 
    } 
    public void presentarTorre(Torre rTorre){ 
        String present;        
        present="La información de la torre es la siguiente: \n\n";
        if(rTorre.getValidez()){       
        present=present
                +"Codigo: "+rTorre.getCodigo()+"\n"+"Latitud: "+rTorre.getLatitud()+"°"+"\n"+"Longitud: "+rTorre.getLongitud()+"°"+"\n"
                +"Altitud: "+rTorre.getAltitud()+" metros"+"\n"+"Altura: "+rTorre.getAltorre()+" metros"+"\n";}
        else{
            present=present+"No hay información valida a presentar";
        }
        JOptionPane.showMessageDialog(null, present);   
    }   
    public void presentarDistancia(float pDistancia){ 
        String presenta="La distancia entre las torres en el tramo es: ";
        if(pDistancia>0){
            JOptionPane.showMessageDialog(null,presenta + pDistancia + "metros");
        }
        else{
             presenta=presenta+"No hay información valida a presentar";
             JOptionPane.showMessageDialog(null, presenta); 
        }
        
}
    public void presentarDistanciaTotal(float pDistancia){ 
        String present="Aplicacion que permite consultar, registrar torres y hallar distancia entre ellas\n\n";
        if(pDistancia>0){
            JOptionPane.showMessageDialog(null,"La distancia total de la linea es de: " +pDistancia+" metros");
        }
        else{
            present=present+"No hay información valida a presentar";
            
        }     
} 
    public void presentarDISTANCIA(double pDistancia){ 
        String presenta="La distancia entre las torres en el tramo es: ";
     
            JOptionPane.showMessageDialog(null,presenta + pDistancia + "metros");
        }
        
}


