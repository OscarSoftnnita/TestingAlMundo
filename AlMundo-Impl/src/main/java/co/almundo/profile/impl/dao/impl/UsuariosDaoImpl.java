/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl.dao.impl;

import co.almundo.profile.api.dao.UsuariosDao;
import co.almundo.profile.api.exceptions.DaoException;
import co.almundo.profile.api.models.Usuarios;
import co.almundo.profile.impl.dao.HibernateDaoImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Clase abstracta para la manipulacion de operaciones crud de la entidad
 * usuarios.
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@Repository("usuariosDao")
public class UsuariosDaoImpl extends HibernateDaoImpl<Integer,Usuarios> implements UsuariosDao
{

    @Override
    public Usuarios getUsuarioPorLogin(String login) throws DaoException
    {
        Session session = this.getSession();
        Query query = session.getNamedQuery("buscarUsuarioPorLogin");
        query.setParameter("PARAM_LOGIN", login);
        Usuarios usuario = (Usuarios)query.uniqueResult();
        return usuario;// OK
    }

    @Override
    public List<Usuarios> getUsuarioActivosMes(String login) throws DaoException
    {
        //Se resta un mes a la fecha actual
        Date fecha_inicio = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha_inicio);
        calendar.add(Calendar.MONTH,-1);
        fecha_inicio = calendar.getTime();

        Date fecha_fin = new Date();
        Session session = this.getSession();
        Query query = session.getNamedQuery("buscarUsuarioUltimoMesActivo");
        query.setParameter("PARAM_FINICIO", fecha_inicio);
        query.setParameter("PARAM_FFIN", fecha_fin);
        List<Usuarios> usuarios = (List<Usuarios>)query.list();
        return usuarios;// OK
    }

    @Override
    public List<Usuarios> getUsuarioActivosEntreFechas(Date fecha_inicio, Date fecha_fin) throws DaoException
    {
        Session session = this.getSession();
        Query query = session.getNamedQuery("buscarUsuarioActivosPorFecha");
        query.setParameter("PARAM_FINICIO", fecha_inicio);
        query.setParameter("PARAM_FFIN", fecha_fin);
        List<Usuarios> usuarios = (List<Usuarios>)query.list();
        return usuarios;// OK
    }

    @Override
    public List<Usuarios> getUsuarioPorEstados(boolean activo) throws DaoException
    {
        Session session = this.getSession();
        Query query = session.getNamedQuery("buscarUsuarioPorEstado");
        query.setParameter("PARAM_ESTADO", activo?1:0);
        List<Usuarios> usuarios = (List<Usuarios>)query.list();
        return usuarios;// OK
    }


}
