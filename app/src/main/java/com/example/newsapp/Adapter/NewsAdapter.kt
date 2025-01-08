package com.example.newsapp.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.model.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    // ArticleViewHolder class
    inner class ArticleViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    // DiffUtil Callback
    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    // AsyncListDiffer
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]

        // تحميل الصورة باستخدام Glide
        Glide.with(holder.binding.root.context)
            .load(article.urlToImage)
            .error(R.drawable.ic_launcher_background)
            .into(holder.binding.articleImage)

        // تعيين النصوص
        holder.binding.articleTitle.text = article.title
        holder.binding.articleDescription.text = article.description
        holder.binding.articleDateTime.text = article.publishedAt
        holder.binding.articleSource.text = article.source!!.name

        // تفعيل Listener عند النقر على العنصر
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(article) }
        }
    }

    // دالة لتحديث القائمة
    fun submitList(list: List<Article>) {
        differ.submitList(list)
    }

    // دالة لإضافة Listener للنقر على العنصر
    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}