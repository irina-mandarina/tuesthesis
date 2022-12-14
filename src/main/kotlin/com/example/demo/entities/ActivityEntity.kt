package com.example.demo.entities

import com.example.demo.models.requestModels.ActivityRequest
import com.example.demo.types.ActivityTypes
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "activities")
class ActivityEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @JoinColumn(name = "journey_id", nullable = false)
    @ManyToOne
    lateinit var journey: JourneyEntity

    @Column(name = "date", nullable = false)
    var date: Timestamp = Timestamp.valueOf(LocalDateTime.now())

    @Column(name = "title", nullable = false)
    var title: String = ""

    @Column(name = "type", nullable = false)
    var type: ActivityTypes = ActivityTypes.OTHER

    @Column(name = "description")
    var description: String = ""

    @Column(name = "location", nullable = false)
    var location: String = ""

    constructor(postActivity: ActivityRequest, journey: JourneyEntity) : this() {
        this.date = postActivity.date
        this.journey = journey
        this.title = postActivity.title
        this.location = postActivity.location
        this.description = postActivity.description
        this.type = postActivity.type
    }
}