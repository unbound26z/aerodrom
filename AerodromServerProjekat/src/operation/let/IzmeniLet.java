/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.let;

import domain.Let;
import operation.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class IzmeniLet extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Let) param);
    }

}
