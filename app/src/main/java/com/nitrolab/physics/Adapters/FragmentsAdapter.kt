package com.nitrolab.physics.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nitrolab.physics.Fragments.FirstYearFragment
import com.nitrolab.physics.Fragments.FourthYearFragment
import com.nitrolab.physics.Fragments.SecondYearFragment
import com.nitrolab.physics.Fragments.ThirdYearFragment

class FragmentsAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return FirstYearFragment()
            1 -> return SecondYearFragment()
            2 -> return ThirdYearFragment()
            3 -> return FourthYearFragment()
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return 4
    }

}