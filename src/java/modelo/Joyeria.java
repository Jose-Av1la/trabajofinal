/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgasd
 */
@Entity
@Table(name = "joyeria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Joyeria.findAll", query = "SELECT j FROM Joyeria j")
    , @NamedQuery(name = "Joyeria.findByIde", query = "SELECT j FROM Joyeria j WHERE j.ide = :ide")
    , @NamedQuery(name = "Joyeria.findByNombre", query = "SELECT j FROM Joyeria j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Joyeria.findByUbicacion", query = "SELECT j FROM Joyeria j WHERE j.ubicacion = :ubicacion")
    , @NamedQuery(name = "Joyeria.findByDireccion", query = "SELECT j FROM Joyeria j WHERE j.direccion = :direccion")
    , @NamedQuery(name = "Joyeria.findByNombrencargado", query = "SELECT j FROM Joyeria j WHERE j.nombrencargado = :nombrencargado")
    , @NamedQuery(name = "Joyeria.findByDimencionloca", query = "SELECT j FROM Joyeria j WHERE j.dimencionloca = :dimencionloca")
    , @NamedQuery(name = "Joyeria.findByCiudad", query = "SELECT j FROM Joyeria j WHERE j.ciudad = :ciudad")})
public class Joyeria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ide")
    private String ide;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "nombrencargado")
    private String nombrencargado;
    @Column(name = "dimencionloca")
    private Integer dimencionloca;
    @Size(max = 50)
    @Column(name = "ciudad")
    private String ciudad;

    public Joyeria() {
    }

    public Joyeria(String ide) {
        this.ide = ide;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombrencargado() {
        return nombrencargado;
    }

    public void setNombrencargado(String nombrencargado) {
        this.nombrencargado = nombrencargado;
    }

    public Integer getDimencionloca() {
        return dimencionloca;
    }

    public void setDimencionloca(Integer dimencionloca) {
        this.dimencionloca = dimencionloca;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ide != null ? ide.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joyeria)) {
            return false;
        }
        Joyeria other = (Joyeria) object;
        if ((this.ide == null && other.ide != null) || (this.ide != null && !this.ide.equals(other.ide))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Joyeria[ ide=" + ide + " ]";
    }
    
}
