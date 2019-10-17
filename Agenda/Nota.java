import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Nota
{
    private String titulo;
    private final DateFormat fecha;
    private final Date fechaAc;
    private File cuerpo;
    public Nota(String titulo){
        setTitulo(titulo);
        cuerpo = new File(titulo+".txt");
        fechaAc = new Date();
        fecha = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public File getCuerpo(){
        return cuerpo;
    }
    
    public String getFecha(){
        return fecha.format(fechaAc);
    }
    
}
