/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybook.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import mybook.util.*;
import mybook.controller.*;
import mybook.facade.Facade;

/**
 *
 * @author gabriela
 */
public class TesteMain {
    
    private static Facade fcd;
   
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        fcd = new Facade();       
        
        fcd.carregarUsuarios("123", "gabs", "123@gmail.com", "123", "fsa", "123", "eu");
        
        System.out.println(fcd.grafo);        
    }
    
}
