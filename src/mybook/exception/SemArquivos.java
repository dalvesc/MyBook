package mybook.exception;

/**
 * Exceção lançada se o usuário não possuir arquivos.
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class SemArquivos extends Exception {

    public SemArquivos() {
        super("Não possui arquivos");
    }
}