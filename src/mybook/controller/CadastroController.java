package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mybook.exception.CadastroInvalido;
import mybook.view.MyBook;

public class CadastroController implements Initializable {

    //colocar label para caso o email já ter sido cadastrado
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

    Controller controller = MyBook.getController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PassarTela tela = new PassarTela();
        String u = usuario.getText();
        String password1 = password.getText();
        String nome1 = nome.getText();
        String email1 = email.getText();
        String nascimento1 = nascimento.getText();
        String cidade1 = cidade.getText();
        String telefone1 = telefone.getText();
        String endereco1 = endereco.getText();

        Cadastrarbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean passou = true;
                try {
                    controller.cadastrarUsuario(password1, nome1, email1, nascimento1, cidade1, telefone1, endereco1);
                } catch (CadastroInvalido ex) {
                    passou = false;
                    System.out.println(ex.getLocalizedMessage());
                }
                if (passou == true) {
                    tela.login();
                    Cadastrarbutton.getScene().getWindow().hide();
                }
            }
        });
    }

}
