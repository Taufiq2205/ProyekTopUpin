package polije.kuliah.topupin.presentation.product

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import polije.kuliah.topupin.R
import polije.kuliah.topupin.data.model.SendProduct
import polije.kuliah.topupin.databinding.ActivityGameshopBinding
import polije.kuliah.topupin.presentation.Injector
import javax.inject.Inject

class ProductActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ProductViewModelFactory
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: ActivityGameshopBinding
    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        (application as Injector).createProductSubComponent().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gameshop)
        productViewModel = ViewModelProvider(this, factory)
            .get(ProductViewModel::class.java)

        val intent_ProductCategory = getIntent().getStringExtra("category".toString())
        initRecylerView(intent_ProductCategory.toString())
    }

    private fun initRecylerView(categoryName: String) {
        binding.recylerView.layoutManager = GridLayoutManager(this, 4)
        adapter = ProductAdapter()
        binding.recylerView.adapter = adapter
        displayProduct(categoryName)
    }

    private fun displayProduct(categoryName: String){
        val responseLiveData = productViewModel.getProduct(SendProduct(categoryName))
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show()
            }
        })
    }
}