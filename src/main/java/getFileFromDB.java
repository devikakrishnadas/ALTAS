
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import com.mongodb.MongoException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christy
 */
public class getFileFromDB {
    
     public int getFile(String path,String filename) {
        // returns 1 on success  
        long r;
        int ret;
        ConnectDB connection = new ConnectDB();
        try {
            DB db = connection.connectMongo();
            GridFS gridFs = new GridFS(db);
            GridFSDBFile file=gridFs.findOne(filename);
            File f = new File(path+"/"+filename);
            r=file.writeTo(f);
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return 1;
        }
        catch (MongoException m) {
            System.out.println(m.getMessage());
            return 2;
        }
        if(r>0) {
            return 0;
        }
        else {
            return 1;
        }
    }
    
}
