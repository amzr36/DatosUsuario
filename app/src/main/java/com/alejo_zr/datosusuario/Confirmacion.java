package com.alejo_zr.datosusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.app.DatePickerDialog;

import java.util.Calendar;

public class Confirmacion extends AppCompatActivity    {

    TextView tvNombreU,tvTelU,tvEmailU,tvDescripcionU,tvCumpleU;
    Button bEditar;
    private int dia,mes,año;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        tvNombreU = (TextView) findViewById(R.id.tvNombreU);
        tvCumpleU = (TextView) findViewById(R.id.tvTelU);
        tvTelU = (TextView) findViewById(R.id.tvTelU);
        tvEmailU = (TextView) findViewById(R.id.tvEmailU);
        tvDescripcionU = (TextView) findViewById(R.id.tvDescripcionU);

        bEditar = (Button) findViewById(R.id.bEditar);


        Bundle nombreU = getIntent().getExtras();
        String nombre = nombreU.getString("nombre").toString();
        tvNombreU.setText(nombre);



        //Bundle cumpleU = getIntent().getExtras();
        //String cumple = cumpleU.getString("cumpleaños");
        //tvCumpleU.setText(cumple);

        Bundle telefonoU = getIntent().getExtras();
        String telefono = telefonoU.getString("telefono").toString();
        tvTelU.setText(telefono);

        Bundle emailU = getIntent().getExtras();
        String email =emailU.getString("email").toString();
        tvEmailU.setText(email);

        Bundle descripcionU = getIntent().getExtras();
        String descripcion = descripcionU.get("descripcion").toString();
        tvDescripcionU.setText(descripcion);

        bEditar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                Intent editar = new Intent(Confirmacion.this,MainActivity.class);

                startActivity(editar);
            }
        });



    }

}
