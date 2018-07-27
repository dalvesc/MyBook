package mybook.facade;

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
    
    public Facade(){
        ctrl = new Controller();               
    }    
    
    public Usuario cadastrarUsuario(String password, String nome, String email, String nascimento, 
                   String cidade, String telefone, String endereco) throws CadastroInvalido, IOException{
        
        return ctrl.cadastrarUsuario(password, nome, email, nascimento, cidade, telefone, endereco); 
    }
    
    public boolean removerConta() throws IOException{
        return ctrl.removerConta();
    }
    
    public boolean fazerAmizade(String outroUser){
        return ctrl.fazerAmizade(outroUser);
    }
    
    public boolean removerAmizade(String outroUser){
        return ctrl.removerAmizade(outroUser);
    }
    
    public boolean fazerLogin(String email, String senha) throws LoginInvalido{
        return ctrl.fazerLogin(email, senha);
    }
    
    public List buscarUsuario(String nome) throws SemResultados{
        return ctrl.buscarUsuario(nome);
    }
    
    public boolean fazerPostagem(String mensagem){
        return ctrl.fazerPostagem(mensagem);
    }
    
    public boolean uploadArquivo(String caminhoArquivo){
        return ctrl.uploadArquivo(caminhoArquivo);
    }
    
    public Usuario obterUsuario(String email){
        return ctrl.obterUsuario(email);
    }
    
}