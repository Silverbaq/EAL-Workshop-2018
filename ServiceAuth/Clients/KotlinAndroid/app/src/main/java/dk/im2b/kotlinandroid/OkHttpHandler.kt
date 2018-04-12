package dk.im2b.kotlinandroid

import android.os.AsyncTask

class OkHttpHandler(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg p0: Void?): Void? {
        handler()
        return null
    }

}