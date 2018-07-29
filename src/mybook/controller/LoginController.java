package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mybook.exception.*;
import mybook.facade.*;
import mybook.view.*;

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

    Facade facade = MyBook.getFacade();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PassarTela tela = new PassarTela();

        entrarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    if (facade.fazerLogin(Email.getText(), Password.getText())) {
                        facade.setU(facade.getUserLogado());
                        tela.telaInicial();
                        entrarButton.getScene().getWindow().hide();
                    }
                } catch (LoginInvalido ex) {
                    loginInvalido.setText("Login Invalido");
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

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