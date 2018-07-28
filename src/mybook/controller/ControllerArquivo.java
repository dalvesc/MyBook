package mybook.controller;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import mybook.facade.Facade;
import mybook.model.*;
import mybook.view.*;

public class ControllerArquivo {

    public ControllerArquivo() {
        Usuario usuario;
        Facade facade = MyBook.getFacade();

        try {
            File arq = new File("usuariosCadastrados.txt");
            String password, nome, email, nascimento, cidade, telefone, fotoPerfil;

            Scanner scan = new Scanner(new FileReader(arq)).useDelimiter(" |\n");

            while (scan.hasNext()) {
                password = scan.next();
                nome = scan.next();
                email = scan.next();
                nascimento = scan.next();
                cidade = scan.next();
                telefone = scan.next();
                fotoPerfil = scan.next();
                System.out.println(fotoPerfil);
                usuario = facade.cadastrarUsuario(password, nome, email, nascimento, cidade, telefone);
                usuario.setFotoPerfil(fotoPerfil);

            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo!");
        }
    }

}
