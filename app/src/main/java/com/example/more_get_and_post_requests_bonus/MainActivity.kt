package com.example.more_get_and_post_requests_bonus

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var names:ArrayList<String>
    lateinit var edname: EditText
    lateinit var btnSave: Button
   lateinit var rv:RecyclerView
  lateinit var adap:MyAdap
    lateinit var btnfech: Button
     var location = "KSA"
   // lateinit var consId:ConstraintLayout
    var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edname = findViewById(R.id.edname)
        btnSave = findViewById(R.id.btnSave)
        btnfech=findViewById(R.id.btnfech)
        names= arrayListOf()
        rv.layoutManager=LinearLayoutManager(this)
        btnSave.setOnClickListener {
            name = edname.text.toString()
            if (name.isNotEmpty()) {
             getAllUsers()
            }


        }
        btnfech.setOnClickListener {
            if (name.isNotEmpty()) {
               postAllUsers()
            }
        }
    }
    fun getAllUsers(){
        val api = APIClint().getClient()?.create(APIInterface::class.java)
        api!!.getAllUsers()?.enqueue(object :Callback<Users?>{


            override fun onResponse(
                call: Call<Users?>,
                response: Response<Users?>
            ) {
                var result=response.body()!!
                for (index in result){
                    names.add("${index.name}")
                }
                rv.adapter = MyAdap(names)
                adap.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Users?>, t: Throwable) {
                call.cancel()
            }


        })
    }
fun postAllUsers(){
    val api = APIClint().getClient()?.create(APIInterface::class.java)
    val progressDialog=ProgressDialog(this)
    progressDialog.setMessage("please Wait")
    progressDialog.show()
    if (api!=null){
        api?.postAllUsers(Users.UsersItem(name,location))?.enqueue(object :Callback<Users.UsersItem?>{
            override fun onResponse(
                call: Call<Users.UsersItem?>,
                response: Response<Users.UsersItem?>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Users.UsersItem?>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
}
}
