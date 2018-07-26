/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.api.dao;

import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.models.SalaLlamadas;

/**
 * Interfaz de acceso a servicios CRUD  de la entidad
 * SalaLlamadas.
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public interface SalaLlamadasTestDao extends HibernateDao<SalaLlamadas, Long>
{
    public SalaLlamadas asignarNuevaLlamadaTesting() throws ServiceException;
}
