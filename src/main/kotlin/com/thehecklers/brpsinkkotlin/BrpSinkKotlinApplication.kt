package com.thehecklers.brpsinkkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import java.util.function.Consumer

@SpringBootApplication
class BrpSinkKotlinApplication

fun main(args: Array<String>) {
    runApplication<BrpSinkKotlinApplication>(*args)
}

@Configuration
//@EnableBinding(Sink::class)
class FlightAttendant {
    @Bean
//    MH: Not yet available, but coming soon
//    fun seatPassenger(): (Flux<FlyingPassenger>) -> Unit =
//        {
    fun seatPassenger(): Consumer<Flux<FlyingPassenger>> =
        Consumer {
            it.subscribe {
                println(it)
            }
        }

    /*  MH: Non-Publisher example
    @StreamListener(Sink.INPUT)
	fun seatPassenger(flyingPassenger: FlyingPassenger) = println(flyingPassenger)
    */
}

data class FlyingPassenger(val id: String, val name: String, val state: State) {
    enum class State {
        VALUED_PASSENGER,
        PREMIUM_PASSENGER
    }
}
