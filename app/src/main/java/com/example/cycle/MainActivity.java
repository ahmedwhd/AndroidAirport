package com.example.cycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.cycle.Model.METAR.Datum;
import com.example.cycle.Model.METAR.Search;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    RecyclerView recyclerView;

    List<Datum> listeAut;


    //SearchAutorAdapter serachAdapt = new  SearchAutorAdapter( this);

    AllDataSearch mAdapter = new AllDataSearch(listeAut,MainActivity.this) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_autor);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG, "onQueryTextSubmit " + query);
                //Toast.makeText(getApplicationContext(), "toas"+query, Toast.LENGTH_SHORT).show();
                //searchArtist( query);
                OkHttpClient client = new OkHttpClient();
                okhttp3.Request request = new Request.Builder()
                        .url("https://api.checkwx.com/metar/"+query+"/decoded?x-api-key=bbc56e91998c41fe8b8b6a9384")
                        .build();
                final Gson gson = new Gson();
                Log.d(TAG, "onQueryTextSubmit " + query);
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }
                    // Parse response using gson deserializer
                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        // Process the data on the worker thread

                        Gson gson = new Gson();
                        final Search dataSearch = gson.fromJson(response.body().string(),
                                Search.class);
                        List<Datum> dataTest = dataSearch.getData();

                        Log.d(TAG, "result"+dataSearch.getResults());

                        for (Datum airport:dataTest) {
                            Log.d(TAG, airport.getIcao() + ":" + airport.getStation().getName());
                        }



                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "runn", Toast.LENGTH_SHORT).show();
                                mAdapter.setData(dataSearch.getData());
                                recyclerView.setAdapter(mAdapter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            }
                        });
                    }
                });
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    /*private TextView totalCasesWorld, totalDeathsWorld, totalRecoveredWorld;

   /** Listener � l'�coute des �v�nements Bouton */
     /*OnClickListener btnEnvoyerOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            popUp("Valeur saisie = " + getTxtValeur());
        }
    };*/

    /* OnClickListener btnQuitterOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // la m�thode finish est appel�e quand l'activit� est finie et
            // doit �tre ferm�e
            finish();
        }
    };*/

    /** Gestion des zones de texte */
    /* public String getTxtValeur() {
        return((EditText) findViewById(R.id.editTxtValeur)).getText().toString();
    }

    public void setTxTValeur(String valeur) {
        EditText zoneValeur = (EditText) findViewById(R.id.editTxtValeur);
        zoneValeur.setText(valeur);
    }*/

    /** Cr�ation d'un "Toast" pour afficher temporairement les informations
     * � l'�cran
     */
     /*public void popUp(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }*/

    /**
     * Appel� au d�but du cycle complet
     */
     /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialiser l'activit�
        Button btnEnvoyer = (Button) findViewById(R.id.btnEnvoyer);
        btnEnvoyer.setOnClickListener(btnEnvoyerOnClickListener);

        Button btnQuitter = (Button) findViewById(R.id.btnQuitter);
        btnQuitter.setOnClickListener(btnQuitterOnClickListener);

        totalCasesWorld = findViewById(R.id.newCasesWorld);
        totalDeathsWorld = findViewById(R.id.newDeathsWorld);
        totalRecoveredWorld = findViewById(R.id.newRecoveredWorld);
        getData();

        // Affichage du toast
        popUp("onCreate()");


    }*/
    /* StringRequest myRequest;

    public void getData() {

        String myUrl = "https://disease.sh/v3/covid-19/all";
         myRequest = new StringRequest(Request.Method.GET, myUrl,
                response -> {
                    try{
                        //Create a JSON object containing information from the API.
                        JSONObject myJsonObject = new JSONObject(response);
                        popUp(myUrl);
                        totalCasesWorld.setText(myJsonObject.getString("cases"));
                        totalRecoveredWorld.setText(myJsonObject.getString("recovered"));
                        totalDeathsWorld.setText(myJsonObject.getString("deaths"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                volleyError -> Toast.makeText(MainActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show()
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(myRequest);
    }*/


    /** Appel�e apr�s onCreate, � utiliser pour restaurer l'�tat de l'interface */
    /* @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        //Restaurer l'interface utilisateur � partir de savedInstanceState.
        //Ne sera appel�e que si l'activit� a �t� tu�e par le syst�me
        //depuis qu'elle a �t� visible pour la derni�re fois.

        // Affichage du toast
        popUp("onRestoreInstanceState()");

    }*/


    /**
     * Appel�e avant les cycles visibles d'une activit�.
     * La fonction onRestart() est suivie de la fonction onStart().
     */
    /* @Override
    protected void onRestart() {
        super.onRestart();

        popUp("onRestart()");
    }*/

    /**
     * Ex�cut� lorsque l'activit� devient visible � l'utilisateur.
     * La fonction onStart() est suivie de la fonction onResume().
     */
    /* @Override
    protected void onStart() {
        super.onStart();

        // R�cup�ration des anciens param�tres
        {
            SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
            setTxTValeur(settings.getString("valeur", ""));
        }

        popUp("onStart()");
    }*/

    /**
     * Ex�cut�e � chaque passage en premier plan de l'activit�.
     * Ou bien, si l'activit� passe � nouveau en premier
     *  (si une autre activit� �tait pass�e en premier plan entre temps).
     *
     * La fonction onResume() est suivie de l'ex�cution de l'activit�.
     */
     /*@Override
    protected void onResume() {
        super.onResume();

        popUp("onResume()");
    }*/

    /**
     * La fonction onPause() est suivie :
     * - d'un onResume() si l'activit� passe � nouveau en premier plan;
     * - d'un onStop() si elle devient invisible � l'utilisateur;
     *
     * L'ex�cution de la fonction onPause() doit �tre rapide,
     * car la prochaine activit� ne d�marrera pas tant que l'ex�cution
     * de la fonction onPause() n'est pas termin�e.
     */
     /*@Override
     protected void onPause() {
        super.onPause();

        // Sauvegarde des param�tres
        // pour pouvoir les restaurer au prochain d�marrage
        {
            SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("valeur", getTxtValeur());
            editor.commit();
        }

        if (isFinishing()) {
            popUp("onPause, l'utilisateur � demand� la fermeture via un finish()");
        } else {
            popUp("onPause, l'utilisateur n'a pas demand� la fermeture via un finish()");
        }
    }*/

    /**
     * La fonction onStop() est ex�cut�e :
     * - lorsque l'activit� n'est plus en premier plan
     * - ou bien lorsque l'activit� va �tre d�truite
     *
     * Cette fonction est suivie :
     * - de la fonction onRestart() si l'activit� passe � nouveau en premier plan;
     * - de la fonction onDestroy() lorsque l'activit� se termine ou bien lorsque le syst�me d�cide de l'arr�ter
     */
     /*@Override
    protected void onStop() {
        super.onStop();

        popUp("onStop()");

    }*/

    /**
     * Cette fonction est ex�cut�e lorsque l'activit� se termine ou bien lorsque
     * le syst�me d�cide de l'arr�ter.
     *
     * La fonction onCreate() devra � nouveau �tre ex�cut�e pour obtenir � nouveau l'activit�.
     */
    /* @Override
    protected void onDestroy() {
        super.onDestroy();

        popUp("onDestroy()");
    }*/

}