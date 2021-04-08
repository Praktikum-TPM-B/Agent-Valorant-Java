package com.maulanakurnia.agentvalorant.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.maulanakurnia.agentvalorant.R;
import com.maulanakurnia.agentvalorant.adapter.AgentAdapter;
import com.maulanakurnia.agentvalorant.data.AgentData;
import com.maulanakurnia.agentvalorant.model.AgentModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<AgentModel> listAgent = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Agent Valorant");

        rv = findViewById(R.id.rvAgent);
        rv.setHasFixedSize(true);
        listAgent.addAll(AgentData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        AgentAdapter agentAdapter = new AgentAdapter(listAgent,this);
        rv.setAdapter(agentAdapter);

    }
}