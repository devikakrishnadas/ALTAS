/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nandu6177
 */
import java.io.File;
import java.io.IOException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import java.net.UnknownHostException;

public class AddFileToDB {
    
    public AddFileToDB(String path,String Q_ID) throws IOException{
        AddFile(path,Q_ID);
    }
    
    private void AddFile(String path,String Q_ID) throws UnknownHostException, IOException {
        MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://admin:admin@ds255889.mlab.com:55889/altasdb"));
        DB db = mongo.getDB("altasdb");
        GridFS gridFs = new GridFS(db);
        GridFSInputFile gridFsInputFile = gridFs.createFile(new File(path));
        gridFsInputFile.setFilename(String.valueOf(Q_ID));
        gridFsInputFile.save();
    }
}
