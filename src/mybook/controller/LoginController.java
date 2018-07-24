package mybook.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private Button cadastrarButton;
    @FXML
    private Button entrarButton;
    @FXML
    private TextField Email;
    @FXML
    private PasswordField Password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        entrarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Email.getText().equals("teste") && Password.getText().equals("test")) {
                    Stage stage = new Stage();
                    Parent root = null;

                    try {
                        root = FXMLLoader.load(getClass().getResource("/mybook.view/TelaInicial.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                    stage.setTitle("Login");
                    entrarButton.getScene().getWindow().hide();
                }
            }
        });

        cadastrarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage stage = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("/mybook.view/Cadastro.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
                stage.setTitle("Cadastro");
                cadastrarButton.getScene().getWindow().hide();

            }
        });
    }
}
