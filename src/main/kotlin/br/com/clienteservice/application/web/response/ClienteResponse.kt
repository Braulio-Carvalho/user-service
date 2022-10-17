package br.com.clienteservice.application.web.response

import br.com.clienteservice.domain.entities.Role
import java.util.*

class ClienteResponse(
        val id: UUID = UUID.randomUUID(),
        val cpf: String,
        val email: String,
        val endereco: String,
        val nome: String,
        val telefone: String,
        val role: List<Role>,
)