package lgsapp.controlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {




    @FXML
    void uploadPic(MouseEvent event) throws IOException {
       /* Parent root = FXMLLoader.load(getClass().getResource("/lgsapp/views/home.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.setFullScreen (true);
*/


    }


    @FXML
    void editInfo(MouseEvent event) throws IOException {
       /* Parent root = FXMLLoader.load(getClass().getResource("/lgsapp/views/home.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.setFullScreen (true);
*/


    }

    @FXML
    void deleteInfo(MouseEvent event) throws IOException {
       /* Parent root = FXMLLoader.load(getClass().getResource("/lgsapp/views/about.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
*/
    }

    @FXML
    void go(MouseEvent event) throws IOException {
       /* Parent root = FXMLLoader.load(getClass().getResource("/lgsapp/views/about.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
*/
    }

    @FXML
    void exitTomain(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lgsapp/views/dashbord.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.setFullScreen (true);

    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
