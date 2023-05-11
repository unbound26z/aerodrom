/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.let;

import domain.Let;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class ZapamtiLet extends AbstractGenericOperation{
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Let)) {
            throw new Exception("Neodgovarajuci podaci o letu!");

        }
        List<Let> letovi = repository.getAll(new Let());
        for (Let l : letovi) {
            if (l.getLetId() == ((Let) param).getLetId()) {
                throw new Exception("Vec postoji ovaj let!");
            }
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Let) param);
    }
}
