package mybook.view;

import java.io.IOException;
import mybook.controller.*;
import mybook.exception.*;
import mybook.facade.Facade;
import mybook.model.Usuario;

public class TesteMain {
    public static void main(String[] args) throws CadastroInvalido, LoginInvalido, IOException{
        
        Facade fcd = new Facade();
        
        //Criando
        //true
        System.out.println("Cadastro: " + fcd.cadastrarUsuario("1234", "Gabriela Nunes", "hehe123@gmail.com", "23/09/1999", 
            "Feira de Santana", "(75)99294-5418", "Rua C, número 07, Conjunto Feira IX"));
        
        
        //true
        System.out.println("Cadastro: " + fcd.cadastrarUsuario("1234", "Gabriela Nunes", "h@gmail.com", "23/09/1999", 
            "Feira de Santana", "(75)99294-5418", "Rua C, número 07, Conjunto Feira IX"));        
        
        
        //true
        System.out.println("Cadastro: " + fcd.cadastrarUsuario("666", "Osvaldo Neto", "666@gmail.com", "13/10/1976", 
                   "Salvador", "(71)6666-6666", "Rua H, número 14"));
        
        //Login                  
        System.out.println("Login: " + fcd.fazerLogin("hehe123@gmail.com", "1234"));
        
        System.out.println("Login: " + fcd.fazerLogin("666@gmail.com", "666"));

        System.out.println("Obter usuário: " + fcd.obterUsuario("666@gmail.com"));        
        
        
        
        
    }
}
