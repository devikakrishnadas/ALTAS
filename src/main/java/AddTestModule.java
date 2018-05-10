
import java.sql.Connection;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author devika
 */
public class AddTestModule {
    private Connection Conn;
    AddTestModule(Connection conn)
    {
        Conn = conn;
    }
    public void AddToTest(Map Data)
    {
        AddDataModule adm = new AddDataModule(Conn,"Test");
        adm.addDoc(Data);
    }
    public void UpdateTest(Map Data)
    {
        AddDataModule adm=new AddDataModule(Conn,"Test");
        adm.updateDoc(Data);
    }
}
