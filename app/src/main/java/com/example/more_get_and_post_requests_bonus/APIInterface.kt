package com.example.more_get_and_post_requests_bonus

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers


//https://dojo-recipes.herokuapp.com/test/
interface APIInterface {
    @Headers("Content-Type:application/json")
    @GET("/test/")
    fun getAllUsers(): Call<Users>

    @Headers("Content-Type:application/json")
    @GET("/test/")
    fun postAllUsers(@Body details: Users.UsersItem): Call<Users.UsersItem?>
}