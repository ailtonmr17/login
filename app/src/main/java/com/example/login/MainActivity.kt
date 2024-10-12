package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.eTT) // Campo de Usuario
        etPassword = findViewById(R.id.eTP) // Campo de Contraseña
        btnLogin = findViewById(R.id.btnLogin) // Botón de Iniciar Sesión

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Verifica el usuario y la contraseña
            if (username == "ailtonmr" && password == "chiki1478") {
                // Si es correcto, inicia el SecondActivity
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            } else {
                // Si es incorrecto, muestra un mensaje
                Toast.makeText(this@MainActivity, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}