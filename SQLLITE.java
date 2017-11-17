import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.sql.*;

public class SQLLITE {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.sqlite.JDBC");
        String urlConection="jdbc:sqlite:KATA5.DB";
        Connection connection= DriverManager.getConnection(urlConection);

        Statement statement = connection.createStatement();
        String query="CREATE TABLE IF NOT EXISTS MAIL ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Mail' TEXT NOT NULL);";
        statement.execute(query);

        String fileName ="C:\\Users\\ADRIELGARCÍADÍAZ\\IdeaProjects\\Kata5P1\\emails.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String mail;

        while((mail=reader.readLine())!=null){
            if(!mail.contains("@")) continue;
            query="INSERT INTO MAIL (mail) VALUES ('" + mail +"')";
            statement.executeUpdate(query);
        }

        statement.close();
        connection.close();
    }
}
