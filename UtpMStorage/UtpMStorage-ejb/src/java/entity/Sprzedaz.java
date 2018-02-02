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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Olek
 */
@Entity
@Table(name = "sprzedaz")
@XmlRootElement
public class Sprzedaz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sis")
    private Integer sis;

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_sprzedazy")
    @Temporal(TemporalType.DATE)
    private Date dataSprzedazy;

    @NotNull
    @Column(name = "cena")
    private String cena;

    @ManyToOne
    private Produkt produkt;

    @ManyToOne
    private Klient klient;

    @OneToOne
    private Serwis serwis;

    public Serwis getSerwis() {
        return serwis;
    }

    public void setSerwis(Serwis serwis) {
        this.serwis = serwis;
    }

    public Integer getSis() {
        return sis;
    }

    public void setSis(Integer sis) {
        this.sis = sis;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Date getDataSprzedazy() {
        return dataSprzedazy;
    }

    public void setDataSprzedazy(Date dataSprzedazy) {
        this.dataSprzedazy = dataSprzedazy;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

}
