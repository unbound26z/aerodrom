/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pilot;

import domain.Destinacija;
import domain.Pilot;
import java.util.List;
import operation.destinacija.UcitajListuDestinacija;
import operation.pilot.UcitajListuPilota;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nikola
 */
public class UcitajListuPilotaTest {

    private UcitajListuPilota so;

    @Before
    public void setUp() {
        so = new UcitajListuPilota();
    }

    @org.junit.Test
    public void testExecute() throws Exception {
        so.execute(new Pilot());
        List<Pilot> lista = so.vratiListuPilota();
        assertEquals(true, lista.size() > 0);
    }
}
