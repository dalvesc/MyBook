package mybook.controller;

import java.io.File;
import java.io.FileNotFoundException;
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
import mybook.exception.SemArquivos;
import mybook.facade.*;
import mybook.model.*;
import mybook.view.*;

public class ArquivosController implements Initializable {

    private Usuario u;

    @FXML
    private Button voltar;

    @FXML
    private ListView<String> arquivos;

    @FXML
    private Button addArquivo;

    @FXML
    private TextField caminhoArquivo;

    @FXML
    private Label caminhoErrado;

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

        ObservableList<String> data = FXCollections.observableArrayList();

        try {
            for (File file : u.getArquivos()) {
                data.add(file.getName());
            }
            arquivos.setItems(data);
        } catch (SemArquivos ex) {
            Logger.getLogger(ArquivosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (u.equals(facade.getUserLogado())) {
            addArquivo.setVisible(true);
            caminhoArquivo.setVisible(true);
            addArquivo.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try {
                        facade.uploadArquivo(caminhoArquivo.getText());
                    } catch (SemArquivos ex) {
                        Logger.getLogger(ArquivosController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        caminhoErrado.setText("Caminho errado");
                        Logger.getLogger(ArquivosController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
    }
}
