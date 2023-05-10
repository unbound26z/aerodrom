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
public class UcitajListuDestinacija extends AbstractGenericOperation{
     private List<Destinacija> destinacije;

    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        destinacije = repository.getAll((Destinacija)param);
    }
    
     public List<Destinacija> vratiListuDestinacija() {
        return destinacije;
    }
    
    
    
}
