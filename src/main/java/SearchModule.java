
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class SearchModule {
    Connection conn;
    void SearchModule(){
        conn = null;
    }
    void setconn(Connection con){
        conn=con;
    }
    public int Login(String Username, String Password,int stud){
        PreparedStatement pres;
        ResultSet res;
        String tablename;
        if(stud==1)
            tablename = "RegisteredStudents";
        else 
            tablename = "RegisteredFaculty";
        String query = "select count(*) from "+ tablename +" where Username='"+ Username +"'and password='"+ Password +"';";
        try {
            
            pres = conn.prepareStatement(query);
            res = pres.executeQuery();
            res.next();
            //System.out.println("res " + res.getInt(1));
            return res.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(SearchModule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
