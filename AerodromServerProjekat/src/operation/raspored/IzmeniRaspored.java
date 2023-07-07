/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.raspored;

import domain.Let;
import domain.Raspored;
import domain.StavkaRasporeda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import operation.AbstractGenericOperation;
import repository.db.DbConnectionFactory;

/**
 *
 * @author Nikola
 */
public class IzmeniRaspored extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Raspored r = (Raspored) param;
        Connection connection = DbConnectionFactory.getInstance().getConnection();

        try {
            String q1 = "DELETE FROM stavkarasporeda WHERE rasporedId=?";
            PreparedStatement st1 = connection.prepareStatement(q1);
            st1.setLong(1, r.getRasporedId());
            System.out.println("Delete: " + st1);
            st1.executeUpdate();

            System.out.println("Izbirsane stare stavke");
            String querySt = "INSERT INTO stavkarasporeda (rBr, rasporedId, vreme, letId) VALUES (?, ?, ?, ?)";
            for (StavkaRasporeda st : r.getStavke()) {
                System.out.println("Nova stavka: " + st);
                PreparedStatement statementSt = connection.prepareStatement(querySt);
                statementSt.setLong(1, st.getrBr());
                statementSt.setLong(2, r.getRasporedId());
                statementSt.setString(3, st.getVreme());
                statementSt.setLong(4, st.getLet().getLetId());

                System.out.println("Insert: " + statementSt);
                statementSt.executeUpdate();
            }

            System.out.println("Dodate nove stavke");
            connection.commit();

            System.out.println("After commit");

        } catch (Exception e) {
            connection.rollback();
            throw new Error("Greska pri izmeni rasporeda " + e.getMessage());
        }
    }
}
