package com.example.listurl

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_url.*

class CreateURLActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_url)

        saveButton.setOnClickListener {
            var title = ""
            if(importantCheckBox.isChecked){
                title = "❗  " + titleEditText.text.toString()
            }
            else{
                title = titleEditText.text.toString()
            }

            //saving
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var urls = prefs.getStringSet(getString(R.string.URL_STRINGS), mutableSetOf())
            val copyOfSet = urls?.toMutableSet()
            copyOfSet?.add(title)

            prefs.edit().putStringSet("URLstrings", copyOfSet).apply()
            finish()
        }
    }
}
