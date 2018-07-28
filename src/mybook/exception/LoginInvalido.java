package mybook.exception;

/**
 * Caso o email ou a senha do usuário esteja incorreta
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class LoginInvalido extends Exception {

    public LoginInvalido() {
        super("E-mail ou senha inválidos!");
    }
}
