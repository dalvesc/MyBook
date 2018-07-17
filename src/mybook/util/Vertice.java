package mybook.util;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

    private Object obj;
    private List<Aresta> adj;

    public Vertice(Object obj) {
        this.obj = obj;
        this.adj = new ArrayList<Aresta>();
    }

    public void addAdj(Aresta e) {
        adj.add(e);
    }
}
