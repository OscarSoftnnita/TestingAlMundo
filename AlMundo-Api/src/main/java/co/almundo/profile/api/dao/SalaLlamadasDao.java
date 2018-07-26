/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.api.dao;

import co.almundo.profile.api.exceptions.DaoException;
import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.models.SalaLlamadas;
import co.almundo.profile.api.models.Usuarios;

import java.util.Date;
import java.util.List;

/**
 * Interfaz de acceso a servicios CRUD  de la entidad
 * SalaLlamadas.
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public interface SalaLlamadasDao extends HibernateDao<SalaLlamadas, Long>
{
}
