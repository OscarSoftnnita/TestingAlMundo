/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.configuration.dom;
import co.almundo.logger.commons.Appender;
import co.almundo.logger.commons.ConsoleAppender;
import co.almundo.logger.commons.EmailAppender;
import co.almundo.logger.commons.FileAppender;
import co.almundo.logger.util.Log;
import co.almundo.logger.util.ModulesAlMundo;
import co.almundo.profile.util.ServletJsfSpringUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Clase de configuracion de
 * subida de spring, en la misma se setean valores de inicio.
 * @author Yaher Carrillo
 * @Date 25/07/2018
 */
public class AlmundoContextListener implements ServletContextListener
{
    /**
     * Identificador unico de clase
     */
    private static final long serialVersionUID = 1L;

    /**
     * Llaves y propiedades de acceso
     */
    private Properties log4jProperties;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initConfProfiler();
        // Define de forma global el contexto
        ServletJsfSpringUtil.setServletContext(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //mute
    }

    /**
     * Metodo que da inicio a las configuracion de subida
     * de AlmundoProfiler
     */
    public void initConfProfiler(){
        this.log4jProperties = loadConfigLog("conf/log4j.properties");
        initLog();
    }

    /**
     * Inicializa las configuraciones de log
     */
    private void initLog() {
        try {
            //Lista de configuracion
            List<Appender> listaAppenders = new ArrayList<>();

            //Configuracion de consola
            ConsoleAppender appender = new ConsoleAppender();
            appender.setCodigo("afiliacion".toUpperCase());
            listaAppenders.add(appender);

            //Configuracion de Archivos Log para Archivos
            List<Appender> listaAppendersFiles = readModulesSystemForGenerateObjectsToFile(log4jProperties);
            listaAppenders.addAll(listaAppendersFiles);

            /**
             * FIXME
             * Se comenta por que no se cuenta con servidor de pruebas
             * de envio de correos.
             */
            //Cofiguracion de log via Email
            EmailAppender ap = readModulesSystemForGenerateObjectsToEmail(log4jProperties);
            listaAppenders.add(ap);

            //CONFIGURACION DE FORMATOS DEL LOG
            //Log.getInstance().configure(listaAppenders, "%-5p %d %m%n");
            Log.getInstance().configure(listaAppenders, log4jProperties.getProperty("log.almundo.format"));
            Log.getInstance().setNivelActivo(Integer.parseInt(log4jProperties.getProperty("log.almundo.active.level")));

            //Evaluar activaciones en modo desarrollador
            boolean isDebug = log4jProperties.getProperty("log.almundo.active.debug") != null && log4jProperties.getProperty("log.almundo.active.debug").equals("true") ? true : false;
            boolean isMonitor = log4jProperties.getProperty("log.almundo.active.monitor") != null && log4jProperties.getProperty("log.almundo.active.debug").equals("true") ? true : false;
            Log.getInstance().activarSalidaConsola();
            if (isDebug)
                Log.getInstance().activarDebug();
            if (isMonitor)
                Log.getInstance().activarMonitoreo();
        } catch (Exception e) {
            System.err.println("IMPOSIBLE INICIAR EL LOG. SE DEBEN REVISAR LOS PARAMETROS");
        }
    }

    /**
     * Carga la configuracion de log que se indique
     *
     * @param nameConfig configuracion a cargar
     */
    public Properties loadConfigLog(String nameConfig)
    {
        Properties prop = new Properties();
        OutputStream output = null;
        try
        {
            //InputStream is = ClassLoader.getSystemResourceAsStream(nameConfig);
            InputStream is = getClass().getClassLoader().getResourceAsStream(nameConfig);
            try
            {
                prop.load(is);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return prop;
    }

    /**
     * Metodo que lee los modulos de la aplicacion y genera
     * los appenders para la configuracion de log
     *
     * @param props
     */
    public List<Appender> readModulesSystemForGenerateObjectsToFile(Properties props)
    {
        List<Appender> listaAppenders = new ArrayList<>();
        for (ModulesAlMundo log : ModulesAlMundo.values())
        {
            FileAppender fa = new FileAppender();
            fa.setCodigo(log.getCodigo());
            fa.setRutaArchivo(props.getProperty("log.almundo.src.files") + log.getNombreArchivo());
            fa.setTamanhoMaximoArchivo(Integer.parseInt(props.getProperty("log.almundo.size.max.files")));
            fa.setFormatotamanho(props.getProperty("log.almundo.size.format.files"));
            fa.setCantidadMaximaArchivos(Integer.parseInt(props.getProperty("log.almundo.count.max.files")));
            listaAppenders.add(fa);
        }
        return listaAppenders;
    }

    /**
     * Metodo que lee los modulos de la aplicacion y genera
     * los appenders para la configuracion de log via correo
     *
     * @param props
     */
    public EmailAppender readModulesSystemForGenerateObjectsToEmail(Properties props)
    {
        EmailAppender ap = new EmailAppender();
        ap.setAsuntoCorreo(props.getProperty("log.almundo.email.affair"));
        ap.setCantidadEventosNoficar(Integer.parseInt(props.getProperty("log.almundo.email.bufferSize")));
        ap.setClave(props.getProperty("log.almundo.email.pass"));
        ap.setCorreoOrigen(props.getProperty("log.almundo.email.origin"));
        ap.setCorreoDestino(props.getProperty("log.almundo.email.destination"));
        ap.setUsuario("yaher");
        ap.setHostServidorCorreo(props.getProperty("log.almundo.email.host"));
        ap.setCodigo(props.getProperty("log.almundo.email.code"));
        ap.setPuertoSMTP(props.getProperty("log.almundo.email.port.smtp"));

        return ap;
    }
}
