package com.credito.ordenaris_risk_engine.rules;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.dto.NivelRiesgo;
import com.credito.ordenaris_risk_engine.dto.SolicitudRiesgoDTO;

public class EmpresaNuevaRegla implements ReglaRiesgo{

	@Override
	public ResultadoRegla evaluar(Empresa empresa, SolicitudRiesgoDTO solicitud) {
		if (empresa.getAniosOperacion() < 2) { // menos de 18 meses
            return new ResultadoRegla("Empresa nueva < 18 meses", NivelRiesgo.MEDIO, true);
        }
        return new ResultadoRegla("Empresa nueva < 18 meses", null, false);
	}

}
