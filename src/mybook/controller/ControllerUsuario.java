package mybook.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mybook.model.Usuario;
import mybook.util.Graph;
import mybook.exception.*;

public class ControllerUsuario {    
   
    private Graph grafo;
    private Iterator<Usuario> itr;
    private ControllerArquivo controllerArquivo;
    
    public ControllerUsuario(){        
        grafo = new Graph();
        controllerArquivo = new ControllerArquivo();
    }
    
    public Usuario cadastrarUsuario(String password, String nome, String email, String nascimento, 
                   String cidade, String telefone, String endereco) throws CadastroInvalido, IOException{
        
        Usuario u = new Usuario(password, nome, email, nascimento, cidade, telefone, endereco); 
        
        if(grafo.addVertex(u)){            
            return u;
        }
        
        throw new CadastroInvalido(email); 
    }
    
    public boolean removerConta(String email) throws IOException{
        itr = grafo.itrVertices();
        
        while(itr.hasNext()){
            Usuario aux = itr.next();
            if(aux.getEmail().equals(email)){                
                return grafo.removeVertex(aux);
            }
        }
        return false;
    }
    
    public boolean fazerAmizade(String u1, String u2) throws IOException{
        
        itr = grafo.itrVertices();
        Usuario aux2 = null, aux3 = null;
        
        while(itr.hasNext()){
            Usuario aux = itr.next();
            if(aux.getEmail().equals(u1)){
                aux2 = aux;
            }
            else if(aux.getEmail().equals(u2)){
                aux3 = aux;
            }        
        }      
        
        return grafo.addEdge(aux2, aux3);
    }
    
    public boolean removerAmizade(String u1, String u2) throws IOException{     
        
        itr = grafo.itrVertices();
        Usuario aux2 = null, aux3 = null;
        
        while(itr.hasNext()){
            Usuario aux = itr.next();
            if(aux.getEmail().equals(u1)){
                aux2 = aux;
            }
            else if(aux.getEmail().equals(u2)){
                aux3 = aux;
            }        
        }
            
        return grafo.removeEdge(aux2, aux3);
    }
    
    public Usuario fazerLogin(String email, String senha) throws LoginInvalido{
        itr = grafo.itrVertices();
        
        while(itr.hasNext()){
            Usuario u = itr.next();
            if(u.getEmail().equals(email) && u.getPassword().equals(senha)){
                return u;
            }            
        }
        throw new LoginInvalido(); 
    }
    
    public String fazerPostagem(Usuario user, String post){
        
        if(user.getPostagens().add(post)){
            return post;
        }
        return null; 
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
