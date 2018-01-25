package id.sch.smktelkom_mlg.biodata.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.biodata.R;

/**
 * Created by NAT on 25/01/2018.
 */

public class KotaAdapter extends ArrayAdapter<String> {
    String mProvinsi = "";

    public KotaAdapter(Context context, ArrayList<String> listKota) {
        super(context, R.layout.row_spinner_kota, listKota);
    }

    public void setmProvinsi(String mProvinsi) {
        this.mProvinsi = mProvinsi;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomVIew(position, view, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomVIew(position, view, parent);
    }

    private View getCustomVIew(int position, View view, ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.row_spinner_kota, parent, false);

        TextView tvTitle = view.findViewById(R.id.textViewTitle);
        tvTitle.setText(getItem(position).substring(0, 1));
        TextView tvKota = view.findViewById(R.id.textViewKota);
        tvKota.setText(getItem(position).substring(0, 1));
        TextView tvProvinsi = view.findViewById(R.id.textViewProvinsi);
        tvProvinsi.setText(mProvinsi);

        return view;
    }
}
