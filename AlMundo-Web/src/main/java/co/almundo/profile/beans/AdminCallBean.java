/*
 * ESTE COMPONENTE FUE REALIZADO SOLO PARA TESTING DE PARTICIPACION
 * DE ALMUNDO.COM
 */
package co.almundo.profile.beans;

import co.almundo.logger.util.Log;
import co.almundo.logger.util.ModulesAlMundo;
import co.almundo.profile.api.util.EnumEstatusLlamadas;
import co.almundo.profile.calls.util.CallDispatcher;
import co.almundo.profile.calls.util.CallInfo;
import co.almundo.profile.util.SpringUtil;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Bean de adminsitracion de llamadas
 */
@Component
@ManagedBean(name = "adminCallBean")
@SessionScoped
public class AdminCallBean
{
    /**
     * Constante de busqueda en sesion de llamadas activas
     */
    private static final String CONSTANT_OBJECT_SLOT_CALLS = "CONSTANT_OBJECT_SLOT_CALLS";

    /**
     * Listado de llamadas cargado al bean de cara al front-end
     */
    private List<CallInfo> listCallView = new ArrayList<>();
/**
     * Genera una nueva llamada
     * con identificaciones unicas aleatorios
     */
    public void generarNuevaLlamada()
    {
        CallInfo call = new CallInfo();
        call.setCliente("anonimo-" + UUID.randomUUID());
        call.setEstatusLlamada(EnumEstatusLlamadas.LLAMADA_ENTRANTE.getStatus());
        call.setHoraInicio(new Date());
        asignarLlamada(call);
    }

    /**
     * Metodo de procesamiento al recargar la pagina
     */
    public synchronized void reload()
    {
        /**
         * Colocar aqui procesos de negocios
         * para la recarga de elementos
         */
    }

    /**
     * Cancela la llamada del listado seleccionada
     * @param call
     */
    public void cancelarLlamada(CallInfo call)
    {
        call.setCancelar(true);
    }

    /**
     * Asigna la llamada a un asesor
     * disponible en la sesion
     */
    public void asignarLlamada(CallInfo call)
    {
        CallDispatcher dispatcher = new CallDispatcher(call);
        try
        {
            dispatcher.procesar();
        }
        catch (Exception e)
        {
            Log.getInstance().warn(ModulesAlMundo.ALMUNDO_PROFILE.getCodigo(), "", "Error asignando llamada", e);
        }
        cargarSlotLlamada(call);

    }

    /**
     * Metodo que carga una llamada en
     * el slot de manejo
     */
    public void cargarSlotLlamada(CallInfo call)
    {
        try
        {
            List<CallInfo> listCall = (List<CallInfo>) SpringUtil.getServletContext().getAttribute(CONSTANT_OBJECT_SLOT_CALLS);
            if (listCall != null && !listCall.isEmpty())
            {
                listCall.add(call);
            }
            else
            {
                listCall = new ArrayList<>();
                listCall.add(call);
            }

            SpringUtil.getServletContext().setAttribute(CONSTANT_OBJECT_SLOT_CALLS, listCall);
            this.setListCallView(listCall);
        }
        catch (Exception e)
        {
            Log.getInstance().warn(ModulesAlMundo.ALMUNDO_PROFILE.getCodigo(), "", "Error cargando una llamada en el slot", e);
        }

    }

    /**
     * Obtiene el listado de llamadas a ser mostrados en la vista
     *
     * @return listado de llamadas
     */
    public List<CallInfo> getListCallView()
    {
        return listCallView;
    }

    /**
     * Asigna un valor al listado de llamadas en sesion
     *
     * @param listCallView valor a asignar
     */
    public void setListCallView(List<CallInfo> listCallView)
    {
        this.listCallView = listCallView;
    }
}
