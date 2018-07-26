package mybook.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PassarTela {

    public void login() {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/Login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Login");
    }

    public void cadastro() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/Cadastro.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Cadastro");
    }

    public void telaInicial() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/TelaInicial.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Tela Inicial");
    }

    public void perfil() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/Pefil.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Perfil");
    }

    public void arquivos() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/Arquivos.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Arquivos");
    }

    public void buscas() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/Busca.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Busca");
    }
}
