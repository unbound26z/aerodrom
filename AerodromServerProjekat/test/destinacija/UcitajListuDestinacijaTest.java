/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package destinacija;

import domain.Avion;
import domain.Destinacija;
import java.util.List;
import operation.avion.UcitajListuAviona;
import operation.destinacija.UcitajListuDestinacija;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nikola
 */
public class UcitajListuDestinacijaTest {

    private UcitajListuDestinacija so;

    @Before
    public void setUp() {
        so = new UcitajListuDestinacija();
    }

    @org.junit.Test
    public void testExecute() throws Exception {
        so.execute(new Destinacija());
        List<Destinacija> lista = so.vratiListuDestinacija();
        assertEquals(true, lista.size() > 0);
    }
}
