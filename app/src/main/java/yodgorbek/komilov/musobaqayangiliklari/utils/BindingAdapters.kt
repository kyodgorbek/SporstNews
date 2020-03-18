package yodgorbek.komilov.musobaqayangiliklari.utils


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import yodgorbek.komilov.musobaqayangiliklari.R

@BindingAdapter("bind:image_url")
fun loadImage(imageView: ImageView, image_url: String) {
    Picasso.get().load(image_url).fit()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .into(imageView)
}


