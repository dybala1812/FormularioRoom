package com.example.formularioroom.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface EstudianteDao {
    @Insert
    suspend fun insertar(estudiante: Estudiante)

    @Update
    suspend fun actualizar(estudiante: Estudiante)

    @Delete
    suspend fun eliminar(estudiante: Estudiante)

    @Query("SELECT * FROM estudiantes ORDER BY id DESC")
    suspend fun obtenerTodos(): List<Estudiante>
}
