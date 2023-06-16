package com.test.study01

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.test.study01.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {


    lateinit var fragmentFirstBinding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentFirstBinding = FragmentFirstBinding.inflate(inflater, container, false)

        fragmentFirstBinding.run {
            webView.run {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl("https://comic.naver.com/webtoon/detail?titleId=811707&no=1")
                setOnKeyListener { view, i, keyEvent ->
                    if(keyEvent.action == KeyEvent.ACTION_DOWN){
                        if(i == KeyEvent.KEYCODE_BACK){
                            if(webView.canGoBack()){
                                webView.goBack()
                            }
                        }
                    }
                    true
                }
            }
        }

        return fragmentFirstBinding.root
    }

}