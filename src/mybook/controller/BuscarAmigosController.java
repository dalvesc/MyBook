package mybook.controller;

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
import mybook.model.*;
import mybook.view.*;

public class BuscarAmigosController implements Initializable {

    List<Usuario> list = new LinkedList();

    @FXML
    private Button voltar;

    @FXML
    private ListView<Usuario> buscados;

    @FXML
    private TextField busca;

    @FXML
    private Button buscar;

    @FXML
    private Label semResultados;

    @FXML
    private Label selecionar;

    @FXML
    private Button adicionar;

    Controller controller = MyBook.getController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PassarTela tela = new PassarTela();

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.telaInicial(controller.getUserLogado());
                voltar.getScene().getWindow().hide();
            }
        });

        ObservableList<Usuario> data = FXCollections.observableArrayList();

        buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    list = controller.buscarUsuario(busca.getText());
                    selecionar.setText("Selecione o usuário que deseja adicionar");
                    for (Usuario usu : list) {
                        data.add(usu);
                    }

                    buscados.setItems(data);
                    Usuario amigo = buscados.getSelectionModel().getSelectedItem();
                    adicionar.setVisible(true);
                    adicionar.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            controller.fazerAmizade(amigo.getNome());
                        }
                    });
                } catch (SemResultados ex) {
                    semResultados.setText("Sem resultados");
                    Logger.getLogger(BuscarAmigosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
