package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mybook.model.Usuario;
import mybook.view.MyBook;

public class AdicionarPublicacaoController implements Initializable {

    private Usuario u;

    @FXML
    private Button voltar;

    @FXML
    private TextField mensagem;

    @FXML
    private Button adicionar;

    AdicionarPublicacaoController(Usuario u) {
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

        adicionar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.fazerPostagem(mensagem.getText());
            }
        });
    }

}
