/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */

package co.almundo.profile.api.models;

import co.almundo.profile.api.dao.BusinessClass;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase Modelo de la tabla ALMUNDO_USUARIO_PERFIL
 * Encargada de los proocesos de interaccion
 * con la tabla a traves de hibernate.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@NamedQueries({
        @NamedQuery(name = "buscarPerfilesUsuarios", query = "select usr.perfil from UsuarioPerfil usr where usr.usuario.id =:PARAM_USER")
})

@Entity
@SequenceGenerator(name = "usuarioperfil-gen", sequenceName = "almundo_usuario_perfil_seq", initialValue = 1, allocationSize = 1)
@Table(name = "ALMUNDO_USUARIO_PERFIL")
public class UsuarioPerfil implements Serializable, BusinessClass
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "usuarioperfil-gen")
    @Column(name = "ID_USUARIO_PERFIL", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL", nullable = false)
    private Perfiles perfil;

    @Column(name = "HABILITADO", nullable = false)
    private int habilitado;

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

    public Perfiles getPerfil()
    {
        return perfil;
    }

    public void setPerfil(Perfiles perfil)
    {
        this.perfil = perfil;
    }

    public int getHabilitado()
    {
        return habilitado;
    }

    public void setHabilitado(int habilitado)
    {
        this.habilitado = habilitado;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UsuarioPerfil))
            return false;
        UsuarioPerfil other = (UsuarioPerfil) obj;
        if (id != other.id)
            return false;
        if (usuario == null)
        {
            if (other.usuario != null)
                return false;
        }
        if (perfil == null)
        {
            if (other.perfil != null)
                return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Usuario_Perfil [id=" + id + ", " + "Usuario=" + usuario.toString() + ", " + "Perfil: [" + perfil.toString() + "]" + ", " + "Habilitado=" + (habilitado == 1 ? "true" : "false") + "]";
    }
}
