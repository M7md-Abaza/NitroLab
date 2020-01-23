package com.nitrolab.physics.Models

import java.math.BigDecimal

class TransistorPart2Model(bCurrent: Double, cCurrent: Double) {

    private var baseCurrent = bCurrent
    private var collectorCurrent = cCurrent

    fun getBaseCurrent(): Double {
        return baseCurrent
    }

    fun getCollectorCurrent(): Double {
        return collectorCurrent
    }

}