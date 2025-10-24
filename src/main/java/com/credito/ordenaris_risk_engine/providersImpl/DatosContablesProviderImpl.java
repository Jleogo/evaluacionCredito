package com.credito.ordenaris_risk_engine.providersImpl;

import org.springframework.stereotype.Service;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.providers.DatosContablesProvider;
import com.credito.ordenaris_risk_engine.repository.EmpresaRepository;
@Service
public class DatosContablesProviderImpl implements DatosContablesProvider{

	private final EmpresaRepository empresaRepository;

    public DatosContablesProviderImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
    
	@Override
	public double obtenerVentasPromedio(Empresa empresa) {
		 return empresa.getIngresosAnuales() / 12;
	}

	@Override
	public double obtenerPasivos(Empresa empresa) {
		return empresa.getDeudaTotal();
	}

	@Override
	public double obtenerActivos(Empresa empresa) {
		 return empresa.getActivos();
	}

}
