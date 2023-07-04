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
public class StatistikaPilota implements GenericEntity {
    
    private Let let;
    private Pilot pilot;
    private int brojLetova;
    
    @Override
    public int hashCode() {
        int hash = 5;
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
        final StatistikaPilota other = (StatistikaPilota) obj;
        if (this.brojLetova != other.brojLetova) {
            return false;
        }
        if (!Objects.equals(this.let, other.let)) {
            return false;
        }
        return Objects.equals(this.pilot, other.pilot);
    }
    
    @Override
    public String toString() {
        return "StatistikaPilota{" + "let=" + let + ", pilot=" + pilot + ", brojLetova=" + brojLetova + '}';
    }
    
    public Let getLet() {
        return let;
    }
    
    public void setLet(Let let) {
        this.let = let;
    }
    
    public Pilot getPilot() {
        return pilot;
    }
    
    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }
    
    public int getBrojLetova() {
        return brojLetova;
    }
    
    public void setBrojLetova(int brojLetova) {
        this.brojLetova = brojLetova;
    }
    
    public StatistikaPilota() {
    }
    
    public StatistikaPilota(Let let, Pilot pilot, int brojLetova) {
        this.let = let;
        this.pilot = pilot;
        this.brojLetova = brojLetova;
    }
    
    @Override
    public String getTableName() {
        return "statistikapilota";
    }
    
    @Override
    public String getColumnNamesForInsert() {
        return "pilotId, letId, brojLetova";
    }
    
    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(pilot.getPilotId()).append("', ")
                .append("'").append(let.getLetId()).append("', ")
                .append(brojLetova);
        
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
            StatistikaPilota s = new StatistikaPilota();
            
            Let l = new Let();
            Pilot p = new Pilot();
            
            Avion a = new Avion();
            Destinacija d = new Destinacija();
            Destinacija m = new Destinacija();
            
            m.setDestinacijaId(rs.getLong("m.destinacijaId"));
            m.setDrzava(rs.getString("m.drzava"));
            m.setNazivDestinacije(rs.getString("m.nazivDestinacije"));
            m.setDestinacijaId(rs.getLong("d.destinacijaId"));
            m.setDrzava(rs.getString("d.drzava"));
            m.setNazivDestinacije(rs.getString("d.nazivDestinacije"));
            
            a.setAvionId(rs.getLong("a.avionId"));
            a.setBrojSedista(rs.getInt("a.brojSedista"));
            a.setGodinaProizvodnje(rs.getInt("a.godinaProizvodnje"));
            a.setMestoProizvodnje("a.mestoProizvodnje");
            a.setNazivAviona(rs.getString("a.nazivAviona"));
            a.setAviokompanija(rs.getString("a.aviokompanija"));
            
            p.setPilotId(rs.getLong("p.pilotId"));
            p.setDatumRodjenja(rs.getDate("p.datumRodjenja"));
            p.setIme(rs.getString("p.ime"));
            p.setPrezime(rs.getString("p.getPrezime"));
            p.setRadniStaz(rs.getInt("p.radniStaz"));
            
            l.setPilot(p);
            l.setMestoPolaska(m);
            l.setDestinacija(d);
            l.setAvion(a);
            l.setCena(rs.getInt("l.cena"));
            l.setLetId(rs.getLong("l.letId"));
            l.setTrajanje(rs.getInt("l.trajanje"));
            
            s.setLet(l);
            s.setBrojLetova(rs.getInt("s.brojLetova"));
            s.setPilot(p);
            
            list.add(p);
        }
        return list;
    }
    
    @Override
    public String getJoinCondition() {
        return "s LEFT JOIN let l ON (s.letId=l.letId) LEFT JOIN pilot p ON (s.pilotId=p.pilotId) LEFT JOIN destinacija d ON (l.destinacijaId=d.destinacijaId) LEFT JOIN destinacija m ON (l.mestoPolaska=m.destinacijaId)";
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
