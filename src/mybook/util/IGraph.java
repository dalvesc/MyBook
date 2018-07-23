package mybook.util;

/**
 *
 * @author gabriela
 */
public interface IGraph {

    public void addVertex(Object key);

    public Iterator vertices();

    public int numVertices();

    public void removeVertex(Object key);

    public void addEdge(Object u, Object v, Object data); 

    public void removeEdge(Edge e);

    public Iterator outgoingEdges(Object v);

    public int outDegree(Object v);

    public Iterator incomingEdges(Object v);

    public int inDegree(Object v);

}
