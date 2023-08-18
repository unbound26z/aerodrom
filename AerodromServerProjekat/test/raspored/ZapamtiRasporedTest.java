/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package raspored;

import avion.ZapamtiAvionTest;
import domain.Avion;
import domain.Raspored;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.avion.ZapamtiAvion;
import operation.raspored.ZapamtiRaspored;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import repository.db.impl.RepositoryDbGeneric;

/**
 *
 * @author Nikola
 */
public class ZapamtiRasporedTest {

    private Raspored raspored;
    ZapamtiRaspored so;

    @Before
    public void setUp() {
        raspored = new Raspored();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

        raspored = new Raspored();
        try {
            raspored.setDatum(sdf.parse(String.valueOf("11.11.1111.")));

        } catch (Exception e) {
            System.out.println(e);
        }
        so = new ZapamtiRaspored();
    }

    @After
    public void tearDown() {
        so = null;
        raspored = null;

    }

    @Test
    public void testExecute() throws Exception {
        try {
            RepositoryDbGeneric repository = new RepositoryDbGeneric();

            so.execute(raspored);
            repository.commit();
        } catch (Exception e) {
            Logger.getLogger(ZapamtiRasporedTest.class.getName()).log(Level.SEVERE, null, e);

        }

    }
}
