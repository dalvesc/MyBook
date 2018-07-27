package mybook.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mybook.model.*;

/**
 * Metódos que irão servir para passar de uma tela para outra da interface
 *
 */
public class PassarTela {

    /**
     * Passa para a tela de login
     */
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

    /**
     * Passa para a tela de cadastro
     */
    public void cadastro() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/Inicio.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Cadastro");
    }

    /**
     * Passa para a tela inicial
     */
    public void telaInicial(Usuario u) {
        TelaInicialController cons = new TelaInicialController(u);
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/Inicio.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Tela Inicial");

    }

    /**
     * Passa para a tela de perfil
     */
    public void perfil(Usuario u) {
        PerfilController cons = new PerfilController(u);

        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/Perfil.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Perfil");
    }

    /**
     * Passa para a tela de arquivos
     */
    public void arquivos(Usuario u) {
        ArquivosController cons = new ArquivosController(u);

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

    /**
     * Passa para a tela de buscas
     */
    public void buscas() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/BuscarAmigos.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Busca");
    }

    /**
     * Passa para a tela de adicionar uma publicação
     */
    public void adicionarPublicacao(Usuario u) {
        AdicionarPublicacaoController cons = new AdicionarPublicacaoController(u);

        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/mybook/view/AdicionarPublicacao.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Adicionar Publicacao");
    }

}
