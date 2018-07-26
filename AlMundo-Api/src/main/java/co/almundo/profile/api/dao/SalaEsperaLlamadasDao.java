/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.api.dao;

import co.almundo.profile.api.exceptions.DaoException;
import co.almundo.profile.api.models.SalaEsperaLlamadas;
import co.almundo.profile.api.models.Usuarios;

import java.util.List;

/**
 * Interfaz de acceso a servicios CRUD  de la entidad
 * SalaEsperaLlamadas.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public interface SalaEsperaLlamadasDao extends HibernateDao<SalaEsperaLlamadas, Long>
{
    /**
     * Busca Usuarios disponibles para nuevas llamadas
     *
     * @return usuarios de sistema
     * @throws DaoException Excepcion que ocurre si falla la aplicacion
     */
    public List<SalaEsperaLlamadas> buscarAsesorDisponble() throws DaoException;
}
