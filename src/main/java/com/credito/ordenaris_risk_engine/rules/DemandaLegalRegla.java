package com.credito.ordenaris_risk_engine.rules;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.dto.NivelRiesgo;
import com.credito.ordenaris_risk_engine.dto.SolicitudRiesgoDTO;
import com.credito.ordenaris_risk_engine.providers.VerificacionLegalProvider;

public class DemandaLegalRegla implements ReglaRiesgo{
	private final VerificacionLegalProvider verificacionLegalProvider;
	public DemandaLegalRegla(VerificacionLegalProvider verificacionLegalProvider) {
        this.verificacionLegalProvider = verificacionLegalProvider;
    }
	@Override
	public ResultadoRegla evaluar(Empresa empresa, SolicitudRiesgoDTO solicitud) {
		if (verificacionLegalProvider.tieneJuicioAbierto(empresa)) {
            return new ResultadoRegla("Demanda legal abierta", NivelRiesgo.ALTO, true);
        }
        return new ResultadoRegla("Demanda legal abierta", null, false);
	}

}
