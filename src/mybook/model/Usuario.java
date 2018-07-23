package mybook.model;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    private String password, nome, email, nascimento, cidade, telefone, endereco;
    private List<String> postagens; 
    private List<File> arquivos;
    //foto - ???
    //amigos - arestas
    //postagens - lista?
    //arquivos - lista?

    public Usuario(String password, String nome, String email, String nascimento, 
                   String cidade, String telefone, String endereco) {
        
        this.password = password;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.endereco = endereco;
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
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<String> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<String> postagens) {
        this.postagens = postagens;
    }

    public List<File> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<File> arquivos) {
        this.arquivos = arquivos;
    }

}
