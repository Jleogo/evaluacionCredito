package com.credito.ordenaris_risk_engine.rules;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.dto.NivelRiesgo;
import com.credito.ordenaris_risk_engine.dto.SolicitudRiesgoDTO;
import com.credito.ordenaris_risk_engine.providers.DatosContablesProvider;

public class AltaSolicitudRegla implements ReglaRiesgo{
	private final DatosContablesProvider datosContables;

    public AltaSolicitudRegla(DatosContablesProvider datosContables) {
        this.datosContables = datosContables;
    }
	@Override
	public ResultadoRegla evaluar(Empresa empresa, SolicitudRiesgoDTO solicitud) {
		double ventasPromedio = datosContables.obtenerVentasPromedio(empresa);
        if (solicitud.getMontoSolicitado().doubleValue() > ventasPromedio * 8) {
            return new ResultadoRegla("Monto solicitado es mayor a 8x ventas", NivelRiesgo.ALTO, true);
        }
        return new ResultadoRegla("Monto solicitado es mayor a  8x ventas", null, false);
	}

}
