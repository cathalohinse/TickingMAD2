package org.wit.tickingmad.models

interface TickingmadStore {
    fun findAll(): List<TickingmadModel>
    fun create(tickingmad: TickingmadModel)
    fun update(tickingmad: TickingmadModel)
}