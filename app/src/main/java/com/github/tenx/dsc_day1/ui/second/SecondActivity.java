package com.github.tenx.dsc_day1.ui.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.tenx.dsc_day1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity{



//    presenter
    private static final String TAG = "MainActivity";
    private UserAdapter adapter;
    private RecyclerView recyclerView;

    private RequestQueue requestQueue;

    private List<String> mList;


    public void initViews(){
        recyclerView = findViewById(R.id.recycler_main);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        adapter = new UserAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(this);


        String url ="https://5db305d7a394f5001443a97d.mockapi.io/api/v1/users";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray users = obj.getJSONArray("users");
                            if(mList != null){
                                mList.clear();
                            }
                            for(int i=0; i<users.length() ; i++){
                                if(mList == null){
                                    mList = new ArrayList<>();
                                }
                                String name = users.get(i).toString();
                                mList.add(name);
                            }

                            adapter.setListData(mList);


                        }catch (JSONException e){
                            Log.d(TAG, "onResponse: json exception");
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onResponse: "+error.getMessage());
            }
        });

        requestQueue.add(stringRequest);


    }
}
