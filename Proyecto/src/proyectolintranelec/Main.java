/* 
@autor:
 * Cesar Villalobos
 * Jhon Velasco
 * @frediv0406
 * Estudiante: Ing.Sistemas UDI
*/

package proyectolintranelec;

public class Main {
    public static void main(String[] args) {
        Tramo tramo,tramo1,tramo2;
        Tramos tramos; 
        Presentacion presentacion; 
        Datos datos; 
        String rMenus;
        Menu m; 
        m = new Menu(); 
        tramo=new Tramo();
        datos= new Datos();
        presentacion= new Presentacion();
        int a=0;
        String c,d;
        do{
        m.m(); 
        rMenus=m.respuesta; 
        switch(rMenus){ 
            case "1":
                datos.grabarTorre(presentacion.CapturarTorre(datos.getSiguienteTorre()));//Mediante el llamado de metodos se capturan 
                                                                                         //los datos de una torre y se almacena
                break; 
            case "2":               
                presentacion.presentarTorre(datos.recuperarTorre(presentacion.capturarCodigo()));//Mediante el codigo de la torre se recuperan sus datos
                                                                                                                                            
                break;
            case "3":
                datos.grabarTramo(presentacion.capturarTramo(datos.getSiguienteTramo()));//Se graba un tramo
                break;
            case "4":
                tramo=datos.recuperarTramo(presentacion.capturarCodigoTramo());//Se recupera un tramo de la capa de datos mediante su codigo
                presentacion.presentarDistancia(tramo.getDistanciaTramo(tramo));//Muestra la distancia entre dos torres del mismo tramo
                presentacion.presentarTorre(tramo.getTorre1());
                presentacion.presentarTorre(tramo.getTorre2());//Presenta las torres asociadas al tramo
                break;             
            case"5":
                tramos=datos.recuperarTramos();//Recupera un tramo
                presentacion.presentarDistanciaTotal(tramos.distanciatotal());//Presenta la distancia de todos los tramos
                break;
            case"6":
                c=presentacion.CAPTURARPeso();
                d=presentacion.CAPTURARTension();
                tramo1=datos.recuperarTramo(presentacion.capturarCodigoTramo());
                tramo2=tramo.getTramo(tramo1, c,d);
                presentacion.presentarDISTANCIA(tramo2.getCatenaria());//Se halla la catenaria de un cable entre dos tramos
                break;
            case"7":
                a=1;
                break;                       
            }                   
        }while(a!=1); 
        }
}