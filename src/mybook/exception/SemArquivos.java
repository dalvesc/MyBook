package mybook.exception;

/**
 * Exceção lançada se o usuário não possuir arquivos.
 *
 */
public class SemArquivos extends Exception {

    public SemArquivos() {
        super("Não possui arquivos");
    }
}
