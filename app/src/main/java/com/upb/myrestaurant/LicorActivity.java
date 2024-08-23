package com.upb.myrestaurant;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LicorActivity extends ListActivity {
    public class Producto {
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;
        private Integer imagenProducto;

    }

    private MyAdapter adaptador = null;
    private static ArrayList<Producto> arregloProductos = new ArrayList<Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
        adaptador = new MyAdapter(this);
        setListAdapter(adaptador);
        //setContentView(R.layout.activity_producto);
    }

    private void setData() {
        arregloProductos.clear();

        // Licor 1
        Producto productoActual1 = new Producto();
        productoActual1.nombreProducto = this.getResources().getString(R.string.licor1);
        productoActual1.ingredientesProducto = this.getResources().getString(R.string.opc_licor1);
        productoActual1.precioProducto = this.getResources().getString(R.string.prec_licor1);
        productoActual1.imagenProducto = R.drawable.ron; // Asegúrate de tener la imagen correspondiente
        arregloProductos.add(productoActual1);

        // Licor 2
        Producto productoActual2 = new Producto();
        productoActual2.nombreProducto = this.getResources().getString(R.string.licor2);
        productoActual2.ingredientesProducto = this.getResources().getString(R.string.opc_licor2);
        productoActual2.precioProducto = this.getResources().getString(R.string.prec_licor2);
        productoActual2.imagenProducto = R.drawable.whisky2; // Asegúrate de tener la imagen correspondiente
        arregloProductos.add(productoActual2);

        // Licor 3
        Producto productoActual3 = new Producto();
        productoActual3.nombreProducto = this.getResources().getString(R.string.licor3);
        productoActual3.ingredientesProducto = this.getResources().getString(R.string.opc_licor3);
        productoActual3.precioProducto = this.getResources().getString(R.string.prec_licor3);
        productoActual3.imagenProducto = R.drawable.vino; // Asegúrate de tener la imagen correspondiente
        arregloProductos.add(productoActual3);
    }

    public static class MyAdapter extends BaseAdapter {
        private Context myContexto;

        public MyAdapter(Context c) {
            myContexto = c;
        }

        @Override
        public int getCount() {
            return arregloProductos.size();
        }

        @Override
        public Object getItem(int arg) {
            return arregloProductos.get(arg);
        }

        @Override
        public long getItemId(int arg) {
            return 0;
        }

        @Override
        public View getView(int position, View vista, ViewGroup arg2) {
            View view = null;
            if (vista == null) {
                LayoutInflater inflater = (LayoutInflater) myContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_producto, null);

            } else {
                view = vista;
            }

            ImageView imgProducto = (ImageView) view.findViewById(R.id.imageViewProducto);
            imgProducto.setImageDrawable(myContexto.getResources().getDrawable(arregloProductos.get(position).imagenProducto));

            TextView nombreProducto = (TextView) view.findViewById(R.id.textViewNombreProducto);
            nombreProducto.setText(arregloProductos.get(position).nombreProducto);

            TextView ingredientesProducto = (TextView) view.findViewById(R.id.textViewIngredientes);
            ingredientesProducto.setText(arregloProductos.get(position).ingredientesProducto);

            TextView preciosProducto = (TextView) view.findViewById(R.id.textViewPrecio);
            preciosProducto.setText(arregloProductos.get(position).precioProducto);

            return view;
        }
    }
}