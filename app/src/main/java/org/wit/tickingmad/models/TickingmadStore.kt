package org.wit.tickingmad.models

import androidx.lifecycle.MutableLiveData

interface TickingmadStore {
    fun findAll(): List<TickingmadModel>
    fun create(tickingmad: TickingmadModel)
    fun update(tickingmad: TickingmadModel)
    fun delete(tickingmad: TickingmadModel)
    fun findById(id:Long) : TickingmadModel?
}

/*interface TickingmadStore {
    fun findAll(tickingmadsList:
                MutableLiveData<List<TickingmadModel>>
    )
    fun findAll(email: String, tickingmadsList:
    MutableLiveData<List<TickingmadModel>>)
    fun findById(id: String) : TickingmadModel?
    fun create(tickingmad: TickingmadModel)
    fun delete(email: String,id: String)
}*/