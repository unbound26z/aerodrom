/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.form.components.table;

import domain.Avion;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nikola
 */
public class AvionTableModel extends AbstractTableModel {

    private List<Avion> avioni;
    private String[] columnNames = {"ID", "Naziv", "Broj sedista", "Mesto proizvodnje", "Godina proizvodnje", "Aviokompanija"};

    public AvionTableModel(List<Avion> avioni) {
        this.avioni = avioni;
    }

    @Override
    public int getRowCount() {
        return avioni.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public void exist(String id) throws Exception {
        for (Avion t : avioni) {
            //TODO: Proveri da li je u redu
            if (t.getAvionId() == Long.parseLong(id)) {
                throw new Exception("Task with thid ID already exists");
            }
        }
    }

    public void obrisiAvion(Avion a) {
        Avion avion = new Avion();
        for (Avion aa : avioni) {
            if (aa.getAvionId() == a.getAvionId()) {
                avion = aa;
            }
        }
        avioni.remove(avion);
        fireTableDataChanged();

    }
    
     @Override
    public Object getValueAt(int i, int i1) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
       
        
        switch(i1){
            case 0: return avioni.get(i).getAvionId();
            case 1: return avioni.get(i).getNazivAviona();
            case 2: return avioni.get(i).getBrojSedista();
            case 3: return avioni.get(i).getMestoProizvodnje();
            case 4: return avioni.get(i).getGodinaProizvodnje();
            case 5: return avioni.get(i).getAviokompanija();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }
    
    public void addTask(Avion t){
        avioni.add(t);
        fireTableDataChanged();
    }

    public List<Avion> getTasks() {
        return avioni;
    }
    

    public Avion getAvionAt(int row) {
        return avioni.get(row);
    }

}
