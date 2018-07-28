package mybook.exception;

/**
 * Caso o email já tenha sido cadastrado
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class CadastroInvalido extends Exception {

    public CadastroInvalido(String email) {
        super("O e-mail ''" + email + "'' já está em uso!");
    }
}
