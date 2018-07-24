package mybook.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EntrarController implements Initializable {

    @FXML
    private Button button;

    @FXML
    private TextField usuario;

    @FXML
    private TextField password;

    @FXML
    private TextField nome;

    @FXML
    private TextField email;

    @FXML
    private TextField nascimento;

    @FXML
    private TextField cidade;

    @FXML
    private TextField telefone;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}