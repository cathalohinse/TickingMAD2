package org.wit.tickingmad.models

import timber.log.Timber.i

class TickingmadMemStore : TickingmadStore {

    val tickingmads = ArrayList<TickingmadModel>()

    override fun findAll(): List<TickingmadModel> {
        return tickingmads
    }

    override fun create(tickingmad: TickingmadModel) {
        tickingmads.add(tickingmad)
        logAll()
    }

    fun logAll() {
        tickingmads.forEach{ i("${it}") }
    }
}