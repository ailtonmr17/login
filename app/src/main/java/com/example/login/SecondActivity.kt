package com.example.login



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Referencias a los elementos de la UI
        val etPrecioDivisa: EditText = findViewById(R.id.etPrecioDivisa)
        val etMontoConvertir: EditText = findViewById(R.id.etMontoConvertir)
        val btnConvertir: Button = findViewById(R.id.btnConvertir)
        val tvResultado: TextView = findViewById(R.id.tvResultado)
        val btnCerrarSesion: Button = findViewById(R.id.btnCerrarSesion)

        // Acción al presionar el botón Convertir
        btnConvertir.setOnClickListener {
            // Verificar que los campos no estén vacíos
            val precioDivisa = etPrecioDivisa.text.toString()
            val montoConvertir = etMontoConvertir.text.toString()

            if (precioDivisa.isNotEmpty() && montoConvertir.isNotEmpty()) {
                try {
                    // Convertir los valores a números y realizar la multiplicación
                    val precio = precioDivisa.toDouble()
                    val monto = montoConvertir.toDouble()
                    val resultado = precio * monto

                    // Mostrar el resultado en el TextView
                    tvResultado.text = "Resultado: $resultado"
                } catch (e: NumberFormatException) {
                    // Manejo de errores en caso de que no se pueda convertir a número
                    Toast.makeText(this, "Por favor, ingrese valores válidos", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Si los campos están vacíos, mostrar un mensaje de error
                Toast.makeText(this, "Por favor, complete ambos campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción para el botón de Cerrar Sesión
        btnCerrarSesion.setOnClickListener {

            // Limpiar datos de sesión (opcional, depende de cómo gestionas la sesión)
            val sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear() // Elimina todos los datos guardados en preferencias compartidas
            editor.apply()

            // Redirigir a la actividad de inicio de sesión
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish() // Finaliza la actividad actual para evitar volver a ella
        }
    }
}
