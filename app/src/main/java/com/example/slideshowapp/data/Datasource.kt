package com.example.slideshowapp.data

import com.example.slideshowapp.R
import com.example.slideshowapp.model.Sushi

object Datasource {
    fun loadSushis(): List<Sushi> {
        return listOf(
            Sushi(R.drawable.futomaki, R.string.futo_maki),
            Sushi(R.drawable.nigiri, R.string.nigiri),
            Sushi(R.drawable.onigiri, R.string.onigiri),
            Sushi(R.drawable.gunkan_maki, R.string.gunkan_maki),
            Sushi(R.drawable.temaki, R.string.temaki),
            Sushi(R.drawable.uramaki, R.string.uramaki),
            Sushi(R.drawable.narezushi, R.string.narezushi),
            Sushi(R.drawable.oshi, R.string.oshi),
            Sushi(R.drawable.inari, R.string.inari),
            Sushi(R.drawable.chirashi, R.string.chirashi)
        )
    }
}
