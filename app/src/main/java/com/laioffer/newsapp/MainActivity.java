package com.laioffer.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.laioffer.newsapp.databinding.ActivityMainBinding;
import com.laioffer.newsapp.model.NewsResponse;
import com.laioffer.newsapp.network.NewsApi;
import com.laioffer.newsapp.network.RetrofitClient;


public class MainActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(navView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController);


    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }


//    private NavController navController;
//    private ActivityMainBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_main);
//        // connect fragments with buttons in bottom navigation
//        // step 1: findViewById --> binding
//        BottomNavigationView navView = binding.navView;
//
//
//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
//
//        navController = navHostFragment.getNavController();
//
//        NavigationUI.setupWithNavController(navView, navController);
//
//        NavigationUI.setupActionBarWithNavController(this, navController);
//
//        // retrofit (replace monkeylearn api) create an instance
//        NewsApi api = RetrofitClient.newInstance(this).create(NewsApi.class);
//        //
//        api.getTopHeadlines("US").enqueue(new Callback<NewsResponse>() {
//            @Override
//            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
//                if (response.isSuccessful()){
//                    Log.d("getTopHeadline", response.body().toString());
//                } else {//server response error
//                    Log.d("getTopHeadlines", response.toString());
//                }
//            }
//            //send failure
//            @Override
//            public void onFailure(Call<NewsResponse> call, Throwable t) {
//                Log.d("getTopHeadlines", t.toString());
//            }
//        });
//    }
//
//    //Overriding onSupportNavigateUp is for handling the top left back button.
//    // if in page_search or page_save, click back to home page -- last page -- startDestination
//    @Override
//    public boolean onSupportNavigateUp() {
//        return navController.navigateUp();
//    }
}