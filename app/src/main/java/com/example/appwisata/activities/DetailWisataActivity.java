package com.example.appwisata.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.appwisata.R;
import com.example.appwisata.model.ModelWisata;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailWisataActivity extends AppCompatActivity {

    Toolbar tbDetailWisata;
    TextView tvNamaWisata, tvDescWisata;
    ImageView imgWisata;
    String idWisata, NamaWisata, Desc;
    ModelWisata modelWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        tbDetailWisata = findViewById(R.id.tbDetailWisata);
        tbDetailWisata.setTitle("Detail Wisata");
        setSupportActionBar(tbDetailWisata);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        modelWisata = (ModelWisata) getIntent().getSerializableExtra("detailWisata");
        if (modelWisata != null) {
            idWisata = modelWisata.getIdWisata();
            NamaWisata = modelWisata.getTxtNamaWisata();

            //set Id
            imgWisata = findViewById(R.id.imgWisata);
            tvNamaWisata = findViewById(R.id.tvNamaWisata);
            tvDescWisata = findViewById(R.id.tvDescWisata);

            //get Image
            Glide.with(this)
                    .load(modelWisata.getGambarWisata())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgWisata);

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
