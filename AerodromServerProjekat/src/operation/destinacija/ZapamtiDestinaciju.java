/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.destinacija;

import domain.Destinacija;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class ZapamtiDestinaciju extends AbstractGenericOperation {
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Destinacija)) {
            throw new Exception("Neodgovarajuci podaci o destinaciji!");

        }
        List<Destinacija> destinacije = repository.getAll(new Destinacija());
        for (Destinacija d : destinacije) {
            if (d.getDestinacijaId()== ((Destinacija) param).getDestinacijaId()) {
                throw new Exception("Vec postoji ova destinacija!");
            }
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Destinacija) param);
    }
}
