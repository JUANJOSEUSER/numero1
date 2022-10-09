package com.example.pruebas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    int a[] = {R.drawable.img, R.drawable.por, R.drawable.name2};
    String v[] = {"español", "ingles", "papa"};
    ver f;
    private Configuration config = new Configuration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> S = new ArrayAdapter<String>(this, R.layout.letras, v);//este metodo funciona pero solo si vas a cambiar el texto ejemplo tamaño color etc
        f = new ver();//te creas una clase que hereda de BaseAdapter
        spinner.setAdapter(f);//hacemos un setadapter que eel adpartador que va a tomar para usar la informacion


    }

    public class ver extends BaseAdapter {

        @Override
        public int getCount() {
            return a.length;
        }

        @Override
        public Object getItem(int i) {
            return v[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inf = LayoutInflater.from(MainActivity.this);//tomamos referencia de el actual activity
            view = inf.inflate(R.layout.letras, null);//llamamos al lienzo que nos creamos y que hacemos un diseño de como debe verse
            ImageView f = view.findViewById(R.id.imageView);//aqui llamamos a la imagen del lienzo que nos creamos previamente
            TextView d = view.findViewById(R.id.textView);//aqui el texto del lienzo que nos creamos
            f.setBackgroundResource(a[i]);//aqui al igual que en el texto hacemos un set para modificar lo que tienen y meter todo lo que tiene  mi array de texo
            d.setText(v[i]);
            //devolvemos la vista ya modificada
            return view;



        }
    }

    public void ide() {

        for (int i = 0; i < f.getCount(); i++) {
            if (f.getItem(i)==spinner.getSelectedItem()&&spinner.getSelectedItem().toString().equals("ingles")){
                        config.locale=new Locale("en");
                        getResources().updateConfiguration(config,null);
                        Intent r=new Intent(this,MainActivity.class);
                        startActivity(r);
                        finish();


                    }
                    if (f.getItem(i)==spinner.getSelectedItem()&&spinner.getSelectedItem().toString().equals("español")){
                        config.locale=new Locale(" ");
                        getResources().updateConfiguration(config,null);
                        Intent r=new Intent(this,MainActivity.class);
                        startActivity(r);
                        finish();




                    }
        }

    }

    public void cambiar(View r) {
        ide();
    }

}