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
public class UcitajListuAviona extends AbstractGenericOperation{
    private List<Avion> avioni;

    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        avioni = repository.getAll((Avion)param);
    }
    
     public List<Avion> vratiListuAviona() {
        return avioni;
    }
    
    
    
}
