package mybook.view;

import mybook.controller.*;
import mybook.exception.*;
import mybook.model.Usuario;

public class TesteMain {
    public static void main(String[] args) throws CadastroInvalido, LoginInvalido{
        
        Controller controller = new Controller();
        
        System.out.println("Cadastro: " + controller.cadastrarUsuario("1234", "Gabriela Nunes", "hehe123@gmail.com", "23/09/1999", 
                   "Feira de Santana", "(75)99294-5418", "Rua C, número 07, Conjunto Feira IX"));
        
//        System.out.println(controller.cadastrarUsuario("1234", "Gabriela Nunes", "hehe123@gmail.com", "23/09/1999", 
//                   "Feira de Santana", "(75)99294-5418", "Rua C, número 07, Conjunto Feira IX"));
        
        System.out.println("Cadastro: " + controller.cadastrarUsuario("1234", "Gabriela Nunes", "hehe12345@gmail.com", "23/09/1999", 
                   "Feira de Santana", "(75)99294-5418", "Rua C, número 07, Conjunto Feira IX"));
                  
        System.out.println("Login: " + controller.fazerLogin("hehe123@gmail.com", "1234"));
        
        System.out.println("Login: " + controller.fazerLogin("hehe123@gmail.com", "12"));
        
        System.out.println("Login: " + controller.fazerLogin("hehe123@gmail", "1234"));
        
    }
}
