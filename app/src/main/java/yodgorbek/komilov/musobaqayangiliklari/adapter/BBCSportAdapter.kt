package yodgorbek.komilov.musobaqayangiliklari.adapter


import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi


import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.bbc_sport_item.view.*
import yodgorbek.komilov.musobaqayangiliklari.R

import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.model.NewsImage
import yodgorbek.komilov.musobaqayangiliklari.ui.detail.DetailActivity
import yodgorbek.komilov.musobaqayangiliklari.utils.updatedTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class BBCSportAdapter :
    RecyclerView.Adapter<BBCSportAdapter.MyViewHolder>() {
    companion object {
        const val urlKey = "urlKey"

    }


    lateinit var articleList: List<Article>

    fun updateData(newList: List<Article>) {
        articleList = newList
        Log.e("articleListSize", articleList.size.toString())

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.bbc_sport_item, parent, false))

                override fun getItemCount(): Int {
                    return articleList.size
                }






        @RequiresApi(Build.VERSION_CODES.O)
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bind(articleList[position])
            holder.itemView.setOnClickListener { v->
                val intent = Intent(v.context, DetailActivity::class.java)
                intent.putExtra(urlKey, articleList[position].url)

                v.context.startActivity(intent)


            }
        }





   private  fun getAppropriateTimeDiffResolution(
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

  private  fun getFormattedTime(@NonNull time: String): String {
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



    fun updatedTime(view: TextView, time: String) {
        view.text =
            getFormattedTime(time)
    }



    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

          private var articleTitle: TextView = itemView.articleTitle
            private var articleSourceName: TextView = itemView.articleSourceName
            private var imageCategory:ImageView = itemView.imageCategory
            private var articleTime:TextView = itemView.articleTime
            private  var newsImages: NewsImage? = null
        private  var imageView:ImageView = itemView.imageView



        fun bind(model: Article) {
                  articleTitle.text = model.title
                  articleSourceName.text = model.source?.name
            Picasso.get().load(model.urlToImage).fit()
                .into(imageView)
            Picasso.get().load(newsImages?.url).fit()
                .into(imageCategory)

            model.publishedAt?.let { updatedTime(articleTime, it) }



            }
        }

    }





