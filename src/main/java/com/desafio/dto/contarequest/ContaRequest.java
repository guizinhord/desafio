package com.desafio.dto.contarequest;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ContaRequest {
    private Long id;
    @NotNull(message = "Numero da conta não pode ser nulo")
    @Range(min = 10000000, max = 100000000, message = "Numero da conta deve ser 8 digitos")
    private int numeroConta;
    @NotNull(message = "Tipo da conta não pode ser nulo")
    private String tipoConta;
    @NotNull(message = "CPF da conta não pode ser nulo")
    private String cpfCliente;
}
