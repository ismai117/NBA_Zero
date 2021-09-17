package com.nbastats.nba_zero.views

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.nbastats.nba_zero.R
import com.nbastats.nba_zero.playerviewmodel.PlayerViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val model = ViewModelProvider(this).get(PlayerViewModel::class.java)
        model.getMutableLiveData().observe(this, Observer {
            if (it != null){
                Log.d("player", "name: ${it.firstName} ${it.lastName}")

                val circularProgress = CircularProgressDrawable(this)
                circularProgress.strokeWidth = 5f
                circularProgress.centerRadius = 32f
                circularProgress.start()

                Picasso.get().load(it.headShotUrl).placeholder(circularProgress).into(player_image)
                player_fullname.text = "${it.firstName} ${it.lastName}"
                player_teamname.text = it.team
                player_position.text = it.position
                player_age.text = it.age
                player_dateOfBirth.text = it.dateOfBirth
                player_height.text = it.height
                player_weight.text = it.weight
                player_jerseyNumber.text = it.jerseyNumber


            }else{
                Log.d("player", "" + "failed")
            }
        })

        model.makeApiCall()

    }
}


