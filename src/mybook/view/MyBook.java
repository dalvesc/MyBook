package mybook.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mybook.exception.*;
import mybook.facade.*;

/**
 * ************************************************************************
 *
 * Autor: Daniel Alves Costa e Gabriela dos Santos Costa Nunes
 *
 * Componente Curricular: Programação * Concluido em: 29/07/2018
 *
 * Declaro que este código foi elaborado por mim e minha dupla e não contém
 * nenhum trecho de código de outro colega ou de outro autor, tais como
 * provindos de livros e apostilas, e páginas ou documentos eletrônicos da
 * Internet. Qualquer trecho de código de outra autoria que não a minha está
 * destacado com uma citação para o autor e a fonte do código, e estou ciente
 * que estes trechos não serão considerados para fins de avaliação.
 *
 **************************************************************************
 */
public class MyBook extends Application {

    static Facade facade;

    @Override
    public void start(Stage stage) throws Exception {
        Parent entrar = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(entrar);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Login");
    }

    /**
     * Retorna o facade que será utilizado durante a execução do programa
     *
     * @return facade criado
     */
    static public Facade getFacade() {
        return MyBook.facade;
    }

    /**
     * Método principal do programa
     *
     * @author Daniel Alves e Gabriela dos Santos
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            facade = new Facade();
        } catch (IOException ex) {
            Logger.getLogger(MyBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CadastroInvalido ex) {
            Logger.getLogger(MyBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LoginInvalido ex) {
            Logger.getLogger(MyBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        launch(args);
    }

}
