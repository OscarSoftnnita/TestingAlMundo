/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl.dao;
import co.almundo.profile.api.dao.UsuariosDao;
import co.almundo.profile.api.exceptions.DaoException;
import co.almundo.profile.api.models.Usuarios;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.dbunit.dataset.IDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

/**
 * Test de Usuarios
 * @author Yaher Carrillo
 * @Date 26/07/2018
 */
public class UsuariosDaoTest extends EntityDaoImplTest{

	@Autowired
	private UsuariosDao usuariosDao;


	/**
	 * Crea un usuarion en el sistema
	 * @throws DaoException
	 */
	@Test
	@Ignore
	public void crearUnUsuario() throws DaoException
	{
		Usuarios usuario = new Usuarios();
		usuario.setNombres("Saher Oscar");
		usuario.setApellidos("Carrillo Domador");
		usuario.setLogin("saher");
		usuario.setClave("saher");
		usuario.setFecha_registro(new Date());
		usuario.setFecha_ultima_visita(new Date());
		//Long id = usuariosDao.agregar(usuario);
		Assert.assertNotNull(usuariosDao.getUsuarioPorLogin("admin"));
	}

	/**
	 * Busca un usuario con el id 1
	 * @throws DaoException
	 */
	@Test
	@Ignore
	public void buscarPorId() throws DaoException
	{
		Assert.assertNotNull(usuariosDao.buscarPorId(new Long(24)));
	}

	/**
	 * Busca un usuario por su nombre
	 * @throws DaoException
	 */
	@Test
	@Ignore
	public void buscarPorLogin() throws DaoException
	{
		Assert.assertNotNull(usuariosDao.getUsuarioPorLogin("admin"));
		//Assert.assertNull(usuariosDao.getUsuarioPorLogin("yaher1"));
	}



	@Test
	//@Ignore
	public void ActualizarUsuario() throws DaoException
	{
		Usuarios usuario = usuariosDao.buscarPorId(new Long("24"));
		usuario.setHabilitado(new Long("0"));
		usuariosDao.actualizar(usuario);
	}


	@Override
	protected IDataSet getDataSet() throws Exception
	{
		return null;
	}

}
