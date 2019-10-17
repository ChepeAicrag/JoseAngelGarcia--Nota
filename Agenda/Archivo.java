
 

import java.io.*;
import javax.swing.JOptionPane;

public class Archivo {
    public static void prueba() throws IOException {
       
        try{
            File arc = new File("archivo1.txt");
            BufferedReader entrada = new BufferedReader(new FileReader(arc));
            if(arc.exists()){
                
                LeerArchivo(arc);
                
                System.out.println("El archivo tiene "+ContarLineas(arc)+" lineas");
                MostrarTodoArchivo(arc);
                
                for(int i = 0; i<ContarLineas(arc);i++){
                    ContarCaracteres(i,entrada);
                }
                EscribirTexto(JOptionPane.showInputDialog("Introduce tu texto"), arc);
                MostrarTodoArchivo(arc);
            }
            else{
                 System.out.println("Creando archivo de nombre "+arc.getName()); 
                 arc.createNewFile();
            }
        }catch(Exception err){
                System.out.println(err.getMessage());
        }
    }
     
    public static void LeerArchivo(File arc){
        
        try{
            
            FileReader fr = new FileReader(arc.getName());
            BufferedReader entrada = new BufferedReader(fr);
                
        }catch(Exception err){
            System.out.println("Error de "+err.getMessage());
        }
    }
    
    public static void EscribirTexto(String texto, File arc){
        try{
             FileWriter fw = new FileWriter(arc.getName());
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw);
             pw.print(texto);
             pw.close();
        
        }catch(Exception e){}
    }
    
    public static void MostrarTodoArchivo(File arc){
        try{
            
            FileReader fr = new FileReader(arc.getName());
            BufferedReader entrada = new BufferedReader(fr);
            
            for(int i = 0; i < ContarLineas(arc);i++){
                System.out.println(entrada.readLine());
            }
            
        }catch(Exception e){
        
        }
    }
    
    public static int ContarLineas(File arc){
        byte Total_Lineas = 0;        
        try{
            FileReader fr = new FileReader(arc.getName());
            BufferedReader entrada2 = new BufferedReader(fr);
            while( entrada2.readLine() != null){  
                Total_Lineas++;
            }
        }catch(Exception err){}  
      return Total_Lineas;  
    }
    
    public static void ContarCaracteres(int x,BufferedReader entrada){
        try{
         
        String linea = entrada.readLine();
        linea.trim();
        System.out.println("La linea "+x+" tiene un total de caracteres: "+(linea).length());
        System.out.println(linea);  
        }catch(Exception e){}    
    }

    
}
