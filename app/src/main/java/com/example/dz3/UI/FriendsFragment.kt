package com.example.dz3.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dz3.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FriendsFragment: Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    private val friendAdapter = FriendAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.friends_fragment, container, false)

    }

    private fun try_reload(loading:ProgressBar, stubText:TextView){
        viewLifecycleOwner.lifecycleScope.launch {
            stubText.isVisible = false
            loading.isVisible = true

            try {
                val list = withContext(Dispatchers.IO) { viewModel.getFriends() }
                friendAdapter.submitList(list)
                loading.isVisible = false
                stubText.isVisible = false

            } catch (error: Throwable) {
                loading.isVisible = false
                stubText.isVisible = true
                stubText.text = (resources.getString(R.string.error) + error.message)
                Toast.makeText(
                    activity,
                    resources.getString(R.string.toast_fail),
                    Toast.LENGTH_SHORT
                ).show()
                error.printStackTrace()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = friendAdapter
        }


        val main_button: ImageView = view.findViewById(R.id.main_img)
        main_button.setOnClickListener {
            it
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace((requireView().parent as ViewGroup).id, MainFragment.newInstance())
            transaction?.commit()

        }
        val profile_button: ImageView = view.findViewById(R.id.profile_img)
        profile_button.setOnClickListener {
            it
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace((requireView().parent as ViewGroup).id, ProfileFragment.newInstance())
            transaction?.commit()

        }

        val loading = view.findViewById<ProgressBar>(R.id.ProgressBar)
        val stubText = view.findViewById<TextView>(R.id.stub)

        viewLifecycleOwner.lifecycleScope.launch {
            loading.isVisible = true
            //delay(2000)
            try {
                val list = withContext(Dispatchers.IO) { viewModel.getFriends() }
                friendAdapter.submitList(list)
                loading.isVisible = false
                stubText.isVisible = false

            } catch (error: Throwable) {
                loading.isVisible = false
                stubText.isVisible = true
                stubText.text = (resources.getString(R.string.error) + error.message)
                error.printStackTrace()
                stubText.setOnClickListener {
                    Toast.makeText(
                        activity,
                        resources.getString(R.string.toast_fail),
                        Toast.LENGTH_SHORT
                    ).show()
                    error.printStackTrace()
                    stubText.setOnClickListener { try_reload(loading, stubText) }
                }



            }


        }



    }
    companion object {
        fun newInstance() = FriendsFragment()
    }
}