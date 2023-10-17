package lk.ijse.dep11.db;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingleConnectionDataSource {

    private static Connection connection;

    private static SingleConnectionDataSource instance;


    private SingleConnectionDataSource(){

        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/Application.properties"));
            String url = properties.getProperty("app.datasource.url");
            String user = properties.getProperty("app.datasource.username");
            String password = properties.getProperty("app.datasource.password");
            connection = DriverManager.getConnection(url,user,password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void generateShema() throws IOException, SQLException, URISyntaxException {
        URL url = getClass().getResource("/shema.sql");
        Path path = Paths.get(url.toURI());
        String script = Files.readAllLines(path).stream().reduce((preveline, curentline) -> preveline + curentline).get();
        connection.createStatement().execute(script);

    }



    public static SingleConnectionDataSource getInstance()
    {
        return (instance==null)?instance=new SingleConnectionDataSource():instance;
    }

    public static Connection getConnection(){
        return connection;
    }
}
