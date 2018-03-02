/* 
@autor:
 * Cesar Villalobos
 * Jhon Velasco
 * @frediv0406
 * Estudiante: Ing.Sistemas UDI
*/


package proyectolintranelec;
import static java.lang.Math.abs;
public class Torres {
    private int capacidad;
    private Torre[] arreglo;
    
    public Torres(int pCapacidad){
        if (pCapacidad>0){
            capacidad=pCapacidad;
            arreglo=new Torre[capacidad];
        }
    }
    public int getCapacidad(){
        return capacidad;
        
    } 
    public void incluir(Torre pTorre){
        int i;
        if (pTorre.getValidez()){
            i=0;
            while ((i<capacidad) && (arreglo[i]!=null)){
                i=i+1;
            }
            if (i<capacidad){
                arreglo[i]=pTorre;
            }
        }    
    }
    public int getCantidad(){
        int i;
        i=0;
        while ((i<capacidad) && (arreglo[i]!=null))
        {
            i=i+1;
        }      
        return i;
    }
    public float getDistanciaTorres(Torre pTorre, Torre rTorre){
        if(!pTorre.getValidez() || !rTorre.getValidez()){          
            float rDistanciaTota=0;
            return rDistanciaTota;
        }else{
        double earthRadius = 6371; // km
        pTorre.latitud = (float) Math.toRadians(pTorre.latitud);
        pTorre.longitud = (float) Math.toRadians(pTorre.longitud);
        rTorre.latitud = (float) Math.toRadians(rTorre.latitud);
        rTorre.longitud = (float) Math.toRadians(rTorre.longitud);

        float dlon = abs(rTorre.longitud - pTorre.longitud);
        float dlat = abs(rTorre.altitud - pTorre.altitud);

        float sinlat = (float) Math.sin(dlat / 2);
        float sinlon = (float) Math.sin(dlon / 2);

        float a = (float) ((sinlat * sinlat) + Math.cos(pTorre.latitud)*Math.cos(rTorre.latitud)*(sinlon*sinlon));
        float c = (float) (2 * Math.asin (Math.min(1.0, Math.sqrt(a))));

        float distanceInMeters = (float) (earthRadius * c * 1000);
        float alt=((pTorre.altitud+pTorre.altorre)-(rTorre.altitud+rTorre.altorre));
        float rDistanciaTota=(float) Math.sqrt(Math.pow(alt,2)+Math.pow(distanceInMeters,2));
        return (float)rDistanciaTota;
        }
    }
    
    
    
}
