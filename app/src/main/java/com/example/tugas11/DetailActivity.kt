import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas11.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val imageUrl = intent.getStringExtra("imageUrl")


        binding.detailName.text = name
        binding.detailEmail.text = email
        Picasso.get().load(imageUrl).into(binding.detailImage)
    }
}
