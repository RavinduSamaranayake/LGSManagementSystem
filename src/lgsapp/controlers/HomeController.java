package lgsapp.controlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private File file;
    private FileChooser fileChooser;
    private Desktop desktop = Desktop.getDesktop();
    private String imageFile;

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtLastname;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtWOP;

    @FXML
    private ComboBox cmbGender;

    @FXML
    private ComboBox cmbCuryr;

    @FXML
    private ComboBox cmbOffice;

    @FXML
    private DatePicker txtBirthday;

    @FXML
    private DatePicker txtFirstAppdate;

    @FXML
    private DatePicker txtUpgrading;

    @FXML
    private DatePicker txtRetirement;

    @FXML
    private DatePicker txtIncrement;

    @FXML
    private CheckBox chkPb;

    @FXML
    private CheckBox chkPm;

    @FXML
    private CheckBox chkPe;

    @FXML
    private RadioButton radioyes;

    @FXML
    private CheckBox radiono;













    @FXML
    private ImageView img_frame;


    @FXML
    void uploadPic(MouseEvent event) throws IOException {    //using file chooser

        handle_load();

    }




    @FXML
    public void handle_load() throws MalformedURLException {  //to select image on hdd and set it to the image view

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif")); // limit fileChooser options to image files
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {

            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println("the path is>>>>>>>"+imageFile+">>>>>>>");

           Image image = new Image(imageFile);
           img_frame.setImage(image);
        } else {


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Please Select valid image File");
            alert.showAndWait();
        }

    }

    @FXML
    void addInfo(MouseEvent event) throws IOException {
        String firstname = txtFirstname.getText();
        String lastname = txtLastname.getText();
        String wop = txtWOP.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String gender = cmbGender.getSelectionModel().getSelectedItem().toString();
        String office = cmbOffice.getSelectionModel().getSelectedItem().toString();
        String curyr = cmbCuryr.getSelectionModel().getSelectedItem().toString();
        String bday = txtBirthday.getValue().toString();
        String fappdate = txtFirstAppdate.getValue().toString();
        String upgrade = txtUpgrading.getValue().toString();
        String retdate = txtRetirement.getValue().toString();
        String incdate = txtIncrement.getValue().toString();
        String chkpb = getchkboxData(chkPb);
        String chkpm = getchkboxData(chkPm);
        String chkpe = getchkboxData(chkPe);
        String incremantal = getIncremantal();
        


    }

     public String getchkboxData(CheckBox checkBox){  ///to get the data from check box
        String value = "";
        if (checkBox.isSelected()){
            value = "yes";
        }
        else{
            value = "no";
        }
        return value;
    }

    public String getIncremantal(){  //to get the data from radio btn
        String value = "";
        if (radioyes.isSelected()){
            value = "yes";
        }
        else{
            value = "no";
        }
        return value;
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
