/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nandu6177
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class PrintDire {
   public static void main(String[] args) {
       try {
            Process p = Runtime.getRuntime().exec("pwd");
            //System.out.println("Successful");
            p.waitFor();
            ///*
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";			
            while ((line = reader.readLine())!= null) {
                sb.append(line + "\n");
                System.out.println(sb.toString());
            }
           //*/
        }
        catch( Exception e) {
            //return e.essage();
        }
        //System.out.println("end");
        //return "0";
   } 
    
}
