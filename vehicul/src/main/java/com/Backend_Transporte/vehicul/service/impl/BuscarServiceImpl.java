package com.Backend_Transporte.vehicul.service.impl;

import com.Backend_Transporte.vehicul.dto.BuscarRequestDTO;
import com.Backend_Transporte.vehicul.service.BuscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class BuscarServiceImpl implements BuscarService {
    @Autowired
    ResourceLoader resourceLoader;
    @Override
    public String[] buscarVehiculo(BuscarRequestDTO buscarRequestDTO) throws IOException {
        String[] datosVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");
                if (buscarRequestDTO.placa().equals(datos[0])) {

                    datosVehiculo = new String[5];
                    datosVehiculo[0] = datos[1]; // Recuperar marca
                    datosVehiculo[1] = datos[2]; // Recuperar modelo
                    datosVehiculo[2] = datos[3]; // Recuperar nro asientos
                    datosVehiculo[3] = datos[4]; // Recuperar precio
                    datosVehiculo[4] = datos[5]; // Recuperar color

                }

            }

        } catch (IOException e) {
            datosVehiculo = null;
            throw new IOException(e);
        }

        return datosVehiculo;
    }
}
