package polije.kuliah.topupin.presentation.product

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import polije.kuliah.topupin.R
import polije.kuliah.topupin.databinding.ActivityGameshopBinding
import polije.kuliah.topupin.presentation.Injector
import javax.inject.Inject

class ProductActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ProductViewModelFactory
    private lateinit var binding : ActivityGameshopBinding
    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        (application as Injector).createProductSubComponent().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gameshop)
        productViewModel = ViewModelProvider(this, factory)
            .get(ProductViewModel::class.java)

        val intent = getIntent()
        binding.testButton.text = intent.getStringExtra("category").toString()

        binding.testButton.setOnClickListener {
            productViewModel.getProduct()
                .observe(this, Observer {
                    Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
                })
        }
    }
}