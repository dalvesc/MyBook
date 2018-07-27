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
import mybook.exception.CadastroInvalido;
import mybook.view.MyBook;

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
        String password1 = password.getText();
        String nome1 = nome.getText();
        String email1 = email.getText();
        String nascimento1 = nascimento.getText();
        String cidade1 = cidade.getText();
        String telefone1 = telefone.getText();
        String fotoPerfil1 = fotoPerfil.getText();

        Cadastrarbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean passou = true;
                while (passou) {
                    try {
                        controller.cadastrarUsuario(password1, nome1, email1, nascimento1, cidade1, telefone1, fotoPerfil1);
                        passou = false;
                    } catch (CadastroInvalido ex) {
                        passou = true;
                        jaCadastrado.setText("Email já cadastrado");
                    }
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
