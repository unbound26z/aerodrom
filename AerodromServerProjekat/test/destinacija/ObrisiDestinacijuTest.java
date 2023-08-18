/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package destinacija;

import domain.Destinacija;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.destinacija.ObrisiDestinaciju;
import operation.destinacija.UcitajListuDestinacija;
import operation.destinacija.ZapamtiDestinaciju;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nikola
 */
public class ObrisiDestinacijuTest {

    private Destinacija d;
    ObrisiDestinaciju so;
    ZapamtiDestinaciju so2;
    UcitajListuDestinacija so3;

    @Before
    public void setUp() {
        so = new ObrisiDestinaciju();
        so2 = new ZapamtiDestinaciju();
        so3 = new UcitajListuDestinacija();
        try {
            so2.execute(new Destinacija(0, "Test", "Test"));

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            so3.execute(new Destinacija());
        } catch (Exception ex) {
            Logger.getLogger(ObrisiDestinacijuTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        d = so3.vratiListuDestinacija().get(0);

    }

    @After
    public void tearDown() {
        so = null;
        so2 = null;
        d = null;
    }

    @Test
    public void testExecute() throws Exception {

        so.execute(d);

    }
}
