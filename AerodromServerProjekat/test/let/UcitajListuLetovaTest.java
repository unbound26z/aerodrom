/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package let;

import domain.Destinacija;
import domain.Let;
import java.util.List;
import operation.destinacija.UcitajListuDestinacija;
import operation.let.UcitajListuLetova;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nikola
 */
public class UcitajListuLetovaTest {

    private UcitajListuLetova so;

    @Before
    public void setUp() {
        so = new UcitajListuLetova();
    }

    @org.junit.Test
    public void testExecute() throws Exception {
        so.execute(new Let());
        List<Let> lista = so.vratiListuLetova();
        assertEquals(true, lista.size() > 0);
    }

}
