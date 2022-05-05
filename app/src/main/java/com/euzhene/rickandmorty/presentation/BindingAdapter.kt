package com.euzhene.rickandmorty.presentation

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.euzhene.rickandmorty.R

@BindingAdapter("name")
fun bindName(tv:TextView, name:String?) {
    tv.text = String.format(
        tv.context.getString(R.string.character_name),
        name
    )
}
@BindingAdapter("race")
fun bindRace(tv:TextView, race:String?) {
    tv.text = String.format(
        tv.context.getString(R.string.character_race),
        race
    )
}
@BindingAdapter("gender")
fun bindGender(tv:TextView, gender:String?){
    tv.text = String.format(
        tv.context.getString(R.string.character_gender),
        gender
    )
}
@BindingAdapter("url_image")
fun bindUrlImage(iv:ImageView, url:String?) {
    Glide.with(iv.context)
        .load(url)
        .into(iv)
}

@BindingAdapter("background_url_image")
fun bindBackgroundUrlImage(v:View, url:String?) {
    Glide.with(v.context)
        .load(url)
        .centerCrop()
        .into(object: CustomTarget<Drawable>(){
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                v.background = resource
            }
            override fun onLoadCleared(placeholder: Drawable?) {}
        })
}
