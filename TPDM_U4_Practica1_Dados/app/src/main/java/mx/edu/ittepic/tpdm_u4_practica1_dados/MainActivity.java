package mx.edu.ittepic.tpdm_u4_practica1_dados;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button iniciar;
    TextView ronda,turno,j1t1,j1t2,j1t3,j1t4,j2t1,j2t2,j2t3,j2t4,j3t1,j3t2,j3t3,j3t4,tota1,tota2,tota3;
    ImageView j1d1,j1d2,j2d1,j2d2,j3d1,j3d2;
    Thread hilo,jugador1,jugador2,jugador3;
    Boolean estado=true;
    int contadorRonda,totalj1,totalj2,totalj3;
    String titulo, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.iniciar);
        ronda = findViewById(R.id.ronda);
        turno = findViewById(R.id.turno);

        j1t1 = findViewById(R.id.j1t1);
        j1t2 = findViewById(R.id.j1t2);
        j1t3 = findViewById(R.id.j1t3);
        j1t4 = findViewById(R.id.j1t4);

        j2t1 = findViewById(R.id.j2t1);
        j2t2 = findViewById(R.id.j2t2);
        j2t3 = findViewById(R.id.j2t3);
        j2t4 = findViewById(R.id.j2t4);

        j3t1 = findViewById(R.id.j3t1);
        j3t2 = findViewById(R.id.j3t2);
        j3t3 = findViewById(R.id.j3t3);
        j3t4 = findViewById(R.id.j3t4);

        j1d1 = findViewById(R.id.j1d1);
        j1d2 = findViewById(R.id.j1d2);

        j2d1 = findViewById(R.id.j2d1);
        j2d2 = findViewById(R.id.j2d2);

        j3d1 = findViewById(R.id.j3d1);
        j3d2 = findViewById(R.id.j3d2);

        tota1 = findViewById(R.id.j1total);
        tota2 = findViewById(R.id.j2total);
        tota3 = findViewById(R.id.j3total);


        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar.setEnabled(false);
                estado=true;

                ronda.setText("RONDA: 1");
                turno.setText("TURNO DEL JUGADOR: 1");

                j1t1.setText("Tiro 1: 0");
                j1t2.setText("Tiro 1: 0");
                j1t3.setText("Tiro 1: 0");
                j1t4.setText("Tiro 1: 0");
                tota1.setText("Total: 0");

                j2t1.setText("Tiro 1: 0");
                j2t2.setText("Tiro 1: 0");
                j2t3.setText("Tiro 1: 0");
                j2t4.setText("Tiro 1: 0");
                tota2.setText("Total: 0");

                j3t1.setText("Tiro 1: 0");
                j3t2.setText("Tiro 1: 0");
                j3t3.setText("Tiro 1: 0");
                j3t4.setText("Tiro 1: 0");
                tota3.setText("Total: 0");

                j1d1.setImageResource(R.drawable.d0);
                j1d2.setImageResource(R.drawable.d0);
                j2d1.setImageResource(R.drawable.d0);
                j2d2.setImageResource(R.drawable.d0);
                j3d1.setImageResource(R.drawable.d0);
                j3d2.setImageResource(R.drawable.d0);


                hilo = new Thread(){
                    public void run(){
                        while(estado){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ronda.setText("RONDA: "+contadorRonda);
                                }
                            });
                            contadorRonda++;
                            try {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        turno.setText("TURNO DEL JUGADOR 1");
                                    }
                                });

                                //HILO DEL JUGADOR 1
                                jugador1 = new Thread(){
                                    public void run(){
                                        final int numero1 = (int) (Math.random() * 6) + 1;
                                        final int numero2 = (int) (Math.random() * 6) + 1;
                                        final int suma = numero1+numero2;

                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                switch (numero1){
                                                    case 1:
                                                        j1d1.setImageResource(R.drawable.d1);
                                                        break;
                                                    case 2:
                                                        j1d1.setImageResource(R.drawable.d2);
                                                        break;
                                                    case 3:
                                                        j1d1.setImageResource(R.drawable.d3);
                                                        break;
                                                    case 4:
                                                        j1d1.setImageResource(R.drawable.d4);
                                                        break;
                                                    case 5:
                                                        j1d1.setImageResource(R.drawable.d5);
                                                        break;
                                                    case 6:
                                                        j1d1.setImageResource(R.drawable.d6);
                                                        break;
                                                }

                                                switch (numero2){
                                                    case 1:
                                                        j1d2.setImageResource(R.drawable.d1);
                                                        break;
                                                    case 2:
                                                        j1d2.setImageResource(R.drawable.d2);
                                                        break;
                                                    case 3:
                                                        j1d2.setImageResource(R.drawable.d3);
                                                        break;
                                                    case 4:
                                                        j1d2.setImageResource(R.drawable.d4);
                                                        break;
                                                    case 5:
                                                        j1d2.setImageResource(R.drawable.d5);
                                                        break;
                                                    case 6:
                                                        j1d2.setImageResource(R.drawable.d6);
                                                        break;
                                                }

                                                if(contadorRonda==1){
                                                    j1t1.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj1=suma;
                                                    tota1.setText("Total: "+totalj1);
                                                }
                                                if(contadorRonda==2){
                                                    j1t2.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj1=totalj1+suma;
                                                    tota1.setText("Total: "+totalj1);
                                                }
                                                if(contadorRonda==3){
                                                    j1t3.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj1=totalj1+suma;
                                                    tota1.setText("Total: "+totalj1);
                                                }
                                                if(contadorRonda==4){
                                                    j1t4.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj1=totalj1+suma;
                                                    tota1.setText("Total: "+totalj1);
                                                }

                                            }
                                        });
                                        try {
                                            sleep(200);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //FINAL DEL HILO JUGADOR1


                                //SE EJECUTA HILO JUGADOR 1
                                jugador1.start();
                                sleep(800);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        turno.setText("TURNO DEL JUGADOR 2");
                                    }
                                });

                                //HILO DEL JUGADOR 2
                                jugador2 = new Thread(){
                                    public void run(){
                                        final int numero1 = (int) (Math.random() * 5) + 1;
                                        final int numero2 = (int) (Math.random() * 5) + 1;
                                        final int suma = numero1+numero2;
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                switch (numero1){
                                                    case 1:
                                                        j2d1.setImageResource(R.drawable.d1);
                                                        break;
                                                    case 2:
                                                        j2d1.setImageResource(R.drawable.d2);
                                                        break;
                                                    case 3:
                                                        j2d1.setImageResource(R.drawable.d3);
                                                        break;
                                                    case 4:
                                                        j2d1.setImageResource(R.drawable.d4);
                                                        break;
                                                    case 5:
                                                        j2d1.setImageResource(R.drawable.d5);
                                                        break;
                                                    case 6:
                                                        j2d1.setImageResource(R.drawable.d6);
                                                        break;
                                                }

                                                switch (numero2){
                                                    case 1:
                                                        j2d2.setImageResource(R.drawable.d1);
                                                        break;
                                                    case 2:
                                                        j2d2.setImageResource(R.drawable.d2);
                                                        break;
                                                    case 3:
                                                        j2d2.setImageResource(R.drawable.d3);
                                                        break;
                                                    case 4:
                                                        j2d2.setImageResource(R.drawable.d4);
                                                        break;
                                                    case 5:
                                                        j2d2.setImageResource(R.drawable.d5);
                                                        break;
                                                    case 6:
                                                        j2d2.setImageResource(R.drawable.d6);
                                                        break;
                                                }
                                                if(contadorRonda==1){
                                                    j2t1.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj2=suma;
                                                    tota2.setText("Total: "+totalj2);
                                                }
                                                if(contadorRonda==2){
                                                    j2t2.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj2=totalj2+suma;
                                                    tota2.setText("Total: "+totalj2);
                                                }
                                                if(contadorRonda==3){
                                                    j2t3.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj2=totalj2+suma;
                                                    tota2.setText("Total: "+totalj2);
                                                }
                                                if(contadorRonda==4){
                                                    j2t4.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj2=totalj2+suma;
                                                    tota2.setText("Total: "+totalj2);
                                                }

                                            }
                                        });
                                        try {
                                            sleep(200);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //FINAL DEL HILO JUGADOR2

                                //SE EJECUTA HILO JUGADOR 2
                                jugador2.start();
                                sleep(800);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        turno.setText("TURNO DEL JUGADOR 3");
                                    }
                                });

                                //HILO DEL JUGADOR 3
                                jugador3 = new Thread(){
                                    public void run(){
                                        final int numero1 = (int) (Math.random() * 5) + 1;
                                        final int numero2 = (int) (Math.random() * 5) + 1;
                                        final int suma = numero1+numero2;
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                switch (numero1){
                                                    case 1:
                                                        j3d1.setImageResource(R.drawable.d1);
                                                        break;
                                                    case 2:
                                                        j3d1.setImageResource(R.drawable.d2);
                                                        break;
                                                    case 3:
                                                        j3d1.setImageResource(R.drawable.d3);
                                                        break;
                                                    case 4:
                                                        j3d1.setImageResource(R.drawable.d4);
                                                        break;
                                                    case 5:
                                                        j3d1.setImageResource(R.drawable.d5);
                                                        break;
                                                    case 6:
                                                        j3d1.setImageResource(R.drawable.d6);
                                                        break;
                                                }

                                                switch (numero2){
                                                    case 1:
                                                        j3d2.setImageResource(R.drawable.d1);
                                                        break;
                                                    case 2:
                                                        j3d2.setImageResource(R.drawable.d2);
                                                        break;
                                                    case 3:
                                                        j3d2.setImageResource(R.drawable.d3);
                                                        break;
                                                    case 4:
                                                        j3d2.setImageResource(R.drawable.d4);
                                                        break;
                                                    case 5:
                                                        j3d2.setImageResource(R.drawable.d5);
                                                        break;
                                                    case 6:
                                                        j3d2.setImageResource(R.drawable.d6);
                                                        break;
                                                }
                                                if(contadorRonda==1){
                                                    j3t1.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj3=suma;
                                                    tota3.setText("Total: "+totalj3);
                                                }
                                                if(contadorRonda==2){
                                                    j3t2.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj3=totalj3+suma;
                                                    tota3.setText("Total: "+totalj3);
                                                }
                                                if(contadorRonda==3){
                                                    j3t3.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj3=totalj3+suma;
                                                    tota3.setText("Total: "+totalj3);
                                                }
                                                if(contadorRonda==4){
                                                    j3t4.setText("Tiro "+contadorRonda+": "+suma);
                                                    totalj3=totalj3+suma;
                                                    tota3.setText("Total: "+totalj3);
                                                }

                                            }
                                        });
                                        try {
                                            sleep(200);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                //FINAL DEL HILO JUGADOR3

                                //SE EJECUTA HILO JUGADOR 3
                                jugador3.start();
                                sleep(800);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(contadorRonda==4){
                                estado=false;
                                contadorRonda=1;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ronda.setText("Fin del juego");
                                        turno.setText("FIN DE TURNOS");
                                        if(totalj1>totalj2 && totalj1>totalj3){
                                           titulo="***FELICIDADES***";
                                           mensaje="EL GANADOR ES EL JUGADOR NUMERO 1\ncon un total del "+totalj1+" puntos";
                                        }
                                        if(totalj2>totalj1 && totalj2>totalj3){
                                            titulo="***FELICIDADES***";
                                            mensaje="EL GANADOR ES EL JUGADOR NUMERO 2\ncon un total del "+totalj2+" puntos";
                                        }
                                        if(totalj3>totalj1 && totalj3>totalj2){
                                            titulo="***FELICIDADES***";
                                            mensaje="EL GANADOR ES EL JUGADOR NUMERO 3\ncon un total del "+totalj3+" puntos";
                                        }
                                        if(totalj3==totalj1 || totalj3==totalj2 ||totalj1==totalj2){
                                            titulo="¡¡¡MOMENTO HAY UN EMPATE, NO SE PERMITEN EMPATES!!!";
                                            mensaje="Deacuerdo a las reglas establecidas por Pablo Crespo(R) no deben de existir empates, se debe de jugar otra ronda";
                                        }

                                        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                                        alerta.setTitle(titulo)
                                                .setMessage(mensaje)
                                                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        iniciar.setText("REINICIAR");
                                                        iniciar.setEnabled(true);
                                                    }
                                                })
                                                .show();
                                    }
                                });
                            }
                        }
                    }
                };
                contadorRonda=0;
                try{
                    hilo.start();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"EL HILO YA ESTABA EN EJECUCION",Toast.LENGTH_LONG).show();
                }
            }
        });



        //asi se cambian las imagenes de los dados
        //j4d1.setImageResource(R.drawable.d6);
        //j4d2.setImageResource(R.drawable.d6);
    }
}
