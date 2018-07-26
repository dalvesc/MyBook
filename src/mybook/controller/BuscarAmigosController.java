package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import mybook.view.MyBook;

public class  BuscarAmigosController implements Initializable {

    @FXML
    private Button voltar;

    @FXML
    private TableView<?> tabelaBuscados;

    @FXML
    private TableColumn<?, ?> buscados;

    @FXML
    private TextField busca;

    
    Controller controller = MyBook.getController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PassarTela tela = new PassarTela();
        
        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tela.telaInicial();
            }
        });
    }
}
