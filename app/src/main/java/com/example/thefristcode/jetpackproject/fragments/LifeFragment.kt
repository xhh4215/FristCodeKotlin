package com.example.thefristcode.jetpackproject.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thefristcode.jetpackproject.R

class LifeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /***
     * Fragment 和Activity建立联系的时候回调的方法
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    /***
     * 为Fragment创建视图的时候回调的方法
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_life, container, false)
    }

    /***
     * 确保相关连的Activity创建完成的时候回调的方法
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    /***
     * 当fragment的视图销毁的时候回到的方法
     */
    override fun onDestroyView() {
        super.onDestroyView()
    }

    /***
     * Fragment和Activity解除关联的时候回调的方法
     */
    override fun onDetach() {
        super.onDetach()
    }


}