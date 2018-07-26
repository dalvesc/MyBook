package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class ArquivosController implements Initializable{

    @FXML
    private Button voltar;

    @FXML
    private TableColumn<?, ?> arquivos;
    
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

