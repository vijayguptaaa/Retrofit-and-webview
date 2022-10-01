package com.example.androidjavamvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.androidjavamvvm.databinding.ActivityBindingBinding;

public class BindingActivity extends AppCompatActivity {

    ActivityBindingBinding binding;
    BindingViewModel bindingViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBindingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
////        binding.setCname("i am set in cname");
//        Customer c = new Customer("Hi am changed by the model class");
//        binding.setCustomer(c);

        bindingViewModel = ViewModelProviders.of(this).get(BindingViewModel.class);
        binding.setCustomer(bindingViewModel.getCustomer());
    }
}