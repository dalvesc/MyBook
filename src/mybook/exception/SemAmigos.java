package mybook.exception;

/**
 * Exceção lançada se o usuário não possuir amigos.
 *
 */
public class SemAmigos extends Exception {

    public SemAmigos() {
        super("Não possui amigos");
    }
}
