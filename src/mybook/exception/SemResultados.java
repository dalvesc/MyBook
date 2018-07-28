package mybook.exception;

/**
 * Exceção lançada se não houverem resultados para uma busca.
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class SemResultados extends Exception {

    public SemResultados(String nome) {
        super("Não há resultados para '" + nome + "'.");
    }
}
