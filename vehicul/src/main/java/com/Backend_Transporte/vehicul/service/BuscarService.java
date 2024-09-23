package com.Backend_Transporte.vehicul.service;

import com.Backend_Transporte.vehicul.dto.BuscarRequestDTO;

import java.io.IOException;

public interface BuscarService {
    String [] buscarVehiculo(BuscarRequestDTO buscarRequestDTO) throws IOException;
}
