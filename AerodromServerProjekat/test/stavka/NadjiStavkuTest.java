/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package stavka;

import domain.Let;
import domain.StavkaRasporeda;
import java.util.List;
import operation.let.NadjiLetove;
import operation.stavkaRasporeda.NadjiStavke;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nikola
 */
public class NadjiStavkuTest {

    private NadjiStavke so;

    @Before
    public void setUp() {
        so = new NadjiStavke();
    }

    @org.junit.Test
    public void testExecute() throws Exception {
        StavkaRasporeda a = new StavkaRasporeda();
        a.setRaspored(123L);
        so.execute(a);
        List<StavkaRasporeda> lista = so.vratiStavke();
        System.out.println(lista);
        assertEquals(true, lista.size() > 0);
    }

}
