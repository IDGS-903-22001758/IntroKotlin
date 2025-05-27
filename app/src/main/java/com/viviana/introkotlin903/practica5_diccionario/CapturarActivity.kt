package com.viviana.introkotlin903.practica5_diccionario

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.viviana.introkotlin903.R
import java.io.File

class CapturarActivity : AppCompatActivity() {

    private val fileName = "diccionario.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar)

        val etEspanol = findViewById<EditText>(R.id.etEspanol)
        val etIngles = findViewById<EditText>(R.id.etIngles)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        val btnMenu = findViewById<Button>(R.id.btnMenu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    btnGuardar.setOnClickListener {
        val esp = etEspanol.text.toString().trim()
        val eng = etIngles.text.toString().trim()
        mostrarPalabrasGuardadas()
        if (esp.isNotEmpty() && eng.isNotEmpty()) {
            val line = "$esp:$eng\n"
            openFileOutput(fileName, Context.MODE_APPEND).use {
                it.write(line.toByteArray())
            }
            tvMensaje.text = "Palabras guardadas con éxito"
            etEspanol.text.clear()
            etIngles.text.clear()
        } else {
            tvMensaje.text = "Debes llenar ambos campos"
        }
    }
        btnMenu.setOnClickListener {
        finish()

    }

}
    fun mostrarPalabrasGuardadas() {
        val tvTodas = findViewById<TextView>(R.id.tvTodas)
        val file = File(filesDir, fileName)
        if (file.exists()) {
            val contenido = file.readText()
            tvTodas.text = "Palabras Guardadas:\n$contenido"
        } else {
            tvTodas.text = "No hay palabras guardadas aún."
        }
    }
}