package com.credito.ordenaris_risk_engine.providersImpl;

import org.springframework.stereotype.Service;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.providers.HistorialPagosProvider;

@Service
public class HistorialPagosProviderImpl implements HistorialPagosProvider{

	@Override
	public boolean historial(Empresa empresa) {
		return empresa.getDeudaTotal() < 500000;
	}

}
