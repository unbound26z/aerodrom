/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.form.components.table;

import domain.Destinacija;
import domain.Let;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class LetTableModel extends AbstractTableModel {

    private List<Let> letovi;
    private String[] columnNames = {"ID", "Trajanje", "Cena", "Mesto polaska"};

    public LetTableModel(List<Let> letovi) {
        this.letovi = letovi;
    }

    @Override
    public int getRowCount() {
        return letovi.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public void exist(String id) throws Exception {
        for (Let t : letovi) {
            //TODO: Proveri da li je u redu
            if (t.getLetId() == Long.parseLong(id)) {
                throw new Exception("Task with thid ID already exists");
            }
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

        switch (i1) {
            case 0:
                return letovi.get(i).getLetId();
            case 1:
                return letovi.get(i).getTrajanje();
            case 2:
                return letovi.get(i).getCena();
            case 3:
                return letovi.get(i).getMestoPolaska();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    public void dodaj(Let t) {
        letovi.add(t);
        fireTableDataChanged();
    }

    public List<Let> vrati() {
        return letovi;
    }

    public Let vratiLetNa(int row) {
        return letovi.get(row);
    }
}
