package com.neuralnet.poc.financasapp.ui.screens.chatbot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.neuralnet.poc.financasapp.R
import com.neuralnet.poc.financasapp.databinding.FragmentChatBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : Fragment(R.layout.fragment_chat) {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl("https://mediafiles.botpress.cloud/b6cf7b0a-6c47-49c4-893b-3c81b3b479dd/webchat/bot.html")
            settings.domStorageEnabled = true
            settings.javaScriptEnabled = true
            settings.setSupportZoom(true)
        }
        return binding.root
    }
}