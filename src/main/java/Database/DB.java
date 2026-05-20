package Database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    private static final String URL =
            "jdbc:mysql://localhost:3306/?allowMultiQueries=true";

    private static final String USER = "root";

    private static final String PASSWORD = "1234";

    public static void initialize() {

        try {

          
            Connection conn =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            
            Statement stmt = conn.createStatement();

            String sql = Files.readString(
                    Paths.get("src/main/resources/sql/DB.sql")
            );


            stmt.execute(sql);

            stmt.close();
            conn.close();

            System.out.println("Banco inicializado.");

        } catch (Exception e) {

            System.out.println("Erro ao iniciar banco.");

            e.printStackTrace();
        }
    }
}