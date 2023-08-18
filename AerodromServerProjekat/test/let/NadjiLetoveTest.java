/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package let;

import domain.Destinacija;
import domain.Let;
import java.util.List;
import operation.avion.NadjiAvione;
import operation.let.NadjiLetove;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nikola
 */
public class NadjiLetoveTest {

    private NadjiLetove so;

    @Before
    public void setUp() {
        so = new NadjiLetove();
    }

    @org.junit.Test
    public void testExecute() throws Exception {
        Let a = new Let();
        a.setCena(13000);
        so.execute(a);
        List<Let> lista = so.vratiLetove();
        assertEquals(true, lista.size() > 0);
    }
}
