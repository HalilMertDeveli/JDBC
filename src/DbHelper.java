import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private  String userName = "root";

    private  String password = "123456";

    private  String url = "jdbc:mysql://localhost:3306/classicmodels";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,userName,password);
    }
    public void showSqlException(SQLException sqlExceptionInstance){
        System.out.println( "Error context :"+sqlExceptionInstance.getMessage());
        System.out.println("Error code:" +sqlExceptionInstance.getErrorCode());
    }
}
