package mybook.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.io.Serializable;
import java.util.Objects;

public class Graph implements IGraph, Serializable {

    private Map<Object, Vertex> vertices;

    private class Vertex implements Serializable {

        private Object data;
        private Set adjacencies;

        private Vertex(Object data) {
            this.data = data;
            adjacencies = new HashSet();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Vertex other = (Vertex) obj;
            if (!Objects.equals(this.data, other.data)) {
                return false;
            }
            if (!Objects.equals(this.adjacencies, other.adjacencies)) {
                return false;
            }
            return true;
        }
    }

    public Graph() {
        vertices = new HashMap();
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public boolean addVertex(Object o) {
        Vertex v = new Vertex(o);
        return vertices.put(o, v) == null;
    }

    @Override
    public boolean removeVertex(Object o) {
        if (vertices.containsKey(o)) {
            Set keys = vertices.keySet();

            for (Object key : keys) {
                Vertex v = vertices.get(key);
                Set adj = v.adjacencies;
                adj.remove(o);
            }
            return vertices.remove(o) != null;
        }
        return false;
    }

    @Override
    public boolean addEdge(Object origin, Object destiny) {
        if (vertices.containsKey(origin) && vertices.containsKey(destiny)) {
            Vertex v1 = vertices.get(origin);
            Vertex v2 = vertices.get(destiny);
            v1.adjacencies.add(destiny);
            v2.adjacencies.add(origin);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEdge(Object o1, Object o2) {
        if (vertices.containsKey(o1) && vertices.containsKey(o2)) {
            Vertex v1 = vertices.get(o1);
            Vertex v2 = vertices.get(o1);
            v1.adjacencies.remove(o2);
            v2.adjacencies.remove(o1);
            return true;
        }
        return false;
    }

    @Override
    public boolean hasEdge(Object v1, Object v2) {
        if (vertices.containsKey(v1) && vertices.containsKey(v2)) {
            Vertex vv1 = vertices.get(v1);
            Vertex vv2 = vertices.get(v2);
            return vv1.adjacencies.contains(v2) && vv2.adjacencies.contains(v1);
        }
        return false;
    }

    @Override
    public int numAdjacencies(Object o) {
        Vertex v = vertices.get(o);
        return v.adjacencies.size();
    }

    @Override
    public Iterator itrAdjacencies(Object o) {
        if (vertices.containsKey(o)) {
            Vertex v = vertices.get(o);
            return v.adjacencies.iterator();
        }
        return null;
    }

    @Override
    public Iterator itrVertices() {
        return vertices.keySet().iterator();
    }

    public boolean contains(Object o) {
        return vertices.containsKey(o);
    }

    public Object getVertex(Object key) {
        return vertices.get(key).data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Graph other = (Graph) obj;
        if (!Objects.equals(this.vertices, other.vertices)) {
            return false;
        }
        return true;
    }
}
