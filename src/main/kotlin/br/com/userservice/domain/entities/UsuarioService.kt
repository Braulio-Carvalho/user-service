package br.com.userservice.domain.entities

import java.util.UUID

data class UsuarioService(
    val id: UUID,
    val produtos: List<String>,
    val name: String,
    val cpf: String,
    val telefone: String,
    val endereço: String,
    val email: String,
    val type: String
)
