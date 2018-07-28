package mybook.facade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import mybook.controller.*;
import mybook.exception.*;
import mybook.model.Usuario;

/**
 * Classe para chamar os métodos do controlador.
 *
 */
public class Facade {

    private Controller ctrl;

    public Facade() {
        ctrl = new Controller();
    }

    public Usuario cadastrarUsuario(String password, String nome, String email, String nascimento,
            String cidade, String telefone, String endereco) throws CadastroInvalido, IOException {

        return ctrl.cadastrarUsuario(password, nome, email, nascimento, cidade, telefone, endereco);
    }

    public Usuario getUserLogado() {
        return ctrl.getUserLogado();
    }

    public boolean removerConta() throws IOException {
        return ctrl.removerConta();
    }

    public boolean fazerAmizade(String outroUser) {
        return ctrl.fazerAmizade(outroUser);
    }

    public boolean removerAmizade(String outroUser) {
        return ctrl.removerAmizade(outroUser);
    }

    public boolean fazerLogin(String email, String senha) throws LoginInvalido {
        return ctrl.fazerLogin(email, senha);
    }

    public List<Usuario> buscarUsuario(String nome) throws SemResultados {
        return ctrl.buscarUsuario(nome);
    }

    public boolean fazerPostagem(Usuario u, String mensagem) throws SemPublicacoes {
        return ctrl.fazerPostagem(u, mensagem);
    }

    public boolean uploadArquivo(String caminhoArquivo) throws SemArquivos, FileNotFoundException {
        return ctrl.uploadArquivo(caminhoArquivo);
    }

    public Usuario obterUsuario(String email) {
        return ctrl.obterUsuario(email);
    }

    public List<Usuario> amizades(Usuario usuario) throws SemAmigos {
        return ctrl.amizades(usuario);
    }

    public void setU(Usuario usuario) {
    }

    public Usuario getU() {
        return ctrl.getU();
    }
}
