package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mybook.model.Usuario;

public class CadastroController implements Initializable {

    @FXML
    private Button Cadastrarbutton;
    @FXML
    private TextField usuario;
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
    private TextField endereco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Usuario usuario1;
        String u = usuario.getText();
        String password1 = password.getText();
        String nome1 = nome.getText();
        String email1 = email.getText();
        String nascimento1 = nascimento.getText();
        String cidade1 = cidade.getText();
        String telefone1 = telefone.getText();
        String endereco1 = endereco.getText();
        usuario1 = new Usuario(password1, nome1, email1, nascimento1,
                cidade1, telefone1, endereco1);
        
    }

}
