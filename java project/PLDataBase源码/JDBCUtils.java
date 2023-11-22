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
            
        	//��������
			Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���Ӷ���
     * @return ���Ӷ���
     */
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * �ͷ���Դ
     * @param statement sqlִ��������
     * @param connection ���Ӷ���
     */
    public static void close(Statement statement,Connection connection) {
        close(null, statement,connection);
    }

    /**
     * �ͷ���Դ
     * @param resultSet ���������
     * @param statement sqlִ��������
     * @param connection ���Ӷ���
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
