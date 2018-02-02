/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Olek
 */
@Entity
@Table(name = "klient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klient.findAll", query = "SELECT k FROM Klient k")
    , @NamedQuery(name = "Klient.findByKid", query = "SELECT k FROM Klient k WHERE k.kid = :kid")

})
public class Klient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kid")
    private Long kid;

    @Size(max = 255)
    @Column(name = "imie")
    private String imie;

    @Size(max = 255)
    @Column(name = "nazwisko")
    private String nazwisko;

    @Size(max = 255)
    @Column(name = "kontakt")
    private String kontakt;

    @Size(max = 255)
    @Column(name = "adres")
    private String adres;

    @OneToMany(mappedBy = "klient")
    private List<Sprzedaz> sprzedaze;

    @OneToMany(mappedBy = "klient")
    private List<Serwis> serwises;

    public Klient() {
    }

    public List<Serwis> getSerwises() {
        return serwises;
    }

    public void setSerwises(List<Serwis> serwises) {
        this.serwises = serwises;
    }

    public List<Sprzedaz> getSprzedaze() {
        return sprzedaze;
    }

    public void setSprzedaze(List<Sprzedaz> sprzedaze) {
        this.sprzedaze = sprzedaze;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Long getKid() {
        return kid;
    }

    public void setKid(Long kid) {
        this.kid = kid;
    }

    public Long getId() {
        return kid;
    }

    public void setId(Long id) {
        this.kid = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kid != null ? kid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the kid fields are not set
        if (!(object instanceof Klient)) {
            return false;
        }
        Klient other = (Klient) object;
        if ((this.kid == null && other.kid != null) || (this.kid != null && !this.kid.equals(other.kid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Klient[ id=" + kid + " ]";
    }

}
