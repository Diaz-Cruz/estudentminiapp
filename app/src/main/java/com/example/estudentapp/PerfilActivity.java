package com.example.estudentapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estudentapp.databinding.ActivityPerfilBinding;

public class PerfilActivity extends AppCompatActivity {

    private ActivityPerfilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String nombre = getIntent().getStringExtra(MainActivity.EXTRA_NOMBRE);
        String matricula = getIntent().getStringExtra(MainActivity.EXTRA_MATRICULA);
        String carrera = getIntent().getStringExtra(MainActivity.EXTRA_CARRERA);

        binding.tvSaludo.setText(getString(R.string.saludo, primerNombre(nombre)));
        binding.tvNombre.setText(getString(R.string.label_nombre, nombre));
        binding.tvMatricula.setText(getString(R.string.label_matricula, matricula));
        binding.tvCarrera.setText(getString(R.string.label_carrera, carrera));

        binding.btnEditar.setOnClickListener(v -> finish());
    }

    private String primerNombre(String completo) {
        if (completo == null || completo.isEmpty()) {
            return "";
        }
        return completo.split(" ")[0];
    }
}
