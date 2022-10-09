package com.example.pruebas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
String nombre[]={"huuuuu","haaaaaa"};
int a[]={R.drawable.name2,R.drawable.name};
String duracion[]={"30s","3s"};
RecyclerView re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        re=findViewById(R.id.re);
        LinearLayoutManager d=new LinearLayoutManager(this);
        re.setLayoutManager(d);
        re.setAdapter(new Adaptador());

    }
    public  void hola(){
        Adaptador d=new Adaptador();

    }

    private class Adaptador extends RecyclerView.Adapter<Adaptador.adatar> {


        @NonNull
        @Override
        public adatar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new adatar(getLayoutInflater().inflate(R.layout.letras,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull adatar holder, int position) {
        holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return a.length;
        }

        private class adatar extends RecyclerView.ViewHolder{
        TextView uno;
        ImageView dos;
        public adatar(View itemView){
            super(itemView);
            uno=itemView.findViewById(R.id.textView);
            dos=itemView.findViewById(R.id.imageView);
        }

            public void imprimir(int position) {
            uno.setText(nombre[position]);
            dos.setBackgroundResource(a[position]);
            }
        }
    }
}