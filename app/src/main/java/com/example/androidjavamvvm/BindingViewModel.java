package com.example.androidjavamvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


public class BindingViewModel extends AndroidViewModel {
    Customer customer;
    public BindingViewModel(@NonNull Application application){
        super(application);
        customer = new Customer("Hi i am changed by the viewemodel");
    }

    public Customer getCustomer() {
        return this.customer;
    }
}
