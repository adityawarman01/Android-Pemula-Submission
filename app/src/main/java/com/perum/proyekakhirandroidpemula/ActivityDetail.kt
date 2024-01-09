package com.perum.proyekakhirandroidpemula

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.perum.proyekakhirandroidpemula.databinding.ActivityMainBinding

class ActivityDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
      /*  val actionbar = supportActionBar
        actionbar!!.title = "Deskripsi Makanan"
        actionbar.setDisplayHomeAsUpEnabled(true)
        */

        val namaMakanan: TextView = findViewById(R.id.nama_food)
        val imgMakanan: ImageView = findViewById(R.id.img_food)
        val descMakanan: TextView = findViewById(R.id.deskripsi_food)

        val qNama = intent.getStringExtra(EXTRA_NAME)
        val qImg = intent.getIntExtra(EXTRA_PHOTO, 0)
        val qDetail = intent.getStringExtra(EXTRA_DESC)

        namaMakanan.text = qNama
        imgMakanan.setImageResource(qImg)
        descMakanan.text = qDetail
    }
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_detail"
        const val EXTRA_PHOTO = "extra_photo"
    }

}