package com.example.lt15304_nhidtyps12778_assignmet_gd2.TabFragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lt15304_nhidtyps12778_assignmet_gd2.Adapter.Khoanthu_Adapter;
import com.example.lt15304_nhidtyps12778_assignmet_gd2.DAO.Giaodich_DAO;
import com.example.lt15304_nhidtyps12778_assignmet_gd2.Dialog.Bottom_sheet_them_thu;
import com.example.lt15304_nhidtyps12778_assignmet_gd2.Modal.Giaodich;
import com.example.lt15304_nhidtyps12778_assignmet_gd2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Tab_Khoanthu extends Fragment {
    FloatingActionButton fl_khoanthu;
    public static RecyclerView rv_thu;
    public static Khoanthu_Adapter khoanthu_adapter;
    public static ArrayList<Giaodich> ds_khoanthu;
    Giaodich_DAO giaodich_dao;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_khoan_thu, container, false);
        fl_khoanthu = view.findViewById(R.id.fl_khoan_thu);
        rv_thu = view.findViewById(R.id.rv_khoan_thu);
        rv_thu.setLayoutManager(new LinearLayoutManager(getContext()));

        fl_khoanthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("trangthai", "Loai thu");

                Bottom_sheet_them_thu bottom_sheet = new Bottom_sheet_them_thu();
                //bottom_sheet.show(((AppCompatActivity)context).getSupportFragmentManager(),"TAG");
                 bottom_sheet.setArguments(args);
                bottom_sheet.show(getFragmentManager(),bottom_sheet.getTag());
            }
        });

        ds_khoanthu = new ArrayList<>();
        giaodich_dao = new Giaodich_DAO(getContext());

        ds_khoanthu = giaodich_dao.getKhoanThu_Chi("Thu");
        khoanthu_adapter = new Khoanthu_Adapter(ds_khoanthu, getContext());
        rv_thu.setAdapter(khoanthu_adapter);


        return view;
    }
}
