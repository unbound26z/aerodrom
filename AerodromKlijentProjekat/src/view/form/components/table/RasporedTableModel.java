/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.form.components.table;

import domain.Avion;
import domain.Raspored;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class RasporedTableModel extends AbstractTableModel {

    private List<Raspored> rasporedi;
    private String[] columnNames = {"ID", "Datum"};

    public RasporedTableModel(List<Raspored> rasporedi) {
        this.rasporedi = rasporedi;
    }

    @Override
    public int getRowCount() {
        return rasporedi.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public void exist(String id) throws Exception {
        for (Raspored t : rasporedi) {
            //TODO: Proveri da li je u redu
            if (t.getRasporedId() == Long.parseLong(id)) {
                throw new Exception("Raspored sa ovim ID vec postoji");
            }
        }
    }

    public void obrisiAvion(Raspored a) {
        Raspored raspored = new Raspored();
        for (Raspored aa : rasporedi) {
            if (aa.getRasporedId() == a.getRasporedId()) {
                raspored = aa;
            }
        }
        rasporedi.remove(raspored);
        fireTableDataChanged();

    }

    @Override
    public Object getValueAt(int i, int i1) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

        switch (i1) {
            case 0:
                return rasporedi.get(i).getRasporedId();
            case 1:
                if (rasporedi.get(i).getDatum() != null) {
                    return sdf.format(rasporedi.get(i).getDatum());
                } else {
                    return "";
                }
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    public void vrati(Raspored t) {
        rasporedi.add(t);
        fireTableDataChanged();
    }

    public List<Raspored> vrati() {
        return rasporedi;
    }

    public Raspored vratiRasporedNa(int row) {
        return rasporedi.get(row);
    }
}
