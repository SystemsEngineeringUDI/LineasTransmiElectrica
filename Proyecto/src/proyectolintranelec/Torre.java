/* 
@autor:
 * Cesar Villalobos
 * Jhon Velasco
 * @frediv0406
 * Estudiante: Ing.Sistemas UDI
*/


package proyectolintranelec;
public class Torre {
    public String codigo;
    public float latitud;
    public float longitud;
    public float altitud;
    public float altorre;
      
    public Torre(){
        codigo="";
        latitud=0;
        longitud=0;
        altitud=0;
        altorre=0;
    }   
    public void setCodigo(String pCodigo){
        double tCodigo;
        tCodigo=0;
        if (pCodigo.length()>0){
            try{
                tCodigo=Double.parseDouble(pCodigo);
            }
            catch (Exception e){

            }
        }
        if (tCodigo>0){
            codigo=pCodigo;
        }
    }
    public void setLatitud(String pLatitud){
        float tLatitud;
        tLatitud=0;
        try{
            tLatitud=Float.parseFloat(pLatitud);
        }
        catch (Exception e){
            
        }
        if (tLatitud>0 || tLatitud<0){
            latitud=tLatitud;
        }
    }
        public void setLongitud(String pLongitud){
        float tLongitud;
        tLongitud=0;
        try{
            tLongitud=Float.parseFloat(pLongitud);
        }
        catch (Exception e){
            
        }
        if (tLongitud>0 || tLongitud<0){
            longitud=tLongitud;
        }
    }
        public void setAltitud(String pAltitud){
        float tAltitud;
        tAltitud=0;
        try{
            tAltitud=Float.parseFloat(pAltitud);
        }
        catch (Exception e){
            
        }
        if (tAltitud>0){
            altitud=tAltitud;
        }
    }
       public void setAltorre(String pAltorre){
        float tAltorre;
        tAltorre=0;
        try{
            tAltorre=Float.parseFloat(pAltorre);
        }
        catch (Exception e){
            
        }
        if (tAltorre>0){
            altorre=tAltorre;
        }
    }  
    public String getCodigo(){
        return codigo;
    }
    public float getLatitud(){
        return latitud;
    }
    
    public float getLongitud(){
        return longitud;
    }
    
    public double getAltitud(){
        return altitud;
    }
    public double getAltorre(){
        return altorre;
    }   
    public float getDistanciaTorres(Torre pTorre){
        if(!pTorre.getValidez()){          
            float rDistanciaTotal=0;
            return rDistanciaTotal;
        }else{
        double earthRadius = 6371; // km
        float c = (float) Math.toRadians(pTorre.latitud);
        float d = (float) Math.toRadians(pTorre.longitud);
        float w = (float) Math.toRadians(this.longitud);
        float l = (float) Math.toRadians(this.latitud);
        float dlon =w- d;
        float dlat = l - c;

        float sinlat = (float) Math.sin(dlat / 2);
        float sinlon = (float) Math.sin(dlon / 2);

        float a = (float) ((sinlat * sinlat) + Math.cos(l)*Math.cos(c)*(sinlon*sinlon));
        float e = (float) (2 * Math.asin (Math.min(1.0, Math.sqrt(a))));

        float distanceInMeters = (float) (earthRadius * e * 1000);
        float alt=((pTorre.altitud+pTorre.altorre)-(this.altitud+this.altorre));
        float rDistanciaTotal=(float) Math.sqrt(Math.pow(alt,2)+Math.pow(distanceInMeters,2));
        return (float)rDistanciaTotal;
      
        }
    }
    public double getDistanciaPARACATENARIA(Torre pTorre){
        double earthRadius = 6371; // km
        double c = (double) Math.toRadians(pTorre.latitud);
        double d = (double) Math.toRadians(pTorre.longitud);
        double w = (double) Math.toRadians(this.longitud);
        double l = (double) Math.toRadians(this.latitud);
        double dlon =w- d;
        double dlat = l - c;

        double sinlat = (double) Math.sin(dlat / 2);
        double sinlon = (double) Math.sin(dlon / 2);

        double a = (double) ((sinlat * sinlat) + Math.cos(l)*Math.cos(c)*(sinlon*sinlon));
        double e = (double) (2 * Math.asin (Math.min(1.0, Math.sqrt(a))));

        double distanceInMeters = (double) (earthRadius * e * 1000);
        double alt=(double) ((pTorre.altitud+pTorre.altorre)-(this.altitud+this.altorre));
        double rDistanciaTotal=(double) Math.sqrt(Math.pow(alt,2)+Math.pow(distanceInMeters,2));
        return (double)rDistanciaTotal;    
    }
    public boolean getValidez(){
        boolean rValidez;
        rValidez=true;  
        rValidez=(rValidez && (this.latitud>0 || this.latitud<0));
        rValidez=(rValidez && (this.longitud>0 || this.longitud<0));
        rValidez=(rValidez && (this.altitud>0));
        rValidez=(rValidez && (this.altorre>0));
        return rValidez;
    }   
    }
        

