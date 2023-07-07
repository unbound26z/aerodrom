/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.stavkaRasporeda;

import domain.Raspored;
import domain.StavkaRasporeda;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class NadjiStavke extends AbstractGenericOperation {

    private List<StavkaRasporeda> stavke;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        stavke = repository.search((StavkaRasporeda) param);
    }

    public List<StavkaRasporeda> vratiStavke() {
        return stavke;
    }
}
