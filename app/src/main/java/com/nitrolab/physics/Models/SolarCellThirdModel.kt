package com.nitrolab.physics.Models

class SolarCellThirdModel(d: Double, dSquare: Double, reverse_d: Double, i_mA: Double) {

    private var distance = d
    private var distanceSquare = dSquare
    private var reverseDistance = reverse_d
    private var current = i_mA

    fun getDistance(): Double {
        return distance
    }

    fun getDistanceSquare(): Double {
        return distanceSquare
    }

    fun getReverseDistance(): Double {
        return reverseDistance
    }

    fun getCurrent(): Double {
        return current
    }
}