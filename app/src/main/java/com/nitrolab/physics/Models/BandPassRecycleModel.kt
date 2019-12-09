package com.nitrolab.physics.Models

class BandPassRecycleModel(iFreq: Int, volt: Double, gain: Double, logFreq: Double) {

    private var frequency = iFreq
    private var voltage = volt
    private var gain: Double = gain
    private var logFreq: Double = logFreq

    fun getFrequency(): Int {
        return frequency
    }

    fun getVoltage(): Double {
        return voltage
    }

    fun getGain(): Double {
        return gain
    }

    fun getLogFreq(): Double {
        return logFreq
    }
}
