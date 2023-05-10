/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author Nikola
 */
public interface GenericEntity extends Serializable {
    
    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();

    void setId(Long id);

    List<GenericEntity> getList(ResultSet rs) throws Exception;

    String getJoinCondition();

    String getUpdateValues();

    String getObjectCase();

    String getSearchCase();
    
}
