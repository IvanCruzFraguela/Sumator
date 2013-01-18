package com.ivancruz.sumator;

import java.util.Date;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity  {
	int numA = 0;
	int numB;
	int auxNumTecleado = 0;
	
	Random random = new Random();
	
	TextView tvSumaARealizar;
	TextView tvNumTecleado; 
	TextView tvError;
	Date TiempoInicial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvSumaARealizar = (TextView)findViewById(R.id.textViewSumaARealizar);
		tvNumTecleado = (TextView)findViewById(R.id.textViewNumTecleado);
		tvError = (TextView)findViewById(R.id.textViewError);
		
		tvError.setVisibility(View.INVISIBLE);
		TiempoInicial = new Date();
		numB = GeneraNumero();
		ShowNumbers();
	}
	
	public void OnClickComprobar(View v){
		int ResultadoReal = numA + numB;
		if(auxNumTecleado != ResultadoReal){
			findViewById(R.id.buttonComprobar).setEnabled(false);
			tvError.setText("Error: Resultado correcto = " + (numA + numB)); 
			tvError.setVisibility(View.VISIBLE);
		}else{
			if(ResultadoReal >= 100){
				findViewById(R.id.buttonComprobar).setEnabled(false);
				double Segundos = CalculaTiempo(this.TiempoInicial,new Date());
				AlertDialog alertDialog;
				alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Final");
				alertDialog.setMessage("Tiempo Utilizado = " + Segundos + " segundos");
				alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int which)
				    {
				        dialog.cancel();
				    }
				});
				alertDialog.show();
			}
			numA = auxNumTecleado;
			auxNumTecleado = 0;
			numB = GeneraNumero();
			this.ShowNumbers();
		}
	}

	public void OnClick1(View v){
		this.NumTecleado(1);
	}
	public void OnClick2(View v){
		this.NumTecleado(2);
	}
	public void OnClick3(View v){
		this.NumTecleado(3);
	}
	public void OnClick4(View v){
		this.NumTecleado(4);
	}
	public void OnClick5(View v){
		this.NumTecleado(5);
	}
	public void OnClick6(View v){
		this.NumTecleado(6);
	}
	public void OnClick7(View v){
		this.NumTecleado(7);
	}
	public void OnClick8(View v){
		this.NumTecleado(8);
	}
	public void OnClick9(View v){
		this.NumTecleado(9);
	}
	public void OnClick0(View v){
		this.NumTecleado(0);
	}
	public void OnClickCancelar(View v){
		this.auxNumTecleado = 0;
		MostrarNumTecleado();
	}
	void NumTecleado(int num){
		if(this.auxNumTecleado == 0){
			this.auxNumTecleado = num;
		}else{
			this.auxNumTecleado = (this.auxNumTecleado * 10) + num;
		}
		MostrarNumTecleado();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	int GeneraNumero(){
		return random.nextInt(10)+1;
	}
	void ShowNumbers(){
		this.tvSumaARealizar.setText("" + numA + " + " + numB);
		MostrarNumTecleado();
	}
	void MostrarNumTecleado(){
		String aux = "_";
		if(this.auxNumTecleado > 0){
			aux = "" + auxNumTecleado + "_";
		}
		this.tvNumTecleado.setText(aux);
	}
	double CalculaTiempo(Date ini,Date fin){
		return ((double)(fin.getTime() - ini.getTime()))/1000;//Porque son milisegundos
	}

}
