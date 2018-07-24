package mybook.controller;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import mybook.model.Usuario;
import mybook.util.Graph;
import mybook.util.IGraph;

/**
 * Classe que controla as interações entre a View e o restante do sistema.
 */
public class Controller {

    IGraph grafo;

    /**
     * Contrutor da classe
     */
    public Controller() {
        grafo = new Graph();
    }

    /**
     * Adiciona usuário no grafo
     *
     * @param usuario usuário que irá ser cadastrado
     * @return true caso o usuário tenha sido cadastrado
     */
    public boolean adicionarUsuario(Object usuario) {
        return grafo.addVertex(usuario);
    }

    /**
     * Adiciona ligações de amizade entre os usuários
     *
     * @param u1 usuário 1
     * @param u2 usuário 2
     * @return true caso tenha sido criado a relação
     */
    public boolean adicionarAmigo(Object u1, Object u2) {
        return grafo.addEdge(u1, u2);
    }

    /**
     * Remover relação de amizade
     *
     * @param u1 usuário 1
     * @param u2 usuário 2
     * @return true caso tenha sido removida a relação
     */
    public boolean removerAmigo(Object u1, Object u2) {
        return grafo.removeEdge(u1, u2);
    }

    /**
     * Ler o arquivo de texto com os usuários salvos e salva eles no programa
     * para poderem ser utilizados
     *
     */
    public void reader() {
        Usuario usuario;

        try {
            File arq = new File("usuáriosCadastrados.txt");
            String password, nome, email, nascimento, cidade, telefone, endereco;
            List<String> postagens;
            List<File> arquivos;

            Scanner scan = new Scanner(new FileReader(arq)).useDelimiter(" |\n");

            while (scan.hasNext()) {
                nome = scan.next();
                email = scan.next();
                password = scan.next();
                nascimento = scan.next();
                cidade = scan.next();
                telefone = scan.next();
                endereco = scan.next();

                usuario = new Usuario(nome, email, password, nascimento,
                        cidade, telefone, endereco);
                //falta postagens e arquivos
                adicionarUsuario(usuario);
            }
            scan.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
