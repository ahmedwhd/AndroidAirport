package com.example.cycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cycle.Model.TAF.TafData;
import com.example.cycle.Model.TAF.TafDatum;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TafsActivity extends AppCompatActivity {


    private static String TAG = "taf";
    RecyclerView recyclerView;

    List<TafDatum> listeAut;
    TafSearch mAdapter = new TafSearch(listeAut, TafsActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context ctx = this.getApplicationContext();
        setContentView(R.layout.taf_display);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_autor);
        Intent INT = getIntent();
        String name = INT.getStringExtra("name");
        Log.d(TAG, "name" + name);
        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
            }
        };
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.checkwx.com/taf/" + name + "/decoded?x-api-key=bbc56e91998c41fe8b8b6a9384")
                .build();
        final Gson gson = new Gson();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            // Parse response using gson deserializer
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // Process the data on the worker thread

                Gson gson = new Gson();
                final TafData dataSearch = gson.fromJson(response.body().string(),
                        TafData.class);
                List<TafDatum> dataTest = dataSearch.getData();

                Log.d(TAG, "result" + dataSearch.getResults());

                for (TafDatum airport : dataTest) {
                    Log.d(TAG, airport.getIcao() + ":" + airport.getStation().getName());
                }

                TafsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "runn", Toast.LENGTH_SHORT).show();
                        mAdapter.setData(dataSearch.getData());
                        recyclerView.setAdapter(mAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(TafsActivity.this));
                        /*Intent INT=new Intent(ctx, Map.class);
                        INT.putExtra("lon",lon);
                        INT.putExtra("lat",lat);
                        ctx.startActivity(INT);*/
                    }
                });


            }
        });

    }

}
