/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybook.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mybook.controller.Controller;

public class MyBook extends Application {

    static Controller controller = new Controller();

    @Override
    public void start(Stage stage) throws Exception {
        Parent entrar = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Scene scene = new Scene(entrar);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Login");

    }

    /**
     * Retorna o controller que será utilizado durante a execução do programa
     *
     * @return controller criado
     */
    static public Controller getController() {
        return MyBook.controller;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
