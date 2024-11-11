import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas11.databinding.ActivityMainBinding
import com.example.tugas11.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        apiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val users = response.body()
                if (users != null) {
                    val adapter = UserAdapter(users) { user ->
                        val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                            putExtra("name", user.name)
                            putExtra("email", user.email)
                            putExtra("imageUrl", user.imageUrl)
                        }
                        startActivity(intent)
                    }
                    binding.recyclerview.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
