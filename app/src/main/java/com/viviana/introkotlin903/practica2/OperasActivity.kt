package com.viviana.introkotlin903.practica2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.viviana.introkotlin903.R

class OperasActivity : AppCompatActivity() {
    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var btn1: Button
    private lateinit var tv1: TextView
    private lateinit var Grupo1: RadioGroup
    private lateinit var r1: RadioButton
    private lateinit var r2: RadioButton
    private lateinit var r3: RadioButton
    private lateinit var r4: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operas)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        tv1 = findViewById(R.id.tv1)
        Grupo1 = findViewById(R.id.Grupo1)
        r1 = findViewById(R.id.r1)
        r2 = findViewById(R.id.r2)
        r3 = findViewById(R.id.r3)
        r4 = findViewById(R.id.r4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun calcular(view:android.view.View){
        var num1 = edt1.text.toString().toDouble()
        var num2 = edt2.text.toString().toDouble()
        val seleccion = Grupo1.checkedRadioButtonId
        if(seleccion == R.id.r1) {
            val suma = num1 + num2
            val result1 = "Resultado: $suma"
            tv1.text = result1
        }else if(seleccion == R.id.r2){
            val resta = num1 - num2
            val result2 = "Resultado: $resta"
            tv1.text = result2
        }else if(seleccion == R.id.r3){
            val multi = num1 * num2
            val result3 = "Resultado: $multi"
            tv1.text = result3
        }else if(seleccion == R.id.r4){
            val divi = num1 / num2
            val result4 = "Resultado: $divi"
            tv1.text = result4
        }
    }
}