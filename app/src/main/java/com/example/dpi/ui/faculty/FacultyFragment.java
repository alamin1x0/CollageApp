package com.example.dpi.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dpi.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView headTeacher, csDepartment, mechanicalDepartment, physicsDepartment, chmesityDepartment, elDepartment, arDepartment, notechDepartment;
    private LinearLayout headNoData, csNoData, mecNoData, phyNoData, chNoData, elNoData, arNoData, notechNoData;
    private List<TeacherData> list, list1, list2, list3, list4, list5, list6, list7;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        headTeacher = view.findViewById(R.id.headTeacher);
        csDepartment = view.findViewById(R.id.csDepartment);
        mechanicalDepartment = view.findViewById(R.id.mechanicalDepartment);
        physicsDepartment = view.findViewById(R.id.physicsDepartment);
        chmesityDepartment = view.findViewById(R.id.chmesityDepartment);
        elDepartment = view.findViewById(R.id.elasticDep);
        arDepartment = view.findViewById(R.id.arDepartmen);
        notechDepartment = view.findViewById(R.id.notechDepartmen);

        headNoData = view.findViewById(R.id.headNoData);
        csNoData = view.findViewById(R.id.csNoData);
        mecNoData = view.findViewById(R.id.mecNoData);
        phyNoData = view.findViewById(R.id.phyNoData);
        chNoData = view.findViewById(R.id.chNoData);
        elNoData = view.findViewById(R.id.elasticNodata);
        arNoData = view.findViewById(R.id.arNoDat);
        notechNoData = view.findViewById(R.id.notechNoDat);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        reference.keepSynced(true);



        headTeacher();
        csDepartment();
        mechanicalDepartment();
        physicsDepartment();
        chmesityDepartment();
        elDepartment();
        arDepartment();
        notechDepartment();

        return view;

    }

        private void headTeacher() {
            dbRef = reference.child("Principal");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list = new ArrayList<>();
                    if (!dataSnapshot.exists()){
                        headNoData.setVisibility(View.VISIBLE);
                        headTeacher.setVisibility(View.GONE);
                    }else {


                        headNoData.setVisibility(View.GONE);
                        headTeacher.setVisibility(View.VISIBLE);
                        for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                            TeacherData data = snapshot.getValue(TeacherData.class);
                            list.add(data);
                        }
                        headTeacher.setHasFixedSize(true);
                        headTeacher.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter = new TeacherAdapter(list, getContext());
                        headTeacher.setAdapter(adapter);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }


        private void csDepartment() {

            dbRef = reference.child("Computer Department");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list1 = new ArrayList<>();
                    if (!dataSnapshot.exists()){
                        csNoData.setVisibility(View.VISIBLE);
                        csDepartment.setVisibility(View.GONE);
                    }else {

                        csNoData.setVisibility(View.GONE);
                        csDepartment.setVisibility(View.VISIBLE);
                        for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                            TeacherData data = snapshot.getValue(TeacherData.class);
                            list1.add(data);
                        }
                        csDepartment.setHasFixedSize(true);
                        csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter = new TeacherAdapter(list1, getContext());
                        csDepartment.setAdapter(adapter);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }


        private void mechanicalDepartment() {

            dbRef = reference.child("Power Department");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list2 = new ArrayList<>();
                    if (!dataSnapshot.exists()){
                        mecNoData.setVisibility(View.VISIBLE);
                        mechanicalDepartment.setVisibility(View.GONE);
                    }else {


                        mecNoData.setVisibility(View.GONE);
                        mechanicalDepartment.setVisibility(View.VISIBLE);
                        for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                            TeacherData data = snapshot.getValue(TeacherData.class);
                            list2.add(data);
                        }
                        mechanicalDepartment.setHasFixedSize(true);
                        mechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter = new TeacherAdapter(list2, getContext());
                        mechanicalDepartment.setAdapter(adapter);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }


        private void physicsDepartment() {

            dbRef = reference.child("Mechanical Department");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list3 = new ArrayList<>();
                    if (!dataSnapshot.exists()){
                        phyNoData.setVisibility(View.VISIBLE);
                        physicsDepartment.setVisibility(View.GONE);
                    }else {


                        phyNoData.setVisibility(View.GONE);
                        physicsDepartment.setVisibility(View.VISIBLE);
                        for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                            TeacherData data = snapshot.getValue(TeacherData.class);
                            list3.add(data);
                        }
                        physicsDepartment.setHasFixedSize(true);
                        physicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter = new TeacherAdapter(list3, getContext());
                        physicsDepartment.setAdapter(adapter);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }



        private void chmesityDepartment() {

            dbRef = reference.child("Civil Department");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list4 = new ArrayList<>();
                    if (!dataSnapshot.exists()){
                        chNoData.setVisibility(View.VISIBLE);
                        chmesityDepartment.setVisibility(View.GONE);
                    }else {
                        chNoData.setVisibility(View.GONE);
                        chmesityDepartment.setVisibility(View.VISIBLE);
                        for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                            TeacherData data = snapshot.getValue(TeacherData.class);
                            list4.add(data);
                        }
                        chmesityDepartment.setHasFixedSize(true);
                        chmesityDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter = new TeacherAdapter(list4, getContext());
                        chmesityDepartment.setAdapter(adapter);
                    }

                }




                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }


        private void elDepartment() {

            dbRef = reference.child("Electrical Department");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list5 = new ArrayList<>();
                    if (!dataSnapshot.exists()){
                        elNoData.setVisibility(View.VISIBLE);
                        elDepartment.setVisibility(View.GONE);
                    }else {
                        elNoData.setVisibility(View.GONE);
                        elDepartment.setVisibility(View.VISIBLE);
                        for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                            TeacherData data = snapshot.getValue(TeacherData.class);
                            list5.add(data);
                        }
                        elDepartment.setHasFixedSize(true);
                        elDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter = new TeacherAdapter(list5, getContext());
                        elDepartment.setAdapter(adapter);
                    }

                }




                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }


        private void arDepartment() {

            dbRef = reference.child("Architecture Department");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list6 = new ArrayList<>();
                    if (!dataSnapshot.exists()){
                        arNoData.setVisibility(View.VISIBLE);
                        arDepartment.setVisibility(View.GONE);
                    }else {
                        arNoData.setVisibility(View.GONE);
                        arDepartment.setVisibility(View.VISIBLE);
                        for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                            TeacherData data = snapshot.getValue(TeacherData.class);
                            list6.add(data);
                        }
                        arDepartment.setHasFixedSize(true);
                        arDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter = new TeacherAdapter(list6, getContext());
                        arDepartment.setAdapter(adapter);
                    }

                }




                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }


        private void notechDepartment() {

            dbRef = reference.child("Non-Tech Department");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list7 = new ArrayList<>();
                    if (!dataSnapshot.exists()){
                        notechNoData.setVisibility(View.VISIBLE);
                        notechDepartment.setVisibility(View.GONE);
                    }else {
                        notechNoData.setVisibility(View.GONE);
                        notechDepartment.setVisibility(View.VISIBLE);
                        for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                            TeacherData data = snapshot.getValue(TeacherData.class);
                            list7.add(data);
                        }
                        notechDepartment.setHasFixedSize(true);
                        notechDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter = new TeacherAdapter(list7, getContext());
                        notechDepartment.setAdapter(adapter);
                    }

                }




                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }