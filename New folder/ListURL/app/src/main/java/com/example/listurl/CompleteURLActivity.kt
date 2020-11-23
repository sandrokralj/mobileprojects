package com.example.listurl

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_url.*

class CompleteURLActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_url)

        val url = intent.extras?.getString("title")

        urlTextView.text = url

        completeButton.setOnClickListener {
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var urls = prefs.getStringSet(getString(R.string.URL_STRINGS), mutableSetOf())
            val copyOfSet = urls?.toMutableSet()

            copyOfSet?.remove(url)
            prefs.edit().putStringSet(getString(R.string.URL_STRINGS), copyOfSet).apply()
            finish()
        }
    }
}
