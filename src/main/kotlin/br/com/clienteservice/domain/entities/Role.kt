package br.com.clienteservice.domain.entities

import org.springframework.security.core.GrantedAuthority
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Role(
        @Id
        @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
        private val id: UUID = UUID.randomUUID(),
        private val nome: String
): GrantedAuthority{
    override fun getAuthority() = nome
}