package mybooktest;

import mybooktests.controller.*;
import mybooktests.model.*;
import mybooktests.util.*;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    GraphTest.class,
    UsuarioTest.class,
    ControllerTest.class,})
public class AllTests {
}
