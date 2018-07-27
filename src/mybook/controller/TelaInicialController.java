package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import mybook.view.MyBook;

public class TelaInicialController implements Initializable {

    @FXML
    private Button arquivos;

    @FXML
    private ListView<?> publicacoes;

    @FXML
    private Button perfil;

    @FXML
    private Button buscar;

    @FXML
    private Button sair;

    @FXML
    private Button adicionarPublicacao;

    Controller controller = MyBook.getController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PassarTela tela = new PassarTela();

        sair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.login();
                controller.setConta(null);
                sair.getScene().getWindow().hide();
            }
        });

        arquivos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.arquivos();
            }
        });

        perfil.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.perfil();
            }
        });

        buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.perfil();
                buscar.getScene().getWindow().hide();
            }
        });

        adicionarPublicacao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.adicionarPublicacao();
            }
        });
    }
}
