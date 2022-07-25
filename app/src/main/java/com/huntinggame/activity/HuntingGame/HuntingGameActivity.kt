package com.huntinggame.activity.HuntingGame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.huntinggame.Adapter.HuntingGameAdapter
import com.huntinggame.Modal.HuntingGameModal
import com.huntinggame.R
import com.huntinggame.activity.AddPlayerScreen.AddPlayerScreenActivity
import com.huntinggame.activity.CurrentLeaderBoardActivity
import com.huntinggame.activity.Main.MainActivity
import com.huntinggame.databinding.ActivityHuntingGameBinding

class HuntingGameActivity : AppCompatActivity() {
    lateinit var bin: ActivityHuntingGameBinding
    private var huntingGameModal = ArrayList<HuntingGameModal>()
   lateinit var  imageView35:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityHuntingGameBinding.inflate(layoutInflater)
        setContentView(bin.root)
        initView()
        lstnr()
    }

    private fun initView() {
        imageView35=findViewById(R.id.imageView35)

        huntingGameModal.add(HuntingGameModal(R.drawable.group_7, "Alexa",R.drawable.checked))
        huntingGameModal.add(HuntingGameModal(R.drawable.group_6, "Alexa",R.drawable.checked))
        huntingGameModal.add(HuntingGameModal(R.drawable.group_7, "Alexa",R.drawable.question))
        huntingGameModal.add(HuntingGameModal(R.drawable.group_6, "Alexa",R.drawable.cancel))
//        huntingGameModal.add(HuntingGameModal(R.drawable.group_7, "Alexa"))
//        huntingGameModal.add(HuntingGameModal(R.drawable.group_6, "Alexa"))

        bin.HuntingGameToolbar.tvName.text = "HUNTING GAME"
        bin.HuntingGameToolbar.ivBackImg.visibility = View.VISIBLE
        bin.HuntingGameToolbar.ivadd.visibility = View.VISIBLE



        imageView35.setOnClickListener {
            startActivity(Intent(this, CurrentLeaderBoardActivity::class.java))
        }


    }

    private fun lstnr() {
        HuntingGameAdapter(this, huntingGameModal).apply {
            bin.rcyHuntingGame.layoutManager = LinearLayoutManager(this@HuntingGameActivity)
            bin.rcyHuntingGame.adapter = this
        }
        bin.HuntingGameToolbar.ivBackImg.setOnClickListener {
            onBackPressed()
        }
        bin.HuntingGameToolbar.ivadd.setOnClickListener {
            startActivity(Intent(this, AddPlayerScreenActivity::class.java))

        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}