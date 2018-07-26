/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */

package co.almundo.profile.api.models;

import co.almundo.profile.api.dao.BusinessClass;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Clase Modelo de la tabla ALMUNDO_SALA_LLAMADAS
 * Encargada de los proocesos de interaccion
 * con la tabla a traves de hibernate.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@Entity
@SequenceGenerator(name = "usuarios-gen", sequenceName = "almundo_sala_llamadas_seq", initialValue = 1, allocationSize = 1)
@Table(name = "ALMUNDO_SALA_LLAMADAS")
public class SalaLlamadas implements Serializable, BusinessClass
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "usuarios-gen")
    @Column(name = "ID_SALA", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuarios usuario;

    @Column(name = "HORA_INICIO")
    private Date hora_inicio;

    @Column(name = "HORA_FIN")
    private Date hora_fin;

    @Size(max = 128)
    @Column(name = "NOMBRE_SALA")
    private String nombre_sala;

    @Size(max = 128)
    @Column(name = "ESTATUS_SALA")
    private String estatus_sala;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Usuarios getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuarios usuario)
    {
        this.usuario = usuario;
    }

    public Date getHora_inicio()
    {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio)
    {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_fin()
    {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin)
    {
        this.hora_fin = hora_fin;
    }

    public String getNombre_sala()
    {
        return nombre_sala;
    }

    public void setNombre_sala(String nombre_sala)
    {
        this.nombre_sala = nombre_sala;
    }

    public String getEstatus_sala()
    {
        return estatus_sala;
    }

    public void setEstatus_sala(String estatus_sala)
    {
        this.estatus_sala = estatus_sala;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof SalaLlamadas))
            return false;
        SalaLlamadas other = (SalaLlamadas) obj;
        if (id != other.id)
            return false;
        if (nombre_sala == null)
        {
            if (other.nombre_sala != null)
                return false;
        }
        else if (!nombre_sala.equals(other.nombre_sala))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Sala [id=" + id + ", " + "Nombres=" + nombre_sala;
    }

}
