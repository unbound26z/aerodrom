/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.form.components.table;

import domain.Avion;
import domain.StavkaRasporeda;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class StavkeTableModel extends AbstractTableModel {

    private List<StavkaRasporeda> stavke;
    private String[] columnNames = {"rBr", "rasporedId", "vreme", "letId"};

    public StavkeTableModel(List<StavkaRasporeda> stavke) {
        this.stavke = stavke;
    }

    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public void exist(String id, String rBr) throws Exception {
        for (StavkaRasporeda t : stavke) {
            //TODO: Proveri da li je u redu
            if (t.getRaspored() == Long.parseLong(id) && t.getrBr() == Long.parseLong(rBr)) {
                throw new Exception("Task with thid ID already exists");
            }
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

        switch (i1) {
            case 0:
                return stavke.get(i).getrBr();
            case 1:
                return stavke.get(i).getRaspored();
            case 2:
                return stavke.get(i).getVreme();
            case 3:
                return stavke.get(i).getLet().getMestoPolaska().getNazivDestinacije() + "-" + stavke.get(i).getLet().getDestinacija().getNazivDestinacije();

            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    public void dodajStavku(StavkaRasporeda t) {
        stavke.add(t);
        fireTableDataChanged();
    }

    public List<StavkaRasporeda> vratiStavke() {
        return stavke;
    }

    public StavkaRasporeda vratiStavkuNa(int row) {
        return stavke.get(row);
    }

}
