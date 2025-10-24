package com.credito.ordenaris_risk_engine.rules;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.dto.SolicitudRiesgoDTO;

public interface ReglaRiesgo {
	ResultadoRegla evaluar(Empresa empresa, SolicitudRiesgoDTO solicitud);
}
