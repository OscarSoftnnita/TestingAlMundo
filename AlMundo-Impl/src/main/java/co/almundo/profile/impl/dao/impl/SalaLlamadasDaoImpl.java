
/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl.dao.impl;

import co.almundo.profile.api.dao.PerfilesDao;
import co.almundo.profile.api.dao.SalaLlamadasDao;
import co.almundo.profile.api.models.Perfiles;
import co.almundo.profile.api.models.SalaLlamadas;
import co.almundo.profile.impl.dao.HibernateDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Clase abstracta para la manipulacion de operaciones crud de la entidad
 * SalaLlamadas.
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
@Repository("salaLlamadasDao")
public class SalaLlamadasDaoImpl extends HibernateDaoImpl<Integer,SalaLlamadas> implements SalaLlamadasDao
{
}
