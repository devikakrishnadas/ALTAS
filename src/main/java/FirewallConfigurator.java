/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christy
 */
import java.util.*;
import java.io.*;
import java.nio.channels.FileChannel;
public class FirewallConfigurator {
    
    private File src = new File("firewall_base.rules");
    private File dest = new File("firewallConfig.rules");
    
    public int updateConfigfile(ArrayList<String> S) {
        FileChannel input = null;
        FileChannel output = null;
        try {
            input = new FileInputStream(src).getChannel();
            output = new FileOutputStream(dest).getChannel();
            output.transferFrom(input,0,input.size());
        }
        catch (FileNotFoundException fnf) {
            return 1;
        }
        catch (IOException e) {
            return 2;
        }
        finally {
            if(input!=null) {
                try {
                    input.close();
                }
                catch (IOException e) {
                    return 2;
                }
            }    
            if(output!=null) {
                try {
                    output.close();
                }
                catch (IOException e) {
                    return 2;
                }
            } 
        }
        DBDetails DB = new DBDetails();
        int ret = DB.fetchDetails();
        if(ret!=0) {
            //System.out.println("No DBDetails");
            return 1;
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(dest,true);
            String inrule,outrule;
            inrule = "-A INPUT -s "+DB.phost+" -j ACCEPT\n";
            outrule = "-A OUTPUT -d "+DB.phost+" -j ACCEPT\n";
            writer.write(inrule);
            writer.write(outrule);
            inrule = "-A INPUT -s "+DB.mhost+" -j ACCEPT\n";
            outrule = "-A OUTPUT -d "+DB.mhost+" -j ACCEPT\n";
            writer.write(inrule);
            writer.write(outrule);
            for(int i=0;i<S.size();i++) {
                inrule = "-A INPUT -s "+S.get(i)+" -j ACCEPT\n";
                outrule = "-A OUTPUT -d "+S.get(i)+" -j ACCEPT\n";
                writer.write(inrule);
                writer.write(outrule);
            }
            writer.write("COMMIT\n");
            writer.flush();
        }
        catch (IOException e) {
            return 2;
        }
        finally {
            if(writer!=null) {
                try {
                    writer.close();
                }
                catch(IOException e) {
                    return 2;
                }
            }
        }
        return 0;
    }
    
    
}
