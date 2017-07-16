package com.alejo_zr.datosusuario;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText txtNombre,txtTelefono, txtEmail, txtDescipcion;
    Button bSiguiente;
    Button bCumpleaños;
    EditText txtCumpleaños;


    private int dia,mes,año;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCumpleaños = (EditText) findViewById(R.id.txtCumpleaños);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtDescipcion = (EditText) findViewById(R.id.txtDescripcion);

        bSiguiente = (Button) findViewById(R.id.bSiguiente);
        bCumpleaños = (Button)findViewById(R.id.bCumpleaños);
        bCumpleaños.setOnClickListener(this);

        bSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent confirmacion = new Intent(MainActivity.this,Confirmacion.class);

                confirmacion.putExtra("nombre",txtNombre.getText().toString());
                confirmacion.putExtra("cumpleaños",txtCumpleaños.getText().toString());
                confirmacion.putExtra("telefono",txtTelefono.getText().toString());
                confirmacion.putExtra("email",txtEmail.getText().toString());
                confirmacion.putExtra("descripcion",txtDescipcion.getText().toString());
                startActivity(confirmacion);
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v == bCumpleaños) {

            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            año = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    monthOfYear++;

                    txtCumpleaños.setText(dayOfMonth + "/" + (monthOfYear) + "/" + year);

                }
            }
                    , dia, mes, año);
            datePickerDialog.show();

        }


    }
}

