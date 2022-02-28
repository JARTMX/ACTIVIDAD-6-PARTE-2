
package conexionjavamongo;

/**
 *
 * @author angel tovar
 */
public class ConexionJavaMongo {


    public static void main(String[] args) {
            
        Conexion conec = new Conexion();
        //conec.insertar("Probando","Angel","2022","Mexico","Espaniol","69");
        //conec.insertar("Probando2","Jose","2023","RD","Espaniol","4");
        conec.Mostrar();
        //conec.Actualizar("Probando2","Jose","2023","RD","Espaniol","4","Probando3","Benito","2024","Colombia","Ingles","1769");
        //conec.Mostrar();
        conec.Eliminar("Probando3","Benito","2024","Colombia","Ingles","1769");
        conec.Mostrar();
        
        
        
    }
    
}
