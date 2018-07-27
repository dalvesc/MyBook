package mybooktests.controller;

import java.util.List;
import mybook.model.*;
import mybook.controller.*;
import mybook.exception.CadastroInvalido;
import mybook.exception.LoginInvalido;
import mybook.exception.SemResultados;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;

public class ControllerTest {
   
    Controller controller;
    Usuario usuario1, usuario2, usuario3;

    @Before
    public void setUp() throws Exception {
        controller = new Controller();
        usuario1 = new Usuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1");
        usuario2 = new Usuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2");
        usuario3 = new Usuario("password2", "nome1", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2");
    }

    @Test
    public void testGetUserLogado() throws CadastroInvalido, LoginInvalido {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertTrue(controller.fazerLogin("email1", "password1"));

        assertEquals(usuario1, controller.getUserLogado());
    }

    @Test
    public void testCadastrarUsuario() throws CadastroInvalido {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario2, controller.cadastrarUsuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));
    }

    @Test
    public void testRemoverConta() throws CadastroInvalido, LoginInvalido {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertTrue(controller.fazerLogin("email1", "password1"));

        assertTrue(controller.removerConta());
    }

    @Test
    public void testFazerAmizade() throws CadastroInvalido, LoginInvalido {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario2, controller.cadastrarUsuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));
        assertTrue(controller.fazerLogin("email1", "password1"));

        assertTrue(controller.fazerAmizade("nome2"));
    }

    @Test
    public void testRemoverAmizade() throws CadastroInvalido, LoginInvalido {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario2, controller.cadastrarUsuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));
        assertTrue(controller.fazerLogin("email1", "password1"));

        assertTrue(controller.fazerAmizade("nome2"));

        assertTrue(controller.removerAmizade("nome2"));

    }

    @Test
    public void testFazerLogin() throws CadastroInvalido, LoginInvalido {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario2, controller.cadastrarUsuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));

        assertTrue(controller.fazerLogin("email1", "password1"));
        assertTrue(controller.fazerLogin("email2", "password2"));
    }

    @Test
    public void testBuscarUsuario() throws CadastroInvalido, SemResultados {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario3, controller.cadastrarUsuario("password2", "nome1", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));

        List<Usuario> list = controller.buscarUsuario("nome1");
        assertTrue(list.contains(usuario1));
        assertTrue(list.contains(usuario3));
    }

    @Test
    public void testFazerPostagem() throws CadastroInvalido, LoginInvalido {
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertTrue(controller.fazerLogin("email1", "password1"));

        assertTrue(controller.fazerPostagem("mensagem"));
    }
    
    @Test
    public void testUploadArquivo() throws CadastroInvalido, LoginInvalido{
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertTrue(controller.fazerLogin("email1", "password1"));
        
        assertTrue(controller.uploadArquivo("caminhoArquivo"));
    }
    
    @Test
    public void testAmizades() throws CadastroInvalido, LoginInvalido{
        assertEquals(usuario1, controller.cadastrarUsuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1"));
        assertEquals(usuario2, controller.cadastrarUsuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2"));
        assertTrue(controller.fazerLogin("email1", "password1"));
        assertTrue(controller.fazerAmizade("nome2"));
        
        List<Usuario> list = controller.amizades(usuario1);
        assertTrue(list.contains(usuario2));
    }
}
