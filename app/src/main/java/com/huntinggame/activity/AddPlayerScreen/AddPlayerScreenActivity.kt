package com.huntinggame.activity.AddPlayerScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.huntinggame.Adapter.AddPlayerScreenAdapter
import com.huntinggame.Adapter.NumberAddPlayerAdapter
import com.huntinggame.R
import com.huntinggame.activity.HuntingGame.HuntingGameActivity
import com.huntinggame.databinding.ActivityAddPlayerScreenBinding
import com.huntinggame.databinding.DoYouAcceptBottomSheetBinding
import com.huntinggame.databinding.SentBottomSheetBinding
import com.huntinggame.utils.Common.CustomLoader.Companion.show

class AddPlayerScreenActivity : AppCompatActivity() {
    lateinit var bin: ActivityAddPlayerScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityAddPlayerScreenBinding.inflate(layoutInflater)
        setContentView(bin.root)
        initView()
        lstnr()
    }

    private fun initView() {
        bin.addplayerToolbar.tvName.text = "ADD PLAYERS SCREEN"
        bin.addplayerToolbar.ivBackImg.visibility = View.VISIBLE

        AddPlayerScreenAdapter(this).apply {
            bin.rcyAddPlayer.layoutManager = LinearLayoutManager(this@AddPlayerScreenActivity)
            bin.rcyAddPlayer.adapter = this
        }
        NumberAddPlayerAdapter(this).apply {
            bin.rcyNumberAddPlayer.layoutManager = LinearLayoutManager(this@AddPlayerScreenActivity)
            bin.rcyNumberAddPlayer.adapter = this
        }

    }

    private fun lstnr() {
        bin.addplayerToolbar.ivBackImg.setOnClickListener {
            onBackPressed()
        }
        bin.imageView8.setOnClickListener {
            BottomSheetDialog(
                this@AddPlayerScreenActivity,
                R.style.CustomBottomSheetDialogTheme
            ).apply {
                val view =
                    SentBottomSheetBinding.inflate(LayoutInflater.from(this@AddPlayerScreenActivity))
                setContentView(view.root)
                show()
                view.imageView11.setOnClickListener {
                    dismiss()
                    startActivity(
                        Intent(
                            this@AddPlayerScreenActivity,
                            HuntingGameActivity::class.java
                        )
                    )
                }
            }



//            BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme).apply {
//                val view =
//                    DoYouAcceptBottomSheetBinding.inflate(LayoutInflater.from(this@AddPlayerScreenActivity))
//                setContentView(view.root)
//                show()
//                view.tvNo.setOnClickListener {
//                    dismiss()
//                }
//                view.imageView9.setOnClickListener {
//                    dismiss()
//                    BottomSheetDialog(
//                        this@AddPlayerScreenActivity,
//                        R.style.CustomBottomSheetDialogTheme
//                    ).apply {
//                        val view =
//                            SentBottomSheetBinding.inflate(LayoutInflater.from(this@AddPlayerScreenActivity))
//                        setContentView(view.root)
//                        show()
//                        view.imageView11.setOnClickListener {
//                            dismiss()
//                            startActivity(Intent(this@AddPlayerScreenActivity, HuntingGameActivity::class.java))
//                        }
//                    }
//
//                }
//            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}