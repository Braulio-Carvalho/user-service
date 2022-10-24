package br.com.clienteservice.application.web

import br.com.clienteservice.application.web.response.ClienteResponse
import br.com.clienteservice.domain.entities.Cliente
import br.com.clienteservice.domain.services.ClienteService
import org.springframework.context.annotation.Lazy
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/clientes")
class ClienteController( private val clienteService: ClienteService) {
    //criar um novo usuario
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarUsuario(@RequestBody cliente: Cliente) {
        clienteService.cadastrar(cliente)
    }

    @GetMapping("/{id}")
    fun listarPorId(@PathVariable id: UUID): Cliente {
        return clienteService.listarPorId(id)
    }

    @GetMapping
    fun getAll(): List<ClienteResponse> {
        return clienteService.listarTodos()
    }

    @GetMapping("/{id}/info")
    fun getInfo(): List<ClienteResponse> {
        return clienteService.listarTodos()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) {
        clienteService.deletar(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody cliente: Cliente) {
        clienteService.atualizar(id, cliente)
    }

}