package com.credito.ordenaris_risk_engine.rules;

import com.credito.ordenaris_risk_engine.dto.NivelRiesgo;

public class ResultadoRegla {
	private String nombreRegla;
	private NivelRiesgo nivelRiesgo;
    private boolean aplica;
	public ResultadoRegla() {
	}
	public ResultadoRegla(String nombreRegla, NivelRiesgo nivelRiesgo, boolean aplica) {
		this.nombreRegla = nombreRegla;
		this.nivelRiesgo = nivelRiesgo;
		this.aplica = aplica;
	}
	public String getNombreRegla() {
		return nombreRegla;
	}
	public void setNombreRegla(String nombreRegla) {
		this.nombreRegla = nombreRegla;
	}
	public NivelRiesgo getNivelRiesgo() {
		return nivelRiesgo;
	}
	public void setNivelRiesgo(NivelRiesgo nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}
	public boolean isAplica() {
		return aplica;
	}
	public void setAplica(boolean aplica) {
		this.aplica = aplica;
	}
}
