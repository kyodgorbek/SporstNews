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


@Suppress("UNREACHABLE_CODE")
class BBCSportAdapter(private val context: Context, private val listViewType: List<Int>) : RecyclerView.Adapter<BBCSportAdapter.MyViewHolder>() {


    companion object {
        val ITEM_A: Int = 1
        val ITEM_B: Int = 2
    }


    var articleList: List<Article> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater =
            LayoutInflater.from(parent.context)
        return when (viewType) {
            ITEM_A -> ViewHolderItemA(inflater.inflate(R.layout.bbc_sport_list, null))

            else -> {
                ViewHolderItemB(inflater.inflate(R.layout.bbc_sport_item, null))
            }

        }

    }


    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val viewType = listViewType?.get(position)
        return when (viewType) {
            ITEM_A -> {
                val viewHolderA = holder as ViewHolderItemA
                Picasso.get().load(articleList[position].urlToImage)
                    .into(viewHolderA.topFlameImageView)
            }
            else -> {
                val viewHolderB = holder as ViewHolderItemB
                viewHolderB.articleTitle.text = articleList[position].title
                viewHolderB.articleSourceName.text = articleList[position].source.name
                Picasso.get().load(articleList[position].urlToImage).into(viewHolderB.image)
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

                        viewHolderB.articleTime.text = "${elapsedTime.toMinutes()}"
                    }
                }
            }
        }
    }
    override fun getItemCount(): Int {
        return listViewType.size
    }


//
//
//
//
//
//                }
//            }
//        }

        fun setMovieListItems(articleList: List<Article>) {
            this.articleList = articleList
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int = listViewType!!.get(position)


    open inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){}


        inner class ViewHolderItemA(itemView: View) : MyViewHolder(itemView) {
            val topFlameImageView: ImageView = itemView.findViewById(R.id.topFlameImageView)
        }


        inner class ViewHolderItemB(itemView: View?) : MyViewHolder(itemView) {
            val image: ImageView = itemView!!.findViewById(R.id.imageView)
            val articleTitle: TextView = itemView!!.findViewById(R.id.articleTitle)
            val articleSourceName: TextView = itemView!!.findViewById(R.id.articleSourceName)
            val imageCategory: ImageView = itemView!!.findViewById(R.id.imageCategory)
            val articleTime: TextView = itemView!!.findViewById(R.id.articleTime)
        }

    }
