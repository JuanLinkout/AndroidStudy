package com.example.androidstudy.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.androidstudy.databinding.TodoDetailsBinding

class TodoDetails : Fragment() {
    private val args: TodoDetailsArgs by navArgs()
    private lateinit var binding: TodoDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TodoDetailsBinding.inflate(layoutInflater)

        binding.textViewTitle.text = args.todoListItem.title
        binding.textViewDescription.text = args.todoListItem.id.toString()
        Glide.with(binding.root).load("https://source.unsplash.com/random/600x600").into(binding.imageViewCoverHeader)

        return binding.root
    }
}