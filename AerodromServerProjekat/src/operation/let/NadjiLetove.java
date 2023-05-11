/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.let;

import domain.Avion;
import domain.Let;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class NadjiLetove extends AbstractGenericOperation{
    private List<Let> letovi;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        letovi = repository.search((Let) param);
    }
    
    
    public List<Let> vratiLetove() {
        return letovi;
    }
    
}
