/* 
@autor:
 * Cesar Villalobos
 * Jhon Velasco
 * @frediv0406
 * Estudiante: Ing.Sistemas UDI
*/

package proyectolintranelec;

import javax.swing.JOptionPane;

public class Tramo {
    private String codigoTramo;
    private String codigoTorre1;
    private String codigoTorre2;
    private Torre torre1;
    private Torre torre2;
    private double tension;
    private double peso;
    
    public Tramo(){
        codigoTramo="";
        codigoTorre1="";
        codigoTorre2="";
        torre1=new Torre();
        torre2=new Torre();
        tension=0;
        peso=0;
    }
    public void setTension(String pTension){
        double rTension=0;
        if (pTension.length()>0){
            try{
                rTension=Double.parseDouble(pTension);
                            
            }
            catch (Exception e){
            }
        }
        if (rTension>0){
            tension=rTension;
        }
    
    }
    public void setPeso(String pPeso){
        double rPeso=0;
        if (pPeso.length()>0){
            try{
                rPeso=Double.parseDouble(pPeso);
            }
            catch (Exception e){
            }
        }
        if (rPeso>0){
            tension=rPeso;
        }
    
    }
    public void setTorre1(Torre pTorre){
        torre1=pTorre;
    }
    public void setTorre2(Torre pTorre){
        torre2=pTorre;
    }
    public void setcodigoTorre1(String pCodigo){
        pCodigo=codigoTorre1;
    }
    public void setcodigoTorre2(String pCodigo){
        pCodigo=codigoTorre2;
    }
    public Torre getTorre1(){
        return torre1;  
    }
    public Torre getTorre2(){
        return torre2;      
    }
    public String getCodigoTorre1(){
        return codigoTorre1;
    }
    public String getCodigoTorre2(){
        return codigoTorre2;       
    }
    public double getTension(){
        return tension;

    }
    public double getPeso(){
        return peso;
    }
    public void setCodigo1(String pCodigo){
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
            codigoTorre1=pCodigo;
        }
    }
    public void setCodigo2(String pCodigo){
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
            codigoTorre2=pCodigo;
        }
    }
    public void setcodigoTramo(String pCodigo){
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
            codigoTramo=pCodigo;
        }
    }
    public String getcodigoTramo(){
        return codigoTramo;
    }
    public float getDistanciaTramo(Tramo pTramo){
        float rDistanciaTramo;
        rDistanciaTramo=getTorre1().getDistanciaTorres(getTorre2());
        return rDistanciaTramo;
    }
    public Tramo getTramo(Tramo pTramo,String pString,String rString){
        Tramo rTramo;
        rTramo=new Tramo();
        this.setPeso(pString);
        this.setTension(rString);
        rTramo.getTorre1().altorre=this.getTorre1().altorre;
        rTramo.getTorre2().altorre=this.getTorre2().altorre;
        return rTramo;
    }
    public double getCatenaria(){  
        double rCatenaria;
        double z= this.getTorre1().altorre ;
        double m=(double)this.getTorre2().altorre;
        double a=(z+m);
        double b=(double)(this.getTorre1().getDistanciaPARACATENARIA(this.getTorre2()));
        double k=(double) a*b;
        double c=(double)((k*(this.getPeso()/2))*(this.getTension()-1));
        double d=(double)(Math.cos(c));
        rCatenaria=(double)(this.getTension()/this.getPeso()*d);
                    JOptionPane.showMessageDialog(null,"La distancia total de la linea es de: "+this.getPeso()+" PESOOO");
                    JOptionPane.showMessageDialog(null,"La distancia total de la linea es de: " +this.getTension()+" TENSIONOOO");
        return rCatenaria;
    }
   
}
