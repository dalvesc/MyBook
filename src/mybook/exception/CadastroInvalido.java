package mybook.exception;

/**
 * Caso o email já tenha sido cadastrado
 *
 */
public class CadastroInvalido extends Exception {

    public CadastroInvalido(String email) {
        super("O e-mail ''" + email + "'' já está em uso!");
    }
}
