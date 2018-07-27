package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mybook.view.MyBook;

public class AdicionarPublicacaoController implements Initializable {

    @FXML
    private Button voltar;

    @FXML
    private TextField mensagem;

    @FXML
    private Button adicionar;

    Controller controller = MyBook.getController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PassarTela tela = new PassarTela();

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.telaInicial();
                voltar.getScene().getWindow().hide();
            }
        });

        adicionar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.telaInicial();
                adicionar.getScene().getWindow().hide();
            }
        });
    }

}
