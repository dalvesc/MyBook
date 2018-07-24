package mybook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mybook.model.Usuario;

/**
 *
 * @author gabriela
 */
public class ControllerArquivo {

    public void gravarUsuario(Usuario u) throws IOException {

        String diretorio = new File("usuarios").getCanonicalPath();
        File pasta = new File(diretorio);
        File newArq = new File(pasta, u.getEmail());
        
        newArq.delete();
        newArq.createNewFile();

        ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(newArq));
        objOutput.writeObject(u);
        objOutput.close();
    }
    
    public void removerUsuario(Usuario u) throws IOException{
        
        String diretorio = new File("usuarios").getCanonicalPath();
        File pasta = new File(diretorio);
        File newArq = new File(pasta, u.getEmail());
        
        newArq.delete();        
    }
    
    

}
