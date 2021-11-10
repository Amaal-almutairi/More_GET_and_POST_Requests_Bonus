package com.example.more_get_and_post_requests_bonus


import com.google.gson.annotations.SerializedName

class Users : ArrayList<Users.UsersItem>(){
    data class UsersItem(
        @SerializedName("name")
        val name: String, // Sara
        @SerializedName("location")
        val location: String, // Australia

    )
}