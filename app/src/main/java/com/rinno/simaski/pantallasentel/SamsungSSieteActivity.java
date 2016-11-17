package com.rinno.simaski.pantallasentel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SamsungSSieteActivity extends AppCompatActivity {


    int contCast = 0;
    @BindView(R.id.ivFlechaIzquierda)
    ImageView ivFlechaIzquierda;
    @BindView(R.id.ivFlechaDerecha)
    ImageView ivFlechaDerecha;
    //@BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.btIrCatalogo)
    Button btIrCatalogo;

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


        pager = (ViewPager) findViewById(R.id.pager);
        ViewPagerIndicator indicator = (ViewPagerIndicator) findViewById(R.id.pager_indicator);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        indicator.setPager(pager);


    }

    @OnClick({R.id.ivFlechaIzquierda, R.id.ivFlechaDerecha, R.id.btIrCatalogo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivFlechaIzquierda:
                Toast.makeText(getApplication(), "Flecha", Toast.LENGTH_SHORT).show();
                pager.setCurrentItem(pager.getCurrentItem() - 1, true); //getItem(-1) for previous
                break;
            case R.id.ivFlechaDerecha:
                Toast.makeText(getApplication(), "Flecha derecha", Toast.LENGTH_SHORT).show();
                pager.setCurrentItem(pager.getCurrentItem() + 1, true); //getItem(-1) for previous
                break;
            case R.id.btIrCatalogo:
                Toast.makeText(getApplication(), "Flecha", Toast.LENGTH_SHORT).show();
                //pager.setCurrentItem(pager.getCurrentItem() + 1, true); //getItem(-1) for previous
                break;
        }
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {

                case 0:
                    return new SamsungSSieteUnoFragment();
                case 1:
                    return new SamsungSSieteDosFragment();
                case 2:
                    return new SamsungSSieteTresFragment();
                default:
                    return new SamsungSSieteUnoFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {

            Intent i = new Intent(SamsungSSieteActivity.this,MainActivity.class);
            startActivity(i);
            SamsungSSieteActivity.this.finish();

        }
        return true;
    }

}
