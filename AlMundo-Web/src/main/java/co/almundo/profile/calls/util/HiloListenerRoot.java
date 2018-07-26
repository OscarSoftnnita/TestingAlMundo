/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.calls.util;

import co.almundo.profile.api.exceptions.ServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Clase que aumenta funcionalidad en los hilos que se llaman en los listener web de almundo
 *
 * @author Yaher Carrillo
 * @date 24/07/2018
 */
public class HiloListenerRoot extends Thread
{
    /**
     * Objeto utilizado para el log
     */
    private static final Log logger = LogFactory.getLog(HiloListenerRoot.class);
    /**
     * Flag que permite detener el hilo
     */
    private volatile boolean parar = false;
    /**
     * Flag que indica si el esta detenido
     */
    private volatile boolean hiloDetenido = true;
    /**
     * Listener que contiene la logica del hilo
     */
    private ThreadRootListener contextListener;
    /**
     * Nombre del proceso que el hilo maneja
     */
    private String nombreProceso;

    /**
     * Constructor para la clase ThreadContextListener.java
     */
    public HiloListenerRoot(ThreadRootListener contextListener, String nombre)
    {
        this.contextListener = contextListener;
        this.nombreProceso = nombre;
    }

    /**
     * Metodo que ejecuta el Hilo. Usa logica para usar detencion segura
     */
    @Override
    public void run()
    {
        logger.info("Iniciando hilo " + getNombreProceso() + "....");
        this.setHiloDetenido(false);
        try
        {
            while (true && !this.isParar())
            {
                try
                {
                    // Se duerme al inicio de forma intencional, si no es asi
                    // y ocurre una excepcion se queda en un bucle infinito
                    Thread.sleep(this.contextListener.getSegundosPausa() * 1000);

                    //Este es el metodo logico que el hilo procesa
                    this.contextListener.procesar();
                }
                catch (ServiceException e)
                {
                    logger.error("Error de servicio al iniciar " + getNombreProceso(), e);
                    pausarProceso(ConstantesListener.TIEMPO_PAUSA_ERROR);
                }
                catch (InterruptedException e)
                {
                    logger.info("Se ha solicitado la detencion del proceso " + getNombreProceso());
                }
                catch (Throwable e)
                {
                    logger.error("Error desconocido al iniciar " + getNombreProceso(), e);
                    pausarProceso(ConstantesListener.TIEMPO_PAUSA_ERROR);
                }
            }
        }
        finally
        {
            this.setHiloDetenido(true);
            logger.info("Hilo " + getNombreProceso() + " detenido");
        }
    }

    /**
     * Metodo que envia peticion de parado del hilo
     */
    private void solicitarDetencionSegura()
    {
        logger.info("Se ha solicitado detencion segura del hilo " + getNombreProceso());
        parar = true;
        super.interrupt();
    }

    /**
     * Este m�todo permite pausar el proceso durante un tiempo determinado en caso de un error
     *
     * @param tiempoPausaError Tiempo de pausa en segundos si hay error al pausar el hilo
     */
    public void pausarProceso(Long tiempoPausaError)
    {
        try
        {
            if (!this.isParar())
            {
                Thread.sleep(tiempoPausaError * 1000);
            }
        }
        catch (InterruptedException e)
        {
            logger.error("Error al dormir hilo " + getNombreProceso(), e);
        }
    }

    /**
     * Metodo que debe ser llamado cuando se destruye el contexto del listener y asegura que el hilo se detenga
     *
     * @param tiempoPausa Tiempo de pausa mientras el hilo se detiene
     */
    public void forzarDetencionHilo(long tiempoPausa)
    {
        try
        {
            this.solicitarDetencionSegura();
            while (!this.hiloDetenido && true)
            {
                // Metodo para que el contextDestroyed no termine
                Thread.sleep(tiempoPausa * 1000);
            }
        }
        catch (InterruptedException e)
        {
            logger.error("Error al dormir hilo " + getNombreProceso(), e);
        }
    }

    /**
     * Obtiene el parar
     *
     * @return el parar
     */
    public boolean isParar()
    {
        return parar;
    }

    /**
     * Modifica el parar
     *
     * @param parar El nuevo parar
     */
    public void setParar(boolean parar)
    {
        this.parar = parar;
    }

    /**
     * Obtiene el hiloDetenido
     *
     * @return el hiloDetenido
     */
    public boolean isHiloDetenido()
    {
        return hiloDetenido;
    }

    /**
     * Modifica el hiloDetenido
     *
     * @param hiloDetenido El nuevo hiloDetenido
     */
    public void setHiloDetenido(boolean hiloDetenido)
    {
        this.hiloDetenido = hiloDetenido;
    }

    /**
     * Modifica el nombreProceso
     *
     * @param nombreProceso El nuevo nombreProceso
     */
    public void setNombreProceso(String nombreProceso)
    {
        this.nombreProceso = nombreProceso;
    }

    /**
     * Obtiene el nombreProceso
     *
     * @return el nombreProceso
     */
    public String getNombreProceso()
    {
        return nombreProceso;
    }
}
