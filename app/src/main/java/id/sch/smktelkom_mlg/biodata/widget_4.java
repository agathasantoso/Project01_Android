package id.sch.smktelkom_mlg.biodata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class widget_4 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox cbBC, cbOR, cbGB, cbNL, cbNF;
    TextView tvHasil, tvHobi;
    int nHobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_4);

        cbBC = findViewById(R.id.checkBoxBC);
        cbOR = findViewById(R.id.checkBoxOR);
        cbNL = findViewById(R.id.checkBoxNL);
        cbNF = findViewById(R.id.checkBoxNF);
        cbGB = findViewById(R.id.checkBoxGB);

        cbBC.setOnCheckedChangeListener(this);
        cbOR.setOnCheckedChangeListener(this);
        cbNL.setOnCheckedChangeListener(this);
        cbNF.setOnCheckedChangeListener(this);
        cbGB.setOnCheckedChangeListener(this);

        tvHasil = findViewById(R.id.textViewHasil);
        tvHobi = findViewById(R.id.textViewHobi);
        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String hasil = "Hobi anda:\n";
        int startlen = hasil.length();
        if (cbBC.isChecked()) hasil += cbBC.getText() + "\n";
        if (cbOR.isChecked()) hasil += cbOR.getText() + "\n";
        if (cbNL.isChecked()) hasil += cbNL.getText() + "\n";
        if (cbNF.isChecked()) hasil += cbNF.getText() + "\n";
        if (cbGB.isChecked()) hasil += cbGB.getText() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak ada pada pilihan";

        tvHasil.setText(hasil);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) nHobi += 1;
        else nHobi -= 1;

        tvHobi.setText("Hobi (" + nHobi + " terpilih");
    }
}

