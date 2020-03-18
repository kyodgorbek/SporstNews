package yodgorbek.komilov.musobaqayangiliklari.adapter


import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.espn_list.view.*
import yodgorbek.komilov.musobaqayangiliklari.databinding.NewsListBinding
import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.ui.detail.DetailActivity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.util.*


class TopHeadlinesAdapter(
    val context: Context, var articleList:
    List<Article>?
) :
    RecyclerView.Adapter<TopHeadlinesAdapter.MyViewHolder>() {


    companion object {
        const val urlKey = "urlKey"

    }

    lateinit var binding: NewsListBinding


    fun updateData(newList: List<Article>) {
        articleList = newList
        Log.e("articleListSize", articleList?.size.toString())

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyViewHolder {
        binding = NewsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articleList!!.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(articleList!![position])

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            binding.root.setOnClickListener { v ->
                val intent = Intent(v.context, DetailActivity::class.java)
                intent.putExtra(urlKey, articleList!![position].url)

                v.context.startActivity(intent)
            }
        }


        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
        val output = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        var d = Date()
        try {
            d = input.parse(articleList!![5].publishedAt)
        } catch (e: ParseException) {
            try {
                val fallback =
                    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
                fallback.timeZone = TimeZone.getTimeZone("UTC")
                d = fallback.parse(articleList!![5].publishedAt)
            } catch (e2: ParseException) {

                val formatted = output.format(d)
                val timelinePoint = LocalDateTime.parse(formatted)
                val now = LocalDateTime.now()

                var elapsedTime = Duration.between(timelinePoint, now)

                println(timelinePoint)
                println(now)
                elapsedTime.toMinutes()

                binding.root.articleTime.text = "${elapsedTime.toMinutes()}"


            }
        }
    }

    inner class MyViewHolder(private var binding: NewsListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(model: Article) {
            with(binding) {
                article = model
                executePendingBindings()


            }
        }

    }


}


