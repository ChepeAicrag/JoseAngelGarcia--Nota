/**
 * Clase utilizada como cliente para probar diferentes métodos
 * @author Garcia Garcia Jose Angel
 * @version 30/11/2019
   */
import java.io.*;
import java.util.*;
public class Test01
{
    /**
     * Método principal para probar a los demás métodos 
     * @@throws IOException
       */
    public static void main()throws IOException{
        Nota n1 = new Nota("Notas 1");
        Nota n2 = new Nota("Notas 2");
        Nota n3 = new Nota("Notas 3");
        Test01 t = new Test01();
        t.EscribirTexto(n1);
        t.EscribirTexto(n2);
        t.EscribirTexto(n3);
        t.MostrarTodoArchivo(n1);
        t.MostrarTodoArchivo(n2);
        t.MostrarTodoArchivo(n3);
        Nota [] n = {n1,n2,n3};
        StdOut.println("Buscando en las notas la palabra hola");
        t.Buscar(n,"hola");
    }
    
    /**
     * Método para buscar una nota por titulo  
     * @param n Arreglo que contiene a la(s) nota(s)
     * @param buscar Titulo a buscar en el arreglo de nota(s)
     * @throw IOException 
       */
    public void Buscar(Nota[] n,String buscar)throws IOException{        
            for(int i = 0; i < n.length; i++){
                if(BusCuerpo(n[i], buscar) || n[i].getTitulo().toUpperCase().contains(buscar.toUpperCase()))
                StdOut.println(n[i].getTitulo());
            }
        } 
        
    /**
     * Método para buscar una palabra en el cuerpo de la nota
     * @param n Nota en la que se busca
     * @param buscar Palabra que se busca en el cuerpo de la nota
     * @throws IOExpcetion
     * @return true si está la palabra y false de lo contrario
       */
    public boolean BusCuerpo(Nota n, String buscar) throws IOException {
      if(!n.getCuerpo().canExecute())
         return false;
      FileReader fr = new FileReader(n.getCuerpo().getName());
      BufferedReader entrada2 = new BufferedReader(fr);
      for(int i = 0; i < ContarLineas(n); i++)
          if(entrada2.readLine().toUpperCase().contains(buscar.toUpperCase()))
             return true;      
     return false;       
    }
    
    /**
     * Método para escribir texto en una nota
     * @param n Nota en la que se escribirá
     * @throws IOException
       */
    public void EscribirTexto(Nota n)throws IOException{ 
        if(!n.getCuerpo().exists())
        n.getCuerpo().createNewFile();
        Scanner leer = new Scanner(System.in);
        StdOut.println("Introduce el texto a agregar");
        String texto = leer.nextLine()+"\n"; 
        try{
             FileWriter fw = new FileWriter(n.getCuerpo().getName(),true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw);
             pw.print(texto);
             pw.close();
        }catch(Exception e){}
    }
    
    /**
     * Método para mostrar texto contenido en una nota
     * @param n Nota de la cual se mostrara su cuerpo
     * @throws IOException
       */
    public void MostrarTodoArchivo(Nota n){
        StdOut.println("El archivo " + n.getTitulo() + " creado el "+ n.getFecha() + " contiene de cuerpo");
        try{
            FileReader fr = new FileReader(n.getCuerpo().getName());
            BufferedReader entrada = new BufferedReader(fr);
            for(int i = 0; i < ContarLineas(n);i++)
                System.out.println(entrada.readLine());
        }catch(Exception e){}
    }
    
    /**
     * Método para contar las lineas que contiene el cuerpo de la nota
     * @peram n Nota a la que le cuenta las lineas de texto
     * @return El numero de lineas que contiene la nota en su cuerpo
       */
    public int ContarLineas(Nota n){
        byte Total_Lineas = 0;        
        try{
            FileReader fr = new FileReader(n.getCuerpo().getName());
            BufferedReader entrada2 = new BufferedReader(fr);
            while( entrada2.readLine() != null)
                Total_Lineas++;
        }catch(Exception err){}  
      return Total_Lineas;  
    }

}
