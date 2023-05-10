/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Nikola
 */
public class Let implements GenericEntity{
    private int letId;
    private int trajanje;
    private int cena;
    private String mestoPolaska;
    private Avion avion;
    private Destinacija destinacija;
    private Pilot pilot;

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
        final Let other = (Let) obj;
        if (this.letId != other.letId) {
            return false;
        }
        if (this.trajanje != other.trajanje) {
            return false;
        }
        if (this.cena != other.cena) {
            return false;
        }
        if (!Objects.equals(this.mestoPolaska, other.mestoPolaska)) {
            return false;
        }
        if (!Objects.equals(this.avion, other.avion)) {
            return false;
        }
        if (!Objects.equals(this.destinacija, other.destinacija)) {
            return false;
        }
        return Objects.equals(this.pilot, other.pilot);
    }

    @Override
    public String toString() {
        return "Let{" + "letId=" + letId + ", trajanje=" + trajanje + ", cena=" + cena + ", mestoPolaska=" + mestoPolaska + ", avion=" + avion + ", destinacija=" + destinacija + ", pilot=" + pilot + '}';
    }

    public int getLetId() {
        return letId;
    }

    public void setLetId(int letId) {
        this.letId = letId;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getMestoPolaska() {
        return mestoPolaska;
    }

    public void setMestoPolaska(String mestoPolaska) {
        this.mestoPolaska = mestoPolaska;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Destinacija getDestinacija() {
        return destinacija;
    }

    public void setDestinacija(Destinacija destinacija) {
        this.destinacija = destinacija;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Let(int letId, int trajanje, int cena, String mestoPolaska, Avion avion, Destinacija destinacija, Pilot pilot) {
        this.letId = letId;
        this.trajanje = trajanje;
        this.cena = cena;
        this.mestoPolaska = mestoPolaska;
        this.avion = avion;
        this.destinacija = destinacija;
        this.pilot = pilot;
    }

    public Let() {
    }

    @Override
    public String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
