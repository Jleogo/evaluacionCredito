package com.credito.ordenaris_risk_engine.rules;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.dto.NivelRiesgo;
import com.credito.ordenaris_risk_engine.dto.SolicitudRiesgoDTO;
import com.credito.ordenaris_risk_engine.providers.DatosContablesProvider;

public class DeudaActivaRegla implements ReglaRiesgo{
	private final DatosContablesProvider datosContables;

    public DeudaActivaRegla(DatosContablesProvider datosContables) {
        this.datosContables = datosContables;
    }
	@Override
	public ResultadoRegla evaluar(Empresa empresa, SolicitudRiesgoDTO solicitud) {
		double deudaTotal = datosContables.obtenerPasivos(empresa);
		if (deudaTotal > 1000000) {
            return new ResultadoRegla("Deuda Activa > 90 días", NivelRiesgo.RECHAZADO, true);
        }
        return new ResultadoRegla("Deuda Activa > 90 días", null, false);
    }
}
