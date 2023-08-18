/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package raspored;

import domain.Destinacija;
import domain.Raspored;
import java.util.List;
import operation.destinacija.UcitajListuDestinacija;
import operation.raspored.UcitajListuRasporeda;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nikola
 */
public class UcitajListuRasporedaTest {

    private UcitajListuRasporeda so;

    @Before
    public void setUp() {
        so = new UcitajListuRasporeda();
    }

    @org.junit.Test
    public void testExecute() throws Exception {
        so.execute(new Raspored());
        List<Raspored> lista = so.vratiListuRasporeda();
        assertEquals(true, lista.size() > 0);
    }
}
