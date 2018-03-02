/* 
@autor:
 * Cesar Villalobos
 * Jhon Velasco
 * @frediv0406
 * Estudiante: Ing.Sistemas UDI
*/


package proyectolintranelec;
import java.io.*;
public class Datos {
        public String nombreArchivoTorres; 
        public String nombreArchivoTramos; 

        public Datos(){ //Archivos de texto plano en los que se ingresarán datos
             nombreArchivoTorres="torres.txt"; 
             nombreArchivoTramos="tramos.txt"; 

    }  
        public void grabarTorre(Torre pTorre){ //Metodo que prueba que los datos ingresados son correctos
                                                //de ser así los guarda
        FileWriter fileWriter; 
        PrintWriter printWriter; 
        String registro; 
        if(pTorre.getValidez()){
        registro=this.getSiguienteTorre()+","+pTorre.getLatitud()+","+pTorre.getLongitud()+","+pTorre.getAltitud()+","+pTorre.getAltorre(); 
        try{  
            fileWriter=new FileWriter(nombreArchivoTorres,true); 
            printWriter=new PrintWriter(fileWriter);
            printWriter.println(registro); 
            fileWriter.close(); 
        }
        catch (Exception e){           
        }
        }
    }
        public void grabarTramo(Tramo pTramo){ //Metodo que graba el tramo entre dos torres
        FileWriter fileWriter; 
        PrintWriter printWriter;
        String registro; 
        
        registro=this.getSiguienteTramo()+","+pTramo.getCodigoTorre1()+","+pTramo.getCodigoTorre2();
        try{  
            fileWriter=new FileWriter(nombreArchivoTramos,true); 
            printWriter=new PrintWriter(fileWriter);
            printWriter.println(registro); 
            fileWriter.close(); 
        }
        catch (Exception e){           
        }
        
    }
        public String getDato(String pTorre){ //Metodo que toma un dato que está después de una coma
        int i;
        String tCaracter;
        String rDato;
        i=0;
        tCaracter="";
        rDato="";
        while ((i<pTorre.length()) && (tCaracter.compareTo(",")!=0)){ 
            tCaracter=pTorre.substring(i,i+1);
            if (tCaracter.compareTo(",")!=0){
                rDato=rDato+tCaracter;
            }
            i=i+1;
        }
        return rDato; 
    }
        public String getResto(String pTorre){ //Metodo que discrimina los datos ingresados antes de la siguiente coma y almacena el resto
        int i;
        String tCaracter;
        String rResto;
        i=0;
        tCaracter="";
        rResto="";
        while ((i<pTorre.length()) && (tCaracter.compareTo(",")!=0)){
            tCaracter=pTorre.substring(i,i+1);
            i=i+1;
        }
        while (i<pTorre.length()){
            rResto=rResto+pTorre.substring(i,i+1);
            i=i+1;
        }
        return rResto;
    }
        public String getRegistro(int pPosicion){ //Metodo que obtiene una linea del archivo de texto plano
        FileReader fileReader;
        BufferedReader bufferedReader;
        int tPosicion;
        String rRegistro;
        tPosicion=-1;
        try{
            fileReader=new FileReader(nombreArchivoTorres);
            bufferedReader=new BufferedReader(fileReader);
            do{
                rRegistro=bufferedReader.readLine();
                tPosicion=tPosicion+1;
            } while (tPosicion<pPosicion);
            fileReader.close();
        }
        catch (Exception e){
            rRegistro="";
        }
        return rRegistro;
    }
        public String getRegistr(int pPosicion){ //Metodo que obtiene la posición de un dato en un archivo de texto plano
        FileReader fileReader;
        BufferedReader bufferedReader;
        int tPosicion;
        String rRegistro;
        tPosicion=-1;
        try{
            fileReader=new FileReader(nombreArchivoTramos);
            bufferedReader=new BufferedReader(fileReader);
            do{
                rRegistro=bufferedReader.readLine();
                tPosicion=tPosicion+1;
            } while (tPosicion<pPosicion);
            fileReader.close();
        }
        catch (Exception e){
            rRegistro="";
        }
        return rRegistro;
    }
        public String getRegistro(String pCodigoTorre){ //Metodo que recupera una torre con su codigo
        FileReader fileReader;
        BufferedReader bufferedReader;
        String tCodigo;
        String rRegistro;
        try{
            fileReader=new FileReader(nombreArchivoTorres);
            bufferedReader=new BufferedReader(fileReader);
            do{
                rRegistro=bufferedReader.readLine();
                tCodigo=this.getDato(rRegistro);
            } while (tCodigo.compareTo(pCodigoTorre)!=0);
            fileReader.close();
        }
        catch (Exception e){
            rRegistro="";
        }
        return rRegistro;
    }
        public int getCantidadTorres(){//Cuenta cuántos datos hay en un texto plano
        FileReader fileReader;
        BufferedReader bufferedReader;
        int tCantidadRegistros;
        String rRegistro;
        tCantidadRegistros=0;
        try{
            fileReader=new FileReader(nombreArchivoTorres);
            bufferedReader=new BufferedReader(fileReader);
            do{
                rRegistro=bufferedReader.readLine();
                if (rRegistro.length()>0){
                    tCantidadRegistros=tCantidadRegistros+1;
                }
            } while (rRegistro.length()>0);
            fileReader.close();
        }
        catch (Exception e){
            
        }
        return tCantidadRegistros;
    }
        public int getSiguienteTorre(){//Obtiene la posición de la siguiente torre que se necesita para el planteamiento del problema
        FileReader fileReader;
        BufferedReader bufferedReader;
        int tCantidadRegistros;
        String rRegistro;
        tCantidadRegistros=1;
        try{
            fileReader=new FileReader(nombreArchivoTorres);
            bufferedReader=new BufferedReader(fileReader);
            do{
                rRegistro=bufferedReader.readLine();
                if (rRegistro.length()>0){
                    tCantidadRegistros=tCantidadRegistros+1;
                }
                
            } while (rRegistro.length()>0);
            
            fileReader.close();
        }
        catch (Exception e){
            
        }
        
        return tCantidadRegistros;
    }
        public int getSiguienteTramo(){//Hace lo mismo del anterior metodo pero sobre otro archivo de texto plano
        FileReader fileReader;
        BufferedReader bufferedReader;
        int tCantidadRegistros;
        String rRegistro;
        tCantidadRegistros=1;
        try{
            fileReader=new FileReader(nombreArchivoTramos);
            bufferedReader=new BufferedReader(fileReader);
            do{
                rRegistro=bufferedReader.readLine();
                if (rRegistro.length()>0){
                    tCantidadRegistros=tCantidadRegistros+1;
                }
                
            } while (rRegistro.length()>0);
            
            fileReader.close();
        }
        catch (Exception e){
        }
        return tCantidadRegistros;
    }
        public int getCantidadTramos(){//Obtiene la cantidad de datos de un archivo de texto plano separados por coma
        FileReader fileReader;
        BufferedReader bufferedReader;
        int tCantidadRegistros;
        String rRegistro;
        tCantidadRegistros=0;
        try{
            fileReader=new FileReader(nombreArchivoTramos);
            bufferedReader=new BufferedReader(fileReader);
            do{
                rRegistro=bufferedReader.readLine();
                if (rRegistro.length()>0){
                    tCantidadRegistros=tCantidadRegistros+1;
                }
            } while (rRegistro.length()>0);
            fileReader.close();
        }
        catch (Exception e){      
        }
        return tCantidadRegistros;
    }
        public Torre recuperarTorre(int pPosicion){ //Dada una posición recupera una torre en el archivo de texto plano
        String tRegistro;
        Torre rTorre;
        rTorre=new Torre();
        tRegistro=this.getRegistro(pPosicion);
        rTorre.setCodigo(this.getDato(tRegistro));
        tRegistro=this.getResto(tRegistro);
        rTorre.setLatitud(this.getDato(tRegistro));
        tRegistro=this.getResto(tRegistro);
        rTorre.setLongitud(this.getDato(tRegistro));
        tRegistro=this.getResto(tRegistro);
        rTorre.setAltitud(this.getDato(tRegistro));
        tRegistro=this.getResto(tRegistro);
        rTorre.setAltorre(this.getDato(tRegistro));
        if (!rTorre.getValidez()){
            rTorre=new Torre();
        }
        
        return rTorre;
    }
        public Torre recuperarTorre(String pCodigoTorre){//Dado un código recupera la torre en el archivo de texto plano
        String tRegistro;	
        Torre rTorre=null;
        rTorre=new Torre();
        tRegistro=this.getRegistro(pCodigoTorre);
        rTorre.setCodigo(this.getDato(tRegistro));
        tRegistro=this.getResto(tRegistro);
        rTorre.setLatitud(this.getDato(tRegistro));
        tRegistro=this.getResto(tRegistro);
        rTorre.setLongitud(this.getDato(tRegistro));
        tRegistro=this.getResto(tRegistro);
        rTorre.setAltitud(this.getDato(tRegistro));
        tRegistro=this.getResto(tRegistro);
        rTorre.setAltorre(this.getDato(tRegistro));
        if(!rTorre.getValidez()){
            rTorre= new Torre();
        }
        return rTorre;
    }
        public Tramo recuperarTramo(String pCodigoTramo){//Recupera datos de un tramo entre dos torres mediante su codigo
        String tRegistro;
        String tCodigo;
        Tramo rTramo;
        Torre torre;
        rTramo=new Tramo();
        tRegistro=this.getRegistr(pCodigoTramo);
        tRegistro=this.getResto(tRegistro);
        tCodigo=this.getDato(tRegistro);
        torre=this.recuperarTorre(tCodigo);
        rTramo.setTorre1(torre);  
        rTramo.setcodigoTorre1(this.getDato(tRegistro));
        tRegistro=this.getResto(tRegistro);
        tCodigo=this.getDato(tRegistro);
        torre=this.recuperarTorre(tCodigo);
        rTramo.setcodigoTorre2(tCodigo);
        rTramo.setTorre2(torre); 
        return rTramo;
    }
        public Tramo recuperarTram(int pPosicion){//Recupera datos de un tramo entre dos torres mediante su posicion
        String tRegistro;
        String tCodigo;
        Tramo rTramo;
        Torre torre;
        rTramo=new Tramo();
        tRegistro=this.getRegistr(pPosicion);
        tRegistro=this.getResto(tRegistro);
        tCodigo=this.getDato(tRegistro);
        torre=this.recuperarTorre(tCodigo);
        rTramo.setTorre1(torre);  
        rTramo.setcodigoTorre1(this.getDato(tRegistro));
        tRegistro=this.getResto(tRegistro);
        tCodigo=this.getDato(tRegistro);
        torre=this.recuperarTorre(tCodigo);
        rTramo.setcodigoTorre2(tCodigo);
        rTramo.setTorre2(torre);    
        return rTramo;
    }
        public String getRegistr(String pCodigoTramo){//Recupera un tramo por su codigo
        FileReader fileReader;
        BufferedReader bufferedReader;
        String tCodigo;
        String rRegistro;
        try{
            fileReader=new FileReader(nombreArchivoTramos);
            bufferedReader=new BufferedReader(fileReader);
            do{
                rRegistro=bufferedReader.readLine();
                tCodigo=this.getDato(rRegistro);
            } while (tCodigo.compareTo(pCodigoTramo)!=0);
            fileReader.close();
        }
        catch (Exception e){
            rRegistro="";
        }
        return rRegistro;
    }
        public Torres recuperarTorres(){//Recupera un conjunto de torres
        int i;     
        Torres rTorres;
        rTorres=new Torres(this.getCantidadTorres());
        for (i=0;i<this.getCantidadTorres();i++){
            rTorres.incluir(this.recuperarTorre(i));
        }
        return rTorres;
    }
        public Tramos recuperarTramos(){//Recupera un conjunto de tramos
        int i;     
        Tramos rTramos;
        rTramos=new Tramos(this.getCantidadTramos());
        for (i=0;i<this.getCantidadTramos();i++){
            rTramos.incluir(this.recuperarTram(i));
        }
        return rTramos;
        }
        
 }


  
