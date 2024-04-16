package app.Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connection {
    
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLNV;encrypt=false;trustServerCertificate=false";
    static final String USER = "sa";
    static final String PASS = "Contraidep7271@";
    
    public static Connection connectionDB(){

        try {
            
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        }
            // Kết nối thành công
            
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

public static void CloseConnect(Connection c){
    try{
        if (c != null )
        {c.close();}
    }
    catch (Exception e){
        e.printStackTrace();
    }

}}
