package mybook.exception;

/**
 * Exceção lançada se o usuário não possuir uma imagem válida.
 *
 */
public class SemImagem extends Exception {

    public SemImagem() {
        super("Não possui imagem.");
    }
}