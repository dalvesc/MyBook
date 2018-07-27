package mybooktests.model;

import mybook.exception.SemImagem;
import mybook.model.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class UsuarioTest {

    Usuario usuario1, usuario2;

    @Before
    public void setUp() throws Exception {
        usuario1 = new Usuario("password1", "nome1", "email1", "nascimento1", "cidade1", "telefone1", "fotoPerfil1");
        usuario2 = new Usuario("password2", "nome2", "email2", "nascimento2", "cidade2", "telefone2", "fotoPerfil2");
    }

    @Test
    public void testGetPassword() {
        assertEquals("password1", usuario1.getPassword());
        assertEquals("password2", usuario2.getPassword());
    }

    @Test
    public void testGetNome() {
        assertEquals("nome1", usuario1.getNome());
        assertEquals("nome2", usuario2.getNome());
    }

    @Test
    public void testGetEmail() {
        assertEquals("email1", usuario1.getEmail());
        assertEquals("email2", usuario2.getEmail());
    }

    @Test
    public void testGetNascimento() {
        assertEquals("nascimento1", usuario1.getNascimento());
        assertEquals("nascimento2", usuario2.getNascimento());
    }

    @Test
    public void testGetCidade() {
        assertEquals("cidade1", usuario1.getCidade());
        assertEquals("cidade2", usuario2.getCidade());
    }

    @Test
    public void testGetTelefone() {
        assertEquals("telefone1", usuario1.getTelefone());
        assertEquals("telefone2", usuario2.getTelefone());
    }

    @Test
    public void testGetFotoPerfil() throws SemImagem {
        assertEquals("fotoPerfil1", usuario1.getFotoPerfil());
        assertEquals("fotoPerfil2", usuario2.getFotoPerfil());
    }
}
