package mybook.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mybook.util.*;

/**
 * Classe para serializar os dados
 */
public class ControllerSerializar {

    private Graph obj;

    public ControllerSerializar(Graph obj) {
        this.obj = obj;
    }

    /**
     * Grava os dados em um arquivo .ser
     *
     * @param obj
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void gravar(Graph obj) throws FileNotFoundException, IOException {
        FileOutputStream fileoutput = new FileOutputStream("grafo.ser");
        ObjectOutputStream objectoutput = new ObjectOutputStream(fileoutput);

        objectoutput.writeObject(obj);
        objectoutput.close();
    }

    /**
     * Recupera os dados de um arquivo .ser
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Graph recuperar() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileinput = new FileInputStream("grafo.ser");
        ObjectInputStream objectinput = new ObjectInputStream(fileinput);

        obj = (Graph) objectinput.readObject();
        objectinput.close();
        return obj;
    }

}
