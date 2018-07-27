package mybook.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
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

//não sei se funciona
public class ArquivosController implements Initializable {

    private Usuario u;
    
    @FXML
    private Button voltar;

    @FXML
    private ListView<String> arquivos;
    
    ArquivosController(Usuario u){
        this.u = u;
    }

    Controller controller = MyBook.getController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PassarTela tela = new PassarTela();
        voltar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                tela.telaInicial(u);
                voltar.getScene().getWindow().hide();
            }
        });

        ObservableList<String> data = FXCollections.observableArrayList();

        for (File file : u.getArquivos()) {
            data.add(file.getName());
        }

        arquivos.setItems(data);
    }
}
