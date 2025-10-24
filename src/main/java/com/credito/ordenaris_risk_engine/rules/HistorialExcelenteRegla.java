package com.credito.ordenaris_risk_engine.rules;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.dto.NivelRiesgo;
import com.credito.ordenaris_risk_engine.dto.SolicitudRiesgoDTO;
import com.credito.ordenaris_risk_engine.providers.HistorialPagosProvider;

public class HistorialExcelenteRegla implements ReglaRiesgo{
	private final HistorialPagosProvider provider;

    public HistorialExcelenteRegla(HistorialPagosProvider provider) {
        this.provider = provider;
    }
    
	@Override
	public ResultadoRegla evaluar(Empresa empresa, SolicitudRiesgoDTO solicitud) {
		if(provider.historial(empresa)) {
            return new ResultadoRegla("Historial excelente", NivelRiesgo.BAJO, true);
        }
        return new ResultadoRegla("Historial excelente", null, false);
	}

}
