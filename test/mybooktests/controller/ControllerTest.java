package mybooktests.controller;

import mybook.model.*;
import mybook.util.*;
import mybook.controller.*;
import mybook.exception.CadastroInvalido;
import mybook.exception.LoginInvalido;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;

public class ControllerTest {

    Controller controller;
    Object usuario1, usuario2;

    @Before
    public void setUp() throws Exception {
        controller = new Controller();
        usuario1 = new Usuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1");
        usuario2 = new Usuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2");
    }

    @Test
    public void testCadastrarUsuario() throws CadastroInvalido {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario2, controller.cadastrarUsuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));
    }

    @Test
    public void testRemoverConta() throws CadastroInvalido {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario2, controller.cadastrarUsuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));

        assertTrue(controller.removerConta("email1"));
        assertTrue(controller.removerConta("email2"));
    }

    @Test
    public void testFazerAmizade() throws CadastroInvalido {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario2, controller.cadastrarUsuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));

        controller.fazerAmizade((Usuario) usuario1, (Usuario) usuario2);
        Graph grafo = controller.getGrafo();
        assertTrue(grafo.hasEdge((Usuario)usuario1, (Usuario) usuario2));
    }
    
    @Test
    public void testRemoverAmizade() throws CadastroInvalido{
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario2, controller.cadastrarUsuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));
    
        controller.fazerAmizade((Usuario) usuario1, (Usuario)usuario2);
        Graph grafo = controller.getGrafo();
        assertTrue(grafo.hasEdge(usuario1, usuario2));
        
        controller.removerAmizade((Usuario) usuario1, (Usuario) usuario2);
        grafo = controller.getGrafo();
        assertFalse(grafo.hasEdge(usuario1, usuario2));
    }
    
    @Test
    public void testFazerLogin() throws CadastroInvalido, LoginInvalido{
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario2, controller.cadastrarUsuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));
        
        assertEquals(usuario1, controller.fazerLogin("email1", "password1"));
        assertEquals(usuario2, controller.fazerLogin("email2", "password2"));
    }
}
