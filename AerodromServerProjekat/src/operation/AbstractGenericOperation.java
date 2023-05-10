/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation;

import repository.Repository;
import repository.db.DbRepository;
import repository.db.impl.RepositoryDbGeneric;

/**
 *
 * @author Nikola
 */
public abstract class AbstractGenericOperation {
    //opsta sistemska operacija
    protected final Repository repository;
    

    public AbstractGenericOperation() {
        this.repository = new RepositoryDbGeneric();
    }
    

    public final void execute(Object param) throws Exception{
        try{
            preconditions(param);
            startTransaction();
            executeOperation(param);
            commitTransaction();
        }catch(Exception e){
            e.printStackTrace();
            rollbackTransaction();
            throw e;
        }finally{
            disconnect();
        }
    }

    protected abstract void preconditions(Object param) throws Exception;
    
    private void startTransaction() throws Exception {
        ((DbRepository)repository).connect();
    }

    protected abstract void executeOperation(Object param) throws Exception;

    private void commitTransaction() throws Exception {
        ((DbRepository)repository).commit();
    }

    private void rollbackTransaction() throws Exception {
        ((DbRepository)repository).rollback();
    }

    private void disconnect() throws Exception {
        ((DbRepository)repository).disconnect();
    }
    
}
