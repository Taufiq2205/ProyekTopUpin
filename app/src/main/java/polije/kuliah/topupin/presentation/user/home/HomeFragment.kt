package polije.kuliah.topupin.presentation.user.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import polije.kuliah.topupin.R
import polije.kuliah.topupin.databinding.FragmentHomeBinding
import polije.kuliah.topupin.presentation.product.ProductActivity
import polije.kuliah.topupin.presentation.user.UserViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ProductCategoryAdapter
    private val userViewModel: UserViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        initRecylerView()

        return binding.root

    }

    private fun initRecylerView() {
        binding.recyclerProducts.layoutManager = GridLayoutManager(context, 4)
        adapter = ProductCategoryAdapter()
        binding.recyclerProducts.adapter = adapter
        displayProduct()
    }

    private fun displayProduct() {
        val responseLiveData = userViewModel.getCategoryProduct()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                Log.i("MyTag", it.toString())
                adapter.setList(it)
                giveButtonFunction(adapter, it)
                adapter.notifyDataSetChanged()
            } else {

                Toast.makeText(context, "No Data Available", Toast.LENGTH_SHORT).show()

            }
        })
    }
    private fun productIntent(category:String){
        val intent = Intent(requireContext(),ProductActivity::class.java)
        intent.putExtra("category",category)
        startActivity(intent)
    }

    private fun giveButtonFunction(adapter: ProductCategoryAdapter, categoryName: List<String>) {
        adapter.setOnItemClickListener { clickedCategory ->
            when (clickedCategory.uppercase()) {
                "GAME" -> {
                    // Action for the first category
                   productIntent("GAME")
                    // Your custom action here for the first cate gory
                }
                "PULSA" -> {
                    // Action for the second category
                    productIntent("PULSA")
                    // Your custom action here for the second category
                }
                "EMONEY" -> {
                    // Action for the third category
                    productIntent("EMONEY")
                    // Your custom action here for the third category
                }
                "PREMIUM" -> {
                    // Default action for unhandled categories
                    productIntent("PREMIUM")
                }
                "TAGIHAN"->{
                    Toast.makeText(context, "Tasgihan category clicked", Toast.LENGTH_SHORT).show()
                }else->{
                    Toast.makeText(context, "SERVICE NOT AVAILABLE", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }




}