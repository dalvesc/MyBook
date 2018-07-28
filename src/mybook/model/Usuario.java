package mybook.model;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import mybook.exception.*;

/**
 * Usuário que será criado para salvar os dados no programa
 *
 * @author Daniel Alves e Gabriela dos Santos
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
     * @return nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return email do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return data de nascimento do usuário
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     *
     * @return cidade do usuário
     */
    public String getCidade() {
        return cidade;
    }

    /**
     *
     * @return telefone do usuário
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @return lista com as postagens do usuário
     * @throws mybook.exception.SemPublicacoes Caso o usuário não tenha
     * publicações
     */
    public List<String> getPostagens() throws SemPublicacoes {
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
     * @return lista com os arquivos do usuário
     * @throws mybook.exception.SemArquivos Caso o usuário não tenha arquivos
     */
    public List<File> getArquivos() throws SemArquivos {
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
     * @return endereço da foto do usuário
     */
    public String getFotoPerfil() {
        return this.fotoPerfil;
    }

    @Override
    public String toString() {
        return nome;
    }

}
