package com.example.formularioroom.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Estudiante::class], version = 1)
abstract class BaseDeDatosEstudiante : RoomDatabase() {
    abstract fun estudianteDao(): EstudianteDao
}