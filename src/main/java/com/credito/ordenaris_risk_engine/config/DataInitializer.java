package com.credito.ordenaris_risk_engine.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.credito.ordenaris_risk_engine.dao.Empresa;
import com.credito.ordenaris_risk_engine.repository.EmpresaRepository;

@Configuration
public class DataInitializer {
	@Bean
    CommandLineRunner initDatabase(EmpresaRepository empresaRepository) {
        return args -> {
            Empresa e1 = new Empresa();
            e1.setNombre("TechCorp");
            e1.setAniosOperacion(5);
            e1.setIngresosAnuales(2500000);
            e1.setDeudaTotal(500000);
            e1.setEmpleados(40);
            e1.setSector("TECNOLOGIA");
            e1.setActivos(250000);
            empresaRepository.save(e1);

            Empresa e2 = new Empresa();
            e2.setNombre("ComercialMX");
            e2.setAniosOperacion(10);
            e2.setIngresosAnuales(8000000);
            e2.setDeudaTotal(1500000);
            e2.setEmpleados(120);
            e2.setSector("COMERCIO");
            e2.setActivos(550000);
            empresaRepository.save(e2);
            
            Empresa e3 = new Empresa();
            e3.setNombre("StartupNova");
            e3.setAniosOperacion(1);
            e3.setIngresosAnuales(100000);
            e3.setDeudaTotal(0);
            e3.setEmpleados(5);
            e3.setSector("SERVICIOS");
            e3.setActivos(50000);
            empresaRepository.save(e3);

            Empresa e4 = new Empresa();
            e4.setNombre("ServiciosPlus");
            e4.setAniosOperacion(3);
            e4.setIngresosAnuales(120000);
            e4.setDeudaTotal(20000);
            e4.setEmpleados(10);
            e4.setSector("SERVICIOS");
            e4.setActivos(50000);
            empresaRepository.save(e4);

            Empresa e5 = new Empresa();
            e5.setNombre("ArrendamientosSA");
            e5.setAniosOperacion(8);
            e5.setIngresosAnuales(500000);
            e5.setDeudaTotal(50000);
            e5.setEmpleados(15);
            e5.setSector("FINANCIERO");
            e5.setActivos(100000);
            empresaRepository.save(e5);

            System.out.println("Datos iniciales cargados en H2");
        };
    }
}
