package com.example.demo.controllers

import com.example.demo.models.requestModels.LogInRequest
import com.example.demo.models.requestModels.SignUpRequest
import com.example.demo.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
class UserController(val userService: UserService) {
    @PostMapping("/users/login")
    fun logIn(@RequestBody logInRequest: LogInRequest): ResponseEntity<String> {
        return userService.logIn(logInRequest)
    }

    @PostMapping("/users/signup")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<String> {
        println("in user controller")
        return userService.signUp(signUpRequest)
    }

    @PostMapping("/users/logout")
    fun logOut(@RequestHeader username: String): ResponseEntity<String> {
        return userService.logOut(username)
    }

    @GetMapping("/users/{username}")
    fun getUserDetails(@RequestHeader username: String, @PathVariable("username") otherUserUsername: String): ResponseEntity<String> {
        return userService.getUserDetails(username)
    }

    @GetMapping("/users/details") // ??
    fun getMyDetails(@RequestHeader username: String): ResponseEntity<String> {
        return userService.getUserDetails(username)
    }

    @DeleteMapping("/users/delete-account")
    fun deleteAccount(@RequestHeader username: String): ResponseEntity<String> {
        return userService.deleteAccount(username)
    }

    @PostMapping("/users/bio")
    fun addBio(@RequestHeader username: String, @RequestBody bio: String): ResponseEntity<String> {
        return userService.setBio(username, bio)
    }

    @PutMapping("/users/bio")
    fun editBio(@RequestHeader username: String, @RequestBody bio: String): ResponseEntity<String> {
        return userService.setBio(username, bio)
    }
}