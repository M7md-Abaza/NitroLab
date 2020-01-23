package com.nitrolab.physics.Models

class NTCRecycleModel(celsius:Double,kelvin:Double,reverseKelvin:Double,resistance:Double,logResistance:Double){

    private var tCelsius = celsius
    private var tKelvin = kelvin
    private var tReverseKelvin = reverseKelvin
    private var tResistance = resistance
    private var tLogResistance = logResistance

    fun getCelsius(): Double {
        return tCelsius
    }
    fun getKelvin(): Double {
        return tKelvin
    }
    fun getReverseKelvin(): Double {
        return tReverseKelvin
    }

    fun getResistance(): Double {
        return tResistance
    }
    fun getLogResistance(): Double {
        return tLogResistance
    }



}
