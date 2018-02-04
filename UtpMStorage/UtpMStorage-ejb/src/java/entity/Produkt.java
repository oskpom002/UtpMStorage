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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukasz
 */
@Entity
@Table(name = "produkt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produkt.findAll", query = "SELECT p FROM Produkt p")
    , @NamedQuery(name = "Produkt.findByPid", query = "SELECT p FROM Produkt p WHERE p.pid = :pid")
    , @NamedQuery(name = "Produkt.findByIlosc", query = "SELECT p FROM Produkt p WHERE p.ilosc = :ilosc")
    , @NamedQuery(name = "Produkt.findByImei", query = "SELECT p FROM Produkt p WHERE p.imei = :imei")
    , @NamedQuery(name = "Produkt.findByMagazyn", query = "SELECT p FROM Produkt p WHERE p.magazyn = :magazyn")
    , @NamedQuery(name = "Produkt.findByMarka", query = "SELECT p FROM Produkt p WHERE p.marka = :marka")
    , @NamedQuery(name = "Produkt.findByModel", query = "SELECT p FROM Produkt p WHERE p.model = :model")
    , @NamedQuery(name = "Produkt.findByStan", query = "SELECT p FROM Produkt p WHERE p.stan = :stan")
    , @NamedQuery(name = "Produkt.findTypes", query = "SELECT DISTINCT(p.typ) FROM Produkt p")
    , @NamedQuery(name = "Produkt.findByTyp", query = "SELECT p FROM Produkt p WHERE p.typ = :typ")})
public class Produkt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pid")
    private Integer pid;

    @Column(name = "ilosc")
    private Integer ilosc;

    @Column(name = "aktualnailosc")
    private Integer aktualnailosc;

    @Size(max = 255)
    @Column(name = "imei")
    private String imei;

    @Size(max = 255)
    @Column(name = "marka")
    private String marka;
    @Size(max = 255)
    @Column(name = "model")
    private String model;
    @Column(name = "stan")
    private Boolean stan;
    @Size(max = 255)
    @Column(name = "typ")
    private String typ;

    @ManyToMany(mappedBy = "produkty")
    private List<Dostawa> dostawy;

    @OneToMany(mappedBy = "produkt")
    private List<Sprzedaz> sprzedaze;

    @ManyToOne
    private Magazyn magazyn;

    public Produkt() {
    }

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    public List<Sprzedaz> getSprzedaze() {
        return sprzedaze;
    }

    public void setSprzedaze(List<Sprzedaz> sprzedaze) {
        this.sprzedaze = sprzedaze;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Dostawa> getDostawy() {
        return dostawy;
    }

    public void setDostawy(List<Dostawa> dostawy) {
        this.dostawy = dostawy;
    }

    public Produkt(Integer pid) {
        this.pid = pid;
    }

    public Integer getAktualnailosc() {
        return aktualnailosc;
    }

    public void setAktualnailosc(Integer aktualnailosc) {
        this.aktualnailosc = aktualnailosc;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getStan() {
        return stan;
    }

    public void setStan(Boolean stan) {
        this.stan = stan;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produkt)) {
            return false;
        }
        Produkt other = (Produkt) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Produkt[ pid=" + pid + " ]";
    }

}
