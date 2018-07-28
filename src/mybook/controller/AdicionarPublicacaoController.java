package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mybook.exception.*;
import mybook.facade.*;
import mybook.model.*;
import mybook.view.*;

public class AdicionarPublicacaoController implements Initializable {

    private Usuario u;

    @FXML
    private Button voltar;

    @FXML
    private TextField mensagem;

    @FXML
    private Button adicionar;

    Facade facade = MyBook.getFacade();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        u = facade.getU();
        PassarTela tela = new PassarTela();

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                facade.setU(u);
                tela.telaInicial();
                voltar.getScene().getWindow().hide();
            }
        });

        adicionar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    facade.fazerPostagem(u, mensagem.getText());
                } catch (SemPublicacoes ex) {
                    Logger.getLogger(AdicionarPublicacaoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tela.telaInicial();
                adicionar.getScene().getWindow().hide();
            }
        });
    }

}
