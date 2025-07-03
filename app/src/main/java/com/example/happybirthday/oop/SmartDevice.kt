package com.example.happybirthday.oop

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
* In kotlin all the classes are final by default so do inherit and use them
* Mentions that as open*/
open class SmartDevice(
    val name: String = "",
    val hasSpeaker: Boolean = false,
    val digital: String = "",
    val category: String = ""
) {
    /*
    * Methods also must be open if they will have to override them because that's also final by default
    * */
    open fun welcome(message: String = "Smart world"){
        println("Welcome to the $message")
    }
}
/*
* If the parent class has Primary constructor and required parameters
* so we have to pass them in the child class as well as default or from the object
* */
class SmartTv(
    name: String = "Android TV",
    hasSpeaker: Boolean = true,
    digital: String = "Yes",
) : SmartDevice(name, hasSpeaker, digital) {
    private var speakerVolume by RangeRegulator(initialValue = 2, min = 0, max = 100)
    private var channelVolume by RangeRegulator(initialValue = 1, min = 1, max = 225)
    fun turnOn() {
        println("Smart TV turned on")
    }
    fun turnOff() {
        println("Smart TV turned off")
    }
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to ${speakerVolume}.")
    }

    fun changeChannel(channel: Int = channelVolume) {
        this.channelVolume = channel
        println("Changed the channel to ${channelVolume}")
    }
}
/*
* This will be Is-A relationship with the Parent class it means the everything the parent class
* do the child class can also do the same */
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    private var brightnessLevel by RangeRegulator(initialValue = 25, min = 0, max = 100)
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    fun turnOn() {
        brightnessLevel = 25
        println("Smart light turned on")
    }
    fun turnOff() {
        brightnessLevel = 0
        println("Smart light turned off")
    }
    override fun welcome(message: String) {
        super.welcome(message)
    }
}

/*
* This will be a has-A relationship with the class because it contains the SmartTv as a
* Property in the SmartHome class
* */
class SmartHome(
    val smartTvDevice: SmartTv,
    val smartLightDevice: SmartLightDevice
) {

    fun turnOnTv() {
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.changeChannel(12)
    }

    fun lightWelcome() {
        smartLightDevice.welcome("Smart light")
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }

}

class RangeRegulator (
    initialValue: Int,
    private val min: Int,
    private val max: Int
): ReadWriteProperty<Any?, Int>{
    var fieldValue = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldValue
    }

    override fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: Int
    ) {
        if(fieldValue in min..max){
            fieldValue = value
        }
    }

}