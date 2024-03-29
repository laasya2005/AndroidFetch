package com.example.fetching;

import java.util.List;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.ArrayList;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set an empty adapter
        ItemAdapter adapter = new ItemAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FetchHiringApi api = retrofit.create(FetchHiringApi.class);

        Call<List<Item>> call = api.getItems();

        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    List<Item> items = response.body();
                    if (items != null) {
                        List<Item> filteredItems = items.stream()
                                .filter(item -> item.getName() != null && !item.getName().isEmpty())
                                .sorted(Comparator.comparing(Item::getListId).thenComparing(Item::getName))
                                .collect(Collectors.toList());

                        // Update the adapter's data
                        adapter.updateData(filteredItems);
                    }
                } else {
                    // Handle the error
                    Toast.makeText(MainActivity.this, "An error occurred while fetching the items", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                // Handle the failure
                Toast.makeText(MainActivity.this, "Failed to fetch the items", Toast.LENGTH_SHORT).show();
            }
        });
    }
}