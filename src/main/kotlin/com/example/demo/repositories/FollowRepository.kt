package com.example.demo.repositories

import com.example.demo.entities.Follow
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FollowRepository: JpaRepository<Follow, Long> {
    fun findByFollowerIdAndAndFollowedId(followerId: Long, followedId: Long): Follow?
}