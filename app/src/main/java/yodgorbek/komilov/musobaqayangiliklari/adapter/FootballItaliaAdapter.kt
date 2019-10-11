package yodgorbek.komilov.musobaqayangiliklari.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import yodgorbek.komilov.musobaqayangiliklari.R
import yodgorbek.komilov.musobaqayangiliklari.model.Article
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

class FootballItaliaAdapter(val context: Context) : RecyclerView.Adapter<FootballItaliaAdapter.MyViewHolder>() {

    var articleList: List<Article> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.football_italia_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.articleTitle.text = articleList[position].title
        holder.articleSourceName.text = articleList[position].source.name
        Picasso.get().load(articleList.get(position).urlToImage).into(holder.image)

        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
        val output = SimpleDateFormat("dd/MM/yyyy")
        var d = Date()
        try {
            d = input.parse(articleList[5].publishedAt)
        } catch (e: ParseException) {
            try {
                val fallback = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                fallback.timeZone = TimeZone.getTimeZone("UTC")
                d = fallback.parse(articleList[5].publishedAt)
            } catch (e2: ParseException) {
                // TODO handle error
                val formatted = output.format(d)
                val timelinePoint = LocalDateTime.parse(formatted)
                val now = LocalDateTime.now()

                var elapsedTime = Duration.between(timelinePoint, now)

                println(timelinePoint)
                println(now)
                elapsedTime.toMinutes()

                holder.articleTime.text = "${elapsedTime.toMinutes()}"
            }
        }
    }

    fun setMovieListItems(articleList: List<Article>) {
        this.articleList = articleList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val image: ImageView = itemView!!.findViewById(R.id.imageView)
        val articleTitle: TextView = itemView!!.findViewById(R.id.articleTitle)
        val articleSourceName: TextView = itemView!!.findViewById(R.id.articleSourceName)
        val imageCategory: ImageView = itemView!!.findViewById(R.id.imageCategory)
        val articleTime: TextView = itemView!!.findViewById(R.id.articleTime)

    }
}