package com.perum.proyekakhirandroidpemula

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListFoodAdapter(private val listFood: ArrayList<Food>) : RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_makanan, parent, false)
        return ListViewHolder(view)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val context = holder.itemView.context
        val (name, description, photo) = listFood[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvDescription.text = description

        /*holder.itemView.setOnClickListener{
            val intentDetail = Intent (holder.itemView.context, ActivityDetail::class.java)
            intentDetail.putExtra("key_food", listFood[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }*/

        holder.itemView.setOnClickListener{
            val goDetail = Intent(context, ActivityDetail::class.java)
            goDetail.putExtra(ActivityDetail.EXTRA_NAME, name)
            goDetail.putExtra(ActivityDetail.EXTRA_PHOTO, photo)
            goDetail.putExtra(ActivityDetail.EXTRA_DESC, description)
            context.startActivity(goDetail)
        }
    }
    override fun getItemCount(): Int {
        return listFood.size
    }
   inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

}