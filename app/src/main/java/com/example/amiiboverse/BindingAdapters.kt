package com.example.amiiboverse

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.amiiboverse.adapter.AmiiboAdapter
import com.example.amiiboverse.model.AmiiboApiStatus
import com.example.amiiboverse.newtork.Character

//Update data in the recyclerview
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data:List<Character>?) {
    val adapter = recyclerView.adapter as AmiiboAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.animate_loading)
            error(R.drawable.cloud_off_outline)
        }
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: AmiiboApiStatus){
    when(status) {
        AmiiboApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.animate_loading)
        }
        AmiiboApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        AmiiboApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.cloud_off_outline)
        }
    }
}