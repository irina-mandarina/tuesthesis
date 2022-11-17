package com.example.demo.entities

import javax.persistence.*

@Entity
class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "x_cord", nullable = false)
    var x: Double = 0.0

    @Column(name = "y_cord", nullable = false)
    var y: Double = 0.0

    @Column(name = "name")
    var name: String? = null

    @OneToMany(mappedBy = "destination")
    var reviews: List<Review> = listOf()

    @OneToMany(mappedBy = "destination")
    var journeys: List<Journey> = listOf()
}