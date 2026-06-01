package com.example.clienteapi.service;

import com.example.clienteapi.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final List<Cliente> clientes = new ArrayList<>();
    private Long nextId = 1L;

    public List<Cliente> listar() {
        return clientes;
    }

    public Cliente criar(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    public Cliente buscarPorId(Long id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean remover(Long id) {
        return clientes.removeIf(cliente -> cliente.getId().equals(id));
    }

    public Cliente atualizar(Long id, Cliente novoCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteAtual = clientes.get(i);

            if (clienteAtual.getId().equals(id)) {
                novoCliente.setId(id);
                clientes.set(i, novoCliente);
                return novoCliente;
            }
        }

        return null;
    }
}
