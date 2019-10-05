package yodgorbek.komilov.musobaqayangiliklari.adapter

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


class TopHeadlinesAdapter(val context: Context) : RecyclerView.Adapter<TopHeadlinesAdapter.MyViewHolder>() {

    var articleList : List<Article> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvMovieName.text = articleList.get(position).title
        Picasso.get().load(articleList.get(position).urlToImage).into(holder.image)
    }

    fun setMovieListItems(articleList: List<Article>){
        this.articleList = articleList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvMovieName: TextView = itemView!!.findViewById(R.id.title)
        val image: ImageView = itemView!!.findViewById(R.id.image)

    }
}