package mybook.controller;

import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import mybook.exception.*;
import mybook.facade.*;
import mybook.model.*;
import mybook.view.*;

public class PerfilController implements Initializable {

    private Usuario u;
    private Usuario amigo;
    Image image;
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
    @FXML
    private Button removerAmigo;
    @FXML
    private Button deletarConta;
    @FXML
    private Button addFoto;
    @FXML
    private TextField nomeFoto;
    @FXML
    private Label label;

    Facade facade = MyBook.getFacade();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PassarTela tela = new PassarTela();
        u = facade.getU();

        voltar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                facade.setU(u);
                tela.telaInicial();
                voltar.getScene().getWindow().hide();
            }
        });

        ObservableList<Usuario> data = FXCollections.observableArrayList();

        try {
            for (Usuario usu : facade.amizades(u)) {
                data.add(usu);
            }

            amigos.setItems(data);
            amigos.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> setAmigo(newValue));
            abrir.setVisible(true);
            abrir.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    facade.setU(amigo);
                    tela.telaInicial();
                    abrir.getScene().getWindow().hide();
                }
            });
        } catch (SemAmigos ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!u.equals(facade.getUserLogado())) {
            removerAmigo.setVisible(true);
            removerAmigo.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    facade.removerAmizade(u.getNome());
                    facade.setU(facade.getUserLogado());
                    tela.telaInicial();
                    removerAmigo.getScene().getWindow().hide();
                }
            });
        }

        if (u.equals(facade.getUserLogado())) {
            deletarConta.setVisible(true);
            deletarConta.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try {
                        if (facade.removerConta()) {
                            tela.login();
                            deletarConta.getScene().getWindow().hide();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
        }

        if (u.equals(facade.getUserLogado())) {
            addFoto.setVisible(true);
            nomeFoto.setVisible(true);
            label.setVisible(true);
            addFoto.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    u.setFotoPerfil(nomeFoto.getText());
                    tela.telaInicial();
                    addFoto.getScene().getWindow().hide();
                }
            });
        }
        nome.setText("Nome: " + u.getNome());
        email.setText("Email: " + u.getEmail());
        nascimento.setText("Nascimento: " + u.getNascimento());
        cidade.setText("Cidade: " + u.getCidade());
        telefone.setText("Telefone: " + u.getTelefone());
        if (u.getFotoPerfil() != null) {
            image = new Image("/mybook/imagens/" + u.getFotoPerfil() + ".jpg");
            fotoPefil.setImage(image);
        }
    }

    public void setAmigo(Usuario amigo) {
        this.amigo = amigo;
    }

}
