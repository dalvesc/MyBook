/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybook.alimentasistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import mybook.controller.Controller;
import mybook.exception.CadastroInvalido;
import mybook.exception.LoginInvalido;

/**
 *
 * @author gabriela
 */
public class AlimentaSistema {
    
    private Controller ctrl;
    
    public AlimentaSistema() throws IOException, FileNotFoundException, ClassNotFoundException, CadastroInvalido, LoginInvalido{
        ctrl = new Controller();
        insereDados();
    }
    
    public void insereDados() throws CadastroInvalido, IOException, LoginInvalido{
       
       ctrl.cadastrarUsuario("222", "Tyrion Lannister", "222@gmail.com", "274 d.C", "Winterfell", "222-222");
       ctrl.cadastrarUsuario("333", "Walter White", "333@gmail.com", "07/09/1958", "Albuquerque", "333-333");
       ctrl.cadastrarUsuario("444", "Bilbo Baggins", "444@gmail.com", "TE 2890", "Condado", "444-444");
       ctrl.cadastrarUsuario("555", "Ted Mosby", "555@gmail.com", "25/04/1978", "Nova York", "555-555");       
       ctrl.cadastrarUsuario("666", "Conde Drácula", "666@gmail.com", "Ano 1431", "Transilvânia", "666-666");
       
       ctrl.fazerLogin("222@gmail.com", "222");
       ctrl.fazerAmizade("Walter White");
       ctrl.fazerAmizade("Ted Mosby");
       ctrl.fazerAmizade("Bilbo Baggins");     
              
       ctrl.fazerLogin("333@gmail.com", "333");
       ctrl.fazerAmizade("Bilbo Baggins");
       ctrl.fazerAmizade("Ted Mosby");
       
       ctrl.fazerLogin("666@gmail.com", "666");
       ctrl.fazerAmizade("Walter White");
       ctrl.fazerAmizade("Ted Mosby");
       ctrl.fazerAmizade("Bilbo Baggins");
       ctrl.fazerAmizade("Tyrion Lannister");
    }    
}
