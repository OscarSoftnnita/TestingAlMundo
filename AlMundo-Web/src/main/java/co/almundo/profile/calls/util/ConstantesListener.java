/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.calls.util;

/**
 * Interfaz que define constantes para ser utilizadas por los hilos
 * @author Yaher Carrillo
 * @date 24/07/2018
 */
public interface ConstantesListener
{
    /** Tiempo de pausa en caso de error en segundos.  Valor por defecto, 10 minutos */
    public static final Long TIEMPO_PAUSA_ERROR = 10*60L;

    /** Tiempo de pausa en caso de error en segundos. Valor por defecto: 3 segundos */
    public static final Long TIEMPO_PAUSA_DETENCION_HILO = 3l;
}
