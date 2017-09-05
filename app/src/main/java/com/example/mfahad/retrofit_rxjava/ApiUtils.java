package com.example.mfahad.retrofit_rxjava;

/**
 * Created by M.FAHAD on 8/31/2017.
 */

public class ApiUtils {
    public static String url = "http://jsonplaceholder.typicode.com";
    public ApiUtils(){}
    public static Api getApiInterface(){
        return RetrofiltClient.getRetrofitClient(url).create(Api.class);
    }

}
