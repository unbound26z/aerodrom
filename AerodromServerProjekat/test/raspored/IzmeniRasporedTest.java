/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package raspored;

import avion.ZapamtiAvionTest;
import domain.Avion;
import domain.Destinacija;
import domain.Let;
import domain.Pilot;
import domain.Raspored;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.let.IzmeniLet;
import operation.raspored.IzmeniRaspored;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import repository.db.impl.RepositoryDbGeneric;

/**
 *
 * @author Nikola
 */
public class IzmeniRasporedTest {

    private Raspored objekat;
    IzmeniRaspored so;

    @Before
    public void setUp() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

        objekat = new Raspored();
        objekat.setRasporedId(123L);
        try {
            objekat.setDatum(sdf.parse(String.valueOf("12.01.2023.")));

        } catch (Exception e) {
            System.out.println(e);
        }

        so = new IzmeniRaspored();
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

            so.execute(objekat);
            repository.commit();
        } catch (Exception e) {
            Logger.getLogger(IzmeniRasporedTest.class.getName()).log(Level.SEVERE, null, e);

        }

    }
}
