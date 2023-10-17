package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep11.db.SingleConnectionDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class AppInitializer extends Application {

    public static void main(String[] args) {


        try(Connection connection = SingleConnectionDataSource.getInstance().getConnection())
        {
            launch(args);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/testForm.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Employee Attendance Management System");
        primaryStage.centerOnScreen();
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}

