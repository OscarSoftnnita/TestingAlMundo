/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl.dao.impl;

import co.almundo.profile.api.dao.ParametrosDao;
import co.almundo.profile.api.models.Parametros;
import co.almundo.profile.impl.dao.HibernateDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Clase abstracta para la manipulacion de operaciones crud de la entidad
 * Parametros.
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@Repository("parametrosDao")
public class ParametrosDaoImpl extends HibernateDaoImpl<Integer, Parametros> implements ParametrosDao
{

}
