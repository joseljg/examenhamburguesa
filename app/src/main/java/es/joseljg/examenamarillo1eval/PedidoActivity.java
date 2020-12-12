package es.joseljg.examenamarillo1eval;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class PedidoActivity extends AppCompatActivity {

    private static final String EXTRA_IVA = "es.joseljg.PedidoActivity.iva";
    private static final String EXTRA_TOTAL = "es.joseljg.PedidoActivity.total";
    private static final String EXTRA_CUPON = "es.joseljg.PedidoActivity.cupon";;
    TextView txt_resultado_hamburguesa;
    TextView txt_resultado_complemento;
    TextView txt_cupon;
    TextView txt_iva;
    TextView txt_total;
    EditText edt_codigo;

    double precioh = 0.0;
    double precioc = 0.0;
    double descuentocupon = 0.0;
    double precioiva = 0.0;
    double preciototal = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DecimalFormat df = new DecimalFormat("#.00");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        txt_resultado_hamburguesa = findViewById(R.id.txt_hamburguesa);
        txt_resultado_complemento = findViewById(R.id.txt_complemento);
        txt_cupon = findViewById(R.id.txt_cupon);
        txt_iva = findViewById(R.id.txt_iva);
        txt_total = findViewById(R.id.txt_total);
        edt_codigo = findViewById(R.id.edt_codigo);

        Intent intent = getIntent();
        String h = intent.getStringExtra(MainActivity.EXTRA_HAMBURGUESA);
        String c = intent.getStringExtra(MainActivity.EXTRA_COMPLEMENTO);
//-------------------------------------------------------------------------------------------
        if(h.equalsIgnoreCase("mac pollo"))
        {
            precioh=3.0;
        }
        if(h.equalsIgnoreCase("xxl"))
        {
            precioh=5.0;
        }
        String txt_hamburguesa =  h + "->" + precioh + "€" ;
        txt_resultado_hamburguesa.setText(txt_hamburguesa);
//-------------------------------------------------------------------------------------------
        if(c.equalsIgnoreCase("patatas"))
        {
            precioc=2.0;
        }
        if(c.equalsIgnoreCase("coca cola"))
        {
            precioc=2.5;
        }
        String txt_complemento =  c + "->" + precioc + "€" ;
        txt_resultado_complemento.setText(txt_complemento);
//-------------------------------------------------------------------------------------------
        String txt_descuento_cupon = "cupon: ->" + descuentocupon + "€" ;
        txt_cupon.setText(txt_descuento_cupon);
//-------------------------------------------------------------------------------------------
        precioiva = (precioh + precioc - descuentocupon) * 0.21;
        String iva = "iva: ->" + df.format( precioiva) + "€" ;
        txt_iva.setText(iva);
//-------------------------------------------------------------------------------------------
        preciototal = (precioh + precioc - descuentocupon) * 1.21;
        String total = "total: ->" + df.format(preciototal) + "€" ;
        txt_total.setText(total);
//-------------------------------------------------------------------------------------------
    }

    public void aplicar(View view) {
        DecimalFormat df = new DecimalFormat("#.00");
        String codigo = String.valueOf(edt_codigo.getText());
        if(codigo.equals("mac123")) {
            descuentocupon = 1.0;
            Toast.makeText(this,"ha obtenido un descuento de " + descuentocupon + "€", Toast.LENGTH_SHORT).show();
            //-------------------------------------------------------------------------------------------
            String descuento_cupon = "cupon: ->" + descuentocupon + "€";
            txt_cupon.setText(descuento_cupon);
//-------------------------------------------------------------------------------------------
            String iva = "iva: ->" + df.format((precioh + precioc - descuentocupon) * 0.21) + "€";
            txt_iva.setText(iva);
//-------------------------------------------------------------------------------------------
            String total = "total: ->" + df.format((precioh + precioc - descuentocupon) * 1.21) + "€";
            txt_total.setText(total);
//-------------------------------------------------------------------------------------------
        }
    }

}