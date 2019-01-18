package lgsapp.controlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private File file;
    private FileChooser fileChooser;
    private Desktop desktop = Desktop.getDesktop();


    @FXML
    private ImageView imageView;

    @FXML
    private Image img;

    @FXML
    void uploadPic(MouseEvent event) throws IOException {    //using file chooser

        fileChooser = new FileChooser();
       

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            openFile(file);
        }
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


    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }


    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            // Logger.getLogger(FileChooserSample.class.getName()).log(
            // Level.SEVERE, null, ex
            System.out.println(ex);

        }
    }








    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
