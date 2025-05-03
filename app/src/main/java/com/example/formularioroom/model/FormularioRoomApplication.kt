package com.example.formularioroom.model

import android.app.Application
import androidx.room.Room

class FormularioRoomApplication:Application() {
    companion object {
        lateinit var database: BaseDeDatosEstudiante
    }
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            BaseDeDatosEstudiante::class.java,
            "mi_base_datos"
        )
            .build()
    }
}
