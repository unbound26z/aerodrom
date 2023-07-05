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
public class Let implements GenericEntity {

    private Long letId;
    private int trajanje;
    private int cena;
    private Destinacija mestoPolaska;
    private Destinacija destinacija;
    private Avion avion;
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

    public Long getLetId() {
        return letId;
    }

    public void setLetId(Long letId) {
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

    public Destinacija getMestoPolaska() {
        return mestoPolaska;
    }

    public void setMestoPolaska(Destinacija mestoPolaska) {
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

    public Let(Long letId, int trajanje, int cena, Destinacija mestoPolaska, Avion avion, Destinacija destinacija, Pilot pilot) {
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
        return "let";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "trajanje, cena, mestoPolaska, avionId, destinacijaId, pilotId";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(trajanje).append(", ")
                .append("").append(cena).append(", ")
                .append("").append(mestoPolaska.getDestinacijaId()).append(", ")
                .append(avion.getAvionId()).append(", ")
                .append(destinacija.getDestinacijaId()).append(", ")
                .append(pilot.getPilotId());

        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.letId = id;
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Let t = new Let();
            t.setId(rs.getLong("l.letId"));
            Pilot p = new Pilot();
            Avion a = new Avion();
            Destinacija d = new Destinacija();
            Destinacija z = new Destinacija();

            p.setPilotId(rs.getLong("p.pilotId"));
            p.setDatumRodjenja(rs.getDate("p.datumRodjenja"));
            p.setIme(rs.getString("p.ime"));
            p.setPrezime(rs.getString("p.prezime"));
            p.setRadniStaz(rs.getInt("p.radniStaz"));

            a.setAvionId(rs.getLong("a.avionId"));
            a.setAviokompanija(rs.getString("a.aviokompanija"));
            a.setBrojSedista(rs.getInt("a.brojSedista"));
            a.setGodinaProizvodnje(rs.getInt("a.godinaProizvodnje"));
            a.setMestoProizvodnje(rs.getString("a.mestoProizvodnje"));
            a.setNazivAviona(rs.getString("a.nazivAviona"));

            d.setDestinacijaId(rs.getLong("d.destinacijaId"));
            d.setDrzava(rs.getString("d.drzava"));
            d.setNazivDestinacije(rs.getString("d.nazivDestinacije"));

            z.setDestinacijaId(rs.getLong("z.destinacijaId"));
            z.setDrzava(rs.getString("z.drzava"));
            z.setNazivDestinacije(rs.getString("z.nazivDestinacije"));

            t.setDestinacija(d);
            t.setAvion(a);
            t.setPilot(p);
            t.setMestoPolaska(z);

            t.setCena(rs.getInt("l.cena"));
            t.setLetId(rs.getLong("l.letId"));
            t.setTrajanje(rs.getInt("l.trajanje"));

            list.add(t);
        }
        return list;
    }

    @Override
    public String getJoinCondition() {
        return "l LEFT JOIN avion a ON (l.avionId=a.avionId) LEFT JOIN pilot p ON (l.pilotId=p.pilotId) LEFT JOIN destinacija z ON (l.mestoPolaska=z.destinacijaId) LEFT JOIN destinacija d ON (l.destinacijaId=d.destinacijaId)";
    }

    @Override
    public String getUpdateValues() {
        StringBuilder sb = new StringBuilder();

        sb.append("trajanje=").append("'").append(trajanje).append("', ")
                .append("cena=").append("'").append(cena).append("', ")
                .append("mestoPolaska=").append("'").append(mestoPolaska.getDestinacijaId()).append("', ")
                .append("destinacija=").append(destinacija.getDestinacijaId()).append(", ")
                .append("avion=").append(avion.getAvionId()).append(", ")
                .append("pilot=").append(pilot.getPilotId());

        return sb.toString();
    }

    @Override
    public String getObjectCase() {
        return "letId=" + letId;
    }

    @Override
    public String getSearchCase() {

        return "cena BETWEEN 0 AND '" + cena + "'";

    }

}
