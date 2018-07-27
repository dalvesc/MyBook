package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import mybook.model.Usuario;
import mybook.view.MyBook;

public class BuscarAmigosController implements Initializable {

    @FXML
    private Button voltar;

    @FXML
    private ListView<Usuario> buscados;

    @FXML
    private TextField busca;

    @FXML
    private Button buscar;

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

        buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //controller.buscar(busca.getText());
            }
        });
    }
}
