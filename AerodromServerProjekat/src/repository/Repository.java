/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Nikola
 */
public interface Repository<T> {
    void add(T param) throws Exception;
    List<T> getAll(T param) throws Exception;
    List<T> getAllBy(T param, String field, String value) throws Exception;
    void edit(T param) throws Exception;
    void delete(T param) throws Exception;
    List<T> search(T param) throws Exception;
    
    
}
