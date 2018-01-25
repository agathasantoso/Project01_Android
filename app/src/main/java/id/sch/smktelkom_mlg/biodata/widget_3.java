package id.sch.smktelkom_mlg.biodata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class widget_3 extends AppCompatActivity {
    RadioButton rbBM, rbM, rbD, rbJ;
    TextView tvHasil;
    RadioGroup rgStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_3);
        rbBM = findViewById(R.id.radioButtonBM);
        rbM = findViewById(R.id.radioButtonM);
        rbD = findViewById(R.id.radioButtonD);
        rbJ = findViewById(R.id.radioButtonJ);
        rgStatus = findViewById(R.id.radioGroupStatus);
        tvHasil = findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String hasil = null;

        if (rgStatus.getCheckedRadioButtonId() != -1) {
            RadioButton rb = findViewById(rgStatus.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
            if (rgStatus.getCheckedRadioButtonId() != R.id.radioButtonBM) {
                EditText etJA = findViewById(R.id.editTextJA);
                hasil += "\n Jumlah Anak : " + etJA.getText();
            }
        }
                /*if(rbBM.isChecked())
                {
                    hasil = rbBM.getText().toString();
                }
                else if(rbM.isChecked())
                {
                    hasil = rbM.getText().toString();
                }
                else if(rbD.isChecked())
                {
                    hasil = rbD.getText().toString();
                }
                if(rbJ.isChecked())
                {
                    hasil = rbJ.getText().toString();
                }*/
        if (hasil == null) {
            tvHasil.setText("Belum memilih status");
        } else {
            tvHasil.setText("Status anda : " + hasil);
        }
    }
}

