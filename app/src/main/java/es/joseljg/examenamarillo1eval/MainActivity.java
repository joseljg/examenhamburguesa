package es.joseljg.examenamarillo1eval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_HAMBURGUESA = "es.joseljg.mainActivity.hamburguesa" ;
    public static final String EXTRA_COMPLEMENTO = "es.joseljg.mainActivity.complemento" ;
    EditText edt_h;
    EditText edt_c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_h = (EditText) findViewById(R.id.edt_nombre_h);
        edt_c = (EditText) findViewById(R.id.edt_nombre_c);
    }

    public void siguiente(View view) {
        String h = String.valueOf(edt_h.getText());
        if(! h.equalsIgnoreCase("mac pollo") && ! h.equalsIgnoreCase("xxl"))
        {
            edt_h.setError("hamburguesa no disponible");
            return;
        }
        String c = String.valueOf(edt_c.getText());
        if(! c.equalsIgnoreCase("patatas") && ! c.equalsIgnoreCase("coca cola"))
        {
            edt_c.setError("complemento no disponible");
            return;
        }
        Intent intent = new Intent(this, PedidoActivity.class);
        intent.putExtra(EXTRA_HAMBURGUESA, h);
        intent.putExtra(EXTRA_COMPLEMENTO, c);
        startActivity(intent);
    }
}