package mybook.facade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import mybook.controller.*;
import mybook.exception.*;
import mybook.model.*;
import mybook.util.*;
import mybook.alimentasistema.*;

/**
 * Classe para chamar os métodos do controlador.
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class Facade {

    private Controller ctrl;
    private ControllerSerializar ctrlSerial;
    public Graph grafo;

    public Facade() throws IOException, FileNotFoundException, ClassNotFoundException, CadastroInvalido, LoginInvalido {
        ctrl = new Controller();
        grafo = ctrl.getGrafo();
        ctrlSerial = new ControllerSerializar(grafo);
        ctrl.setGrafo(ctrlSerial.recuperar());
        AlimentaSistema as = new AlimentaSistema(ctrl);
    }

    public Usuario cadastrarUsuario(String password, String nome, String email, String nascimento,
            String cidade, String telefone, String fotoPerfil) throws CadastroInvalido, IOException {

        Usuario u = ctrl.cadastrarUsuario(password, nome, email, nascimento, cidade, telefone, fotoPerfil);
        grafo = ctrl.getGrafo();
        ctrlSerial.gravar(grafo);
        return u;
    }

    public Usuario getUserLogado() {
        return ctrl.getUserLogado();
    }

    public boolean removerConta() throws IOException {
        boolean r = ctrl.removerConta();
        ctrlSerial.gravar(grafo);
        return r;
    }

    public boolean fazerAmizade(String outroUser) throws IOException {
        boolean r = ctrl.fazerAmizade(outroUser);
        ctrlSerial.gravar(grafo);
        return r;
    }

    public boolean removerAmizade(String outroUser) throws IOException {
        boolean r = ctrl.removerAmizade(outroUser);
        ctrlSerial.gravar(grafo);
        return r;
    }

    public boolean fazerLogin(String email, String senha) throws LoginInvalido {
        return ctrl.fazerLogin(email, senha);
    }

    public List<Usuario> buscarUsuario(String nome) throws SemResultados {
        return ctrl.buscarUsuario(nome);
    }

    public boolean fazerPostagem(Usuario u, String mensagem) throws SemPublicacoes, IOException {
        boolean r = ctrl.fazerPostagem(u, mensagem);
        ctrlSerial.gravar(grafo);
        return r;
    }

    public boolean uploadArquivo(String caminhoArquivo) throws SemArquivos, FileNotFoundException, IOException {
        boolean r = ctrl.uploadArquivo(caminhoArquivo);
        ctrlSerial.gravar(grafo);
        return r;
    }

    public List<Usuario> amizades(Usuario usuario) throws SemAmigos {
        return ctrl.amizades(usuario);
    }

    public void setU(Usuario usuario) {
        ctrl.setU(usuario);
    }

    public Usuario getU() {
        return ctrl.getU();
    }
}
