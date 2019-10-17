
import java.io.*;
import java.util.*;
public class Test01
{
    public static void main()throws IOException{
        Nota n1 = new Nota("Notas 1");
        Nota n2 = new Nota("Notas 2");
        Nota n3 = new Nota("Notas 3");
        EscribirTexto(n1);
        EscribirTexto(n2);
        EscribirTexto(n3);
        MostrarTodoArchivo(n1);
        MostrarTodoArchivo(n2);
        MostrarTodoArchivo(n3);
        Nota [] n = {n1,n2,n3};
        StdOut.println("Buscando en las notas la palabra hola");
        Buscar(n,"hola");
    }
    
    
    public static void Buscar(Nota[] n,String buscar)throws IOException{        
            for(int i = 0; i < n.length; i++){
                if(BusCuerpo(n[i], buscar) || n[i].getTitulo().toUpperCase().contains(buscar.toUpperCase()))
                StdOut.println(n[i].getTitulo());
            }
        } 
    
    
    public static boolean BusCuerpo(Nota n, String buscar) throws IOException {
      if(!n.getCuerpo().canExecute())
         return false;
      FileReader fr = new FileReader(n.getCuerpo().getName());
      BufferedReader entrada2 = new BufferedReader(fr);
      for(int i = 0; i < ContarLineas(n); i++)
          if(entrada2.readLine().toUpperCase().contains(buscar.toUpperCase()))
             return true;      
     return false;       
    }
    
    
    public static void EscribirTexto(Nota n)throws IOException{ 
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
    
    public static void MostrarTodoArchivo(Nota n){
        StdOut.println("El archivo " + n.getTitulo() + " creado el "+ n.getFecha() + " contiene de cuerpo");
        try{
            FileReader fr = new FileReader(n.getCuerpo().getName());
            BufferedReader entrada = new BufferedReader(fr);
            for(int i = 0; i < ContarLineas(n);i++)
                System.out.println(entrada.readLine());
        }catch(Exception e){}
    }
    
    public static int ContarLineas(Nota n){
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
