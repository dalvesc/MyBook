package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import mybook.exception.*;
import mybook.model.*;
import mybook.view.*;

public class PerfilController implements Initializable {

    private Usuario u;

    @FXML
    private Button voltar;

    @FXML
    private ImageView fotoPefil;

    @FXML
    private Text nome;

    @FXML
    private Text email;

    @FXML
    private Text nascimento;

    @FXML
    private Text cidade;

    @FXML
    private Text telefone;

    @FXML
    private ListView<Usuario> amigos;

    @FXML
    private Button abrir;

    Controller controller = MyBook.getController();

    PerfilController(Usuario u) {
        this.u = u;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PassarTela tela = new PassarTela();

        voltar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                tela.telaInicial(u);
                voltar.getScene().getWindow().hide();
            }
        });

        ObservableList<Usuario> data = FXCollections.observableArrayList();

        try {
            for (Usuario usu : controller.amizades(u)) {
                data.add(usu);
            }

            amigos.setItems(data);
            Usuario amigo = amigos.getSelectionModel().getSelectedItem();
            abrir.setVisible(true);
            abrir.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    tela.telaInicial(amigo);
                }
            });
        } catch (SemAmigos ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }

        nome.setText("Nome: " + u.getNome());
        email.setText("Email: " + u.getEmail());
        nascimento.setText("Nascimento: " + u.getNascimento());
        cidade.setText("Cidade: " + u.getCidade());
        telefone.setText("Telefone: " + u.getTelefone());
        
        try {
            Image image = new Image(u.getFotoPerfil());
            fotoPefil.setImage(image);
        } catch (SemImagem ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
