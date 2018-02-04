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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukasz
 */
@Entity
@Table(name = "magazyn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Magazyn.findAll", query = "SELECT m FROM Magazyn m")
    , @NamedQuery(name = "Magazyn.findByMid", query = "SELECT m FROM Magazyn m WHERE m.mid = :mid")
    , @NamedQuery(name = "Magazyn.findByAdres", query = "SELECT m FROM Magazyn m WHERE m.adres = :adres")
    , @NamedQuery(name = "Magazyn.findByNazwa", query = "SELECT m FROM Magazyn m WHERE m.nazwa = :nazwa")
})
public class Magazyn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mid")
    private Integer mid;
    @Size(max = 255)
    @Column(name = "adres")
    private String adres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nazwa")
    private String nazwa;

    @OneToMany(mappedBy = "magazyn")
    private List<Serwis> serwisy;

    @OneToMany(mappedBy = "magazyn")
    private List<Produkt> produkty;

    public Magazyn() {
    }

    public Magazyn(Integer mid) {
        this.mid = mid;
    }

    public Magazyn(Integer mid, String nazwa) {
        this.mid = mid;
        this.nazwa = nazwa;
    }

    public List<Serwis> getSerwisy() {
        return serwisy;
    }

    public void setSerwisy(List<Serwis> serwisy) {
        this.serwisy = serwisy;
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(List<Produkt> produkty) {
        this.produkty = produkty;
    }
    
    
    

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magazyn)) {
            return false;
        }
        Magazyn other = (Magazyn) object;
        if ((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Magazyny[ mid=" + mid + " ]";
    }

}
