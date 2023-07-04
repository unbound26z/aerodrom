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
public class Avion implements GenericEntity {

    private Long avionId;
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

    public Long getAvionId() {
        return avionId;
    }

    public void setAvionId(Long avionId) {
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

    public Avion(Long avionId, String nazivAviona, int brojSedista, String mestoProizvodnje, int godinaProizvodnje, String aviokompanija) {
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
        return "nazivAviona, brojSedista, mestoProizvodnje, godinaProizvodnje, aviokompanija";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(nazivAviona).append("', ")
                .append("'").append(brojSedista).append("', ")
                .append(mestoProizvodnje).append(", ")
                .append(godinaProizvodnje).append(", ")
                .append(aviokompanija);

        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Avion m = new Avion();
            m.setAvionId(rs.getLong("m.avionId"));
            m.setBrojSedista(rs.getInt("m.brojSedista"));
            m.setGodinaProizvodnje(rs.getInt("m.godinaProizvodnje"));
            m.setMestoProizvodnje("m.mestoProizvodnje");
            m.setNazivAviona(rs.getString("m.nazivAviona"));
            m.setAviokompanija(rs.getString("m.aviokompanija"));

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
        StringBuilder sb = new StringBuilder();

        sb.append("nazivAviona=").append("'").append(nazivAviona).append("', ")
                .append("brojSedista=").append("'").append(brojSedista).append("', ")
                .append("mestoProizvodnje=").append(mestoProizvodnje).append(", ")
                .append("godinaProizvodnje=").append(godinaProizvodnje).append(", ")
                .append("aviokompanija=").append(aviokompanija);

        return sb.toString();
    }

    @Override
    public String getObjectCase() {
        return "avionId=" + avionId;
    }

    @Override
    public String getSearchCase() {
        return "nazivAviona LIKE '" + nazivAviona + "%'";
    }

}
