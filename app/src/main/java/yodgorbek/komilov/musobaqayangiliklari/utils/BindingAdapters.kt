package yodgorbek.komilov.musobaqayangiliklari.utils


import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import yodgorbek.komilov.musobaqayangiliklari.R
import yodgorbek.komilov.musobaqayangiliklari.adapter.TopHeadlinesAdapter
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

@BindingAdapter("bind:image_url")
fun loadImage(imageView: ImageView, image_url: String) {
    Picasso.get().load(image_url).fit()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .into(imageView)

    @BindingAdapter("app:formattedTime")
    fun formattedTime(view: TextView, time:String) {
       // view.setText(view.getContext().getString(getFormattedTime, time))
    }

    @SuppressLint("NewApi")
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.O)
    fun getFormattedTime(time:String): String {
        //"published_date":"2015-08-13T20:21:28-5:00 skip time zone"
        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
        val output = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        var d = Date()
        try {
            d = input.parse(time!!)
        } catch (e: ParseException) {
            try {
                val fallback =
                    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
                fallback.timeZone = TimeZone.getTimeZone("UTC")
                d = fallback.parse(time)
            } catch (e2: ParseException) {

                val formatted = output.format(d)
                val timelinePoint = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    LocalDateTime.parse(formatted)
                } else {
                    TODO("VERSION.SDK_INT < O")
                }
                val now = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    LocalDateTime.now()
                } else {
                    TODO("VERSION.SDK_INT < O")
                }

                var elapsedTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Duration.between(timelinePoint, now)
                } else {
                    TODO("VERSION.SDK_INT < O")
                }

                println(timelinePoint)
                println(now)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    elapsedTime.toMinutes()
                }
            }


        }
        return time
    }
}
