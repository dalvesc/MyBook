package mybook.view;

import java.io.IOException;
import mybook.controller.*;
import mybook.exception.*;

public class TesteMain {
    public static void main(String[] args) throws CadastroInvalido, LoginInvalido, IOException{
        
        ControllerUsuario controller = new ControllerUsuario();
        
        
        System.out.println("Cadastro: " + controller.cadastrarUsuario("1234", "Gabriela Nunes", "hehe123@gmail.com", "23/09/1999", 
                   "Feira de Santana", "(75)99294-5418", "Rua C, número 07, Conjunto Feira IX"));
        
//        System.out.println(controller.cadastrarUsuario("1234", "Gabriela Nunes", "hehe123@gmail.com", "23/09/1999", 
//                   "Feira de Santana", "(75)99294-5418", "Rua C, número 07, Conjunto Feira IX"));
        
        System.out.println("Cadastro: " + controller.cadastrarUsuario("666", "Osvaldo Silva", "xxx@gmail.com", "23/09/1999", 
                   "Feira de Santana", "(75)99294-5418", "Rua C, número 07, Conjunto Feira IX"));
                  
        System.out.println("Login: " + controller.fazerLogin("hehe123@gmail.com", "1234"));
        
//        System.out.println("Login: " + controller.fazerLogin("hehe123@gmail.com", "12"));
        
        System.out.println("Login: " + controller.fazerLogin("xxx@gmail.com", "666"));
        
        System.out.println("Amizade: " + controller.fazerAmizade("hehe123@gmail.com", "xxx@gmail.com"));
        
        System.out.println("Removendo amizade: " + controller.removerAmizade("hehe123@gmail.com", "xxx@gmail.com"));
        
        
        
    }
}
