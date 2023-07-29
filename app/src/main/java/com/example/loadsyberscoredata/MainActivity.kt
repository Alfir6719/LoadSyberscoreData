package com.example.loadsyberscoredata

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.loadsyberscoredata.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textView = binding.textView
        CoroutineScope(IO).launch {
            val time = measureTimeMillis {
                val matches = CyberScoreApi.retrofitService.getAllData()
                val list = mutableListOf<Job>()
                for (item in matches.rows) {
                    list + launch {
                        println(fetchData(item.id))
                    }
                }
                list.joinAll()
            }
            println(time)
        }
    }

    private fun fetchData(matchId: String): CyberScoreMatch {
        val doc: Document = Jsoup.connect("https://cyberscore.live/matches/$matchId").get()
        val str = doc.html().toString()
        val text =
            str.substring(str.indexOf("<script id=\"__NEXT_DATA__\" type=\"application/json\">") + 51)
        val json = text.substring(0, text.indexOf("</script>"))
        return gson.fromJson(json, CyberScoreMatch::class.java)
    }
}