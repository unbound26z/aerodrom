/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package avion;

import domain.Avion;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.avion.ZapamtiAvion;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import repository.db.impl.RepositoryDbGeneric;

/**
 *
 * @author Nikola
 */
public class ZapamtiAvionTest {

    private Avion avion;
    ZapamtiAvion so;

    @Before
    public void setUp() {
        avion = new Avion(null, "TestAvion", 200, "Beograd", 2023, "Test kompanija");
        so = new ZapamtiAvion();
    }

    @After
    public void tearDown() {
        so = null;
        avion = null;

    }

    @Test
    public void testExecute() throws Exception {
        try {
            RepositoryDbGeneric repository = new RepositoryDbGeneric();

            int rezultat = repository.add(avion);
            repository.commit();
            assertEquals(1, rezultat);
        } catch (Exception e) {
            Logger.getLogger(ZapamtiAvionTest.class.getName()).log(Level.SEVERE, null, e);

        }

    }

}
