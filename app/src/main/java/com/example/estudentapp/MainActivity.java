package com.example.estudentapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estudentapp.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NOMBRE = "extra_nombre";
    public static final String EXTRA_MATRICULA = "extra_matricula";
    public static final String EXTRA_CARRERA = "extra_carrera";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGuardar.setOnClickListener(v -> guardarPerfil());
    }

    private void guardarPerfil() {
        String nombre = binding.etNombre.getText().toString().trim();
        String matricula = binding.etMatricula.getText().toString().trim();
        String carrera = binding.acCarrera.getText().toString().trim();

        boolean valido = true;
        valido &= validarCampo(binding.tilNombre, nombre, R.string.error_nombre);
        valido &= validarCampo(binding.tilMatricula, matricula, R.string.error_matricula);
        valido &= validarCampo(binding.tilCarrera, carrera, R.string.error_carrera);

        if (!valido) {
            return;
        }

        Toast.makeText(this, R.string.guardado, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
        intent.putExtra(EXTRA_NOMBRE, nombre);
        intent.putExtra(EXTRA_MATRICULA, matricula);
        intent.putExtra(EXTRA_CARRERA, carrera);
        startActivity(intent);
    }

    private boolean validarCampo(TextInputLayout contenedor, String valor, int idMensaje) {
        if (valor.isEmpty()) {
            contenedor.setError(getString(idMensaje));
            return false;
        }
        contenedor.setError(null);
        return true;
    }
}
