
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        String tablename,accountType;
        if(stud==1){
            tablename = "userlist";
            accountType="s";
        }
        else {
            tablename = "userlist";
            accountType="f";
        }
        String query = "select count(*) from "+ tablename +" where Username='"+ Username +"' and password='"+ Password +"' and accounttype='"+accountType+"';";
        System.out.println(query);
        try {
            
            pres = conn.prepareStatement(query);
            res = pres.executeQuery();
            res.next();
            //System.out.println("res " + res.getInt(1));
            return res.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Exception encountered");
            Logger.getLogger(SearchModule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    ArrayList<Test> UpcomingTestDetails() {
        // returns a list of all upcomming tests
        PreparedStatement prestmt = null;
        ResultSet res = null;
        ArrayList<Test> A = new ArrayList<Test>();
        Test temp;
        try {
            String query = "select * from test where starttime > CURRENT_TIMESTAMP;";
            //System.out.println(query);
            prestmt = conn.prepareStatement(query);
            res = prestmt.executeQuery();
            while(res.next()){
                temp = new Test();
                temp.Testid = res.getLong(1);
                temp.Starttime = res.getTimestamp(2);
                temp.Endtime = res.getTimestamp(3);
                temp.Testname = res.getString(4);
//                temp.status = res.getInt(5);
                A.add(temp);
            }
            // conn.commit();
            //print(res);
            System.out.println("Statement excetued Successfully");
            
        } catch (SQLException sqle){
            System.out.println("Statement not excetued");
            /*
            try {
                conn.rollback();
                System.out.println("Rollback successful");
                 
            } catch (SQLException sqle1){
                System.out.println("Error");
                System.out.println(sqle1.getMessage());
            }
            */
            System.out.println(sqle.getMessage());
            
        } finally {
            try {
                //conn.setAutoCommit(true);
                if(prestmt!=null)
                    prestmt.close();
            } catch (SQLException sqle){
                System.out.println("Error");
                System.out.println(sqle.getMessage());
            }
        }
        return A;
    }
    
    ArrayList<Test> PreviousTestDetails() {
        // returns a list of all upcomming tests
        PreparedStatement prestmt = null;
        ResultSet res = null;
        ArrayList<Test> A = new ArrayList<Test>();
        Test temp;
        try {
            String query = "select * from test where starttime < CURRENT_TIMESTAMP;";
            //System.out.println(query);
            prestmt = conn.prepareStatement(query);
            res = prestmt.executeQuery();
            while(res.next()){
                temp = new Test();
                temp.Testid = res.getLong(1);
                temp.Starttime = res.getTimestamp(2);
                temp.Endtime = res.getTimestamp(3);
                temp.Testname = res.getString(4);
//                temp.status = res.getInt(5);
                A.add(temp);
            }
            // conn.commit();
            //print(res);
            System.out.println("Statement excetued Successfully");
            
        } catch (SQLException sqle){
            System.out.println("Statement not excetued");
            /*
            try {
                conn.rollback();
                System.out.println("Rollback successful");
                 
            } catch (SQLException sqle1){
                System.out.println("Error");
                System.out.println(sqle1.getMessage());
            }
            */
            System.out.println(sqle.getMessage());
            
        } finally {
            try {
                //conn.setAutoCommit(true);
                if(prestmt!=null)
                    prestmt.close();
            } catch (SQLException sqle){
                System.out.println("Error");
                System.out.println(sqle.getMessage());
            }
        }
        return A;
    }
    
    ArrayList<Request> fetchrequests() {
        // returns a list of all upcomming tests
        PreparedStatement prestmt = null;
        ResultSet res = null;
        ArrayList<Request> A = new ArrayList<Request>();
        Request temp;
        try {
            //conn.setAutoCommit(false);
            String query = "select * from requests;";
            System.out.println(query);
            prestmt = conn.prepareStatement(query);
            res = prestmt.executeQuery();
            while(res.next()){
                temp = new Request();
                temp.userid = res.getString(1);
                temp.pass = res.getString(2);
                temp.name = res.getString(3);
                temp.designation = res.getString(4);
                A.add(temp);
            }
            // conn.commit();
            //print(res);
            System.out.println("Statement excetued Successfully");
            
        } catch (SQLException sqle){
            System.out.println("Statement not excetued");
            /*
            try {
                conn.rollback();
                System.out.println("Rollback successful");
                 
            } catch (SQLException sqle1){
                System.out.println("Error");
                System.out.println(sqle1.getMessage());
            }
            */
            System.out.println(sqle.getMessage());
            
        } finally {
            try {
                //conn.setAutoCommit(true);
                if(prestmt!=null)
                    prestmt.close();
            } catch (SQLException sqle){
                System.out.println("Error");
                System.out.println(sqle.getMessage());
            }
        }
        return A;
    }
    Examinee fetchExamineeDetails(String username) {
        PreparedStatement prestmt = null;
        ResultSet res = null;
        Examinee temp = new Examinee();
        try {
            //conn.setAutoCommit(false);
            String query = "select name from userlist where username = ?;";
            System.out.println(query);
            prestmt = conn.prepareStatement(query);
            prestmt.setString(1,username);
            res = prestmt.executeQuery();
            res.next();
            temp.name = res.getString(1);
            query = "select * from registeredstudents where username = ?;";
            System.out.println(query);
            prestmt = conn.prepareStatement(query);
            prestmt.setString(1,username);
            res = prestmt.executeQuery();
            res.next();
            temp.username = res.getString(1);
            temp.Class = res.getString(2);
            temp.Branch = res.getString(3);
            // conn.commit();
            //print(res);
            System.out.println("Statement excetued Successfully");
            
        } catch (SQLException sqle){
            System.out.println("Statement not excetued");
            /*
            try {
                conn.rollback();
                System.out.println("Rollback successful");
                 
            } catch (SQLException sqle1){
                System.out.println("Error");
                System.out.println(sqle1.getMessage());
            }
            */
            System.out.println(sqle.getMessage());
            
        } finally {
            try {
                //conn.setAutoCommit(true);
                if(prestmt!=null)
                    prestmt.close();
            } catch (SQLException sqle){
                System.out.println("Error");
                System.out.println(sqle.getMessage());
            }
        }
        return temp; 
    }
}
