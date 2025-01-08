package com.example.newsapp.ui.fragment

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentArticleBinding
import com.example.newsapp.ui.NewsActivity
import com.example.newsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var binding: FragmentArticleBinding
    private val args: ArticleFragmentArgs by navArgs()
    private lateinit var newsViewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ربط الـ Binding
        binding = FragmentArticleBinding.bind(view)

        // استدعاء ViewModel
        newsViewModel = (activity as NewsActivity).newsViewModel

        // الحصول على المقال من Safe Args
        val article = args.article

        binding.wabView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }

        }

        binding.fab.setOnClickListener {
            newsViewModel.addFavoriteNews(article)
            Snackbar.make(view,"Added to Favorite",Snackbar.LENGTH_LONG).show()
        }
    }

}