package dk.im2b.kotlinandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_basic_auth.*


class BasicAuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_auth)

        basicAuth_btnAdd.setOnClickListener{
            val numA = basicAuth_etANumber.text
            val numB = basicAuth_etBNumber.text

            val url = "http://basicauthwebapi.azurewebsites.net/api/calc/add?a=$numA&b=$numB"
            val username = basicAuth_etUsername.text.toString()
            val password = basicAuth_etPassword.text.toString()

            // Using: https://github.com/kittinunf/Fuel
            Fuel.get(url).authenticate(username, password).response { request, response, result ->
                basicAuth_tvResult.text = String(response.data)
            }
        }

        basicAuth_btnSub.setOnClickListener{
            val numA = basicAuth_etANumber.text
            val numB = basicAuth_etBNumber.text

            val url = "http://basicauthwebapi.azurewebsites.net/api/calc/sub?a=$numA&b=$numB"
            val username = basicAuth_etUsername.text.toString()
            val password = basicAuth_etPassword.text.toString()

            // Using: https://github.com/kittinunf/Fuel
            Fuel.get(url).authenticate(username, password).response { request, response, result ->
                basicAuth_tvResult.text = String(response.data)
            }
        }

        basicAuth_btnMulti.setOnClickListener{
            val numA = basicAuth_etANumber.text
            val numB = basicAuth_etBNumber.text

            val url = "http://basicauthwebapi.azurewebsites.net/api/calc/multi?a=$numA&b=$numB"
            val username = basicAuth_etUsername.text.toString()
            val password = basicAuth_etPassword.text.toString()

            // Using: https://github.com/kittinunf/Fuel
            Fuel.get(url).authenticate(username, password).response { request, response, result ->
                basicAuth_tvResult.text = String(response.data)
            }
        }

        basicAuth_btnDiv.setOnClickListener{
            val numA = basicAuth_etANumber.text
            val numB = basicAuth_etBNumber.text

            val url = "http://basicauthwebapi.azurewebsites.net/api/calc/div?a=$numA&b=$numB"
            val username = basicAuth_etUsername.text.toString()
            val password = basicAuth_etPassword.text.toString()

            // Using: https://github.com/kittinunf/Fuel
            Fuel.get(url).authenticate(username, password).response { request, response, result ->
                basicAuth_tvResult.text = String(response.data)
            }
        }

    }

}
