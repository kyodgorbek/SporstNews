package yodgorbek.komilov.musobaqayangiliklari.utils


import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import yodgorbek.komilov.musobaqayangiliklari.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@BindingAdapter("bind:image_url")
fun loadImage(imageView: ImageView?, image_url: String?) {
    Picasso.get().load(image_url).fit()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .into(imageView)
}


fun getAppropriateTimeDiffResolution(
    start: Date?,
    end: Date?
): String {
    return if (start != null && end != null) {
        val diffInMs: Long = end.time - start.time
        val diffInMins: Long = TimeUnit.MILLISECONDS.toMinutes(diffInMs)
        val diffInHrs: Long = TimeUnit.MILLISECONDS.toHours(diffInMs)
        val diffInDays: Long = TimeUnit.MILLISECONDS.toDays(diffInMs)
        val diffInMonth: Long = TimeUnit.MILLISECONDS.toDays(diffInMs) / 30
        val diffInYear = diffInMonth / 12
        val stringBuilder = StringBuilder()
        if (diffInMins < 60) {
            if (diffInMins > 1) stringBuilder.append(diffInMins)
                .append(" Mins Ago")
                .toString() else if (diffInMins == 0L) "Now" else stringBuilder.append(
                diffInMins
            ).append(" Mins Ago").toString()
        } else if (diffInHrs < 24) {
            stringBuilder.append(diffInHrs)
                .append(" Hours Ago")
                .toString()
        } else if (diffInDays < 30) {
            stringBuilder.append(diffInDays)
                .append(" Days Ago").toString()
        } else if (diffInMonth < 12) {
            stringBuilder.append(diffInMonth)
                .append(" Months Ago")
                .toString()
        } else {
            stringBuilder.append(diffInYear)
                .append(" Years Ago").toString()

        }
    } else {
        "--"
    }
}

fun getFormattedTime(@NonNull time: String): String {
    Log.e("BindingAdapter", time)

    val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
    var d: Date?
    try {
        d = input.parse(time)
        return getAppropriateTimeDiffResolution(d, Date())
    } catch (e: ParseException) {
        try {
            val fallback =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            d = fallback.parse(time)
            return getAppropriateTimeDiffResolution(d, Date())
        } catch (e2: ParseException) {
            return "--"
        }
    }
}


@BindingAdapter("updatedTime")
fun updatedTime(view: TextView, time: String) {
    view.text =
        getFormattedTime(time)
}

