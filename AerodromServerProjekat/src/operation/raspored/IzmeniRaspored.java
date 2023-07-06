/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.raspored;

import domain.Let;
import domain.Raspored;
import operation.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class IzmeniRaspored extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Raspored) param);
    }
}
