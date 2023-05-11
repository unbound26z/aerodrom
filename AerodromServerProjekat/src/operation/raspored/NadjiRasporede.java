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
public class NadjiRasporede extends AbstractGenericOperation{
    private List<Raspored> rasporedi;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        rasporedi = repository.search((Raspored) param);
    }
    
    
    public List<Raspored> vratiRasporede() {
        return rasporedi;
    }
    
}
