/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukasz
 */
@Entity
@Table(name = "dostawa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dostawa.findAll", query = "SELECT d FROM Dostawa d")
    , @NamedQuery(name = "Dostawa.findByDid", query = "SELECT d FROM Dostawa d WHERE d.did = :did")

})
public class Dostawa implements Serializable {

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

    @ManyToMany
    @JoinTable(
            name = "zrealizowane_dostawy",
            joinColumns = {
                @JoinColumn(name = "id_dostawy")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_produktu")}
    )
    private List<Produkt> produkty;

    public Dostawa() {
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    public Dostawa(Integer did) {
        this.did = did;
    }

    public Dostawa(Integer did, Date dataZamowienia, int ilosc, String magazyn, String marka, String model, String typ) {
        this.did = did;
        this.dataZamowienia = dataZamowienia;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (did != null ? did.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dostawa)) {
            return false;
        }
        Dostawa other = (Dostawa) object;
        if ((this.did == null && other.did != null) || (this.did != null && !this.did.equals(other.did))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dostawa[ did=" + did + " ]";
    }

}
