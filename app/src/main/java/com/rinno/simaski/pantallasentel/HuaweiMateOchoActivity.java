package com.rinno.simaski.pantallasentel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HuaweiMateOchoActivity extends AppCompatActivity {


    int contCast = 0;
    @BindView(R.id.ivFlechaIzquierda)
    ImageView ivFlechaIzquierda;
    @BindView(R.id.ivFlechaDerecha)
    ImageView ivFlechaDerecha;
    //@BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.btIrCatalogo)
    Button btIrCatalogo;
    int bandera = 0;
    String TAG = "HOLA";
    MyPagerAdapter adapter;
    int stateJimmy;

    @Override
    protected void onResume() {
        super.onResume();
        contCast = 0;
    }

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

        contCast = 0;

        pager = (ViewPager) findViewById(R.id.pager);

        pager.setPageTransformer(true, new ZoomOutPageTransformer());


        ViewPagerIndicator indicator = (ViewPagerIndicator) findViewById(R.id.pager_indicator);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);



        indicator.setPager(pager);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if(position == 2 && positionOffset == 0.0 && stateJimmy == 1){
                    contCast++;
                    if(contCast == 1){
                        Log.d(TAG,"ABRIR ACTIVITY");
                        Intent intent = new Intent(HuaweiMateOchoActivity.this,PruebaActivity.class);
                        startActivity(intent);
                    }
                }else{
                    Log.d(TAG,"NO");

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                stateJimmy = state;
            }
        });


    }

    @OnClick({R.id.ivFlechaIzquierda, R.id.ivFlechaDerecha, R.id.btIrCatalogo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivFlechaIzquierda:
                pager.setCurrentItem(pager.getCurrentItem() - 1, true); //getItem(-1) for previous
                bandera--;
                break;
            case R.id.ivFlechaDerecha:
                pager.setCurrentItem(pager.getCurrentItem() + 1, true); //getItem(-1) for previous
                bandera++;
                if(bandera == 3){
                    Intent intent = new Intent(HuaweiMateOchoActivity.this,PruebaActivity.class);
                    startActivity(intent);
                    bandera = 2;
                }
                break;
            case R.id.btIrCatalogo:
                Toast.makeText(this, "ID "+bandera, Toast.LENGTH_SHORT).show();
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
                    return new HuaweiMateOchoUnoFragment();
                case 1:
                    return new HuaweiMateOchoDosFragment();
                case 2:
                    return new HuaweiMateOchoTresFragment();
                default:
                    return new HuaweiMateOchoUnoFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {

            Intent i = new Intent(HuaweiMateOchoActivity.this,MainActivity.class);
            startActivity(i);
            HuaweiMateOchoActivity.this.finish();

        }
        return true;
    }


}