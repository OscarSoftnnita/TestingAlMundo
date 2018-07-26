/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.logger.util;

/**
 * Enum que clasifica los modulos del sistema
 * y sirve para segmentar los logs correspondientes a visualizar en sistama.
 * @author Yaher Carrillo
 * @Date 24/05/2018
 */
public enum ModulesAlMundo
{

    ALMUNDO_PROFILE("almundo.profile", "MODULE CALL CENTER", "CALLCENTER\\call-profile"),
    ALMUNDO_OTHER("almundo.other", "MODULE PAYMENT CONTROL", "OTHER\\other-control");

    private String codigo;
    private String nombre;
    private String nombreArchivo;

    ModulesAlMundo(String codigo, String nombre, String nombreArchivo)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombreArchivo = nombreArchivo;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public String getNombreArchivo()
    {
        return nombreArchivo;
    }

    public static String getCodigoLogMonitor()
    {
        return "log.error.monitor";
    }
}
