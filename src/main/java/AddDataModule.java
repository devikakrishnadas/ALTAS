
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author devika
 */
public class AddDataModule {
    private Connection Conn;
    private String TableName;
    AddDataModule(Connection conn, String TableName) {
        Conn = conn;
        this.TableName = TableName;
    }

    public int addDoc(Map data)  
    {
        // returns 1 on success
        int ret=0;
        PreparedStatement pres;
        String query = "insert into " + TableName +" (";
        Iterator it = data.entrySet().iterator();
        
        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            query = query + pair.getKey() + ",";
        }
        query = query.substring(0,query.length()-1);
        query = query + ")";
        it = data.entrySet().iterator();
        query =  query + " values (";
        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
           
            query = query + pair.getValue() + ",";
        }
        query = query.substring(0,query.length()-1);
        query = query + " ); ";
        System.out.println(query);
        try {
            pres = Conn.prepareStatement(query);
            ret=pres.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(AddDataModule.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return ret;
    }
    public void updateDoc(Map data){
        PreparedStatement pres;
        String query = "update " + TableName +" set ";
        Iterator it = data.entrySet().iterator();
        
        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            query = query + pair.getKey() + "=" + pair.getValue() + ",";
        }
        query = query.substring(0,query.length()-1);
        query = query + " where TestID=" + data.get("TestID") + ";";
        System.out.println(query);
        try {
            pres = Conn.prepareStatement(query);
            /*ResultSet executeQuery = */pres.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddDataModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
