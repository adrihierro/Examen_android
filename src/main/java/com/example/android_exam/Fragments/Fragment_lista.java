package com.example.android_exam.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.android_exam.R;

public class Fragment_lista extends Fragment {

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos el layout del fragment con el ListView
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        list = view.findViewById(R.id.listView1);

        final String[] datos = new String[]{
                "Resistencia Básica",
                "Entrenamiento de Fuerza",
                "Cardio",
                "Yoga"
        };

        final int[] imagenes = new int[]{
                R.drawable.resistencia_exam,   // añade tus imágenes en res/drawable
                R.drawable.fuerza_exam,
                R.drawable.cardio_exam,
                R.drawable.yoga
        };

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                requireContext(),
                R.layout.list_item,
                R.id.item_text,
                datos) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ImageView icon = view.findViewById(R.id.item_icon);
                TextView text = view.findViewById(R.id.item_text);

                icon.setImageResource(imagenes[position]);
                text.setText(datos[position]);
                return view;
            }
        };

        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();

                if (selected.contains("Resistencia Básica")) {
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new Fragment_resistencia())
                            .addToBackStack(null) // para poder volver atrás
                            .commit();

                } else if (selected.contains("Entrenamiento de Fuerza")) {
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new Fragment_fuerza())
                            .addToBackStack(null) // para poder volver atrás
                            .commit();

                } else if(selected.contains("Cardio")){
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new Fragment_Cardio())
                            .addToBackStack(null) // para poder volver atrás
                            .commit();
                } else if (selected.contains("Yoga")) {
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new Fragment_Yoga())
                            .addToBackStack(null) // para poder volver atrás
                            .commit();
                }
            }
        });

        return view;
    }
}
