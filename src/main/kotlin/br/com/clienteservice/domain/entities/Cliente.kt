package br.com.clienteservice.domain.entities

import br.com.clienteservice.application.web.response.ClienteResponse
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cliente", schema = "public")
data class Cliente(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID = UUID.randomUUID(),
        val cpf: String,
        val email: String,
        val endereco: String,
        val nome: String,
        val telefone: String,

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "cliente_role")
        val role: List<Role>,
        val password: String
)

fun Cliente.toModel() = ClienteResponse(
        id = id,
        cpf = cpf,
        email = email,
        endereco = endereco,
        nome = nome,
        telefone = telefone,
        role = role
)