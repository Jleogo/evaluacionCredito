package com.credito.ordenaris_risk_engine.providers;

import com.credito.ordenaris_risk_engine.dao.Empresa;

public interface VerificacionLegalProvider {
	boolean tieneJuicioAbierto(Empresa empresa);
}
