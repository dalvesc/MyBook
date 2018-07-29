package mybook.controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
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
import mybook.exception.SemResultados;
import mybook.facade.*;
import mybook.model.*;
import mybook.view.*;

public class BuscarAmigosController implements Initializable {

    List<Usuario> list = new LinkedList();
    private Usuario amigo;
    @FXML
    private Button voltar;

    @FXML
    private ListView<Usuario> buscados;

    @FXML
    private TextField busca;

    @FXML
    private Button buscar;

    @FXML
    private Label selecionar;

    @FXML
    private Button adicionar;

    Facade facade = MyBook.getFacade();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PassarTela tela = new PassarTela();

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                facade.setU(facade.getUserLogado());
                tela.telaInicial();
                voltar.getScene().getWindow().hide();
            }
        });

        ObservableList<Usuario> data = FXCollections.observableArrayList();

        buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    list = facade.buscarUsuario(busca.getText());
                    selecionar.setText("Selecione o usuário que deseja adicionar");
                    for (Usuario usu : list) {
                        data.add(usu);
                    }

                    buscados.setItems(data);
                    buscados.getSelectionModel().selectedItemProperty().addListener(
                            (observable, oldValue, newValue) -> setAmigo(newValue));
                    adicionar.setVisible(true);
                    adicionar.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                if (facade.fazerAmizade(amigo.getNome())) {
                                    selecionar.setText("Adicionado");
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(BuscarAmigosController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                } catch (SemResultados ex) {
                    selecionar.setText("Sem resultados");
                    Logger.getLogger(BuscarAmigosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void setAmigo(Usuario amigo) {
        this.amigo = amigo;
    }
}
