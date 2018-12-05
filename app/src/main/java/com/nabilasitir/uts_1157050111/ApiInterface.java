package com.nabilasitir.uts_1157050111;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("getcontact.php")
    Call<List<Buah>> getBuah(@Query("item_type") String item_type);
}
