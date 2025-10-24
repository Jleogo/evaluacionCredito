package com.credito.ordenaris_risk_engine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credito.ordenaris_risk_engine.dto.NivelRiesgo;
import com.credito.ordenaris_risk_engine.dto.ResultadoRiesgoDTO;
import com.credito.ordenaris_risk_engine.dto.SolicitudRiesgoDTO;
import com.credito.ordenaris_risk_engine.service.OrdenarisRiskEngineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/risk")
public class OrdenarisRiskEngineController {
	private final OrdenarisRiskEngineService riesgoService;

    public OrdenarisRiskEngineController(OrdenarisRiskEngineService riesgoService) {
        this.riesgoService = riesgoService;
    }
    
    @PostMapping("/evaluar")
    public ResponseEntity<ResultadoRiesgoDTO> evaluarRiesgo(@Valid @RequestBody SolicitudRiesgoDTO solicitud) {
        try {
            ResultadoRiesgoDTO resultado = riesgoService.evaluarRiesgo(solicitud);
            return ResponseEntity.ok(resultado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResultadoRiesgoDTO(NivelRiesgo.ERROR, null, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResultadoRiesgoDTO(NivelRiesgo.ERROR, null, "Error interno del servidor"));
        }
    }

}
