package com.huntinggame.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huntinggame.R
import com.huntinggame.activity.FriendActivity
import com.huntinggame.base.BaseFragment
import com.huntinggame.databinding.FragmentProfileBinding


class ProfileFragment : BaseFragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        init()
        initControl()
        myObserver()
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun init() {

    }

    override fun initControl() {
        binding.ivaddProfile.setOnClickListener {
            startActivity(Intent(this.requireContext(), FriendActivity::class.java))
        }


    }

    override fun myObserver() {

    }


}