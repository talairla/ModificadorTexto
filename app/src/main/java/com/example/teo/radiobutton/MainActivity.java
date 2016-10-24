package com.example.teo.radiobutton;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener{

                    //Creamos aquí las variables para que sean accesibles por toda la clase
    CheckBox chbSubrayado, chbNegrita, chbCursiva, chbTachado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                    //Inicializamos las variables en el onCreate
        chbSubrayado =  (CheckBox) findViewById(R.id.chbUnderlined);
        chbNegrita =  (CheckBox) findViewById(R.id.chbBold);
        chbCursiva =  (CheckBox) findViewById(R.id.chbItalics);
        chbTachado = (CheckBox) findViewById(R.id.chbCrossedOut);
                    //Establecemos los Listeners
        chbSubrayado.setOnCheckedChangeListener(this);
        chbCursiva.setOnCheckedChangeListener(this);
        chbNegrita.setOnCheckedChangeListener(this);
        chbTachado.setOnCheckedChangeListener(this);
                    //Hacemos lo mismo con el RadioGroup
        RadioGroup rgTamanyo = (RadioGroup) findViewById(R.id.rgSize);
        rgTamanyo.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        EditText txtMuestra = (EditText) findViewById(R.id.txtMuestra);
        switch (buttonView.getId()){
            case R.id.chbBold:      //En caso de que haya habido cambio en el Negrita o Cursiva...
            case R.id.chbItalics:
                if(chbNegrita.isChecked() && chbCursiva.isChecked()){   //Tratamos los cuatro casos posibles.
                    txtMuestra.setTypeface(null, Typeface.BOLD_ITALIC);
                }else if(chbNegrita.isChecked() && !chbCursiva.isChecked()){
                    txtMuestra.setTypeface(null, Typeface.BOLD);
                }else if(!chbNegrita.isChecked() && chbCursiva.isChecked()){
                    txtMuestra.setTypeface(null, Typeface.ITALIC);
                }else if(!chbNegrita.isChecked() && !chbCursiva.isChecked()){
                    txtMuestra.setTypeface(null, Typeface.NORMAL);
                }
                break;
            case R.id.chbCrossedOut:  //Para tachar el texto o subrayarlo se hace diferente
                txtMuestra.setPaintFlags( txtMuestra.getPaintFlags() ^ Paint.STRIKE_THRU_TEXT_FLAG  );  //Así hacemos una operación XOR (OR exclusiva), con el ^
                break;                                                                                  //Con esa operación, conseguimos que si estaba activado se desactive
            case R.id.chbUnderlined:                                                                    //y si estaba desactivado se active, ya que 1 XOR 1 = 0 y 0 XOR 1 = 1
                txtMuestra.setPaintFlags( txtMuestra.getPaintFlags() ^ Paint.UNDERLINE_TEXT_FLAG  );
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //Para el radio group, trabajamos de manera parecida. Hacemos el switch sobre el radioButon interior que ha sido activado
        // que está representado por el argumento checkedId de la función.
        EditText txtMuestra = (EditText) findViewById(R.id.txtMuestra);  //Capturamos el texto de muestra.
        switch (checkedId){
            case R.id.rbsize20:     //Según sea el radioButon activo, establecemos un tamaño de letra.
                //txtMuestra.setTextSize(20); //Esto significa 20sp
                txtMuestra.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20); //Aquí le especificamos la unidad que van a ser 20sp
                break;
            case R.id.rbsize22:
                //txtMuestra.setTextSize(22);
                txtMuestra.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22); //Aquí le decimos que van a ser 20dip
                break;
            case R.id.rbsize24:
                //txtMuestra.setTextSize(24);
                txtMuestra.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24); //Aquí le decimos que van a ser 20dip
                break;
            case R.id.rbsize26:
                //txtMuestra.setTextSize(26);
                txtMuestra.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 26); //Aquí le decimos que van a ser 20dip
                break;
            case R.id.rbsize28:
                //txtMuestra.setTextSize(28);
                txtMuestra.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28); //Aquí le decimos que van a ser 20dip
                break;
            case R.id.rbsize30:
                //txtMuestra.setTextSize(30);
                txtMuestra.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30); //Aquí le decimos que van a ser 20dip
                break;
        }
    }
}
