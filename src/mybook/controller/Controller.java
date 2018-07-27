package mybook.controller;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
    //lista de amigos no perfil
    //adicionar amigo - criar tela???
    private Graph grafo;
    private Iterator<Usuario> itr;
    private Usuario userLogado;

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

        Usuario u = new Usuario(password, nome, email, nascimento, cidade, telefone, fotoPerfil);

        if (grafo.addVertex(u)) {
            return u;
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
            Usuario u = itr.next();
            if (u.getEmail().equals(email) && u.getPassword().equals(senha)) {
                userLogado = u;
                return true;
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
            Usuario u = itr.next();
            if (u.getNome().equals(nomeUser)) {
                usuariosBuscados.add(u);
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
     * @param mensagem mensagem a ser postada.
     * @return "true" se a operação for bem sucedida e "false" se não.
     */
    public boolean fazerPostagem(String mensagem) {
        return userLogado.getPostagens().add(mensagem);
    }

    /**
     * Adiciona à lista de arquivos do usuário um novo arquivo.
     *
     * @param caminhoArquivo caminho do arquivo.
     * @return "true" se a operação for bem sucedida e "false" se não.
     */
    public boolean uploadArquivo(String caminhoArquivo) {
        return userLogado.getArquivos().add(new File(caminhoArquivo));
    }

    /**
     * Retorna as amizades que o usuário tem
     *
     * @param u usuário que será verificado.
     * @return lista com os amigos.
     */
    public List<Usuario> amizades(Usuario u) {
        List<Usuario> list = new LinkedList();
        itr = grafo.itrAdjacencies(u);

        while (itr.hasNext()) {
            list.add(itr.next());
        }
        return list;
    }

    public Usuario obterUsuario(String email) {

        itr = grafo.itrVertices();

        Usuario aux = new Usuario("xx", "xx", email, "xx", "xx", "xx", "xx");

        return (Usuario) grafo.getVertex(aux);
    }//para pegar o usuário que foi selecionado (estudar sobre o metodo encontrado)
}
