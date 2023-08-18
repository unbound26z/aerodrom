/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package let;

import avion.ZapamtiAvionTest;
import domain.Avion;
import domain.Destinacija;
import domain.Let;
import domain.Pilot;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ZapamtiLetTest {

    private Let d;
    ZapamtiDestinaciju so;

    @Before
    public void setUp() {
        d = new Let(0L, 130, 13000, new Destinacija(123, "", ""), new Avion(123L, "", 0, "", 0, ""), new Destinacija(123, "", ""), new Pilot(123L, "", "", null, 0));
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
            Logger.getLogger(ZapamtiLetTest.class.getName()).log(Level.SEVERE, null, e);

        }

    }
}
