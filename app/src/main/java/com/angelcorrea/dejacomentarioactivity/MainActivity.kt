package com.angelcorrea.dejacomentarioactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombreEditText = findViewById<EditText>(R.id.editTextText)
        val emailEditText = findViewById<EditText>(R.id.editTextText2)
        val comentarioEditText = findViewById<EditText>(R.id.editTextText3)
        val enviarButton = findViewById<Button>(R.id.button)

        enviarButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val email = emailEditText.text.toString()
            val comentario = comentarioEditText.text.toString()

            if (nombre.isEmpty() || email.isEmpty() || comentario.isEmpty()) {
                Toast.makeText(this, "completa todos los campos.", Toast.LENGTH_SHORT).show()
            } else {
                val mensaje = """
                    Nombre: $nombre
                    Email: $email
                    Comentario: $comentario
                """.trimIndent()

                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            }
        }


    }
}