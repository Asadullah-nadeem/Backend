package in.codeaxe.apiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterR adapterR;
    private ArrayList<list> empList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;
    private String url = "https://codeaxe.in/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        progressBar = findViewById(R.id.progressBar);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        empList = new ArrayList<>();
        adapterR = new AdapterR(this, empList);
        recyclerView.setAdapter(adapterR);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        // Initial data load
        loadData();
    }

    private void loadData() {
        showProgressBar();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<list>> call = apiService.getlist();
        call.enqueue(new Callback<List<list>>() {
            @Override
            public void onResponse(Call<List<list>> call, Response<List<list>> response) {
                if (response.isSuccessful()) {
                    List<list> empList = response.body();
                    if (empList != null) {
                        adapterR.setEmpPojos(new ArrayList<>(empList));
                        adapterR.notifyDataSetChanged();
                    } else {
                        // Handle API response errors
                    }
                } else {
                    // Handle API response errors
                }

                hideProgressBar();
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<list>> call, Throwable t) {
                // Handle API call failure
                hideProgressBar();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
