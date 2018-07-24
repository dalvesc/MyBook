package mybook.exception;

/**
 *
 * @author gabriela
 */
public class CadastroInvalido extends Exception{ 
    
    public CadastroInvalido(String email){
        super("O e-mail ''" + email + "'' jÃ¡ estÃ¡ em uso!");
    }
    
}