package mybook.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 
 * 
 * @author gabriela
 */
public class Graph {   
    private Map <Object, Vertex> vertices; 
    
    private class Vertex{
        
        private Object data;
        private HashSet adjacencies;
        
        public Vertex(Object data){
            this.data = data;
            adjacencies = new HashSet();           
        }
        
        public HashSet getAdjacencies() {
            return adjacencies;
        }        
    }  
    
    public Graph(){
        vertices = new HashMap();
    }
    
    public int numVertices(){
        return vertices.size();
    }
    
    public boolean addVertex(Object o){
        Vertex v = new Vertex(o);        
        return vertices.put(o,v) == null;
    }
    
    public boolean addEdge(Object origin, Object destiny){        
        if(vertices.containsKey(origin) && vertices.containsKey(destiny)){        
            Vertex v1 = vertices.get(origin);
            Vertex v2 = vertices.get(destiny);
            v1.adjacencies.add(destiny);
            v2.adjacencies.add(origin);
            return true;
        }
        return false;
    }
    
    public boolean hasEdge(Object v1, Object v2){
        if(vertices.containsKey(v1) && vertices.containsKey(v2)){ 
            Vertex vv1 = vertices.get(v1);
            Vertex vv2 = vertices.get(v2);
            return vv1.adjacencies.contains(v2) && vv2.adjacencies.contains(v1);
        }
        return false;
    }
}
