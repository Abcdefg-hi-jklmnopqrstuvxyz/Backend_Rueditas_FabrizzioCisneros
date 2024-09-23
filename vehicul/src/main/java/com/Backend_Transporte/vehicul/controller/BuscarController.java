package com.Backend_Transporte.vehicul.controller;

import com.Backend_Transporte.vehicul.dto.BuscarRequestDTO;
import com.Backend_Transporte.vehicul.dto.BuscarResponseDTO;
import com.Backend_Transporte.vehicul.service.BuscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/vehiculos")
public class BuscarController {
    @Autowired
    BuscarService buscarService;

    @PostMapping("/buscar")
    public BuscarResponseDTO buscarVehiculo(@RequestBody BuscarRequestDTO buscarRequestDTO) {
        try {

            String[] datosVehiculos = buscarService.buscarVehiculo(buscarRequestDTO);

            if (datosVehiculos == null) {
                return new BuscarResponseDTO("02","Error: Vehiculo no encontrado", "Error: Vehiculo no encontrado",00,0.0,"Error: Vehiculo no encontrado");
            }
            // Conversión de datos
            int nroAsientos = Integer.parseInt(datosVehiculos[2]); // Convierte a Integer
            double precio = Double.parseDouble(datosVehiculos[3]); // Convierte a Double

            return new BuscarResponseDTO("00",datosVehiculos[0], datosVehiculos[1],nroAsientos,precio,datosVehiculos[4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new BuscarResponseDTO("02","Error: Vehiculo no encontrado", "Error: Vehiculo no encontrado", 00,0.0,"Error: Vehiculo no encontrado");
        }
    }
}
