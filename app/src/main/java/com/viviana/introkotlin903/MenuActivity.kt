package com.viviana.introkotlin903

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.viviana.introkotlin903.ejemplo1.CinepolisActivity
import com.viviana.introkotlin903.practica1.saludoActivity
import com.viviana.introkotlin903.practica2.OperasActivity
import com.viviana.introkotlin903.practica3.ejemplo3Activity
import com.viviana.introkotlin903.practica4.ArchivosActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSaludo = findViewById<Button>(R.id.btn1)

        btnSaludo.setOnClickListener{navegateToSaludo()}

        val btnCalcula = findViewById<Button>(R.id.btn2)

        btnCalcula.setOnClickListener{navegateToCalcula()}

        val btnCinepolis = findViewById<Button>(R.id.btn3)

        btnCinepolis.setOnClickListener{navegateToCinepolis()}

        val btnEjercio3 = findViewById<Button>(R.id.btn4)

        btnEjercio3.setOnClickListener{navegateToEjercicio3()}

        val btnArchivos = findViewById<Button>(R.id.btn5)

        btnArchivos.setOnClickListener{navegateToArchivos()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToArchivos() {
        val intent = Intent(this, ArchivosActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToEjercicio3() {
        val intent = Intent(this,ejemplo3Activity::class.java)
        startActivity(intent)
    }

    private fun navegateToCalcula() {
        val intent = Intent(this,OperasActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToSaludo() {
        val intent = Intent(this,saludoActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToCinepolis() {
        val intent = Intent(this,CinepolisActivity::class.java)
        startActivity(intent)
    }
}