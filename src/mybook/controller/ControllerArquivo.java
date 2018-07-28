package mybook.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import mybook.facade.Facade;
import mybook.model.*;
import mybook.view.*;

public class ControllerArquivo {

    /**
     * Ler o arquivo de texto com os usuários salvos e salva eles no programa
     * para poderem ser utilizados
     *
     */
    public void usuariosCadastrados() {
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
                
                facade.carregarUsuarios(password, nome, email, nascimento, cidade, telefone, fotoPerfil);
            }
            scan.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Escreve no arquivo de texto um novo usuário
     *
     * @param usuario - novo usuário
     */
    public void cadastrarUsuario(Usuario usuario) {
        try {
            FileWriter arquivo = new FileWriter("usuariosCadastrados.txt", true);
            BufferedWriter buffer = new BufferedWriter(arquivo);
            PrintWriter escritor = new PrintWriter(arquivo);

            escritor.println(usuario.getPassword() + " " + usuario.getNome()
                    + " " + usuario.getEmail() + " " + usuario.getNascimento()
                    + " " + usuario.getCidade() + " " + usuario.getTelefone()
                    + " " + usuario.getFotoPerfil());

            escritor.flush();
            escritor.close();
            arquivo.close();

        } catch (Exception e) {
            System.out.println("Erro ao escrever arquivo!");
        }
    }
}
