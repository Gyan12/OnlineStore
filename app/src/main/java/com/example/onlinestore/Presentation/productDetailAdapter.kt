package com.example.onlinestore.Presentation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.Model.productDetail
import com.example.onlinestore.R
import com.squareup.picasso.Picasso

class productDetailAdapter (
     var productDetails : List<productDetail>,
     var context : Context
        ) : RecyclerView.Adapter<productDetailAdapter.productDetailViewHolder>() {

    var mImageView : ImageView ?= null
    var mTitle : TextView ?= null
    var mPrice : TextView ?= null
    var mRating : TextView ?= null
    var mCategory : TextView ?= null
    var mDescription : TextView ?= null
    var mImageUrl : String ?= null


    inner class productDetailViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    @SuppressLint("MissingInflatedId")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)
        mImageView = view.findViewById(R.id.imageView2)
        mTitle = view.findViewById(R.id.title)
        mRating = view.findViewById(R.id.RatingVal)
        mCategory = view.findViewById(R.id.Category)
        mDescription = view.findViewById(R.id.description)
        mPrice = view.findViewById(R.id.priceVal)


        return productDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: productDetailViewHolder, position: Int) {
        holder.itemView.apply {
            mTitle?.text = productDetails[position].title
            mImageUrl = productDetails[position].image
            mRating?.text = productDetails[position].rating.toString()
            mCategory?.text = productDetails[position].category
            mDescription?.text = productDetails[position].description
            mPrice?.text = productDetails[position].price.toString()

            Picasso.with(context)
                .load(mImageUrl)
                .into(mImageView)
        }
    }

    override fun getItemCount(): Int {
        return productDetails.size
    }


}