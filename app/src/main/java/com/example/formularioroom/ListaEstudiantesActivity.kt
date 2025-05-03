package com.example.formularioroom

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.formularioroom.model.FormularioRoomApplication
import kotlinx.coroutines.launch

class ListaEstudiantesActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_estudiantes)

        recycler = findViewById(R.id.recyclerEstudiantes)
        recycler.layoutManager = LinearLayoutManager(this)

        cargarEstudiantes()
    }

    private fun cargarEstudiantes() {
        lifecycleScope.launch {
            val estudiantes = FormularioRoomApplication.database.estudianteDao().obtenerTodos()
            runOnUiThread {
                recycler.adapter = EstudianteAdapter(estudiantes, this@ListaEstudiantesActivity)

            }

        }
    }
}

