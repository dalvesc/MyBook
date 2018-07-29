/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybook.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mybook.util.Graph;

/**
 *
 * @author gabriela
 */
public class ControllerSerializar {
    
    private Graph obj; 
    
    public ControllerSerializar(Graph obj){
        this.obj = obj;
    }
    
    public void gravar(Graph obj) throws FileNotFoundException, IOException{
        FileOutputStream fileoutput = new FileOutputStream("grafo.ser");
        ObjectOutputStream objectoutput = new ObjectOutputStream(fileoutput);
        
        objectoutput.writeObject(obj);
        objectoutput.close();
    }
        
    public Graph recuperar() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fileinput = new FileInputStream("grafo.ser");
        ObjectInputStream objectinput = new ObjectInputStream(fileinput);
       
        obj = (Graph) objectinput.readObject();
        objectinput.close();
        return obj;
    }
    
    
}
