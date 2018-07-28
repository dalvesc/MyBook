package mybook.controller;

import java.io.IOException;
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
import javafx.scene.control.TextField;
import mybook.exception.*;
import mybook.facade.*;
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

    Facade facade = MyBook.getFacade();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PassarTela tela = new PassarTela();

        Cadastrarbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    facade.cadastrarUsuario(password.getText(),
                            nome.getText(), email.getText(), nascimento.getText(),
                            cidade.getText(), telefone.getText(), fotoPerfil.getText());
                } catch (CadastroInvalido ex) {
                    jaCadastrado.setText("Email já cadastrado");
                } catch (IOException ex) {
                    Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tela.login();
                Cadastrarbutton.getScene().getWindow().hide();
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.login();
                voltar.getScene().getWindow().hide();
            }
        });
    }

}
