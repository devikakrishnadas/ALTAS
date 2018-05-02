
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christy
 */
public class DeleteModule {
    private Connection conn;
    void DeleteModule() {
        conn = null;
    }
    void setconn(Connection con) {
        conn = con;
    }
    public int deleteRequest(String userid) {
        int rows = 0;
        PreparedStatement prestmt = null;
        try {
            conn.setAutoCommit(false);
            String query = "Delete from requests where userid = ?;";
            prestmt = conn.prepareStatement(query);
            prestmt.setString(1,userid);
            rows = prestmt.executeUpdate();
            conn.commit();
            System.out.println("Statement excetued Successfully");
            
        } catch (SQLException sqle){
            System.out.println("Statement not excetued");
            try {
                conn.rollback();
                System.out.println("Rollback successful");
                 
            } catch (SQLException sqle1){
                System.out.println("Error");
                System.out.println(sqle1.getMessage());
            }
            System.out.println(sqle.getMessage());
            
        } finally {
            try {
                conn.setAutoCommit(true);
                if(prestmt!=null)
                    prestmt.close();
            } catch (SQLException sqle){
                System.out.println("Error");
                System.out.println(sqle.getMessage());
            }
        }
        return rows;
        
    }
}
