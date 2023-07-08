/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.form.components.table;

import domain.Avion;
import domain.Destinacija;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class DestinacijaTableModel extends AbstractTableModel {

    private List<Destinacija> destinacije;
    private String[] columnNames = {"ID", "Naziv", "Drzava"};

    public DestinacijaTableModel(List<Destinacija> destinacije) {
        this.destinacije = destinacije;
    }

    @Override
    public int getRowCount() {
        return destinacije.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public void exist(String id) throws Exception {
        for (Destinacija t : destinacije) {
            //TODO: Proveri da li je u redu
            if (t.getDestinacijaId() == Long.parseLong(id)) {
                throw new Exception("Destinacija sa ovim ID vec postoji");
            }
        }
    }

    public void obrisiDestinaciju(Destinacija a) {
        Destinacija destinacija = new Destinacija();
        for (Destinacija aa : destinacije) {
            if (aa.getDestinacijaId() == a.getDestinacijaId()) {
                destinacija = aa;
            }
        }
        destinacije.remove(destinacija);
        fireTableDataChanged();

    }

    @Override
    public Object getValueAt(int i, int i1) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

        switch (i1) {
            case 0:
                return destinacije.get(i).getDestinacijaId();
            case 1:
                return destinacije.get(i).getNazivDestinacije();
            case 2:
                return destinacije.get(i).getDrzava();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    public void dodaj(Destinacija t) {
        destinacije.add(t);
        fireTableDataChanged();
    }

    public List<Destinacija> vrati() {
        return destinacije;
    }

    public Destinacija vratiDestinacijuNa(int row) {
        return destinacije.get(row);
    }
}
