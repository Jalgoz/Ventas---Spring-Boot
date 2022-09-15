package com.jalgoz.ventas.exception;

import java.util.Date;
import java.util.Map;

public class ExceptionResponse {
    private Date timeStamp;
    private String mensaje;
    private String detalles;
    private Map<String, String> erroresValidacion;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date timeStamp, String mensaje, String detalles) {
        this.timeStamp = timeStamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public ExceptionResponse(Date timeStamp, String mensaje, String detalles, Map<String, String> erroresValidacion) {
        this.timeStamp = timeStamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
        this.erroresValidacion = erroresValidacion;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Map<String, String> getErroresValidacion() {
        return erroresValidacion;
    }

    public void setErroresValidacion(Map<String, String> erroresValidacion) {
        this.erroresValidacion = erroresValidacion;
    }
}
