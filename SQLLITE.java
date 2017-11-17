import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.*;

public class SQLLITE {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String urlConection="jdbc:sqlite:KATA5.DB";
        Connection connection= DriverManager.getConnection(urlConection);

        Statement statement = connection.createStatement();
        String query="Select * from PEOPLE";
        ResultSet rs = statement.executeQuery(query);

        while(rs.next()){
            System.out.print(rs.getInt(1)+"-");
            System.out.print(rs.getString(2)+" ");
        }
    }
}
