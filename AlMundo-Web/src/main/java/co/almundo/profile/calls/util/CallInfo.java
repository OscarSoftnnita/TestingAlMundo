/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.calls.util;

import co.almundo.profile.api.models.Usuarios;

import java.util.Date;

/**
 * Clase que emula los datos reales de una llamada
 *
 * @author Yaher Carrillo
 * @Date 24/07/2018
 */
public class CallInfo
{
    /**
     * Cliente llamada
     */
    private String cliente;

    /**
     * Usuario asignado
     */
    private Usuarios usuarioAsignado;

    /**
     * Hora inicio de la llamada
     */
    private Date horaInicio;

    /**
     * Hora fin de la llamada
     */
    private Date horaFin;

    /**
     * Estatus de la llamada
     */
    private String estatusLlamada;

    /**
     * Logica que indica que la llamada debe ser cancelada
     */
    private boolean cancelar;

    /**
     * Constructor por defecto
     */
    public CallInfo()
    {
    }

    /***
     * Constructor que iniciliza los valores del objeto
     * @param cliente
     * @param horaInicio
     * @param horaFin
     * @param estatusLlamada
     */
    public CallInfo(String cliente, Date horaInicio, Date horaFin, String estatusLlamada)
    {
        this.cliente = cliente;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estatusLlamada = estatusLlamada;
    }

    public String getCliente()
    {
        return cliente;
    }

    public void setCliente(String cliente)
    {
        this.cliente = cliente;
    }

    public Date getHoraInicio()
    {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio)
    {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin()
    {
        return horaFin;
    }

    public void setHoraFin(Date horaFin)
    {
        this.horaFin = horaFin;
    }

    public String getEstatusLlamada()
    {
        return estatusLlamada;
    }

    public void setEstatusLlamada(String estatusLlamada)
    {
        this.estatusLlamada = estatusLlamada;
    }

    public Usuarios getUsuarioAsignado()
    {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuarios usuarioAsignado)
    {
        this.usuarioAsignado = usuarioAsignado;
    }

    @Override
    public String toString()
    {
        return "CallInfo [cliente=" + cliente + ", " + "Usuario Asignado=" + usuarioAsignado.getNombres() + ", " + "HoraInicio=" + horaInicio + ", Estatus : " + estatusLlamada;
    }

    public boolean isCancelar()
    {
        return cancelar;
    }

    public void setCancelar(boolean cancelar)
    {
        this.cancelar = cancelar;
    }
}
