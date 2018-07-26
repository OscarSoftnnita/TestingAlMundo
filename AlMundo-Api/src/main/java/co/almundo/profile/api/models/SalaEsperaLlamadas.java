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
 * Clase Modelo de la tabla ALMUNDO_SALA_ESPERA
 * Encargada de los proocesos de interaccion
 * con la tabla a traves de hibernate.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@NamedQueries({ @NamedQuery(name = "buscarAsesoresPorEstado", query = "select sala from SalaEsperaLlamadas sala where sala.estatus_usuario =:PARAM_STATUS") })
@Entity
@SequenceGenerator(name = "salaespera-gen", sequenceName = "almundo_sala_espera_llamadas_seq", initialValue = 1, allocationSize = 1)
@Table(name = "ALMUNDO_SALA_ESPERA")
public class SalaEsperaLlamadas implements Serializable, BusinessClass
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "salaespera-gen")
    @Column(name = "ID_SALA_ATENCION", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuarios usuario;

    @Column(name = "ULTIMA_HORA_CONEC")
    private Date ultima_hora_conec;

    @Size(max = 64)
    @Column(name = "ESTATUS_USUARIO")
    private String estatus_usuario;

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

    public Date getUltima_hora_conec()
    {
        return ultima_hora_conec;
    }

    public void setUltima_hora_conec(Date ultima_hora_conec)
    {
        this.ultima_hora_conec = ultima_hora_conec;
    }

    public String getEstatus_usuario()
    {
        return estatus_usuario;
    }

    public void setEstatus_usuario(String estatus_usuario)
    {
        this.estatus_usuario = estatus_usuario;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof SalaEsperaLlamadas))
            return false;
        SalaEsperaLlamadas other = (SalaEsperaLlamadas) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Sala Espera [id=" + id + ", " + "Estatus=" + estatus_usuario;
    }

}
