package id.sch.smktelkom_mlg.biodata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import id.sch.smktelkom_mlg.biodata.adapter.KotaAdapter;

public class widget_5 extends AppCompatActivity {
    Spinner spProvinsi, spKota;
    TextView tvHasil;
    String[][] arKota = {{"Jakarta Pusat", "Jakarta Barat", "Jakarta Selatan",
            "Jakarta Timur", "Jakarta Utara"},
            {"Bandung", "Cirebon", "Bekasi"}, {"Semarang", "Magelang", "Surakarta"},
            {"Surabaya", "Malang", "Blitar"}, {"Denpasar"}};

    ArrayList<String> listKota = new ArrayList<>();
    KotaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_5);

        spProvinsi = findViewById(R.id.spinnerProvinsi);
        spKota = findViewById(R.id.spinnerKota);
        tvHasil = findViewById(R.id.textViewHasil);
        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
        spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listKota.clear();
                listKota.addAll(Arrays.asList(arKota[pos]));
                adapter.notifyDataSetChanged();
                adapter.setmProvinsi((String) spProvinsi.getItemAtPosition(pos));
                spKota.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adapter = new KotaAdapter(this, listKota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKota.setAdapter(adapter);
    }

    private void doClick() {
        StringBuilder builder = new StringBuilder();
        builder.append("Wilayah Provinsi ");
        builder.append(spProvinsi.getSelectedItem().toString());
        builder.append(" Kota ");
        builder.append(spKota.getSelectedItem().toString());
        builder.append("\n\n\n");

        builder.append("Kota yang tidak dipilih adalah :\n\n");

        String[] arProvinsi = getResources().getStringArray(R.array.provinsi);
        int posProv = spProvinsi.getSelectedItemPosition();
        int posKota = spKota.getSelectedItemPosition();

        for (int i = 0; i < arProvinsi.length; i++) {
            builder.append(arProvinsi[i]).append(":\n");
            for (int j = 0; j < arKota[i].length; j++) {
                if (!(i == posProv && j == posKota)) {
                    builder.append("\t").append(arKota[i][j]).append("\n");
                }
            }
            builder.append("\n");
        }
        tvHasil.setText(builder);
    }
}

