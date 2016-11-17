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
                Intencion(HuaweiMateOchoActivity.class);
                break;
            case R.id.btHuaweiPNueve:
                Intencion(HuaweiPNueveActivity.class);
                break;
            case R.id.btIphoneCuatroSe:
                Intencion(IphoneCuatroSeActivity.class);
                break;
            case R.id.btIphoneSiete:
                Intencion(IphoneSieteActivity.class);
                break;
            case R.id.btIphoneSietePlus:
                Intencion(IphoneSietePlusActivity.class);
                break;
            case R.id.btLgGCinco:
                Intencion(LgGCincoActivity.class);
                break;
            case R.id.btSamsungSSiete:
                Intencion(SamsungSSieteActivity.class);
                break;
            case R.id.btSamsungSSieteEdge:
                Intencion(SamsungSSieteEdgeActivity.class);
                break;
            case R.id.btXperiaX:
                Intencion(XperiaXActivity.class);
                break;
        }
    }

    public void Intencion(Class name){
        Intent i = new Intent(MainActivity.this ,name);
        startActivity(i);
        MainActivity.this.finish();
    }

}



