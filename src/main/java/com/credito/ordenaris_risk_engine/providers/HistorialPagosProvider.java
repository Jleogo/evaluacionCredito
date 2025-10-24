package com.credito.ordenaris_risk_engine.providers;

import com.credito.ordenaris_risk_engine.dao.Empresa;

public interface HistorialPagosProvider {
	boolean historial(Empresa empresa);
}
