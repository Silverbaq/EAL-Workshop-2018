package dk.im2b.kotlinandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.mainActivity_btnNoAuth).setOnClickListener({
            val intent = Intent(this, NoAuthActivity::class.java)
            startActivity(intent)
        })

        findViewById<Button>(R.id.mainActivity_btnBasicAuth).setOnClickListener({
            val intent = Intent(this, BasicAuthActivity::class.java)
            startActivity(intent)
        })

        findViewById<Button>(R.id.mainActivity_btnTokenAuth).setOnClickListener({
            val intent = Intent(this, TokenActivity::class.java)
            startActivity(intent)
        })
    }
}
