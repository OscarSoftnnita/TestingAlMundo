/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.calls.util;

import co.almundo.profile.api.exceptions.ServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener que contiene la logica para implementar hilos en Listeners de almundo para que tengan una detencion segura
 *
 * @author Yaher Carrillo
 * @date 24/07/2018
 */
public abstract class ThreadRootListener
{
    /**
     * Objeto utilizado para el log
     */
    private static final Log logger = LogFactory.getLog(ThreadRootListener.class);
    /**
     * Objeto con el thread que genera alertas
     */
    private HiloListenerRoot hilo;

    /**
     * Constructor para la clase.
     *
     * @param nombre Nombre del listener
     */
    public ThreadRootListener(String nombre)
    {

        hilo = new HiloListenerRoot(this, nombre);
        hilo.start();
    }

    public abstract void init();


    /**
     * Metodo con la logica para ser procesada por el Thread
     *
     * @throws ServiceException     Cuando el servicio usado en la logica falla
     * @throws InterruptedException Cuando no se puede dormir en hilo
     * @throws Exception            Cuando hay una excepcion General
     */
    public abstract void procesar() throws ServiceException, InterruptedException, Exception;

    /**
     * Obtiene el tiempo en segundos para pausar el servicio
     *
     * @return el tiempo en segundos del servicio
     * @throws ServiceException si no se puede obtener el servicio que determina el tiempo
     */
    public abstract Long getSegundosPausa() throws ServiceException;


    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed()
    {
        // Aseguramos que el context destroyed se termina de llamar cuando el hilo ha sido detenido
        logger.info("Inicio detencion listener " + getHilo().getNombreProceso());
        this.hilo.forzarDetencionHilo(ConstantesListener.TIEMPO_PAUSA_DETENCION_HILO);
        logger.info("Listener " + getHilo().getNombreProceso() + " detenido");
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyedUtil()
    {
        // Aseguramos que el context destroyed se termina de llamar cuando el hilo ha sido detenido
        logger.info("Inicio detencion listener " + getHilo().getNombreProceso());
        this.hilo.forzarDetencionHilo(ConstantesListener.TIEMPO_PAUSA_DETENCION_HILO);
        logger.info("Listener " + getHilo().getNombreProceso() + " detenido");
    }

    /**
     * Obtiene el hilo
     *
     * @return el hilo
     */
    public HiloListenerRoot getHilo()
    {
        return hilo;
    }
}
