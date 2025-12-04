package com.example.android_exam;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.android_exam.Fragments.Fragment_lista;
import com.example.android_exam.Fragments.Fragment_resistencia;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configurar Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Entrenaments");
        }

        if (savedInstanceState == null) {
            cargarLista();
        }
    }

    private void cargarLista() {
        Fragment_lista fragmentLista = new Fragment_lista();

        if (findViewById(R.id.fragment_list_container) != null) {
            // Landscape → lista a la izquierda
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_list_container, fragmentLista)
                    .commit();


            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_exercise_container, new Fragment_resistencia())
                    .commit();

        } else if (findViewById(R.id.fragment_container) != null) {
            // Portrait → ocupa toda la pantalla
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragmentLista)
                    .commit();
        }
    }
}
