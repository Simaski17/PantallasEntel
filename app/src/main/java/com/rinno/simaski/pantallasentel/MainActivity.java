package com.rinno.simaski.pantallasentel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    int contCast = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * Seteando el Fullscreen
		 */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /*
         * Cargando contenido del layout
		 */
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        ViewPagerIndicator indicator = (ViewPagerIndicator) findViewById(R.id.pager_indicator);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        indicator.setPager(pager);



    }
    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0:
                    return new HuaweiPNueveTresFragment();
                case 1:
                    return new HuaweiPNueveUnoFragment();
                case 2:
                    return new HuaweiPNueveDosFragment();
                case 3:
                    return new LgGCincoUnoFragment();
                case 4:
                    return new LgGCincoDosFragment();
                case 5:
                    return new LgGCincoTresFragment();
                default:
                    return new HuaweiPNueveTresFragment();
            }
        }

        @Override
        public int getCount() {
            return 6;
        }
    }
}



