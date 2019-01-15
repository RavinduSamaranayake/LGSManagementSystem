package lgsapp.controlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lgsapp.helpers.DbConnect;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    @FXML
    private TextField txt_uname;

    @FXML
    private TextField txt_email;

    @FXML
    private PasswordField txt_password;

    double x = 0, y = 0;

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void dragged(MouseEvent event) {

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void btnlogin(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/lgsapp/views/login.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }

    @FXML
    void signup(MouseEvent event) {

        String username = txt_uname.getText();
        String email = txt_email.getText();
        String password = txt_password.getText();

        boolean emailvalid = isValidEmailAddress(email); //for valid email address
        boolean valid = true;

        if(username.isEmpty()){
            valid = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("SignUp Error");
            String s = "The Username is empty";
            alert.setContentText(s);
            alert.showAndWait();


        }
        else if(email.isEmpty()){
            valid = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("SignUp Error");
            String s = "The Email is empty";
            alert.setContentText(s);
            alert.showAndWait();

        }

        else if(!emailvalid){
            valid = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("SignUp Error");
            String s = "The Email is not valid";
            alert.setContentText(s);
            alert.showAndWait();

        }
        else if(password.isEmpty()){
            valid = false;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("SignUp Error");
            String s = "The Password is empty";
            alert.setContentText(s);
            alert.showAndWait();

        }
        else if(password.length()<8){
            valid = false;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("SignUp Warning");
            String s = "The Password must be at least 8 characters ";
            alert.setContentText(s);
            alert.showAndWait();

        }

        else if(password.length()>20){
            valid = false;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("SignUp Warning");
            String s = "The Password is too long ";
            alert.setContentText(s);
            alert.showAndWait();

        }

        else {
            Connection connection = DbConnect.getConnection();


            try {


                Statement statement = connection.createStatement();

                int status = statement.executeUpdate("insert into users (username,email,password)" +
                        " values('" + username + "','" + email + "','" + password + "')");

                if (status > 0) {
                    System.out.println("user registered");
                    valid = false;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("SignUp Cofirmation");
                    String s = "Registration Sucessfully";
                    alert.setContentText(s);
                    alert.showAndWait();

                    txt_uname.setText("");
                    txt_email.setText("");
                    txt_password.setText("");


                }

            } catch (SQLException e) {
                e.printStackTrace();
                valid = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("SignUp Error");
                String s = "Username or Email is already used";
                alert.setContentText(s);
                alert.showAndWait();
            }

        }


    }

    public boolean isValidEmailAddress(String email) {  //for email validation
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
