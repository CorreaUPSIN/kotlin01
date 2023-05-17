package com.example.kotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.text.Editable


class MainActivity : AppCompatActivity() {
    private lateinit var btnSaludar: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button
    private lateinit var lblSaludar: TextView
    private lateinit var txtNombre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Relacion de los objetos Kotlin con las vistas XML
        btnSaludar = findViewById(R.id.btnSaludar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)
        lblSaludar = findViewById(R.id.lblSaludar)
        txtNombre = findViewById(R.id.txtNombre)

        // Codificar evento click boton
        btnSaludar.setOnClickListener {
            if (txtNombre.text.toString().isEmpty()) {
                // Falta capturar el nombre
                Toast.makeText(this, "Favor de ingresar el nombre", Toast.LENGTH_SHORT).show()
            } else {
                val saludar = txtNombre.text.toString()
                lblSaludar.text = "Hola $saludar, ¿Cómo estás?"
            }
        }

        // btn limpiar
        btnLimpiar.setOnClickListener {
            lblSaludar.text = ""
            txtNombre.text = Editable.Factory.getInstance().newEditable("")
            txtNombre.requestFocus()
        }

        // btn Cerrar
        btnCerrar.setOnClickListener { finish() }
    }
}
