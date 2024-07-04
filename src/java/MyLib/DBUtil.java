/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLib;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USER
 */
public class DBUtil {
    public static Connection makeConnection() throws Exception {
        Connection cn = null;
        String IP = "localhost";
        String instanceName = "ROG-FLOW-X13\\TRONGTIEN";
        String port = "1433";
        String uid = "sa";
        String pwd = "12345";
        String db = "Foody";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port
                   + ";databaseName=" + db + ";user=" + uid + ";password=" + pwd
                   + ";useUnicode=true;characterEncoding=UTF-8";
        Class.forName(driver);
        cn = DriverManager.getConnection(url);
        return cn;
    }
}
