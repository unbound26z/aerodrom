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
public class Raspored implements GenericEntity {

    private Long rasporedId;
    private Date datum;
    private List<StavkaRasporeda> stavke;

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
        final Raspored other = (Raspored) obj;
        if (this.rasporedId != other.rasporedId) {
            return false;
        }
        return Objects.equals(this.datum, other.datum);
    }

    @Override
    public String toString() {
        return "Raspored{" + "rasporedId=" + rasporedId + ", datum=" + datum + '}';
    }

    public Long getRasporedId() {
        return rasporedId;
    }

    public void setRasporedId(Long rasporedId) {
        this.rasporedId = rasporedId;
    }

    public Date getDatum() {
        return datum;
    }

    public List<StavkaRasporeda> getStavke() {
        return stavke;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Raspored() {
        this.stavke = new ArrayList<>();
    }

    public Raspored(Long rasporedId, Date datum) {
        this.rasporedId = rasporedId;
        this.datum = datum;
        this.stavke = new ArrayList<>();
    }

    public Raspored(Long rasporedId, Date datum, List<StavkaRasporeda> stavke) {
        this.rasporedId = rasporedId;
        this.datum = datum;
        this.stavke = stavke;
    }

    @Override
    public String getTableName() {
        return "raspored";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "datum";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(datum).append("");

        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.rasporedId = id;
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();

        while (rs.next()) {
            Raspored m = new Raspored();
            m.setId(rs.getLong("rasporedId"));
            m.setDatum(rs.getDate("datum"));

            list.add(m);
        }
        return list;
    }

    @Override
    public String getJoinCondition() {
        return "";
    }

    @Override
    public String getUpdateValues() {
        return "";
    }

    @Override
    public String getObjectCase() {
        return "rasporedId=" + rasporedId;
    }

    @Override
    public String getSearchCase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
