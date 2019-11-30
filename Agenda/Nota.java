/**
 * Esta clase contruye objetos Nota
 * @author Garcia Garcia Jose Angel
 * @version 30/11/2019
   */
import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Nota
{
    /**
     * Campos de clase
       */
    private String titulo;
    private final DateFormat fecha;
    private final Date fechaAc;
    private File cuerpo;
    /**
     * Constuctor para la clase Nota
     * @param titulo El parametro titulo define el titulo que va a tener la nota
       */
    public Nota(String titulo){
        this.titulo = titulo;
        cuerpo = new File(titulo+".txt");
        fechaAc = new Date();
        fecha = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    /**
      * Método que devuelve el titulo de la Nota
      * @return El titulo que tiene la Nota
       */
    public String getTitulo(){
        return titulo;
    }
    
    /**
      * Método que devuelve el archivo (File) relaciando al cuerpo de la Nota
      * @return El archivo que contiene la Nota como cuerpo
       */
    public File getCuerpo(){
        return cuerpo;
    }
    
    /**
      * Método que devuelve la fecha de la Nota
      * @return La fecha formateada con la que se creo la Nota
       */
    public String getFecha(){
        return fecha.format(fechaAc);
    }
    
}
