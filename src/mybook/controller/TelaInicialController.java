package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import mybook.model.Usuario;
import mybook.view.MyBook;

public class TelaInicialController implements Initializable {

    private Usuario u;
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
    
    TelaInicialController(Usuario u){
        this.u = u;
    }

//    TelaInicialController(Usuario u, int i){
//        this.u = u;
//    }
    
    Controller controller = MyBook.getController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PassarTela tela = new PassarTela();

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
                tela.arquivos(u);
            }
        });

        perfil.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.perfil(u);
            }
        });

        buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //tela.perfil(u);
                buscar.getScene().getWindow().hide();
            }
        });

        adicionarPublicacao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.adicionarPublicacao(u);
            }
        });
        
        ObservableList<String> data = FXCollections.observableArrayList();
        
        for (String usu : u.getPostagens()) {
            data.add(usu);
        }
        
        publicacoes.setItems(data);
    }
}
