package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class PerfilController implements Initializable {

    @FXML
    private Button voltar;

    @FXML
    private ImageView fotoPefil;

    @FXML
    private Text nome;

    @FXML
    private Text email;

    @FXML
    private Text nascimento;

    @FXML
    private Text cidade;

    @FXML
    private Text telefone;

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
