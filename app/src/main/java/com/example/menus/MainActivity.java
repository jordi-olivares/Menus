package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvNombre=(TextView)findViewById(R.id.tvNombre);
        registerForContextMenu(tvNombre);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent i=new Intent(this,ActivityAbout.class);
                startActivity(i);
                break;
            case R.id.mSettings:
                Intent i2=new Intent(this,ActivitySettings.class);
                startActivity(i2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_contexto,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mEditar:
                //accion
                Toast.makeText(this, getResources().getString(R.string.edit), Toast.LENGTH_SHORT).show();
                break;

            case R.id.mEliminar:
                Toast.makeText(this, getResources().getString(R.string.delete), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }


    public void levantarMenuPopup(View view) {
        //ImageView im=(ImageView)findViewById(R.id.imgImage);
        PopupMenu p=new PopupMenu(this,view);
        p.getMenuInflater().inflate(R.menu.menu_popup,p.getMenu());

        p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.mVer:
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.menu_view), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mDetalles:
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.menu_detalles), Toast.LENGTH_SHORT).show();
                        break;
                }


                return true;
            }
        });

        p.show();
    }
}