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
import mybook.exception.CadastroInvalido;

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

        String u = usuario.getText();
        String password1 = password.getText();
        String nome1 = nome.getText();
        String email1 = email.getText();
        String nascimento1 = nascimento.getText();
        String cidade1 = cidade.getText();
        String telefone1 = telefone.getText();
        String endereco1 = endereco.getText();

        Controller controller = new Controller();

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
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/mybook/view/Login.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                    stage.setTitle("Login");
                    Cadastrarbutton.getScene().getWindow().hide();
                }
            }
        });
    }

}
