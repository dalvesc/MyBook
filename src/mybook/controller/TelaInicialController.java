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
import mybook.exception.*;
import mybook.facade.*;
import mybook.model.*;
import mybook.view.*;

public class TelaInicialController implements Initializable {

    static private Usuario u;
    @FXML
    private Button arquivos;

    @FXML
    private ListView<String> publicacoes;

    @FXML
    private Button perfil;

    @FXML
    private Button buscar;

    @FXML
    private Button sair;

    @FXML
    private Button adicionarPublicacao;

    @FXML
    private Button voltarAmigo;

    Facade facade = MyBook.getFacade();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PassarTela tela = new PassarTela();
        u = facade.getU();
        System.out.println(u);
        sair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.login();
                sair.getScene().getWindow().hide();
            }
        });

        arquivos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.arquivos();
                arquivos.getScene().getWindow().hide();
            }
        });

        perfil.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.perfil();
                perfil.getScene().getWindow().hide();
            }
        });

        buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.buscas();
                buscar.getScene().getWindow().hide();
            }
        });

        adicionarPublicacao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.adicionarPublicacao();
                adicionarPublicacao.getScene().getWindow().hide();
            }
        });

        if (!u.equals(facade.getUserLogado())) {
            voltarAmigo.setVisible(true);
            voltarAmigo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    facade.setU(facade.getUserLogado());
                    tela.telaInicial();
                }
            });
        }

        ObservableList<String> data = FXCollections.observableArrayList();

        try {
            for (String usu : u.getPostagens()) {
                data.add(usu);
            }
            publicacoes.setItems(data);
        } catch (SemPublicacoes ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
