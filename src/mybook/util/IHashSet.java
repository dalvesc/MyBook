package mybook.util;

/**
 * @author Daniel Alves e Gabriela Nunes. Adaptado do código do professor João
 * Batista.
 * https://0ea7cb47-a-529ca56d-s-sites.googlegroups.com/a/ecomp.uefs.br/joao/files/EXA806-HashTable.pdf?attachauth=ANoY7cocs35ibu9wUokmqkHle4FS5YfPDUs2MY8MmvznmSyRp4L4YALRwzYvgLFVIHxBKp0lO-EI1HQyV_gzCLo_drfG8fX9-773LZlW8d4X-M6Urjef1Cv_bLXwehKFZGmEQ40qouwSW_wP45zTd-S7VFWRG6x7Mxu01yOhZrhRXpSW6ye4U6_J6SGF4afauhg6rBi22HRBDpktLpjB-gdKJuxee2EBYw%3D%3D&attredirects=0
 */
public interface IHashSet {

    /**
     * Adiciona um objeto na hash
     *
     * @param data objeto que será adicionado
     */
    public void put(Object data);

    /**
     * Verifica se determinado objeto está na hash
     *
     * @param data objeto que será verificado
     * @return true caso o item está na hash e false caso não
     */
    public boolean contains(Object data);

    /**
     * Remove um item da has
     *
     * @param data objeto que será removido
     */
    public void remove(Object data);

    /**
     * Verifica se a lista está vazia
     *
     * @return true caso não contenha nada na hash
     */
    public boolean isEmpty();

    /**
     * Indica o número de objetos que contém na hash
     *
     * @return número de elementos
     */
    public int size();
}
