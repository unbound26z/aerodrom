/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Nikola
 */
public class Destinacija implements GenericEntity {

    private long destinacijaId;
    private String nazivDestinacije;
    private String drzava;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Destinacija other = (Destinacija) obj;
        if (this.destinacijaId != other.destinacijaId) {
            return false;
        }
        if (!Objects.equals(this.nazivDestinacije, other.nazivDestinacije)) {
            return false;
        }
        return Objects.equals(this.drzava, other.drzava);
    }

    @Override
    public String toString() {
        return "Destinacija{" + "destinacijaId=" + destinacijaId + ", nazivDestinacije=" + nazivDestinacije + ", drzava=" + drzava + '}';
    }

    public long getDestinacijaId() {
        return destinacijaId;
    }

    public void setDestinacijaId(long destinacijaId) {
        this.destinacijaId = destinacijaId;
    }

    public String getNazivDestinacije() {
        return nazivDestinacije;
    }

    public void setNazivDestinacije(String nazivDestinacije) {
        this.nazivDestinacije = nazivDestinacije;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public Destinacija(int destinacijaId, String nazivDestinacije, String drzava) {
        this.destinacijaId = destinacijaId;
        this.nazivDestinacije = nazivDestinacije;
        this.drzava = drzava;
    }

    public Destinacija() {
    }

    @Override
    public String getTableName() {
        return "destinacija";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();
        while (rs.next()) {
            Destinacija k = new Destinacija();
            k.setDestinacijaId(rs.getLong("id"));
            k.setDrzava(rs.getString("drzava"));
            k.setNazivDestinacije(rs.getString("nazivDestinacije"));
            lista.add(k);
        }

        return lista;
    }

    @Override
    public String getJoinCondition() {
        return "";
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getObjectCase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSearchCase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
