package yodgorbek.komilov.musobaqayangiliklari.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.bbc_sport_item.view.*
import yodgorbek.komilov.musobaqayangiliklari.R
import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.ui.detail.DetailActivity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.util.*


@Suppress("UNREACHABLE_CODE")
class BBCSportAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var articleList: List<Article> = listOf()

    companion object {
        const val urlKey = "urlKey"

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bbc_sport_item, null)
        return ViewHolder(view)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ViewHolder).apply {
            when (position) {
                0 -> {
                    header.visibility = ViewGroup.VISIBLE
                    item.visibility = ViewGroup.GONE

                    Picasso.get().load(articleList[position].urlToImage)
                        .into(bigImage)
                }
                else -> {
                    header.visibility = ViewGroup.GONE
                    item.visibility = ViewGroup.VISIBLE

                    articleTitle.text = articleList[position].title
                    articleSourceName.text = articleList[position].source.name
                    Picasso.get().load(articleList[position].urlToImage).into(image)
                    val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
                    val output = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    var d = Date()
                    try {
                        d = input.parse(articleList[5].publishedAt)
                    } catch (e: ParseException) {
                        try {
                            val fallback =
                                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
                            fallback.timeZone = TimeZone.getTimeZone("UTC")
                            d = fallback.parse(articleList[5].publishedAt)
                        } catch (e2: ParseException) {

                            val formatted = output.format(d)
                            val timelinePoint = LocalDateTime.parse(formatted)
                            val now = LocalDateTime.now()

                            val elapsedTime = Duration.between(timelinePoint, now)

                            println(timelinePoint)
                            println(now)
                            elapsedTime.toMinutes()

                            articleTime.text = "${elapsedTime.toMinutes()}"


                        }
                    }
                }
            }
        }
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra("urlKey", articleList[position].url)

            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    fun setMovieListItems(articleList: List<Article>) {
        this.articleList = articleList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.imageView
        val articleTitle: TextView = itemView.articleTitle
        val articleSourceName: TextView = itemView.articleSourceName
        val imageCategory: ImageView = itemView.imageCategory
        val articleTime: TextView = itemView.articleTime

        val bigImage = itemView.bigImage
        val header: CardView = itemView.header
        val item: CardView = itemView.item
    }
}
