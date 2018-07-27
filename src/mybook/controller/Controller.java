package mybook.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mybook.model.Usuario;
import mybook.util.Graph;
import mybook.exception.*;

/**
 * Classe que controla as interações entre a View e o restante do sistema.
 *
 */
public class Controller {

    //falta colocar para ler os arquivos com os usuários já cadastrados
    //metodo para buscar pessoas, para abrir tela de uma pessoa especifica
    //pensando em criar classe para as publicações
    //metodo para adicionar um cometario
    private Graph grafo;
    private Iterator<Usuario> itr;
    private Usuario conta;

    /**
     * Construtor da classe
     */
    public Controller() {
        grafo = new Graph();
    }

    /**
     *
     * @return grafo em que os dados são armazenados
     */
    public Graph getGrafo() {
        return this.grafo;
    }

    /**
     * Cadastra um usuário no programa
     *
     * @param password senha do usuário
     * @param nome nome do usuário
     * @param email email do usuário
     * @param nascimento data de nascimento do usuário
     * @param cidade cidade do usuário
     * @param telefone telefone do usuário
     * @param fotoPerfil foto do usuário
     * @return usuário que foi cadastrado
     * @throws CadastroInvalido caso o email já tenha sido cadastrado
     */
    public Usuario cadastrarUsuario(String password, String nome, String email, String nascimento,
            String cidade, String telefone, String fotoPerfil) throws CadastroInvalido {

        Usuario u = new Usuario(password, nome, email, nascimento, cidade, telefone, fotoPerfil);
        if (grafo.addVertex(u)) {
            return u;
        }

        throw new CadastroInvalido(email);
    }

    /**
     * Remove uma conta do programa
     *
     * @param email email do usuário que irá ser removido
     * @return true caso o usuário tenha sido removido e false caso não
     */
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

    /**
     * Cria uma relação de amizade(aresta) entre dois usuários
     *
     * @param u1 usuário 1
     * @param u2 usuário 2
     */
    public void fazerAmizade(Usuario u1, Usuario u2) {
        grafo.addEdge(u1, u2);
    }

    /**
     * Remove uma relação de amizade(aresta) entre dois usuários
     *
     * @param u1 usuário 1
     * @param u2 usuário 2
     */
    public void removerAmizade(Usuario u1, Usuario u2) {
        grafo.removeEdge(u1, u2);
    }

    /**
     * Faz o login do usuário no progrma
     *
     * @param email email de usuário
     * @param senha senha do usuário
     * @return usuário que está fazendo login
     * @throws LoginInvalido caso o email ou a senha do usuário esteja incorreta
     */
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
    
    public void setConta(Usuario u){
        this.conta = u;
    }
    
    public Usuario getConta(){
        return this.conta;
    }
}
