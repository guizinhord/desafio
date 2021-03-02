package com.desafio.service;

import com.desafio.dto.reqconta.ContaPostDto;
import com.desafio.dto.reqconta.ContaPutDto;
import com.desafio.model.Cliente;
import com.desafio.model.Conta;
import com.desafio.repository.ContaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ContaServiceTest {

    @InjectMocks
    private ContaService contaService;

    @Mock
    private ContaRepository contaRepositoryMock;


    @Test
    void salvarConta_ComSucesso() {
        Conta contaSalvar = this.criarConta();
        ContaPostDto contaPostDto = this.criarContaPostDto();

        when(contaRepositoryMock.save(any(Conta.class)))
                .thenReturn(contaSalvar);

        Conta conta = contaService.salvar(contaPostDto);
        Assertions.assertThat(conta).isNotNull();
    }

    @Test
    void atualizarConta_ComSucesso() {
        Conta contaSalvar = this.criarConta();
        ContaPutDto contaPutDto = this.criarContaPutDto();

        when(contaRepositoryMock.save(any(Conta.class)))
                .thenReturn(contaSalvar);
        when(contaRepositoryMock.findById(1L))
                .thenReturn(Optional.of(contaSalvar));

        Conta conta = contaService.atualizar(contaPutDto);
        Assertions.assertThat(conta).isNotNull();
    }

    @Test
    void buscarPorId() {
        Conta contaSalvar = this.criarConta();

        when(contaRepositoryMock.findById(1L))
                .thenReturn(Optional.of(contaSalvar));

        Conta conta = contaService.encontreIdOuErro(1L);
        Assertions.assertThat(conta).isNotNull();
    }

    @Test
    void deletarPorId() {
        Conta contaSalvar = this.criarConta();

        when(contaRepositoryMock.findById(1L))
                .thenReturn(Optional.of(contaSalvar));

        contaService.deletar(1L);
        Assertions.assertThat(contaService).isNotNull();
    }


    private Conta criarConta() {
        return Conta.builder()
                .id(1l)
                .numeroConta(4564566)
                .tipoConta("Test")
                .digitoVerificador(454564)
                .saldo(0)
                .cliente(Cliente.builder().id(1l).build())
                .limiteSaque(0)
                .build();
    }

    private ContaPostDto criarContaPostDto() {
        return ContaPostDto.builder()
                .numeroConta(4564566)
                .tipoConta("Test")
                .cliente(Cliente.builder().id(1l).build())
                .digitoVerificador(454564)
                .saldo(0)
                .build();
    }

    private ContaPutDto criarContaPutDto() {
        return ContaPutDto.builder()
                .id(1l)
                .numeroConta(4564566)
                .tipoConta("Test")
                .cliente(Cliente.builder().id(1l).build())
                .digitoVerificador(454564)
                .build();
    }
}