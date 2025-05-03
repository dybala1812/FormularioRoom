package com.example.formularioroom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.formularioroom.model.Estudiante
import com.example.formularioroom.model.FormularioRoomApplication
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etApellido: EditText
    private lateinit var etCarrera: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnVerLista: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre = findViewById(R.id.etNombre)
        etApellido = findViewById(R.id.etApellido)
        etCarrera = findViewById(R.id.etCarrera)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnVerLista = findViewById(R.id.btnVerLista)

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val carrera = etCarrera.text.toString()

            if (nombre.isNotEmpty() && apellido.isNotEmpty() && carrera.isNotEmpty()) {
                val estudiante = Estudiante(nombre = nombre, apellido = apellido, carrera = carrera)

                lifecycleScope.launch {
                    FormularioRoomApplication.database.estudianteDao().insertar(estudiante)
                    runOnUiThread {
                        Toast.makeText(applicationContext, "Estudiante guardado", Toast.LENGTH_SHORT).show()
                        limpiarCampos()
                    }
                }
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnVerLista.setOnClickListener {
            startActivity(Intent(this, ListaEstudiantesActivity::class.java))
        }
    }

    private fun limpiarCampos() {
        etNombre.text.clear()
        etApellido.text.clear()
        etCarrera.text.clear()
    }
}
