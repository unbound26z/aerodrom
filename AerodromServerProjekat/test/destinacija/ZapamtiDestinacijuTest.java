/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package destinacija;

import avion.ZapamtiAvionTest;
import domain.Avion;
import domain.Destinacija;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.avion.ZapamtiAvion;
import operation.destinacija.ZapamtiDestinaciju;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import repository.db.impl.RepositoryDbGeneric;

/**
 *
 * @author Nikola
 */
public class ZapamtiDestinacijuTest {

    private Destinacija d;
    ZapamtiDestinaciju so;

    @Before
    public void setUp() {
        d = new Destinacija(0, "Test", "Test");
        so = new ZapamtiDestinaciju();
    }

    @After
    public void tearDown() {
        so = null;
        d = null;

    }

    @Test
    public void testExecute() throws Exception {
        try {
            RepositoryDbGeneric repository = new RepositoryDbGeneric();

            int rezultat = repository.add(d);
            repository.commit();
            assertEquals(1, rezultat);
        } catch (Exception e) {
            Logger.getLogger(ZapamtiDestinacijuTest.class.getName()).log(Level.SEVERE, null, e);

        }

    }
}
