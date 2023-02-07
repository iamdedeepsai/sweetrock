package com.example.sweetrock

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2FragmentAdapter(
    private val fragments: List<Fragment>,
    private val lifecycle: Lifecycle, private val manager: FragmentManager
) : FragmentStateAdapter(manager, lifecycle) {

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}