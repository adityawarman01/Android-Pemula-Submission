package com.perum.proyekakhirandroidpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.perum.proyekakhirandroidpemula.databinding.ActivityDetailBinding
import com.perum.proyekakhirandroidpemula.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var rvFood: RecyclerView
    private val list: ArrayList<Food> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.title="Nama Makanan"

        rvFood = findViewById(R.id.rv_food)
        rvFood.setHasFixedSize(true)

        list.addAll(FoodData.listData)
        rvFood.layoutManager = LinearLayoutManager(this)
        val listCharFood = ListFoodAdapter(list)
        rvFood.adapter = listCharFood
    }

/*
    private fun getListFood(): ArrayList<Food>{
        val dataName = resources.getStringArray(R.array.data_makanan)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFood = ArrayList<Food>()
        for (i in dataName.indices){
            val makanan = Food(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, 1))
            listFood.add(makanan)
        }
        return listFood
    }
    private fun showRecylerList(){
        rvFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFood.adapter = listFoodAdapter
    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.food_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectMode: Int) {
        when (selectMode){
            R.id.about -> {
                val rAbout = Intent(this@MainActivity,About::class.java)
                startActivity(rAbout)
            }
        }
    }
}