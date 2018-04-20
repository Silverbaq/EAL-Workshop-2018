package dk.im2b.kotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_pinning.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.CertificatePinner


class PinningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pinning)

        // events with the correct fingerprint
        pinning_btnAdd.setOnClickListener {
            val numA = pinning_etANumber.text.toString()
            val numB = pinning_etBNumber.text.toString()

            val url = "http://basicwebapi.azurewebsites.net/api/calc/add?a=$numA&b=$numB"

            val urlForPinning = "basicwebapi.azurewebsites.net"
            val pin = "sha256/OtGR7ixvqZTxaH6c5Vpeje4IUMgdfqgYdIq5ZykUcgc="

            requestWebService(url, urlForPinning, pin, pinning_tvResult)
        }

        pinning_btnDiv.setOnClickListener {
            pinning_btnDiv.setOnClickListener {
                val numA = pinning_etANumber.text.toString()
                val numB = pinning_etBNumber.text.toString()

                val url = "http://basicwebapi.azurewebsites.net/api/calc/div?a=$numA&b=$numB"

                val urlForPinning = "basicwebapi.azurewebsites.net"
                val pin = "sha256/OtGR7ixvqZTxaH6c5Vpeje4IUMgdfqgYdIq5ZykUcgc="

                requestWebService(url, urlForPinning, pin, pinning_tvResult)
            }
        }

        pinning_btnSub.setOnClickListener {
            pinning_btnSub.setOnClickListener {
                val numA = pinning_etANumber.text.toString()
                val numB = pinning_etBNumber.text.toString()

                val url = "http://basicwebapi.azurewebsites.net/api/calc/sub?a=$numA&b=$numB"

                val urlForPinning = "basicwebapi.azurewebsites.net"
                val pin = "sha256/OtGR7ixvqZTxaH6c5Vpeje4IUMgdfqgYdIq5ZykUcgc="

                requestWebService(url, urlForPinning, pin, pinning_tvResult)
            }
        }

        pinning_btnMulti.setOnClickListener {
            pinning_btnMulti.setOnClickListener {
                val numA = pinning_etANumber.text.toString()
                val numB = pinning_etBNumber.text.toString()

                val url = "http://basicwebapi.azurewebsites.net/api/calc/multi?a=$numA&b=$numB"

                val urlForPinning = "basicwebapi.azurewebsites.net"
                val pin = "sha256/OtGR7ixvqZTxaH6c5Vpeje4IUMgdfqgYdIq5ZykUcgc="

                requestWebService(url, urlForPinning, pin, pinning_tvResult)
            }
        }

        // Events with a wrong fingerprint
        incPinning_btnAdd.setOnClickListener {
            val numA = pinning_etANumber.text.toString()
            val numB = pinning_etBNumber.text.toString()

            val url = "http://basicwebapi.azurewebsites.net/api/calc/add?a=$numA&b=$numB"

            val urlForPinning = "basicwebapi.azurewebsites.net"
            val pin = "sha256/1234567890"

            requestWebService(url, urlForPinning, pin, pinning_tvResult)
        }

        incPinning_btnDiv.setOnClickListener {
            pinning_btnDiv.setOnClickListener {
                val numA = pinning_etANumber.text.toString()
                val numB = pinning_etBNumber.text.toString()

                val url = "http://basicwebapi.azurewebsites.net/api/calc/div?a=$numA&b=$numB"

                val urlForPinning = "basicwebapi.azurewebsites.net"
                val pin = "sha256/1234567890"

                requestWebService(url, urlForPinning, pin, pinning_tvResult)
            }
        }

        incPinning_btnSub.setOnClickListener {
            pinning_btnSub.setOnClickListener {
                val numA = pinning_etANumber.text.toString()
                val numB = pinning_etBNumber.text.toString()

                val url = "http://basicwebapi.azurewebsites.net/api/calc/sub?a=$numA&b=$numB"

                val urlForPinning = "basicwebapi.azurewebsites.net"
                val pin = "sha256/1234567890"

                requestWebService(url, urlForPinning, pin, pinning_tvResult)
            }
        }

        incPinning_btnMulti.setOnClickListener {
            pinning_btnMulti.setOnClickListener {
                val numA = pinning_etANumber.text.toString()
                val numB = pinning_etBNumber.text.toString()

                val url = "http://basicwebapi.azurewebsites.net/api/calc/multi?a=$numA&b=$numB"

                val urlForPinning = "basicwebapi.azurewebsites.net"
                val pin = "sha256/1234567890"

                requestWebService(url, urlForPinning, pin, pinning_tvResult)
            }
        }
    }

    fun requestWebService(url: String, pinUrl: String, certificate: String, tvResult: TextView) {
        OkHttpHandler {
            val certPinner = CertificatePinner.Builder()
                    .add(pinUrl, certificate)
                    .build()

            val client = OkHttpClient().newBuilder().certificatePinner(certPinner).build()

            val request = Request.Builder()
                    .url(url)
                    .build()

            val response = client.newCall(request).execute()
            val result = response.body()!!.string()
            runOnUiThread { tvResult.text =  result}
        }.execute()
    }

}
