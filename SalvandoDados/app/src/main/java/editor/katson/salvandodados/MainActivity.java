package editor.katson.salvandodados;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    private EditText edt_nome;
    private EditText edt_cpf;
    private EditText edt_telefone;
    private EditText edt_email;
    private Button btn;
    private Button ler;



    private String file = "arq";

    private User usuario = new User("","");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_nome = (EditText) findViewById(R.id.edt_nome);
        edt_cpf = (EditText) findViewById(R.id.edt_cpf);
        btn = (Button) findViewById(R.id.btn);
        ler = (Button) findViewById(R.id.ler);

        try{
            FileInputStream fin = openFileInput(file);
            int c;

            HashMap<Integer, String> atributos = new HashMap<Integer, String>();

            String nome="";
            String cpf="";
            int cont = 1;

            atributos.put(1,nome);
            atributos.put(2,cpf);

            while( (c = fin.read()) != -1){

                if ((Character.toString((char) c).equals("&"))){
                    cont++;
                }

                if (cont == 1) {
                    nome += Character.toString((char) c);
                }
                else if (cont == 2 && !((Character.toString((char) c).equals("&")))){
                    cpf += Character.toString((char) c);
                }
                else{
                }


            }
            edt_nome.setText(nome);
            edt_cpf.setText(cpf);
            Toast.makeText(getBaseContext(),"file read",
                    Toast.LENGTH_SHORT).show();

        }catch(Exception e){

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setNome(edt_nome.getText().toString());
                usuario.setCpf(edt_cpf.getText().toString());

                try {
                    FileOutputStream fOut = openFileOutput(file, MODE_PRIVATE);
                    fOut.write(usuario.getNome().getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(), "file saved",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        ler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fin = openFileInput(file);
                    int c;

                    String nome="";
                    String cpf="";
                    int cont = 1;

                    while( (c = fin.read()) != -1){

                        if ((Character.toString((char) c).equals("&"))){
                            cont++;
                        }

                        if (cont == 1) {
                            nome += Character.toString((char) c);
                        }
                        else if (cont == 2 && !((Character.toString((char) c).equals("&")))){
                            cpf += Character.toString((char) c);
                        }
                        else{
                        }


                    }
                    edt_nome.setText(nome);
                    edt_cpf.setText(cpf);
                    Toast.makeText(getBaseContext(),"file read",
                            Toast.LENGTH_SHORT).show();

                }catch(Exception e){

                }
            }
        });

    }



}
