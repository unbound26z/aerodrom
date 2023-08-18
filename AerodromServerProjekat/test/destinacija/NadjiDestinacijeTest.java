/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package destinacija;

import domain.Destinacija;
import java.util.List;
import operation.destinacija.NadjiDestinacije;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nikola
 */
public class NadjiDestinacijeTest {

    private NadjiDestinacije so;

    @Before
    public void setUp() {
        so = new NadjiDestinacije();
    }

    @org.junit.Test
    public void testExecute() throws Exception {
        Destinacija a = new Destinacija();
        a.setNazivDestinacije("B");
        so.execute(a);
        List<Destinacija> lista = so.vratiDestinacije();
        assertEquals(true, lista.size() > 0);
    }
}
