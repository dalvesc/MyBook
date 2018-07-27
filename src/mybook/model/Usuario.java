package mybook.model;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Usuário que será criado para salvar os dados no programa
 *
 */
public class Usuario {

    private String password, nome, email, nascimento, cidade, telefone;
    private List<String> postagens;
    private List<File> arquivos;
    private String fotoPerfil;

    /**
     * Construtor da classe
     *
     * @param password senha do usuário
     * @param nome nome do usuário
     * @param email email do usuário
     * @param nascimento data de nascimento do usuário
     * @param cidade cidade do usuário
     * @param telefone telefone do usuário
     * @param fotoPerfil foto do usuário
     */
    public Usuario(String password, String nome, String email, String nascimento,
            String cidade, String telefone, String fotoPerfil) {

        this.password = password;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.fotoPerfil = fotoPerfil;
        postagens = new LinkedList();
        arquivos = new LinkedList();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return senha do usuário
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     *
     * @return
     */
    public String getCidade() {
        return cidade;
    }

    /**
     *
     * @return
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @return
     */
    public List<String> getPostagens() {
        return postagens;
    }

    /**
     *
     * @param postagens
     */
    public void setPostagens(List<String> postagens) {
        this.postagens = postagens;
    }

    /**
     *
     * @return
     */
    public List<File> getArquivos() {
        return arquivos;
    }

    /**
     *
     * @param arquivos
     */
    public void setArquivos(List<File> arquivos) {
        this.arquivos = arquivos;
    }

    /**
     *
     * @return
     */
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    /**
     *
     * @param fotoPerfil
     */
    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome = " + nome + ", email = " + email + '}';
    }

}
