package com.rodrigotelles.metrictoimperial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit_kilo: EditText = findViewById(R.id.edit_text_kilo)
        val edit_metros: EditText = findViewById(R.id.edit_text_metros)
        val edit_quilometros: EditText = findViewById(R.id.edit_text_quilometros)
        val edit_velocidade: EditText = findViewById(R.id.edit_text_velocidade)

        val button_quilogramas: Button = findViewById(R.id.button_converter_quilogramas)
        val button_metragem: Button = findViewById(R.id.button_converter_metros)
        val button_quilometragem: Button = findViewById(R.id.button_converter_quilometragem)
        val button_velocidade: Button = findViewById(R.id.button_converter_velocidade)

        val result_quilogramas: TextView = findViewById(R.id.text_view_result_quilogramas)
        val result_metros: TextView = findViewById(R.id.text_view_result_metragem)
        val result_quilometros: TextView = findViewById(R.id.text_view_result_quilometragem)
        val result_velocidade: TextView = findViewById(R.id.text_view_result_velocidade)

        button_metragem.setOnClickListener {
            val metros: Double = edit_metros.text.toString().toDouble()
            result_metros.setText("" + convertToFeet(metros))
        }

        button_quilometragem.setOnClickListener {
            val kms: Double = edit_quilometros.text.toString().toDouble()
            result_quilometros.setText("" + convertToMiles(kms))
        }

        button_quilogramas.setOnClickListener {
            val kilos: Double = edit_kilo.text.toString().toDouble()
            result_quilogramas.setText("" + convertToPounds(kilos))
        }

        button_velocidade.setOnClickListener {
            val kmh: Int = edit_velocidade.text.toString().toInt()
            result_velocidade.setText("" + convertToMph(kmh))
        }
    }

    fun convertToPounds(kilos: Double): Double {
        var pounds = kilos * 2.205
        return ((pounds * 100.0).roundToInt() / 100.0)
    }

    fun convertToFeet(metros: Double): Double {
        var feet = metros * 3.281
        return feet
    }

    fun convertToMiles(km: Double): Double {
        var mile = km / 1.609
        return ((mile * 100.0).roundToInt() / 100.0)
    }

    fun convertToMph(kmh: Int): Int {
        var mph = kmh / 1.609
        return mph.toInt()
    }

}