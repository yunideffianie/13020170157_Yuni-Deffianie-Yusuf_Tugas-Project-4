package com.example.tugasproject4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Details extends AppCompatActivity {
    private TextView judul, desc, genre, durasi, sutradara, tahun;
    private ImageView photo;
    private RecyclerView recyclerView;
    private Toolbar toolbar;

    String getJudul, getDesc, getGenre, getDurasi, getSutradara, getTahun;
    int getphoto;
    String[] nama;
    TypedArray photocast;

    private ArrayList<FilmDetails> data = new ArrayList<>();

    public void prepare() {
        switch (getJudul) {
            case "WALL-E" :
                nama = getResources().getStringArray(R.array.walle);
                photocast = getResources().obtainTypedArray(R.array.castwalle);
                break;
            case "Home" :
                nama = getResources().getStringArray(R.array.home);
                photocast = getResources().obtainTypedArray(R.array.casthome);
                break;
            case "Resident Evil : Vendetta" :
                nama = getResources().getStringArray(R.array.residentevil);
                photocast = getResources().obtainTypedArray(R.array.castresidentevil);
                break;
            case "Avengers : Infinity War" :
                nama = getResources().getStringArray(R.array.infinitywar);
                photocast = getResources().obtainTypedArray(R.array.castinfinitywar);
                break;
            case "Inception" :
                nama = getResources().getStringArray(R.array.inception);
                photocast = getResources().obtainTypedArray(R.array.castinception);
                break;
            case "Captain Marvel" :
                nama = getResources().getStringArray(R.array.marvel);
                photocast = getResources().obtainTypedArray(R.array.marvel);
                break;
            case "Avengers : Endgame" :
                nama = getResources().getStringArray(R.array.endgame);
                photocast = getResources().obtainTypedArray(R.array.castendgame);
                break;
            case "Avatar" :
                nama = getResources().getStringArray(R.array.avatar);
                photocast = getResources().obtainTypedArray(R.array.castavatar);
                break;
            case "Alita : Battle Angel" :
                nama = getResources().getStringArray(R.array.alita);
                photocast = getResources().obtainTypedArray(R.array.castalita);
                break;
            case "Zootopia" :
                nama = getResources().getStringArray(R.array.zootopia);
                photocast = getResources().obtainTypedArray(R.array.castzootopia);
                break;
            case "Aladdin" :
                nama = getResources().getStringArray(R.array.aladdin);
                photocast = getResources().obtainTypedArray(R.array.castaladdin);
                break;
            case "Parasite" :
                nama = getResources().getStringArray(R.array.parasite);
                photocast = getResources().obtainTypedArray(R.array.castparasite);
                break;
            case "Cars" :
                nama = getResources().getStringArray(R.array.cars);
                photocast = getResources().obtainTypedArray(R.array.castcars);
                break;
            case "Knives Out" :
                nama = getResources().getStringArray(R.array.knivesout);
                photocast = getResources().obtainTypedArray(R.array.castknivesout);
                break;
            case "Big Hero 6" :
                nama = getResources().getStringArray(R.array.bighero);
                photocast = getResources().obtainTypedArray(R.array.castbighero);
                break;
            case "Inside Out" :
                nama = getResources().getStringArray(R.array.insideout);
                photocast = getResources().obtainTypedArray(R.array.castinsideout);
                break;
            case "Coco" :
                nama = getResources().getStringArray(R.array.coco);
                photocast = getResources().obtainTypedArray(R.array.castcoco);
                break;
            case "Kingsman : The Golden Circle" :
                nama = getResources().getStringArray(R.array.kingsman);
                photocast = getResources().obtainTypedArray(R.array.castkingsman);
                break;
            case "Toy Story" :
                nama = getResources().getStringArray(R.array.toystory);
                photocast = getResources().obtainTypedArray(R.array.casttoystory);
                break;
            case "Brave" :
                nama = getResources().getStringArray(R.array.brave);
                photocast = getResources().obtainTypedArray(R.array.castbrave);
                break;
        }
    }

    public void addItem() {
        for(int i=0; i<nama.length; i++) {
            FilmDetails film = new FilmDetails(nama[i], photocast.getResourceId(i, -1));
            data.add(film);
        }
    }

    public void getData() {
        prepare();
        addItem();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        recyclerView = findViewById(R.id.cast);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        FilmAdapterDetails filmAdapterDetails = new FilmAdapterDetails(this, data);
        recyclerView.setAdapter(filmAdapterDetails);
        filmAdapterDetails.notifyDataSetChanged();

        toolbar = findViewById(R.id.toolbar);
        judul = findViewById(R.id.judul);
        desc = findViewById(R.id.desc);
        genre = findViewById(R.id.genre);
        durasi = findViewById(R.id.durasi);
        sutradara = findViewById(R.id.sutradara);
        tahun = findViewById(R.id.tahun);
        photo = findViewById(R.id.photo);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getJudul = getIntent().getStringExtra("judul");
        getDesc = getIntent().getStringExtra("desc");
        getGenre = getIntent().getStringExtra("genre");
        getDurasi = getIntent().getStringExtra("durasi");
        getSutradara = getIntent().getStringExtra("sutradara");
        getTahun = getIntent().getStringExtra("tahun");
        getphoto = getIntent().getIntExtra("photo",0);

        getData();

        judul.setText(getJudul);
        desc.setText(getDesc);
        genre.setText(getGenre);
        durasi.setText(getDurasi);
        sutradara.setText(getSutradara);
        tahun.setText(getTahun);
        photo.setImageResource(getphoto);

    }
}
