package com.bailong.administrator.ausedcar.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bailong.administrator.ausedcar.R;
import com.bailong.administrator.ausedcar.ui.biblefragment.BibleFragment;
import com.bailong.administrator.ausedcar.ui.buycarsfragment.BuyCarsFragment;
import com.bailong.administrator.ausedcar.ui.homepagefragment.HomePageFragment;
import com.bailong.administrator.ausedcar.ui.myfragment.MyFragment;
import com.bailong.administrator.ausedcar.ui.selltruckfragment.SellTruckFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.main_framelayout)
    FrameLayout mainFramelayout;
    @Bind(R.id.main_radiogroup_homepage)
    RadioButton mainRadiogroupHomepage;
    @Bind(R.id.main_radiogroup_buycars)
    RadioButton mainRadiogroupBuycars;
    @Bind(R.id.main_radiogroup_selltruck)
    RadioButton mainRadiogroupSelltruck;
    @Bind(R.id.main_radiogroup_blble)
    RadioButton mainRadiogroupBlble;
    @Bind(R.id.main_radiogroup_my)
    RadioButton mainRadiogroupMy;
    @Bind(R.id.main_radiogroup)
    RadioGroup mainRadiogroup;
    private HomePageFragment homePageFragment;
    private BuyCarsFragment buyCarsFragment;
    private SellTruckFragment sellTruckFragment;
    private BibleFragment bibleFragment;
    private MyFragment myFragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //黄油刀绑定控件

        InitView();
        SetListener();

    }

    private void SetListener() {
        mainRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.main_radiogroup_homepage:
                        switchfragment(0);
                        break;
                    case R.id.main_radiogroup_buycars:
                        switchfragment(1);
                        break;
                    case R.id.main_radiogroup_selltruck:
                        switchfragment(2);
                        break;
                    case R.id.main_radiogroup_blble:
                        switchfragment(3);
                        break;
                    case R.id.main_radiogroup_my:
                        switchfragment(4);
                        break;
                }
            }
        });
    }

    private void InitView() {
        ButterKnife.bind(this);
        manager = getSupportFragmentManager();


    }

    //切换碎片的方法,根据索引对碎片进行切换
    public void switchfragment(int index) {
        //创建碎片管理器
        FragmentTransaction transaction = manager.beginTransaction();
        AddTransaction(transaction);

        //根据id对碎片进行切换 ,如果碎片开始为空 进行创建
        switch (index) {
            case 0:
                if (homePageFragment == null) {
                    homePageFragment = new HomePageFragment();
                    transaction.add(R.id.main_framelayout, homePageFragment);
                } else {
                    transaction.show(homePageFragment);
                }
            case 1:
                if (buyCarsFragment == null) {
                    buyCarsFragment = new BuyCarsFragment();
                    transaction.add(R.id.main_framelayout, buyCarsFragment);
                } else {
                    transaction.show(buyCarsFragment);
                }
            case 2:
                if (sellTruckFragment == null) {
                    sellTruckFragment = new SellTruckFragment();
                    transaction.add(R.id.main_framelayout, sellTruckFragment);
                } else {
                    transaction.show(sellTruckFragment);
                }
            case 3:
                if (bibleFragment == null) {
                    bibleFragment = new BibleFragment();
                    transaction.add(R.id.main_framelayout, bibleFragment);
                } else {
                    transaction.show(bibleFragment);
                }
            case 4:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    transaction.add(R.id.main_framelayout, myFragment);
                } else {
                    transaction.show(myFragment);
                }


        }

    }

    private void AddTransaction(FragmentTransaction transaction) {
        if (homePageFragment != null) {
            transaction.hide(homePageFragment);
        }
        if (buyCarsFragment != null) {
            transaction.hide(buyCarsFragment);
        }
        if (sellTruckFragment != null) {
            transaction.hide(sellTruckFragment);
        }
        if (bibleFragment != null) {
            transaction.hide(bibleFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
