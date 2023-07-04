/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Nikola
 */
public class Pilot implements GenericEntity {

    private Long pilotId;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private int radniStaz;

    public Pilot() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Pilot other = (Pilot) obj;
        if (this.pilotId != other.pilotId) {
            return false;
        }
        if (this.radniStaz != other.radniStaz) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.datumRodjenja, other.datumRodjenja);
    }

    @Override
    public String toString() {
        return "Pilot{" + "pilotId=" + pilotId + ", ime=" + ime + ", prezime=" + prezime + ", datumRodjenja=" + datumRodjenja + ", radniStaz=" + radniStaz + '}';
    }

    public Long getPilotId() {
        return pilotId;
    }

    public void setPilotId(Long pilotId) {
        this.pilotId = pilotId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public int getRadniStaz() {
        return radniStaz;
    }

    public void setRadniStaz(int radniStaz) {
        this.radniStaz = radniStaz;
    }

    public Pilot(Long pilotId, String ime, String prezime, Date datumRodjenja, int radniStaz) {
        this.pilotId = pilotId;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.radniStaz = radniStaz;
    }

    @Override
    public String getTableName() {
        return "pilot";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime, prezime, datumRodjenja, radniStaz";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(ime).append("', ")
                .append("'").append(prezime).append("', ")
                .append(datumRodjenja).append(", ")
                .append(radniStaz).append("'");

        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.pilotId = id;
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Pilot p = new Pilot();
            p.setPilotId(rs.getLong("p.pilotId"));
            p.setDatumRodjenja(rs.getDate("p.datumRodjenja"));
            p.setIme(rs.getString("p.ime"));
            p.setPrezime(rs.getString("p.getPrezime"));
            p.setRadniStaz(rs.getInt("p.radniStaz"));

            list.add(p);
        }
        return list;
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
        return "pilotId=" + pilotId;
    }

    @Override
    public String getSearchCase() {
        return "prezime LIKE '" + prezime + "%'";
    }
}
