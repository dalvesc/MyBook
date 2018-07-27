package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mybook.exception.*;
import mybook.view.*;

public class CadastroController implements Initializable {

    @FXML
    private Button Cadastrarbutton;
    @FXML
    private TextField password;
    @FXML
    private TextField nome;
    @FXML
    private TextField email;
    @FXML
    private TextField nascimento;
    @FXML
    private TextField cidade;
    @FXML
    private TextField telefone;
    @FXML
    private Label jaCadastrado;
    @FXML
    private TextField fotoPerfil;
    @FXML
    private Button voltar;

    Controller controller = MyBook.getController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PassarTela tela = new PassarTela();

        Cadastrarbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String foto = "imagens: " +fotoPerfil.getText();
                try {
                    controller.cadastrarUsuario(password.getText(),
                            nome.getText(), email.getText(), nascimento.getText(),
                            cidade.getText(), telefone.getText(), foto);
                } catch (CadastroInvalido ex) {
                    jaCadastrado.setText("Email já cadastrado");
                }
                tela.login();
                Cadastrarbutton.getScene().getWindow().hide();
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.login();
            }
        });
    }

}
