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
import operation.let.IzmeniLet;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import repository.db.impl.RepositoryDbGeneric;

/**
 *
 * @author Nikola
 */
public class IzmeniLetTest {

    private Let objekat;
    IzmeniLet so;

    @Before
    public void setUp() {
        objekat = new Let(123L, 0, 0, new Destinacija(123, "", ""), new Avion(123L, "", 0, "", 0, ""), new Destinacija(123, "", ""), new Pilot(123L, "", "", null, 0));
        so = new IzmeniLet();
    }

    @After
    public void tearDown() {
        so = null;
        objekat = null;

    }

    @Test
    public void testExecute() throws Exception {
        try {
            RepositoryDbGeneric repository = new RepositoryDbGeneric();

            int rezultat = repository.edit(objekat);
            repository.commit();
            assertEquals(1, rezultat);
        } catch (Exception e) {
            Logger.getLogger(ZapamtiAvionTest.class.getName()).log(Level.SEVERE, null, e);

        }

    }
}
