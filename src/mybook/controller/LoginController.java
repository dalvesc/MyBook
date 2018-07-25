package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mybook.view.MyBook;

public class LoginController implements Initializable {

    //colocar label para login errado
    @FXML
    private Button cadastrarButton;
    @FXML
    private Button entrarButton;
    @FXML
    private TextField Email;
    @FXML
    private PasswordField Password;

    Controller controller = MyBook.getController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PassarTela tela = new PassarTela();

        entrarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (controller.cadastrado(Email.getText(), Password.getText())) {
                    tela.telaInicial();
                    entrarButton.getScene().getWindow().hide();
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
