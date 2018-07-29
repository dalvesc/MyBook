package mybook.alimentasistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import mybook.controller.Controller;
import mybook.exception.CadastroInvalido;
import mybook.exception.LoginInvalido;

public class AlimentaSistema {
    
    private Controller ctrl;
    
    public AlimentaSistema(Controller ctrl) throws IOException, FileNotFoundException, ClassNotFoundException, CadastroInvalido, LoginInvalido{
        this.ctrl = ctrl;
        insereDados();
    }
    
    public void insereDados() throws CadastroInvalido, IOException, LoginInvalido{
       
       ctrl.cadastrarUsuario("222", "Tyrion Lannister", "222@gmail.com", "274 d.C", "Winterfell", "222-222", "tyrion");
       ctrl.cadastrarUsuario("333", "Walter White", "333@gmail.com", "07/09/1958", "Albuquerque", "333-333", "walter");
       ctrl.cadastrarUsuario("444", "Bilbo Baggins", "444@gmail.com", "TE 2890", "Condado", "444-444", "bilbo");
       ctrl.cadastrarUsuario("555", "Ted Mosby", "555@gmail.com", "25/04/1978", "Nova York", "555-555", "ted");       
       ctrl.cadastrarUsuario("666", "Conde Drácula", "666@gmail.com", "Ano 1431", "Transilvânia", "666-666", "dracula");
       
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
