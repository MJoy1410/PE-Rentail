/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Trần Minh Tuấn
 */
@Entity
@Table(name = "RoomForRent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomForRent.findAll", query = "SELECT r FROM RoomForRent r"),
    @NamedQuery(name = "RoomForRent.findById", query = "SELECT r FROM RoomForRent r WHERE r.id = :id"),
    @NamedQuery(name = "RoomForRent.findByTitle", query = "SELECT r FROM RoomForRent r WHERE r.title = :title"),
    @NamedQuery(name = "RoomForRent.findByPrice", query = "SELECT r FROM RoomForRent r WHERE r.price = :price"),
    @NamedQuery(name = "RoomForRent.findByLocation", query = "SELECT r FROM RoomForRent r WHERE r.location = :location"),
    @NamedQuery(name = "RoomForRent.findByDescription", query = "SELECT r FROM RoomForRent r WHERE r.description = :description"),
    @NamedQuery(name = "RoomForRent.findByPostedDate", query = "SELECT r FROM RoomForRent r WHERE r.postedDate = :postedDate"),
    @NamedQuery(name = "RoomForRent.findByStatus", query = "SELECT r FROM RoomForRent r WHERE r.status = :status")})
public class RoomForRent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;
    @Column(name = "description")
    private String description;
    @Column(name = "postedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedDate;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Account username;

    public RoomForRent() {
    }

    public RoomForRent(Integer id) {
        this.id = id;
    }

    public RoomForRent(Integer id, String title, BigDecimal price, String location) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Account getUsername() {
        return username;
    }

    public void setUsername(Account username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomForRent)) {
            return false;
        }
        RoomForRent other = (RoomForRent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.model.RoomForRent[ id=" + id + " ]";
    }
    
}
