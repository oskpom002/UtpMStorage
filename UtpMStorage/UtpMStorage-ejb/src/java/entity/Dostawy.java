/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukasz
 */
@Entity
@Table(name = "dostawy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dostawy.findAll", query = "SELECT d FROM Dostawy d")
    , @NamedQuery(name = "Dostawy.findByDid", query = "SELECT d FROM Dostawy d WHERE d.did = :did")
    , @NamedQuery(name = "Dostawy.findByDataZamowienia", query = "SELECT d FROM Dostawy d WHERE d.dataZamowienia = :dataZamowienia")
    , @NamedQuery(name = "Dostawy.findByIlosc", query = "SELECT d FROM Dostawy d WHERE d.ilosc = :ilosc")
    , @NamedQuery(name = "Dostawy.findByImei", query = "SELECT d FROM Dostawy d WHERE d.imei = :imei")
    , @NamedQuery(name = "Dostawy.findByMagazyn", query = "SELECT d FROM Dostawy d WHERE d.magazyn = :magazyn")
    , @NamedQuery(name = "Dostawy.findByMarka", query = "SELECT d FROM Dostawy d WHERE d.marka = :marka")
    , @NamedQuery(name = "Dostawy.findByModel", query = "SELECT d FROM Dostawy d WHERE d.model = :model")
    , @NamedQuery(name = "Dostawy.findByStan", query = "SELECT d FROM Dostawy d WHERE d.stan = :stan")
    , @NamedQuery(name = "Dostawy.findByTyp", query = "SELECT d FROM Dostawy d WHERE d.typ = :typ")})
public class Dostawy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "did")
    private Integer did;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_zamowienia")
    @Temporal(TemporalType.DATE)
    private Date dataZamowienia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ilosc")
    private int ilosc;
    @Size(max = 255)
    @Column(name = "imei")
    private String imei;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "magazyn")
    private String magazyn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "marka")
    private String marka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "model")
    private String model;
    @Column(name = "stan")
    private Boolean stan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "typ")
    private String typ;

    public Dostawy() {
    }

    public Dostawy(Integer did) {
        this.did = did;
    }

    public Dostawy(Integer did, Date dataZamowienia, int ilosc, String magazyn, String marka, String model, String typ) {
        this.did = did;
        this.dataZamowienia = dataZamowienia;
        this.ilosc = ilosc;
        this.magazyn = magazyn;
        this.marka = marka;
        this.model = model;
        this.typ = typ;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Date getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(Date dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(String magazyn) {
        this.magazyn = magazyn;
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
        hash += (did != null ? did.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dostawy)) {
            return false;
        }
        Dostawy other = (Dostawy) object;
        if ((this.did == null && other.did != null) || (this.did != null && !this.did.equals(other.did))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dostawy[ did=" + did + " ]";
    }
    
}
