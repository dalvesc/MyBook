package mybooktests.util;

import mybook.model.*;
import mybook.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author gabriela
 */
public class GraphTest {

    Graph grafo;
    Object usuario1, usuario2;

    @Before
    public void setUp() throws Exception {
        grafo = new Graph();
        usuario1 = new Usuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "endereco1");
        usuario2 = new Usuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "endereco2");

    }

    @Test
    public void testNumVertices() {
        grafo.addVertex(usuario1);
        assertEquals(1, grafo.numVertices());
        grafo.addVertex(usuario2);
        assertEquals(2, grafo.numVertices());
    }

    @Test
    public void testAddVertex() {
        assertTrue(grafo.addVertex(usuario1));
        assertTrue(grafo.addVertex(usuario2));
    }

    @Test
    public void testRemoveVertex() {
        assertTrue(grafo.addVertex(usuario1));
        assertTrue(grafo.addVertex(usuario2));
        assertEquals(2, grafo.numVertices());

        assertTrue(grafo.removeVertex(usuario1));
        assertEquals(1, grafo.numVertices());

        assertTrue(grafo.removeVertex(usuario2));
    }

    @Test
    public void testAddEdge() {
        assertTrue(grafo.addVertex(usuario1));
        assertTrue(grafo.addVertex(usuario2));
        assertEquals(2, grafo.numVertices());

        assertTrue(grafo.addEdge(usuario1, usuario2));
    }

    @Test
    public void testRemoveEdge() {
        assertTrue(grafo.addVertex(usuario1));
        assertTrue(grafo.addVertex(usuario2));
        assertEquals(2, grafo.numVertices());

        assertTrue(grafo.addEdge(usuario1, usuario2));

        assertTrue(grafo.removeEdge(usuario1, usuario2));
    }

    @Test
    public void testHasEdge() {
        assertTrue(grafo.addVertex(usuario1));
        assertTrue(grafo.addVertex(usuario2));
        assertEquals(2, grafo.numVertices());

        assertTrue(grafo.addEdge(usuario1, usuario2));
        assertTrue(grafo.hasEdge(usuario1, usuario2));

        assertTrue(grafo.removeEdge(usuario1, usuario2));
        assertFalse(grafo.hasEdge(usuario1, usuario2));
    }

    @Test
    public void testNumAdjacencies() {
        assertTrue(grafo.addVertex(usuario1));
        assertTrue(grafo.addVertex(usuario2));
        assertEquals(2, grafo.numVertices());

        assertTrue(grafo.addEdge(usuario1, usuario2));
        assertTrue(grafo.hasEdge(usuario1, usuario2));

        assertEquals(1, grafo.numAdjacencies(usuario1));
        assertEquals(1, grafo.numAdjacencies(usuario2));
    }

    @Test
    public void testItrAdjacencies() {
        assertTrue(grafo.addVertex(usuario1));
        assertTrue(grafo.addVertex(usuario2));
        assertEquals(2, grafo.numVertices());

        assertTrue(grafo.addEdge(usuario1, usuario2));
        assertTrue(grafo.hasEdge(usuario1, usuario2));

        java.util.Iterator iterator = grafo.itrAdjacencies(usuario1);
        assertTrue(iterator.hasNext());
        assertEquals(usuario2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testItrVertices() {
        assertTrue(grafo.addVertex(usuario1));
        assertTrue(grafo.addVertex(usuario2));
        assertEquals(2, grafo.numVertices());

        java.util.Iterator iterator = grafo.itrVertices();
        assertTrue(iterator.hasNext());
        assertEquals(usuario2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(usuario1, iterator.next());
        assertFalse(iterator.hasNext());

    }
}
