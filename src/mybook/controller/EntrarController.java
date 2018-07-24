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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EntrarController implements Initializable {

    String usuario;
    String senha;

    @FXML
    private Button cadastrarButton;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private Button entrarButton;

    @FXML
    public void cadastrarButtonAction(ActionEvent event) throws IOException {

    }

    @FXML
    void entrarButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent cadastro = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        Scene scene = new Scene(cadastro);
        stage.setScene(scene);
        stage.show();
        entrarButton.getScene().getWindow().hide();
    }

    @FXML
    void getEmail(ActionEvent event) {
        usuario = email.getText();
    }

    @FXML
    void getPassword(ActionEvent event) {
        senha = password.getText();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cadastrarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                Parent cadastro = null;
                try {
                    cadastro = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(EntrarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(cadastro);
                stage.setScene(scene);
                stage.show();
                cadastrarButton.getScene().getWindow().hide();
            }
        });
    }

}
