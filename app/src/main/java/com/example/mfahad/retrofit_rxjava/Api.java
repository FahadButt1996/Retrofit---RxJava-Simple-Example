package com.example.mfahad.retrofit_rxjava;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by M.FAHAD on 8/31/2017.
 */

public interface Api {
    @GET("/comments")
    Observable<List<Data>> getData() ;
}
