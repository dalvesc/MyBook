package mybook.facade;

import java.io.IOException;
import mybook.controller.*;
import mybook.exception.CadastroInvalido;
import mybook.model.Usuario;

/**
 *
 * @author gabriela
 */
public class Facade {
    ControllerUsuario ctrlUsuario;
    ControllerArquivo ctrlArquivo;
    
    public Facade(){
        ctrlUsuario = new ControllerUsuario();
        ctrlArquivo = new ControllerArquivo();        
    }
    
    
    public Usuario cadastrarUsuario(String password, String nome, String email, String nascimento, 
                   String cidade, String telefone, String endereco) throws CadastroInvalido, IOException{
        
        Usuario u = ctrlUsuario.cadastrarUsuario(password, nome, email, nascimento, cidade, telefone, endereco); 
        ctrlArquivo.gravarUsuario(u);
        return u;
    }
    
    public boolean removerConta(String email) throws IOException{
        
             
        ctrlUsuario.removerConta(email);
    }
    
    
    
}
