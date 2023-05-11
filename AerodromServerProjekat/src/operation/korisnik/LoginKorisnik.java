/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.korisnik;

import domain.Korisnik;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class LoginKorisnik extends AbstractGenericOperation{

    Korisnik korisnik;
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        List<Korisnik> korisnici = repository.getAll((Korisnik) param);
        Korisnik k = (Korisnik) param;
        for(Korisnik korisnik : korisnici){
            if(korisnik.getEmail().equals(k.getEmail()) && korisnik.getSifra().equals(k.getSifra())){
                this.korisnik = korisnik;
                return;
            }
        }
        throw new Exception("Korisnik ne postoji!");
    }

    public Korisnik vratiKorisnika() {
        return korisnik;
    }
    
    
    
}
