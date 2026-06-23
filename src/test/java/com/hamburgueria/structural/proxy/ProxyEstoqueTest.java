package com.hamburgueria.structural.proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProxyEstoqueTest {

    @Test
    @DisplayName("Proxy deve permitir consulta de quantidade para qualquer perfil")
    void deveConsultarQuantidadeNormalmente() {
        ServicoEstoque proxy = new ProxyEstoque("ATENDENTE");

        int quantidade = proxy.consultarQuantidade("Pao");

        assertEquals(200, quantidade);
    }

    @Test
    @DisplayName("Proxy deve bloquear atualizacao de estoque para perfis nao autorizados")
    void deveBloquearAtualizacaoParaPerfilNaoAutorizado() {
        ServicoEstoque proxy = new ProxyEstoque("ATENDENTE");

        assertThrows(SecurityException.class, () -> proxy.atualizarQuantidade("Pao", 500));
    }

    @Test
    @DisplayName("Proxy deve permitir atualizacao de estoque para o perfil GERENTE")
    void devePermitirAtualizacaoParaGerente() {
        ServicoEstoque proxy = new ProxyEstoque("GERENTE");

        assertDoesNotThrow(() -> proxy.atualizarQuantidade("Carne", 400));
        assertEquals(400, proxy.consultarQuantidade("Carne"));
    }

    @Test
    @DisplayName("Segunda consulta ao mesmo ingrediente deve vir do cache sem alterar o valor")
    void segundaConsultaDeveUsarCache() {
        ServicoEstoque proxy = new ProxyEstoque("ATENDENTE");

        int primeira = proxy.consultarQuantidade("Queijo");
        int segunda = proxy.consultarQuantidade("Queijo");

        assertEquals(primeira, segunda);
    }

    @Test
    @DisplayName("Cliente deve poder usar o proxy de forma transparente atraves da interface ServicoEstoque")
    void clienteDeveUsarProxyTransparentemente() {
        ServicoEstoque servico = new ProxyEstoque("GERENTE");

        assertInstanceOf(ServicoEstoque.class, servico);
        assertDoesNotThrow(() -> servico.consultarQuantidade("Pao"));
    }
}
