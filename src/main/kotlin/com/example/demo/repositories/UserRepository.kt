package com.example.demo.repositories

import com.example.demo.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findUserById(id: Long): User
    fun findUserByUsername(username: String): User
}