/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Nikola
 */
public class StavkaRasporeda implements GenericEntity {

    private Long rBr;
    private Long rasporedId;
    private String vreme;
    private Let let;

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
        final StavkaRasporeda other = (StavkaRasporeda) obj;
        if (this.rBr != other.rBr) {
            return false;
        }
        if (this.rasporedId != other.rasporedId) {
            return false;
        }
        if (!Objects.equals(this.vreme, other.vreme)) {
            return false;
        }
        return Objects.equals(this.let, other.let);
    }

    @Override
    public String toString() {
        return "StavkaRasporeda{" + "rBr=" + rBr + ", raspored=" + rasporedId + ", vreme=" + vreme + ", let=" + let + '}';
    }

    public Long getrBr() {
        return rBr;
    }

    public void setrBr(Long rBr) {
        this.rBr = rBr;
    }

    public Long getRaspored() {
        return rasporedId;
    }

    public void setRaspored(Long raspored) {
        this.rasporedId = raspored;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public Let getLet() {
        return let;
    }

    public void setLet(Let let) {
        this.let = let;
    }

    public StavkaRasporeda() {
    }

    public StavkaRasporeda(Long rBr, Long raspored, String vreme, Let let) {
        this.rBr = rBr;
        this.rasporedId = raspored;
        this.vreme = vreme;
        this.let = let;
    }

    @Override
    public String getTableName() {
        return "stavkarasporeda";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "rasporedId, vreme, let";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(rasporedId).append("', ")
                .append("'").append(vreme).append("', ")
                .append(let).append("'");

        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            StavkaRasporeda s = new StavkaRasporeda();
            s.setrBr(rs.getLong("s.rBr"));
            s.setRaspored(rs.getLong("s.rasporedId"));
            s.setVreme(rs.getString("s.vreme"));

            Let l = new Let();
            l.setLetId(rs.getLong("l.letId"));

            s.setLet(l);

            list.add(s);
        }
        return list;
    }

    @Override
    public String getJoinCondition() {
        return "s LEFT JOIN let l ON (s.letId=l.letId)";
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
