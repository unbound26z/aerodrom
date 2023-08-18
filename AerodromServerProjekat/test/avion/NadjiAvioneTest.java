/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package avion;

import domain.Avion;
import java.util.List;
import operation.avion.NadjiAvione;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

/**
 *
 * @author Nikola
 */
public class NadjiAvioneTest {
    
    private NadjiAvione so;

    @Before
    public void setUp() {
         so=new NadjiAvione();
    }
    
    @org.junit.Test
    public void testExecute() throws Exception {
        Avion a = new Avion();
        a.setNazivAviona("");
        so.execute(a);
        List<Avion> lista=so.vratiAvione();   
        assertEquals(true, lista.size() > 0);
    }
}
