package com.example.dz3.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.dz3.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

   private val id="4"

    private val friendAdapter = ProfileAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.profile_fragment, container, false)

    }

    private fun try_reload(loading: ProgressBar, id: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            loading.isVisible = true

            try {
                val list = withContext(Dispatchers.IO) { viewModel.getFriend(id) }
                friendAdapter.submitList(list)
                loading.isVisible = false

            } catch (error: Throwable) {
                loading.isVisible = false
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val friends_button: ImageView = view.findViewById(R.id.friends_img)
        friends_button.setOnClickListener {
            it
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(
                (requireView().parent as ViewGroup).id,
                FriendsFragment.newInstance()
            )
            transaction?.commit()

        }
        val main_button: ImageView = view.findViewById(R.id.main_img)
        main_button.setOnClickListener {
            it
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace((requireView().parent as ViewGroup).id, MainFragment.newInstance())
            transaction?.commit()

        }

        val loading = view.findViewById<ProgressBar>(R.id.ProgressBar)


        viewLifecycleOwner.lifecycleScope.launch {
            loading.isVisible = true
            //delay(2000)
            try {          //Log.d("TEST", "lol1")
                val list = withContext(Dispatchers.IO) {
                    viewModel.getFriend(id)
                }
                //Log.d("TEST", "lol2")
                friendAdapter.submitList(list)
                loading.isVisible = false


            } catch (error: Throwable) {
                loading.isVisible = true
                loading.setOnClickListener { try_reload(loading, id) }
            }


        }


    }


companion object {
    fun newInstance() = ProfileFragment()
}
}