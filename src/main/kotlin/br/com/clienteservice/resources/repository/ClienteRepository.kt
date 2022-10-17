package br.com.clienteservice.resources.repository

import br.com.clienteservice.application.web.response.ClienteResponse
import br.com.clienteservice.domain.entities.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ClienteRepository: JpaRepository<Cliente, UUID> {
  fun findByEmail(username: String?): Cliente?
  override fun findAll(): List<Cliente>
}


