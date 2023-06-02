package in.codeaxe.apiapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api-key.php")
    Call<List<list>> getlist();
}
