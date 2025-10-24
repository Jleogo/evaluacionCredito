package com.credito.ordenaris_risk_engine.providersImpl;

import org.springframework.stereotype.Service;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.providers.VerificacionLegalProvider;

@Service
public class VerificacionLegalProviderImpl implements VerificacionLegalProvider{

	@Override
	public boolean tieneJuicioAbierto(Empresa empresa) {
		return false;
	}

}
