package mybook.exception;

/**
 * Exceção lançada se o usuário não possuir publicações.
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class SemPublicacoes extends Exception {

    public SemPublicacoes() {
        super("Não possui publicações");
    }
}
