/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package avion;

import domain.Avion;
import java.util.List;
import operation.avion.NadjiAvione;
import operation.avion.UcitajListuAviona;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nikola
 */
public class UcitajListuAvionaTest {
    
    private UcitajListuAviona so;

    @Before
    public void setUp() {
         so=new UcitajListuAviona();
    }
    
    @org.junit.Test
    public void testExecute() throws Exception {
        so.execute(new Avion());
        List<Avion> lista=so.vratiListuAviona();   
        assertEquals(true, lista.size() > 0);
    }
}
