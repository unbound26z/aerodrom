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
public class Avion implements GenericEntity {

    private int avionId;
    private String nazivAviona;
    private int brojSedista;
    private String mestoProizvodnje;
    private int godinaProizvodnje;
    private String aviokompanija;

    @Override
    public String toString() {
        return "Airplane{" + "avionId=" + avionId + ", nazivAviona=" + nazivAviona + ", brojSedista=" + brojSedista + ", mestoProizvodnje=" + mestoProizvodnje + ", godinaProizvodnje=" + godinaProizvodnje + ", aviokompanija=" + aviokompanija + '}';
    }

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
        final Avion other = (Avion) obj;
        if (this.avionId != other.avionId) {
            return false;
        }
        if (this.brojSedista != other.brojSedista) {
            return false;
        }
        if (this.godinaProizvodnje != other.godinaProizvodnje) {
            return false;
        }
        if (!Objects.equals(this.nazivAviona, other.nazivAviona)) {
            return false;
        }
        if (!Objects.equals(this.mestoProizvodnje, other.mestoProizvodnje)) {
            return false;
        }
        return Objects.equals(this.aviokompanija, other.aviokompanija);
    }

    public int getAvionId() {
        return avionId;
    }

    public void setAvionId(int avionId) {
        this.avionId = avionId;
    }

    public String getNazivAviona() {
        return nazivAviona;
    }

    public void setNazivAviona(String nazivAviona) {
        this.nazivAviona = nazivAviona;
    }

    public int getBrojSedista() {
        return brojSedista;
    }

    public void setBrojSedista(int brojSedista) {
        this.brojSedista = brojSedista;
    }

    public String getMestoProizvodnje() {
        return mestoProizvodnje;
    }

    public void setMestoProizvodnje(String mestoProizvodnje) {
        this.mestoProizvodnje = mestoProizvodnje;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public String getAviokompanija() {
        return aviokompanija;
    }

    public void setAviokompanija(String aviokompanija) {
        this.aviokompanija = aviokompanija;
    }

    public Avion() {
    }

    public Avion(int avionId, String nazivAviona, int brojSedista, String mestoProizvodnje, int godinaProizvodnje, String aviokompanija) {
        this.avionId = avionId;
        this.nazivAviona = nazivAviona;
        this.brojSedista = brojSedista;
        this.mestoProizvodnje = mestoProizvodnje;
        this.godinaProizvodnje = godinaProizvodnje;
        this.aviokompanija = aviokompanija;
    }

    @Override
    public String getTableName() {
        return "avion";
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
