package com.example.demo.entities

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*
import org.springframework.data.relational.core.mapping.Table

@Entity
@Table(name = "follow_requests")
class FollowRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "request_date", nullable = false)
    var requestDate: Timestamp = Timestamp.valueOf(LocalDateTime.now())

    @JoinColumn(name = "requester_id", nullable = false)
    @ManyToOne
    lateinit var requester: User

    @JoinColumn(name = "receiver_id", nullable = false)
    @ManyToOne
    lateinit var receiver: User

}