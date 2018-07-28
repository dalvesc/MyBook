package mybook.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import mybook.facade.*;
import mybook.model.*;
import mybook.view.*;

public class ControllerArquivo {

    /**
     * Ler o arquivo de texto com os usuários salvos e salva eles no programa
     * para poderem ser utilizados
     *
     * @return lista com os usuários cadastrados anteriormente
     */
    public List<Usuario> usuariosCadastrados() {
        Facade facade = MyBook.getFacade();
        List<Usuario> list = new LinkedList();
        String password, nome, email, nascimento, cidade, telefone, fotoPerfil;
        try {
            File arq = new File("usuariosCadastrados.txt");

            Scanner scan = new Scanner(new FileReader(arq)).useDelimiter(" |\n");
            while (scan.hasNext()) {
                password = scan.next();
                nome = scan.next();
                email = scan.next();
                nascimento = scan.next();
                cidade = scan.next();
                telefone = scan.next();
                fotoPerfil = scan.next();
                Usuario u = new Usuario(password, nome, email, nascimento, cidade, telefone);
                u.setFotoPerfil(fotoPerfil);
                //facade.carregarUsuarios(u);
                list.add(u);

            }
            scan.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       // facade.carregarUsuarios(list);
        return list;
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
