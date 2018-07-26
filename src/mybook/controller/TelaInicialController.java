package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TelaInicialController implements Initializable {

    @FXML
    private Button arquivos;//ir para tela de arquivos

    @FXML
    private TableView<?> publicacoes;

    @FXML
    private Button perfil;//ir para tela de perfil

    @FXML
    private TextField buscar;//botão?

    @FXML
    private Button sair;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PassarTela tela = new PassarTela();

        sair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.login();
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
            }
        });
    }
}
