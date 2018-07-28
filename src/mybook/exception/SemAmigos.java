package mybook.exception;

/**
 * Exceção lançada se o usuário não possuir amigos.
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class SemAmigos extends Exception {

    public SemAmigos() {
        super("Não possui amigos");
    }
}
