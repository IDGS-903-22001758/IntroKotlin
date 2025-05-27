package com.viviana.introkotlin903.practica5_diccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.viviana.introkotlin903.R

class BuscarActivity : AppCompatActivity() {
    private val fileName = "diccionario.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)

        val etBuscar = findViewById<EditText>(R.id.etBuscar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val rbEspanol = findViewById<RadioButton>(R.id.rbEspanol)
        val rbIngles = findViewById<RadioButton>(R.id.rbIngles)
        val btnMenu2 = findViewById<Button>(R.id.btnMenu2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnBuscar.setOnClickListener {
            val palabra = etBuscar.text.toString().trim()
            val resultadoTextView = findViewById<TextView>(R.id.tvResultado)

            if (palabra.isNotEmpty()) {
                val lines = openFileInput(fileName).bufferedReader().readLines()
                var resultado = " Palabra no encontrada"

                for (line in lines) {
                    val partes = line.split(":")
                    if (partes.size == 2) {
                        val esp = partes[0].trim()
                        val eng = partes[1].trim()

                        if ((rbEspanol.isChecked && eng.equals(palabra, ignoreCase = true)) ||
                            (rbIngles.isChecked && esp.equals(palabra, ignoreCase = true))) {
                            resultado = "Resultado: $esp : $eng"
                            break
                        }
                    }
                }

                resultadoTextView.text = resultado
            } else {
                resultadoTextView.text = "Ingresa una palabra para buscar"
            }
        }


        btnMenu2.setOnClickListener {
            finish()
        }
    }
}