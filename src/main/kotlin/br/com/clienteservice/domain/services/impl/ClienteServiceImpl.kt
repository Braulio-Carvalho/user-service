package br.com.clienteservice.domain.services.impl

import br.com.clienteservice.application.web.response.ClienteResponse
import br.com.clienteservice.domain.entities.Cliente
import br.com.clienteservice.domain.entities.toModel
import br.com.clienteservice.domain.services.ClienteService
import br.com.clienteservice.resources.repository.ClienteRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClienteServiceImpl(private val clienteRepository: ClienteRepository) : UserDetailsService, ClienteService {

    override fun cadastrar(cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    override fun atualizar(id: UUID, cliente: Cliente): Cliente {
        val clienteExistente = clienteRepository.findById(id).orElseThrow { Exception("Cliente não encontrado") }
        clienteExistente.copy(id = cliente.id,
                cpf = cliente.cpf,
                email = cliente.email,
                endereco = cliente.endereco,
                nome = cliente.nome,
                telefone = cliente.telefone,
                role = cliente.role,
                password = cliente.password
        )
        return clienteRepository.saveAndFlush(clienteExistente)
    }

    override fun deletar(id: UUID) {
        val clienteExistente = clienteRepository.findById(id).orElseThrow { Exception("Cliente não encontrado") }
        clienteRepository.delete(clienteExistente)
    }

    override fun listarPorId(id: UUID): Cliente {
        return clienteRepository.findById(id).orElseThrow { Exception("Cliente não encontrado") }
    }

    override fun listarTodos(): List<ClienteResponse> {
        return clienteRepository.findAll().map { it.toModel() }
    }

    override fun informacoes(id: UUID): String {
        return "Cliente: ${listarPorId(id).nome}"
    }

    override fun findByEmail(username: String?): Cliente? {
        return clienteRepository.findByEmail(username)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val cliente = clienteRepository.findByEmail(username!!) ?: throw RuntimeException("Cliente não encontrado")
        return UserDetail(cliente)
    }

}