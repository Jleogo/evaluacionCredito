package com.credito.ordenaris_risk_engine.dto;

import java.util.List;

public class ResultadoRiesgoDTO {
	private NivelRiesgo nivelRiesgo;
    private List<String> reglasEvaluadas;
    private String motivoFinal;
	public ResultadoRiesgoDTO() {
	}
	
	public ResultadoRiesgoDTO(NivelRiesgo nivelRiesgo, List<String> reglasEvaluadas, String motivoFinal) {
		super();
		this.nivelRiesgo = nivelRiesgo;
		this.reglasEvaluadas = reglasEvaluadas;
		this.motivoFinal = motivoFinal;
	}

	public NivelRiesgo getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(NivelRiesgo nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}

	public List<String> getReglasEvaluadas() {
		return reglasEvaluadas;
	}
	public void setReglasEvaluadas(List<String> reglasEvaluadas) {
		this.reglasEvaluadas = reglasEvaluadas;
	}
	public String getMotivoFinal() {
		return motivoFinal;
	}
	public void setMotivoFinal(String motivoFinal) {
		this.motivoFinal = motivoFinal;
	}
}
