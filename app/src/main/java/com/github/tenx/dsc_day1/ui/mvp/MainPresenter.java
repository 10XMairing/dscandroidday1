package com.github.tenx.dsc_day1.ui.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.github.tenx.dsc_day1.ui.second.SecondActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainPresenter {

    private Context context;
    private MainView mainView;


    public MainPresenter(Context context) {
        this.context = context;
        if(context instanceof MainView){
            this.mainView = (MainView) context;
        }else{
            throw new Error("Calling activity must implement MainView");
        }
    }

    public void handleClick(){
        mainView.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mainView.changeHeader("MOVING TO SECOND ACTIVITY TWO In 2 Seconds!");
                mainView.hideProgress();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(context , SecondActivity.class);
                        ((AppCompatActivity) context).startActivity(intent);
                    }
                }, 2000);
            }
        }, 2000);

    }





    interface  MainView {
        void showProgress();

        void hideProgress();

        void changeHeader(String text);
    }
}
