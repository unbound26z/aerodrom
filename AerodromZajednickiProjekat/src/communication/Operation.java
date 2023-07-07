/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Nikola
 */
public enum Operation implements Serializable {
    UCITAJ_LISTU_AVIONA,
    UCITAJ_LISTU_DESTINACIJA,
    UCITAJ_LISTU_LETOVA,
    UCITAJ_LISTU_PILOTA,
    UCITAJ_LISTU_RASPOREDA,
    ZAPAMTI_LET,
    NADJI_LETOVE,
    UCITAJ_LET,
    KREIRAJ_AVION,
    ZAPAMTI_AVION,
    NADJI_AVIONE,
    UCITAJ_AVION,
    KREIRAJ_DESTINACIJU,
    ZAPAMTI_DESTINACIJU,
    NADJI_DESTINACIJE,
    UCITAJ_DESTINACIJU,
    OBRISI_DESTINACIJU,
    ZAPAMTI_RASPORED,
    NADJI_RASPOREDE,
    NADJI_STAVKE,
    UCITAJ_RASPORED,
    LOGIN,
    LOGOUT,
    IZMENI_LET,
    IZMENI_RASPORED
}
