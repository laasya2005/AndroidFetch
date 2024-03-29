package com.example.fetching;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface FetchHiringApi {
    @GET("hiring.json")
    Call<List<Item>> getItems();
}