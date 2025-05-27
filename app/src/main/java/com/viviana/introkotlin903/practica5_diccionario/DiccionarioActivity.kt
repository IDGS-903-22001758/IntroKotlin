package com.viviana.introkotlin903.practica5_diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.viviana.introkotlin903.R

class DiccionarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario)

        val btnCapturar = findViewById<Button>(R.id.btnCapturar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnCapturar.setOnClickListener {
            startActivity(Intent(this, CapturarActivity::class.java))
        }

        btnBuscar.setOnClickListener {
            startActivity(Intent(this, BuscarActivity::class.java))
        }
    }
}