package com.credito.ordenaris_risk_engine.service;

import com.credito.ordenaris_risk_engine.dto.ResultadoRiesgoDTO;
import com.credito.ordenaris_risk_engine.dto.SolicitudRiesgoDTO;

public interface OrdenarisRiskEngineService {
	ResultadoRiesgoDTO evaluarRiesgo(SolicitudRiesgoDTO solicitud);
}
