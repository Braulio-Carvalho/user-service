package br.com.clienteservice.domain.services.impl

import br.com.clienteservice.domain.entities.Cliente
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(private val cliente: Cliente): UserDetails {

    override fun getAuthorities() = cliente.role

    override fun getPassword() = cliente.password

    override fun getUsername() = cliente.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}