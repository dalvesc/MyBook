package mybook.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mybook.model.Usuario;
import mybook.util.Graph;
import mybook.exception.*;

public class Controller {

    //falta colocar para ler os arquivos com os usuários já cadastrados
    //aumentar as telas e colocar outras anchorpanes
    private Graph grafo;
    private Iterator<Usuario> itr;

    public Controller() {
        grafo = new Graph();
    }

    public Usuario cadastrarUsuario(String password, String nome, String email, String nascimento,
            String cidade, String telefone, String fotoPerfil) throws CadastroInvalido {

        Usuario u = new Usuario(password, nome, email, nascimento, cidade, telefone, fotoPerfil);

        if (grafo.addVertex(u)) {
            return u;
        }

        throw new CadastroInvalido(email);
    }

    public boolean removerConta(String email) {
        itr = grafo.itrVertices();

        while (itr.hasNext()) {
            Usuario aux = itr.next();
            if (email.equals(aux.getEmail())) {
                return grafo.removeVertex(aux);
            }
        }
        return false;
    }

    public void fazerAmizade(String u1, String u2) {
        grafo.addEdge(u1, u2);
    }

    public void removerAmizade(Usuario u1, Usuario u2) {
        grafo.removeEdge(u1, u2);
    }

    public Usuario fazerLogin(String email, String senha) throws LoginInvalido {
        itr = grafo.itrVertices();

        while (itr.hasNext()) {
            Usuario u = itr.next();
            if (u.getEmail().equals(email) && u.getPassword().equals(senha)) {
                return u;
            }
        }
        throw new LoginInvalido();
    }

    //depois apagar
    public void imprimi() {
        itr = grafo.itrVertices();

        while (itr.hasNext()) {
            Usuario u = itr.next();
            System.out.println(u);
        }
    }
}
