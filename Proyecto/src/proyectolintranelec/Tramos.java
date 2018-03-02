/* 
@autor:
 * Cesar Villalobos
 * Jhon Velasco
 * @frediv0406
 * Estudiante: Ing.Sistemas UDI
*/

package proyectolintranelec;

public class Tramos {
    private int capacity;
    private Tramo[] array;
    private Torre torre1;
    private Torre torre2;
    
    public Tramos(int pCapacidad){
        if (pCapacidad>0){
            capacity=pCapacidad;
            array=new Tramo[capacity];
        }
        torre1=new Torre();
        torre2=new Torre();
    }
    public void setTorre1(Torre pTorre){
        torre1=pTorre;
    }
    public void setTorre2(Torre pTorre){
        torre2=pTorre;
    }
    public Torre getTorre1(){
        return torre1;  
    }
    public Torre getTorre2(){
        return torre2;      
    }
    public int getCapacidad(){
        return capacity;      
    } 
    public void incluir(Tramo pTramo){
        int i;
        i=0;
        while ((i<capacity) && (array[i]!=null)){
            i=i+1;
        }
        if (i<capacity){
            array[i]=pTramo;
        }
    }
    public int getCantidad(){
        int i;
        i=0;
        while ((i<capacity) && (array[i]!=null))
        {
            i=i+1;
        }      
        return i;
    }
    public float distanciatotal(){        
        int i=0;
        float rDistanciaTotal=0;
        while((i<(this.getCantidad())) && (array[i]!=null)){              
                rDistanciaTotal=rDistanciaTotal+array[i].getTorre1().getDistanciaTorres(array[i].getTorre2());
                i=i+1;
            }
        return rDistanciaTotal;
    }   
}
