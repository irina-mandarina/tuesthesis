package com.example.demo.entities

import com.example.demo.serialization.TimestampSerializer
import kotlinx.serialization.Serializable
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "follow")
class Follow() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "follow_date", nullable = false)
    var followDate: Timestamp = Timestamp.valueOf(LocalDateTime.now())

    @JoinColumn(name = "follower_id", nullable = false)
    @ManyToOne
    var follower: User = User()

    @JoinColumn(name = "followed_id", nullable = false)
    @ManyToOne
    var followed: User = User()

    constructor(followRequest: FollowRequest) : this() {
        this.followDate = Timestamp.valueOf(LocalDateTime.now())
        this.followed = followRequest.receiver
        this.follower = followRequest.receiver
    }
}