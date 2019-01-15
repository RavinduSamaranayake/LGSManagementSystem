package lgsapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lgsapp.helpers.DbConnect;

import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/lgsapp/views/login.fxml"));


        Scene scene = new Scene(root);

        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);

        stage.initStyle(StageStyle.TRANSPARENT);

        stage.show();
    }

 /*   public static void callfunc() {
        PreparedStatement ps;
        Connection con = DbConnect.getConnection();
        String query = "SELECT * FROM users WHERE username=? AND password =?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, "kushan");
            ps.setString(2, "12345");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Successfully connection with...."+rs.getString(1)+" "+rs.getString(2));
            }
        }
        catch (SQLException e) {
            System.out.println("Some thing wrong.... " + e );
           // e.printStackTrace();
        }

    }
 */

    public static void main(String[] args) {

       // callfunc();  //to testing connection and access
        launch(args);
    }
}