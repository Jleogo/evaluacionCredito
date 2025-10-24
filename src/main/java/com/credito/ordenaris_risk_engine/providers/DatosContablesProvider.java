package com.credito.ordenaris_risk_engine.providers;

import com.credito.ordenaris_risk_engine.dao.Empresa;

public interface DatosContablesProvider {
	 double obtenerVentasPromedio(Empresa empresa);
	 double obtenerPasivos(Empresa empresa);
	 double obtenerActivos(Empresa empresa);
}
