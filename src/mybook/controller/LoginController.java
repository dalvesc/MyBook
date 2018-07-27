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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mybook.exception.LoginInvalido;
import mybook.view.MyBook;

public class LoginController implements Initializable {

    @FXML
    private Button cadastrarButton;
    @FXML
    private Button entrarButton;
    @FXML
    private TextField Email;
    @FXML
    private PasswordField Password;
    @FXML
    private Label loginInvalido;

    Controller controller = MyBook.getController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PassarTela tela = new PassarTela();

        entrarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    controller.setConta(controller.fazerLogin(Email.getText(), Password.getText()));
                } catch (LoginInvalido ex) {
                    loginInvalido.setText("Login Invalido");
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tela.telaInicial();
                entrarButton.getScene().getWindow().hide();
            }
        });

        cadastrarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.cadastro();
                cadastrarButton.getScene().getWindow().hide();
            }
        });
    }
}
