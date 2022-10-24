//package br.com.clienteservice.application.web
//
//import br.com.clienteservice.application.config.JWTUtil
//import br.com.clienteservice.domain.entities.Credentials
//import br.com.clienteservice.domain.services.ClienteService
//import org.springframework.stereotype.Controller
//import org.springframework.web.bind.annotation.PostMapping
//
//@Controller("Auth")
//class AuthController(private val clienteService: ClienteService, private val jwtUtil: JWTUtil) {
//
//    @PostMapping
//    fun auth(credentials: Credentials){
//        jwtUtil.getAuthentication()
//    }
//}