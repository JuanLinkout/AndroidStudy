import com.example.androidstudy.data.models.TodoListItem
import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun getTodos(): List<TodoListItem>
}