package yodgorbek.komilov.musobaqayangiliklari.adapter




import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import yodgorbek.komilov.musobaqayangiliklari.databinding.NewsListBinding
import yodgorbek.komilov.musobaqayangiliklari.model.Article
import yodgorbek.komilov.musobaqayangiliklari.ui.detail.DetailActivity


class TopHeadlinesAdapter(


) :
    RecyclerView.Adapter<TopHeadlinesAdapter.MyViewHolder>() {


    companion object {
        const val urlKey = "urlKey"

    }

    lateinit var binding: NewsListBinding
    lateinit var articleList: List<Article>

    fun updateData(newList: List<Article>) {
        articleList = newList
        Log.e("articleListSize", articleList.size.toString())

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyViewHolder {
        binding = NewsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(articleList[position])

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            binding.root.setOnClickListener { v ->
                val intent = Intent(v.context, DetailActivity::class.java)
                intent.putExtra(urlKey, articleList[position].url)

                v.context.startActivity(intent)
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


