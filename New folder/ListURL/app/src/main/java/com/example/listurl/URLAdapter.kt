package com.example.listurl

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.url_row.view.*

class URLAdapter(val urls: List<String>) : RecyclerView.Adapter<URLAdapter.URLHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): URLHolder {
        return URLHolder(LayoutInflater.from(p0.context).inflate(R.layout.url_row, p0, false))
    }

    override fun getItemCount(): Int {
        return urls.count()
    }

    override fun onBindViewHolder(holder: URLHolder, position: Int) {
        val title = urls[position]
        holder.bindURL(title)
    }

    class URLHolder(v:View) : RecyclerView.ViewHolder(v), View.OnClickListener{

        var view : View = v
        var title : String = ""

        init{
            v.setOnClickListener(this)
        }
        fun bindURL(title:String){
            this.title = title
            view.textView.text = title
        }
        override fun onClick(v: View?) {
            val intent = Intent(view.context, CompleteURLActivity::class.java)
            intent.putExtra("title", title)
            startActivity(view.context, intent, null)
        }

    }
}