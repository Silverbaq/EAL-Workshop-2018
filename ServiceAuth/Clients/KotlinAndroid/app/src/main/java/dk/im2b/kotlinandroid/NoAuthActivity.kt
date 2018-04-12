package dk.im2b.kotlinandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_no_auth.*
import okhttp3.OkHttpClient
import okhttp3.Request

class NoAuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_auth)

        var tvResult = findViewById<TextView>(R.id.noAuth_tvResult)

        noAuth_btnAdd.setOnClickListener {
            val numA = noAuth_etANumber.text.toString()
            val numB = noAuth_etBNumber.text.toString()

            val url = "http://basicwebapi.azurewebsites.net/api/calc/add?a=$numA&b=$numB"
            requestWebService(url, tvResult)
        }

        noAuth_btnSub.setOnClickListener {
            val numA = noAuth_etANumber.text.toString()
            val numB = noAuth_etBNumber.text.toString()

            val url = "http://basicwebapi.azurewebsites.net/api/calc/sub?a=$numA&b=$numB"
            requestWebService(url, tvResult)
        }

        noAuth_btnMulti.setOnClickListener {
            val numA = noAuth_etANumber.text.toString()
            val numB = noAuth_etBNumber.text.toString()

            val url = "http://basicwebapi.azurewebsites.net/api/calc/multi?a=$numA&b=$numB"
            requestWebService(url, tvResult)
        }

        noAuth_btnDiv.setOnClickListener {
            val numA = noAuth_etANumber.text.toString()
            val numB = noAuth_etBNumber.text.toString()

            val url = "http://basicwebapi.azurewebsites.net/api/calc/div?a=$numA&b=$numB"
            requestWebService(url, tvResult)
        }
    }

    fun requestWebService(url: String, tvResult: TextView) {
        OkHttpHandler {
            val client = OkHttpClient();
            val request = Request.Builder()
                    .url(url)
                    .build()

            val response = client.newCall(request).execute();

            runOnUiThread { tvResult.text = response.body()!!.string() }
        }.execute()
    }



}
