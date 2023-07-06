/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.raspored;

import domain.Destinacija;
import domain.Raspored;
import java.sql.Connection;
import domain.StavkaRasporeda;
import java.util.List;
import operation.AbstractGenericOperation;
import repository.db.DbConnectionFactory;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Date;

/**
 *
 * @author Nikola
 */
public class ZapamtiRaspored extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Raspored)) {
            throw new Exception("Neodgovarajuci podaci o rasporedu!");

        }
        List<Raspored> rasporedi = repository.getAll(new Raspored());
        for (Raspored r : rasporedi) {
            if (r.getRasporedId() == ((Raspored) param).getRasporedId()) {
                throw new Exception("Vec postoji ova raspored!");
            }
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {

        Raspored r = (Raspored) param;
        Connection connection = DbConnectionFactory.getInstance().getConnection();

        try {

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ").append("raspored")
                    .append(" (")
                    .append("datum")
                    .append(") ")
                    .append(" VALUES (")
                    .append("?")
                    .append(") ");
            String query = sb.toString();
            System.out.println(query);
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setDate(1, new java.sql.Date(r.getDatum().getTime()));
            statement.executeUpdate();
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                r.setId(id);
            }
            statement.close();
            rsKey.close();

            String querySt = "INSERT INTO stavkarasporeda (rBr, rasporedId, vreme, letId) VALUES (?, ?, ?, ?)";
            for (StavkaRasporeda st : r.getStavke()) {
                System.out.println(st);
                PreparedStatement statementSt = connection.prepareStatement(querySt);
                System.out.println("MAJSTOREE");
                statementSt.setLong(1, st.getrBr());
                statementSt.setLong(2, r.getRasporedId());
                statementSt.setString(3, st.getVreme());
                statementSt.setLong(4, st.getLet().getLetId());
                statementSt.executeUpdate();
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw new Error("Greska pri kreiranju rasporeda " + e.getMessage());
        }
    }
}
