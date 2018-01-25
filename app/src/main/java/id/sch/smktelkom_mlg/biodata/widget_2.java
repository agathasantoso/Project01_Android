package id.sch.smktelkom_mlg.biodata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class widget_2 extends AppCompatActivity {
    EditText etNama;
    EditText etTahun;
    Button bOk;
    TextView tvhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_2);


        etNama = findViewById(R.id.editTextNama);
        etTahun = findViewById(R.id.editTextTahun);
        bOk = findViewById(R.id.buttonOK);
        tvhasil = findViewById(R.id.tvHasil);


        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProcess();
            }

        });
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etTahun.getText().toString());
            int usia = 2017 - tahun;
            tvhasil.setText(nama + " berusia " + usia + " tahun");
        }
    }


    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (tahun.isEmpty()) {
            etNama.setError("Tahun Kelahiran belum diisi");
            valid = false;
        } else if (tahun.length() != 4) {
            etNama.setError("Format Tahun Kelahiran bukan yyyy");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }

}

