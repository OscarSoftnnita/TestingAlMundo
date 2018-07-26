/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.impl;

import co.almundo.logger.util.Log;
import co.almundo.logger.util.ModulesAlMundo;
import co.almundo.profile.api.dao.SalaLlamadasTestDao;
import co.almundo.profile.api.util.EnumEstatusLlamadas;
import co.almundo.profile.calls.util.CallDispatcher;
import co.almundo.profile.calls.util.CallInfo;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.dbunit.dataset.IDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.UUID;

/**
 * Implementacion de procesos dao
 * de la entidad Parametros, operaciones basicas de la entidad
 *
 * @author Yaher Carrillo
 * @Date 26/07/2018
 */
@Component
public class CallDispatcherTest extends EntityCalledTest
{

    /**
     * Dao que revisa las llamadas en sala.
     */
    @Autowired
    private SalaLlamadasTestDao salaLlamadasTestDao;

    @Test
    @Ignore
    public void callRelease()
    {
        Assert.assertNotNull(generarNuevaLlamada());
    }

    /**
     * Genera una nueva llamada
     * con identificaciones unicas aleatorios
     */
    public CallDispatcher generarNuevaLlamada()
    {
        CallInfo call = new CallInfo();
        call.setCliente("anonimo-" + UUID.randomUUID());
        call.setEstatusLlamada(EnumEstatusLlamadas.LLAMADA_ENTRANTE.getStatus());
        call.setHoraInicio(new Date());
        return asignarLlamada(call);
    }

    /**
     * Genera los hilos
     *
     * @param call
     * @return
     */
    public CallDispatcher asignarLlamada(CallInfo call)
    {
        CallDispatcher dispatcher = new CallDispatcher(call, salaLlamadasTestDao);
        try
        {
            dispatcher.procesar();
        }
        catch (Exception e)
        {
            Log.getInstance().warn(ModulesAlMundo.ALMUNDO_PROFILE.getCodigo(), "", "Error asignando llamada", e);
            return null;
        }
        return dispatcher;

    }

    @Override
    protected IDataSet getDataSet() throws Exception
    {
        return null;
    }
}
