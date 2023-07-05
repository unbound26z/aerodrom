/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pilot;

import domain.Avion;
import domain.Pilot;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class UcitajListuPilota extends AbstractGenericOperation {

    private List<Pilot> piloti;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        piloti = repository.getAll((Pilot) param);
    }

    public List<Pilot> vratiListuPilota() {
        return piloti;
    }

}
