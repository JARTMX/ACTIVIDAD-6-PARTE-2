/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionjavamongo;

/**
 *
 * @author angel tovar
 */

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    
    public Conexion (){
        try{
            Mongo mongo = new Mongo ("localhost",27017);
            BaseDatos = mongo.getDB("Actividad502");
            coleccion=BaseDatos.getCollection("Actividad502");
                System.out.println("Conexion Exitosa");
            
        }catch(UnknownHostException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    //C-CREATE R-READ U-UPDATE D-DELATE

    //CREATE
    public boolean insertar(String Titulo,String Autor,String Anio,String Pais,String Idioma,String Precio){
        document.put("Titulo", Titulo);
        document.put("Autor", Autor);
        document.put("Anio", Anio);
        document.put("Pais", Pais);
        document.put("Idioma", Idioma);
        document.put("Precio", Precio);
        coleccion.insert(document);
        return true;
    }
    //READ
    public void Mostrar(){
        DBCursor cursor = coleccion.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    //UPDATE
    public boolean Actualizar(String TituloVieja,String AutorVieja,String AnioVieja,String PaisVieja,String IdiomaVieja,String PrecioVieja,
                              String TituloNueva,String AutorNueva,String AnioNueva,String PaisNueva,String IdiomaNueva,String PrecioNueva){
        
        document.put("Titulo", TituloVieja);
        document.put("Autor", AutorVieja);
        document.put("Anio", AnioVieja);
        document.put("Pais", PaisVieja);
        document.put("Idioma", IdiomaVieja);
        document.put("Precio", PrecioVieja);
        
        BasicDBObject documentoNuevo = new BasicDBObject();
        
        documentoNuevo.put("Titulo", TituloNueva);
        documentoNuevo.put("Autor", AutorNueva);
        documentoNuevo.put("Anio", AnioNueva);
        documentoNuevo.put("Pais", PaisNueva);
        documentoNuevo.put("Idioma", IdiomaNueva);
        documentoNuevo.put("Precio", PrecioNueva);
        
        coleccion.findAndModify(document, documentoNuevo);
        
        return true;
    }
    
    //DELATE
    public boolean Eliminar(String Titulo,String Autor,String Anio,String Pais,String Idioma,String Precio){
        
        document.put("Titulo", Titulo);
        document.put("Autor", Autor);
        document.put("Anio", Anio);
        document.put("Pais", Pais);
        document.put("Idioma", Idioma);
        document.put("Precio", Precio);
        
        coleccion.remove(document);
        
        return true;
    }
    
}
