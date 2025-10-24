package com.credito.ordenaris_risk_engine.rules;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.dto.NivelRiesgo;
import com.credito.ordenaris_risk_engine.dto.ProductoFinanciero;
import com.credito.ordenaris_risk_engine.dto.SolicitudRiesgoDTO;

public class ProductoEstrictoRegla implements ReglaRiesgo{

	@Override
	public ResultadoRegla evaluar(Empresa empresa, SolicitudRiesgoDTO solicitud) {
		 if (solicitud.getProductoFinanciero() == ProductoFinanciero.ARRENDAMIENTO_FINANCIERO) {
	            return new ResultadoRegla("Producto estricto", NivelRiesgo.ALTO, true);
	        }
	        return new ResultadoRegla("Producto estricto", null, false);
	}

}
