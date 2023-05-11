/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.raspored;

import domain.Destinacija;
import domain.Raspored;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class ZapamtiRaspored extends AbstractGenericOperation{
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Raspored)) {
            throw new Exception("Neodgovarajuci podaci o rasporedu!");

        }
        List<Raspored> rasporedi = repository.getAll(new Raspored());
        for (Raspored r : rasporedi) {
            if (r.getRasporedId()== ((Raspored) param).getRasporedId()) {
                throw new Exception("Vec postoji ova raspored!");
            }
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Raspored) param);
    }
}
