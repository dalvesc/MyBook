package mybook.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mybook.model.*;
import mybook.util.*;
import mybook.exception.*;

/**
 * Classe que controla as interações entre a View e o restante do sistema.
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class Controller {

    private Graph grafo;
    private Iterator<Usuario> itr;
    private Usuario userLogado;
    private Usuario u;

    /**
     * Construtor da classe
     */
    public Controller() {

        grafo = new Graph();
    }

    /**
     *
     * @return usuário que está logado no programa
     */
    public Usuario getUserLogado() {
        return this.userLogado;
    }

    /**
     * Cadastra um usuário no programa.
     *
     * @param password senha do usuário
     * @param nome nome do usuário
     * @param email email do usuário
     * @param nascimento data de nascimento do usuário
     * @param cidade cidade do usuário
     * @param telefone telefone do usuário
     * @param fotoPerfil foto do usuário
     * @return usuário que foi cadastrado
     * @throws CadastroInvalido caso o email já tenha sido cadastrado.
     */
    public Usuario cadastrarUsuario(String password, String nome, String email, String nascimento,
            String cidade, String telefone, String fotoPerfil) throws CadastroInvalido {
        Usuario aux = new Usuario(password, nome, email, nascimento, cidade, telefone, fotoPerfil);

        if (grafo.addVertex(aux)) {
            return aux;
        }

        throw new CadastroInvalido(email);
    }

    /**
     * Remove uma conta do programa
     *
     * @return "true" caso o usuário tenha sido removido e "false" caso não.
     */
    public boolean removerConta() {
        return grafo.removeVertex(userLogado);
    }

    /**
     * Cria uma relação de amizade(aresta) entre dois usuários.
     *
     * @param outroUser
     * @return "true" se a operação for bem sucedida e "false" se não.
     */
    public boolean fazerAmizade(String outroUser) {
        itr = grafo.itrVertices();
        while (itr.hasNext()) {
            Usuario aux = itr.next();
            if (outroUser.equals(aux.getNome())) {
                return grafo.addEdge(userLogado, aux);
            }
        }
        return false;
    }

    /**
     * Remove uma relação de amizade(aresta) entre dois usuários.
     *
     * @param outroUser
     * @return "true" se a operação for bem sucedida e "false" se não.
     */
    public boolean removerAmizade(String outroUser) {
        itr = grafo.itrVertices();
        while (itr.hasNext()) {
            Usuario aux = itr.next();
            if (outroUser.equals(aux.getNome())) {
                return grafo.removeEdge(userLogado, aux);
            }
        }
        return false;
    }

    /**
     * Faz o login do usuário no programa
     *
     * @param email email de usuário
     * @param senha senha do usuário
     * @return usuário que está fazendo login
     * @throws LoginInvalido caso o email ou a senha do usuário esteja incorreta
     */
    public boolean fazerLogin(String email, String senha) throws LoginInvalido {
        itr = grafo.itrVertices();

        while (itr.hasNext()) {
            Usuario aux = itr.next();
            if (aux.getEmail().equals(email) && aux.getPassword().equals(senha)) {
                userLogado = aux;
                setU(aux);
                return true;
            }
        }
        throw new LoginInvalido();
    }

    /**
     * Faz uma busca por usuários pelo nome.
     *
     * @param nomeUser nome a ser buscado.
     * @return lista com todos os usuarios que possuem esse nome.
     * @throws mybook.exception.SemResultados caso não existam resultados para a
     * busca.
     */
    public List<Usuario> buscarUsuario(String nomeUser) throws SemResultados {

        List<Usuario> usuariosBuscados = new LinkedList();

        itr = grafo.itrVertices();

        while (itr.hasNext()) {
            Usuario aux = itr.next();
            if (aux.getNome().equalsIgnoreCase(nomeUser)) {
                usuariosBuscados.add(aux);
            }
        }

        if (!usuariosBuscados.isEmpty()) {
            return usuariosBuscados;
        }
        throw new SemResultados(nomeUser);
    }

    /**
     * Adiciona à lista de postagens do usuário uma nova postagem.
     *
     * @param u usuário que está recendo a postagem
     * @param mensagem mensagem a ser postada.
     * @return "true" se a operação for bem sucedida e "false" se não.
     * @throws mybook.exception.SemPublicacoes caso o usuário não tenha
     * publicações
     */
    public boolean fazerPostagem(Usuario u, String mensagem) throws SemPublicacoes {
        return u.getPostagens().add(mensagem);
    }

    /**
     * Adiciona à lista de arquivos do usuário um novo arquivo.
     *
     * @param caminhoArquivo caminho do arquivo.
     * @return "true" se a operação for bem sucedida e "false" se não.
     * @throws mybook.exception.SemArquivos caso o usuário não tenha arquivos
     * @throws java.io.FileNotFoundException caso o arquivo não tenha sido
     * encontrado
     */
    public boolean uploadArquivo(String caminhoArquivo) throws SemArquivos, FileNotFoundException {
        return userLogado.getArquivos().add(new File(caminhoArquivo));
    }

    /**
     * Retorna as amizades que o usuário possui
     *
     * @param u usuário que será verificado.
     * @return lista com os amigos.
     * @throws mybook.exception.SemAmigos caso o usuário não tenha amigos
     */
    public List<Usuario> amizades(Usuario u) throws SemAmigos {
        List<Usuario> list = new LinkedList();
        itr = grafo.itrAdjacencies(u);

        while (itr.hasNext()) {
            list.add(itr.next());
        }
        if (!list.isEmpty()) {
            return list;
        }
        throw new SemAmigos();
    }

    /**
     *
     * @param u iguala a variável para poder utiliza-la posteriomente
     */
    public void setU(Usuario u) {
        this.u = u;
    }

    /**
     *
     * @return variável com os dados do usuário que sendo pedido
     */
    public Usuario getU() {
        return this.u;
    }

    /**
     *
     * @return grafo criado
     */
    public Graph getGrafo() {
        return grafo;
    }

    /**
     *
     * @param grafo iguala o grafo para utilizar os dados já lidos
     */
    public void setGrafo(Graph grafo) {
        this.grafo = grafo;
    }

}
