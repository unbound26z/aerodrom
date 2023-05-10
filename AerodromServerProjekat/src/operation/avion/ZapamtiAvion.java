/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.avion;

import domain.Avion;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class ZapamtiAvion extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Avion)) {
            throw new Exception("Neodgovarajuci podaci o avionu!");

        }
        List<Avion> avioni = repository.getAll(new Avion());
        for (Avion a : avioni) {
            if (a.getAvionId() == ((Avion) param).getAvionId()) {
                throw new Exception("Vec postoji ovaj avion!");
            }
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Avion) param);
    }

}
