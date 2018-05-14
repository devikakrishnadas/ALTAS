
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christy
 */
public class serverDetails {
    String url;
    private File DBConfig = new File("serverconfig.properties");
    private Properties configProps;
    public int fetchDetails() {
        InputStream inputStream = null;
        configProps = new java.util.Properties();
        try {
            inputStream = new FileInputStream(DBConfig);
            configProps.load(inputStream);
        }
        catch (FileNotFoundException fnf) {
            return 1;
        }
        catch (IOException e ){
            return 2;
        }
        finally {
            if(inputStream!=null) {
                try {
                    inputStream.close();
                }
                catch ( IOException e ){
                    return 2;
                }
            }    
        }
        url = configProps.getProperty("url");
        return 0;
    }
    public int pushDetails() {
        configProps = new java.util.Properties();
        configProps.setProperty("url", url);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(DBConfig);
            configProps.store(outputStream, "Server Details");
            
        }
        catch (FileNotFoundException fnf)  {
            return 1;
        }
        catch (IOException e) {
            return 2;
        }
        finally {
            if(outputStream!=null) {
                try {
                    outputStream.close();
                }
                catch ( IOException e ){
                    return 2;
                }
            }    
        }
        return 0;
    }
   
}
