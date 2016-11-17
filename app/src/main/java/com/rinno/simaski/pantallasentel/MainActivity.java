package com.rinno.simaski.pantallasentel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btHuaweiMateOcho)
    Button btHuaweiMateOcho;
    @BindView(R.id.btHuaweiPNueve)
    Button btHuaweiPNueve;
    @BindView(R.id.btIphoneCuatroSe)
    Button btIphoneCuatroSe;
    @BindView(R.id.btIphoneSiete)
    Button btIphoneSiete;
    @BindView(R.id.btIphoneSietePlus)
    Button btIphoneSietePlus;
    @BindView(R.id.btLgGCinco)
    Button btLgGCinco;
    @BindView(R.id.btSamsungSSiete)
    Button btSamsungSSiete;
    @BindView(R.id.btSamsungSSieteEdge)
    Button btSamsungSSieteEdge;
    @BindView(R.id.btXperiaX)
    Button btXperiaX;

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
        setContentView(R.layout.main);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.btHuaweiMateOcho, R.id.btHuaweiPNueve, R.id.btIphoneCuatroSe, R.id.btIphoneSiete, R.id.btIphoneSietePlus, R.id.btLgGCinco, R.id.btSamsungSSiete, R.id.btSamsungSSieteEdge, R.id.btXperiaX})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btHuaweiMateOcho:
                Intent i = new Intent(MainActivity.this,HuaweiMateOchoActivity.class);
                startActivity(i);
                MainActivity.this.finish();
                break;
            case R.id.btHuaweiPNueve:
                Intent i2 = new Intent(MainActivity.this ,HuaweiPNueveActivity.class);
                startActivity(i2);
                MainActivity.this.finish();
                break;
            case R.id.btIphoneCuatroSe:
                Intent i3 = new Intent(MainActivity.this ,IphoneCuatroSeActivity.class);
                startActivity(i3);
                MainActivity.this.finish();
                break;
            case R.id.btIphoneSiete:
                Intent i4 = new Intent(MainActivity.this ,IphoneSieteActivity.class);
                startActivity(i4);
                MainActivity.this.finish();
                break;
            case R.id.btIphoneSietePlus:
                Intent i5 = new Intent(MainActivity.this ,IphoneSietePlusActivity.class);
                startActivity(i5);
                MainActivity.this.finish();
                break;
            case R.id.btLgGCinco:
                Intent i6 = new Intent(MainActivity.this ,LgGCincoActivity.class);
                startActivity(i6);
                MainActivity.this.finish();
                break;
            case R.id.btSamsungSSiete:
                Intent i7 = new Intent(MainActivity.this ,SamsungSSieteActivity.class);
                startActivity(i7);
                MainActivity.this.finish();
                break;
            case R.id.btSamsungSSieteEdge:
                Intent i8 = new Intent(MainActivity.this ,SamsungSSieteEdgeActivity.class);
                startActivity(i8);
                MainActivity.this.finish();
                break;
            case R.id.btXperiaX:
                Intent i9 = new Intent(MainActivity.this ,XperiaXActivity.class);
                startActivity(i9);
                MainActivity.this.finish();
                break;
        }
    }

}



