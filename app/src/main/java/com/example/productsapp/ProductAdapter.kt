package com.example.productsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class ProductAdapter(val context:Context,val productArrayList: List<Product>):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvProductName:TextView
        val ivProductImage:ShapeableImageView
        val ratingBar:RatingBar
        init {
            tvProductName = itemView.findViewById(R.id.tvProductName)
            ivProductImage = itemView.findViewById(R.id.ivProductImage)
            ratingBar = itemView.findViewById(R.id.ratingBar)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.productitem,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.tvProductName.text = currentItem.title
        Picasso.get().load(currentItem.thumbnail).into(holder.ivProductImage)
        holder.ratingBar.rating = currentItem.rating.toFloat()
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }
}