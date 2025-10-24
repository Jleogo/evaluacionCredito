package com.credito.ordenaris_risk_engine.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.dto.NivelRiesgo;
import com.credito.ordenaris_risk_engine.dto.ResultadoRiesgoDTO;
import com.credito.ordenaris_risk_engine.dto.SolicitudRiesgoDTO;
import com.credito.ordenaris_risk_engine.providers.DatosContablesProvider;
import com.credito.ordenaris_risk_engine.providers.HistorialPagosProvider;
import com.credito.ordenaris_risk_engine.providers.VerificacionLegalProvider;
import com.credito.ordenaris_risk_engine.repository.EmpresaRepository;
import com.credito.ordenaris_risk_engine.rules.AltaSolicitudRegla;
import com.credito.ordenaris_risk_engine.rules.DemandaLegalRegla;
import com.credito.ordenaris_risk_engine.rules.DeudaActivaRegla;
import com.credito.ordenaris_risk_engine.rules.EmpresaNuevaRegla;
import com.credito.ordenaris_risk_engine.rules.HistorialExcelenteRegla;
import com.credito.ordenaris_risk_engine.rules.ProductoEstrictoRegla;
import com.credito.ordenaris_risk_engine.rules.ReglaRiesgo;
import com.credito.ordenaris_risk_engine.service.OrdenarisRiskEngineService;

@Service
public class OrdenarisRiskEngineServiceImpl implements OrdenarisRiskEngineService{
	private final EmpresaRepository empresaRepository;
	private final List<ReglaRiesgo> reglas;
	private final DatosContablesProvider datosContablesProvider;
    private final HistorialPagosProvider historialPagosProvider;
    private final VerificacionLegalProvider verificacionLegalProvider;
    
	public OrdenarisRiskEngineServiceImpl(EmpresaRepository empresaRepository, DatosContablesProvider datosContablesProvider,
		HistorialPagosProvider historialPagosProvider, VerificacionLegalProvider verificacionLegalProvider) {
		this.empresaRepository = empresaRepository;
		this.datosContablesProvider = datosContablesProvider;
		this.historialPagosProvider = historialPagosProvider;
		this.verificacionLegalProvider = verificacionLegalProvider;
		
		reglas = List.of(
		new DeudaActivaRegla(datosContablesProvider),
		new AltaSolicitudRegla(datosContablesProvider),
		new EmpresaNuevaRegla(),
		new DemandaLegalRegla(verificacionLegalProvider),
		new HistorialExcelenteRegla(historialPagosProvider),
		new ProductoEstrictoRegla()
		);
}

	@Override
    public ResultadoRiesgoDTO evaluarRiesgo(SolicitudRiesgoDTO solicitud) {
        Empresa empresa = empresaRepository.findById(Long.parseLong(solicitud.getEmpresaId()))
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        ResultadoRiesgoDTO resultado = new ResultadoRiesgoDTO();
        List<String> reglasEvaluadas = new ArrayList<>();
        NivelRiesgo nivelRiesgoFinal = NivelRiesgo.BAJO;

        for (ReglaRiesgo regla : reglas) {
            var res = regla.evaluar(empresa, solicitud);
            reglasEvaluadas.add(res.getNombreRegla());

            if (res.getNivelRiesgo() != null) {
                if (res.getNivelRiesgo() == NivelRiesgo.RECHAZADO) {
                    nivelRiesgoFinal = NivelRiesgo.RECHAZADO;
                    break;
                }
                // Ajustar nivel de riesgo si no es RECHAZADO
                if (res.getNivelRiesgo().ordinal() > nivelRiesgoFinal.ordinal()) {
                    nivelRiesgoFinal = res.getNivelRiesgo();
                }
            }
        }

        resultado.setNivelRiesgo(nivelRiesgoFinal);
        resultado.setReglasEvaluadas(reglasEvaluadas);
        resultado.setMotivoFinal("Evaluación basada en reglas configuradas");

        return resultado;
    }

	
	private NivelRiesgo ajustarNivelRiesgo(NivelRiesgo actual, NivelRiesgo nuevo) {
        if (nuevo == NivelRiesgo.RECHAZADO) return NivelRiesgo.RECHAZADO;
        if (nuevo == NivelRiesgo.ALTO) {
            if (actual == NivelRiesgo.BAJO || actual == NivelRiesgo.MEDIO) return NivelRiesgo.ALTO;
        }
        if (nuevo == NivelRiesgo.MEDIO) {
            if (actual == NivelRiesgo.BAJO) return NivelRiesgo.MEDIO;
        }
        return actual;
    }

}
