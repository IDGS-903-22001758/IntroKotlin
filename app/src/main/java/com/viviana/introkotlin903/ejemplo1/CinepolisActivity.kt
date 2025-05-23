package com.viviana.introkotlin903.ejemplo1


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.viviana.introkotlin903.R

class CinepolisActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtCantidadCompra: EditText
    private lateinit var edtCantidadBoletos: EditText
    private lateinit var rgTarjetaCineco: RadioGroup
    private lateinit var tvTotalPagar: TextView
    private lateinit var rbSi: RadioButton
    private lateinit var rbNo: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinepolis)

        edtNombre = findViewById(R.id.edtNombre)
        edtCantidadCompra = findViewById(R.id.edtCantidadCompra)
        edtCantidadBoletos = findViewById(R.id.edtCantidadBoletos)
        rgTarjetaCineco = findViewById(R.id.rgTarjetaCineco)
        tvTotalPagar = findViewById(R.id.tvTotalPagar)
        rbSi = findViewById(R.id.rbSi)
        rbNo = findViewById(R.id.rbNo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcularTotal(view: android.view.View){
        try{
        var nombre = edtNombre.text.toString()
        var cantCompra = edtCantidadCompra.text.toString().toInt()
        var cantBoletos = edtCantidadBoletos.text.toString().toInt()
        var tarjeta = rgTarjetaCineco.checkedRadioButtonId
        val precioUnitario= 12.0

        val maxBoletos = cantCompra * 7
        if (cantBoletos > maxBoletos) {
            tvTotalPagar.text = "Error: Excede la cantidad permitida"
            return
        }

        var total = cantBoletos * precioUnitario


        total = when {
            cantBoletos > 5 -> total * 0.85
            cantBoletos in 3..5 -> total * 0.90
            else -> total
        }

        if (tarjeta == R.id.rbSi) {
            total *= 0.90
        }


        val df = DecimalFormat("0.00")
        tvTotalPagar.text = "$${df.format(total)}"
        } catch (e: NumberFormatException) {
            tvTotalPagar.text = "Error: Datos inválidos"
            Toast.makeText(this, "Por favor ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            tvTotalPagar.text = "Error inesperado"
            Toast.makeText(this, "Ocurrió un error al procesar la información", Toast.LENGTH_SHORT).show()
        }

    }
}