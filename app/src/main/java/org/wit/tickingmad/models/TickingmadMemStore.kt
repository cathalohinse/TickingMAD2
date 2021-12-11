package org.wit.tickingmad.models

import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class TickingmadMemStore : TickingmadStore {

    val tickingmads = ArrayList<TickingmadModel>()

    override fun findAll(): List<TickingmadModel> {
        return tickingmads
    }

    override fun create(tickingmad: TickingmadModel) {
        tickingmad.id = getId()
        tickingmads.add(tickingmad)
        logAll()
    }

    override fun update(tickingmad: TickingmadModel) {
        val foundTickingmad: TickingmadModel? = tickingmads.find { p -> p.id == tickingmad.id }
        if (foundTickingmad != null) {
            foundTickingmad.title = tickingmad.title
            foundTickingmad.description = tickingmad.description
            foundTickingmad.image = tickingmad.image
            foundTickingmad.lat = tickingmad.lat
            foundTickingmad.lng = tickingmad.lng
            foundTickingmad.zoom = tickingmad.zoom
            logAll()
        }
    }

    override fun delete(tickingmad: TickingmadModel) {
        //var foundTickingmad: TickingmadModel? = tickingmads.find { p -> p.id == tickingmad.id }
        //if (foundTickingmad != null) {
            tickingmads.remove(tickingmad)

            //logAll()
        //}
    }

    private fun logAll() {
        tickingmads.forEach { i("$it") }
    }

    override fun findById(id:Long) : TickingmadModel? {
        val foundTickingmad: TickingmadModel? = tickingmads.find { it.id == id }
        return foundTickingmad
    }
}