package mybook.util;

import java.util.Iterator;

/**
 *
 * @author Daniel Alves e Gabriela Nunes. Adaptado da interface IGraph do professor
 * João Batista.
 */
public interface IGraph {
    
    /**
     * Indica o número de vértices do grafo.
     * @return número de vértices.
     */
    public int numVertices();

    /**
     * Adiciona um vértice no grafo.
     * 
     * @param key objeto que será o novo vértice.
     * @return "true" se a operação for bem sucedida e "false" se não.
     */
    public boolean addVertex(Object key);
    
    /**
     * Remove um vértice do grafo.
     * 
     * @param key objeto que será removido.
     * @return "true" se a operação for bem sucedida e "false" se não.
     */
    public boolean removeVertex(Object key);
    
    /**
     * Adiciona uma aresta entre dois vértices.
     * 
     * @param origin vértice de origem.
     * @param destiny vértice de destino.
     * @return "true" se a operação for bem sucedida e "false" se não.
     */
    public boolean addEdge(Object origin, Object destiny);
    
    /**
     * Remove uma aresta entre dois vértices.
     * 
     * @param o1 vértice de origem.
     * @param o2 vértice de destino.
     * @return "true" se a operação for bem sucedida e "false" se não.
     */
    public boolean removeEdge(Object o1, Object o2);
    
    /**
     * Verifica a existência de uma aresta entre dois vértices.
     * 
     * @param v1 vértice de origem.
     * @param v2 vértice de destino.
     * @return "true" se houver uma aresta e "false" se não.
     */
    public boolean hasEdge(Object v1, Object v2);
    
    /**
     * Indica o número de adjacências de um determinado vértice.
     * 
     * @param o vértice a ser consultado.
     * @return número de adjacências que o vértice contém.
     */
    public int numAdjacencies(Object o);
    
    /**
     * Retorna um iterador que percorre as adjacências de determinado vértice.
     * 
     * @param o vértice a ser consultado.
     * @return iterador para percorrer as adjacências do vértice dado.
     */
    public Iterator itrAdjacencies(Object o);

    public Iterator itrVertices();

}
