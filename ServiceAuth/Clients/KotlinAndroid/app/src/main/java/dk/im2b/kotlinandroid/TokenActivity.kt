package dk.im2b.kotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_token.*
import okhttp3.*

class TokenActivity : AppCompatActivity() {

    var userToken = ""
    val tokenUrl = "http://basictokenwebapi.azurewebsites.net/api/token/gettoken"

    val baseUrl = "http://basictokenwebapi.azurewebsites.net/api/calc/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_token)

        // Request token
        tokenAuth_btnGetToken.setOnClickListener {
            val username = tokenAuth_etUsername.text.toString()
            val password = tokenAuth_etPassword.text.toString()

            val json = "{ \"username\": \"$username\", \"password\": \"$password\"}"
            postWebRequest(tokenUrl,json, tokenAuth_tvGotToken)

        }

        // API calls, using token
        tokenAuth_btnAdd.setOnClickListener {
            val numberA = tokenAuth_etANumber.text.toString()
            val numberB = tokenAuth_etBNumber.text.toString()

            requestWebService(baseUrl+"add?a=$numberA&b=$numberB", tokenAuth_tvResult)
        }

        tokenAuth_btnSub.setOnClickListener {
            val numberA = tokenAuth_etANumber.text.toString()
            val numberB = tokenAuth_etBNumber.text.toString()

            requestWebService(baseUrl+"sub?a=$numberA&b=$numberB", tokenAuth_tvResult)
        }

        tokenAuth_btnMulti.setOnClickListener {
            val numberA = tokenAuth_etANumber.text.toString()
            val numberB = tokenAuth_etBNumber.text.toString()

            requestWebService(baseUrl+"multi?a=$numberA&b=$numberB", tokenAuth_tvResult)
        }

        tokenAuth_btnDiv.setOnClickListener {
            val numberA = tokenAuth_etANumber.text.toString()
            val numberB = tokenAuth_etBNumber.text.toString()

            requestWebService(baseUrl+"div?a=$numberA&b=$numberB", tokenAuth_tvResult)
        }
    }


    fun requestWebService(url: String, tvResult: TextView) {
        OkHttpHandler {
            val client = OkHttpClient();
            val request = Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "Bearer $userToken")
                    .build()

            val response = client.newCall(request).execute();
            val result = response.body()!!.string()
            runOnUiThread { tvResult.text = result }
        }.execute()
    }

    fun postWebRequest(url: String, json: String, tvResult: TextView){
        OkHttpHandler {
            val JSON = MediaType.parse("application/json; charset=utf-8")

            val client = OkHttpClient()

            val body = RequestBody.create(JSON, json)
            val request = Request.Builder()
                    .url(url)
                    .post(body)
                    .build()

            val response = client.newCall(request).execute()
            val result = response.body()!!.string()
            runOnUiThread {

                val token = Gson().fromJson(result, JsonObject::class.java).get("token").asString
                tvResult.text = token
                userToken = token
            }
        }.execute()
    }

}
