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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Olek
 */
@Entity
public class Serwis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sid")
    private Long sid;

    @Basic(optional = false)
    @Column(name = "data_przyjecia")
    @Temporal(TemporalType.DATE)
    private Date dataPrzyjecia;

    @Column(name = "data_oddania")
    @Temporal(TemporalType.DATE)
    private Date dataOddania;

    @Size(max = 255)
    @Column(name = "magazyn")
    private String magazyn;
    
    @Size(max = 255)
    @Column(name = "marka")
    private String marka;
    
    @Size(max = 255)
    @Column(name = "model")
    private String model;
    
    @Size(max = 255)
    @Column(name = "usterka")
    private String usterka;
    
    @Size(max = 255)
    @Column(name = "status")
    private String status;

    @Size(max = 255)
    @Column(name = "info")
    private String info;

    @ManyToOne
    private Klient klient;

    @OneToOne(mappedBy = "serwis")
    private Sprzedaz sprzedaz;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMagazyn() {
        return magazyn;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setMagazyn(String magazyn) {
        this.magazyn = magazyn;
    }

    public Date getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(Date dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }

    public Date getDataOddania() {
        return dataOddania;
    }

    public void setDataOddania(Date dataOddania) {
        this.dataOddania = dataOddania;
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

    public String getUsterka() {
        return usterka;
    }

    public void setUsterka(String usterka) {
        this.usterka = usterka;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Sprzedaz getSprzedaz() {
        return sprzedaz;
    }

    public void setSprzedaz(Sprzedaz sprzedaz) {
        this.sprzedaz = sprzedaz;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sid != null ? sid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the sid fields are not set
        if (!(object instanceof Serwis)) {
            return false;
        }
        Serwis other = (Serwis) object;
        if ((this.sid == null && other.sid != null) || (this.sid != null && !this.sid.equals(other.sid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Serwis[ id=" + sid + " ]";
    }

}
