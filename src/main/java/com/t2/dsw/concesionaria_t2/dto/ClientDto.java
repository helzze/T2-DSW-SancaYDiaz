package com.t2.dsw.concesionaria_t2.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto {
    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String telefono;
}
