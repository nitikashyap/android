package com.huntinggame.activity.CreateGame


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.huntinggame.activity.Main.MainActivity

import com.huntinggame.databinding.ActivityCreateGameBinding
import kotlinx.android.synthetic.main.activity_create_game.*

import java.text.SimpleDateFormat
import java.util.*

class CreateGameActivity : AppCompatActivity() {
    lateinit var bin: ActivityCreateGameBinding
    var selectTime: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityCreateGameBinding.inflate(layoutInflater)
        setContentView(bin.root)
        initView()
        lstnr()

    }

    private fun initView() {
        bin.CreateGameToolbar.tvName.text = "Create Game"
        bin.CreateGameToolbar.ivBackImg.visibility = View.VISIBLE
    }

    private fun lstnr() {
        bin.startDate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                MaterialDatePicker.Builder.datePicker().setSelection(Date().time).build()
                    .apply {
                        show(supportFragmentManager, this@CreateGameActivity.toString())
                        addOnPositiveButtonClickListener {
                            bin.startDate.setText(
                                SimpleDateFormat("dd-MM-yyyy ", Locale.getDefault()).format(
                                    Date(it)
                                )
                            )
                        }
                    }
            }

        })
        bin.textView24.setOnClickListener {
            MaterialDatePicker.Builder.datePicker().setSelection(Date().time).build()
                .apply {
                    show(supportFragmentManager, this@CreateGameActivity.toString())
                    addOnPositiveButtonClickListener {
                        bin.textView24.setText(
                            SimpleDateFormat("dd-MM-yyyy ", Locale.getDefault()).format(
                                Date(it)
                            )
                        )
                    }
                }
        }
        bin.textView241.setOnClickListener {
            val materialTimePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()

            materialTimePicker.show(supportFragmentManager, "fragment_tag")
            materialTimePicker.addOnPositiveButtonClickListener {
                val newHour = materialTimePicker.hour
                val newMinute = materialTimePicker.minute
                selectTime = newHour.toString() + ":" + newMinute
                bin.textView241.text = selectTime
            }
        }
        bin.textView2411.setOnClickListener {
            val materialTimePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()

            materialTimePicker.show(supportFragmentManager, "fragment_tag")
            materialTimePicker.addOnPositiveButtonClickListener {
                val newHour = materialTimePicker.hour
                val newMinute = materialTimePicker.minute
                selectTime = newHour.toString() + ":" + newMinute
                bin.textView2411.text = selectTime
            }
        }
        bin.CreateGameToolbar.ivBackImg.setOnClickListener {
            onBackPressed()
        }
        bin.ivCreateGame.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


}