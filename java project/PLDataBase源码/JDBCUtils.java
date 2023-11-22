package PLDataBase;

import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

	private static String url="jdbc:mysql://localhost:3306/premierleague?useUnicode=true&characterEncoding=utf8";
	private static String user="root";
	private static String password="53468896Aa@";
	
    private JDBCUtils() {};

    static {
        try {
            
        	//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return 连接对象
     */
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param statement sql执行语句对象
     * @param connection 连接对象
     */
    public static void close(Statement statement,Connection connection) {
        close(null, statement,connection);
    }

    /**
     * 释放资源
     * @param resultSet 结果集对象
     * @param statement sql执行语句对象
     * @param connection 连接对象
     */
    public static void close(ResultSet resultSet, Statement statement,Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}
