
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christy
 */
public class AddSubmissionModule {
    private Connection Conn;
    private String tablename;
    AddSubmissionModule(Connection conn)
    {
        Conn = conn;
        tablename = new String("submission");
    }
    public int add(Submission S) {
        // return value is 1 for success
        Connection conn = null;
        ConnectDB DB = new ConnectDB();
        int ret = DB.connect();
        if(ret != 0) {
            return 1;
        }
        conn = DB.getconn();
        
        Map data = new HashMap();
        data.put("id","'"+S.id+"'");
        data.put("questionid","'"+S.questionid+"'");
        data.put("examineeid","'"+S.examineeid+"'");
        data.put("lang","'"+S.lang+"'");
        data.put("submittime","'"+S.submittime+"'");
        AddDataModule adm = new AddDataModule(conn,tablename);
        ret = adm.addDoc(data);
        DB.disconnect();
        return ret;
    }
}
