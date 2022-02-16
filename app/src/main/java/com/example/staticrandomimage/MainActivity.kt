package com.example.staticrandomimage

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.staticrandomimage.databinding.ActivityMainBinding
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

    glide("https://picsum.photos/seed/picsum/200/300",binding.iv1)
        glide("https://picsum.photos/seed/picsum/200/300",binding.iv2)
        glide("https://picsum.photos/seed/picsum/200/300",binding.iv3)
        glide("https://picsum.photos/seed/picsum/200/300",binding.iv4)

    }

    private fun glide(url : String,imageView : ImageView) {
        Glide.with(this)
            .load(url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    binding.loading = false
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    binding.loading = true
                    return false
                }

            })
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }

}