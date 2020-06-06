package com.styledotme.kamlesh_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.styledotme.kamlesh_task.fragment.EmployeeTaskFragment;
import com.styledotme.kamlesh_task.util.EmployeeUtil;

public class MainActivity extends AppCompatActivity {

    private TextView title_txt;
    private TextView subtitle_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title_txt = findViewById(R.id.title_txt);
        subtitle_txt = findViewById(R.id.subtitle_txt);

        // Adding EmployeeTaskFragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.employeeFragmentContainer, EmployeeTaskFragment.getInstance());
        ft.commit();

        //EmployeeUtil.doColorSpanForSecondString(this, "Task ", "Members", title_txt, R.color.title_color);
        EmployeeUtil.doColorSpanForFirstString(this, "Science Fair 2020 / ", "Team Alpha", subtitle_txt, R.color.subtitle_color);



    }




}
