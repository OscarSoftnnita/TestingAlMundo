/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.calls.util;

import co.almundo.profile.api.dao.SalaLlamadasTestDao;
import co.almundo.profile.api.exceptions.ServiceException;
import co.almundo.profile.api.models.SalaLlamadas;
import co.almundo.profile.api.services.SalasLlamadasServices;
import co.almundo.profile.api.util.EnumEstatusLlamadas;
import co.almundo.profile.api.util.EnumServicesAlmundoConfig;
import co.almundo.profile.util.SpringUtil;

/**
 * Administrador de llamadas Dispatcher
 *
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public class CallDispatcher extends ThreadRootListener
{

    /**
     * Valor que se multiplica para obtener el tiempo en segundos
     */
    private static final int CONVERSION_MINUTO_SEGUNDO = 60;
    /**
     * Cantidad de intentos para llamadas entrantes
     */
    private static final int COUNT_LIMIT_CALLS = 3;

    /**
     * Servicio de llamadas
     */
    private SalasLlamadasServices servicioSalas;
    /**
     * Servicio inyectado para pruebas
     */
    private SalaLlamadasTestDao servicioSalasTest;
    /**
     * Llamada entrante
     */
    private CallInfo callInfo;
    /**
     * contador de intentos de atencion de llamadas
     */
    private int countCalls;

    private boolean isTest;

    public CallDispatcher(CallInfo callInfo)
    {
        super("Inicio de nueva llamada");
        this.callInfo = callInfo;
        servicioSalas = SpringUtil.getSpringBean(EnumServicesAlmundoConfig.SERVICES_SALAS.getNameService());
        isTest = false;

    }


    public CallDispatcher(CallInfo callInfo,SalaLlamadasTestDao servicioSalasTest)
    {
        super("Inicio de nueva llamada");
        this.callInfo = callInfo;
        this.servicioSalasTest = servicioSalasTest;
        isTest = true;

    }

    @Override
    public void init()
    {
    }

    @Override
    public void procesar()
    {
        try
        {
            if (callInfo.isCancelar())
            {
                this.cancelarLlamada(callInfo);
            }
            else
            {
                String statusCall = callInfo.getEstatusLlamada();
                switch (statusCall)
                {
                    case "atendiendose":
                        /*Aki se colocan procesos de monitoreo, envio de tramas, videos, textos, informacion, entre otros. */
                        procesoMonitoreoLlamada(callInfo);
                        break;
                    case "pausa":
                        pausarEnvioTramas();
                        break;
                    default:
                        countCalls++;
                        if (!isTest)
                            asignarInfoSala(servicioSalas.asignarNuevaLlamada());
                        else
                            asignarInfoSala(servicioSalasTest.asignarNuevaLlamadaTesting());
                        break;
                }
            }

        }
        catch (ServiceException e)
        {
            String code_error = e.getCode();
            switch (code_error)
            {
                case "007":
                    //No hay asesores disponibles
                    callInfo.setEstatusLlamada(EnumEstatusLlamadas.LLAMADA_ESPERA.getStatus());
                    break;
                default:
                    boolean logic = countCalls >= COUNT_LIMIT_CALLS ? cancelarLlamada(callInfo) : false;
                    break;
            }

        }
    }

    /**
     * Asigna los valores de atencion de llamadas
     *
     * @param salaLlamadas
     */
    public void asignarInfoSala(SalaLlamadas salaLlamadas)
    {
        if (salaLlamadas != null)
        {
            callInfo.setEstatusLlamada(salaLlamadas.getEstatus_sala());
            callInfo.setUsuarioAsignado(salaLlamadas.getUsuario());
        }

    }


    public void asignarInfoSalaTest(SalaLlamadas salaLlamadas)
    {
        if (salaLlamadas != null)
        {
            callInfo.setEstatusLlamada(salaLlamadas.getEstatus_sala());
            callInfo.setUsuarioAsignado(salaLlamadas.getUsuario());
        }

    }

    /**
     * Aqui se pueden alojar procesos de monitoreo
     * los decididos por el negocio
     *
     * @param callInfo
     */
    public void procesoMonitoreoLlamada(CallInfo callInfo)
    {
        System.out.println("Monitoreo de llamada en atencion :" + callInfo.toString());
    }

    /**
     * Pausa el envio o monitoreo de tramas
     * por desicion del asesor
     * se asigna n minuto
     */
    public void pausarEnvioTramas()
    {
        long tiempoEnMinutos = 1;
        Long tiempo = CONVERSION_MINUTO_SEGUNDO * tiempoEnMinutos;
        this.getHilo().forzarDetencionHilo(tiempoEnMinutos);
    }

    /**
     * Se cancela la llamada
     */
    public boolean cancelarLlamada(CallInfo call)
    {
        call.setEstatusLlamada(EnumEstatusLlamadas.LLAMADA_CANCELADA.getStatus());
        procesoCierreLlamada(call);
        this.getHilo().setParar(true);
        return true;
    }

    /**
     * Aqui se realizan los procesos de negocio para el cierre de llamadas
     *
     * @param callInfo llamada en curso
     */
    public void procesoCierreLlamada(CallInfo callInfo)
    {
        System.out.println("Cierre de llamada :" + callInfo.toString());
    }

    @Override
    public Long getSegundosPausa() throws ServiceException
    {
        /**
         * Aleatoriedad hasta 10 segundos de
         */
        //long tiempoEnMinutos = (long) (Math.random() * (10 + 1));
        long tiempoEnMinutos = 1;
        Long tiempo = CONVERSION_MINUTO_SEGUNDO * tiempoEnMinutos;
        return tiempo;
    }

    /**
     * Obtiene la informacion de llamada
     * manejada por el hilo
     *
     * @return
     */
    public CallInfo getCallInfo()
    {
        return callInfo;
    }
}
