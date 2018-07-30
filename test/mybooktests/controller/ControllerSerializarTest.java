/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybooktests.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import mybook.controller.ControllerSerializar;
import mybook.util.Graph;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author gabriela
 */
public class ControllerSerializarTest {
    ControllerSerializar ctrlSerial;   
    Graph grafo;
    Graph expected;
    
    @Before
    public void setUp() throws Exception {        
        grafo = new Graph();         
        
        grafo.addVertex("teste1");
        grafo.addVertex("teste2");
        grafo.addVertex("teste3");
        
        grafo.addEdge("teste1", "teste2");
        grafo.addEdge("teste2", "teste3");
        
        ctrlSerial = new ControllerSerializar(grafo);
    }       
    
    @Test
    public void testGravarRecuperar() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        ctrlSerial.setArqSerial("teste.ser");        
        ctrlSerial.gravar(grafo);
        
        expected = ctrlSerial.recuperar();
        assertEquals(expected, grafo);        
    }            
}
