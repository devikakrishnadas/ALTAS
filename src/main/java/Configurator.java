/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christy
 */
import java.io.*;
public class Configurator {
    public String start() {
        try {
            Process p = Runtime.getRuntime().exec("/home/christy/NetBeansProjects/ALTAS/start.sh");
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
            return e.getMessage();
        }
        //System.out.println("end");
        return "0";
    }
    public String end() {
        try {
            Process p = Runtime.getRuntime().exec("/home/christy/NetBeansProjects/ALTAS/end.sh");
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
            return e.getMessage();
        }
        //System.out.println("end");
        return "0";        
    }

} 
