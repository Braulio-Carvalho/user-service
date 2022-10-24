package br.com.clienteservice.domain.services

import br.com.clienteservice.application.web.response.ClienteResponse
import br.com.clienteservice.domain.entities.Cliente
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

interface ClienteService {

    fun cadastrar(cliente: Cliente): Cliente
    fun atualizar(id : UUID, cliente: Cliente): Cliente
    fun deletar(id: UUID)
    fun listarPorId(id: UUID): Cliente
    fun listarTodos(): List<ClienteResponse>
    fun informacoes(id: UUID): String
    fun findByEmail(username: String?): Cliente?
    fun loadUserByUsername(username: String?): UserDetails
}