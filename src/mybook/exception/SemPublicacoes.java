package mybook.exception;

/**
 * Exceção lançada se o usuário não possuir publicações.
 *
 */
public class SemPublicacoes extends Exception {

    public SemPublicacoes() {
        super("Não possui publicações.");
    }
}