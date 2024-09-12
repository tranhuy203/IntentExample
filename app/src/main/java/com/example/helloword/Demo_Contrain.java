package com.example.helloword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Demo_Contrain extends AppCompatActivity {
    private Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo_contrain);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_back = findViewById(R.id.btn_back);
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        Toast.makeText(this, bundle.getString("data"), Toast.LENGTH_SHORT).show();
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Demo_Contrain.this,MainActivity.class);
                Bundle b = new Bundle();
                b.putString("data","Hello from child");
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}