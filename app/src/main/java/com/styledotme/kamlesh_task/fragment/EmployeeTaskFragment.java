package com.styledotme.kamlesh_task.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.styledotme.kamlesh_task.R;
import com.styledotme.kamlesh_task.adapter.EmployeeTaskAdapter;
import com.styledotme.kamlesh_task.callback.EmployeeDataCallback;
import com.styledotme.kamlesh_task.data.EmployeeBean;
import com.styledotme.kamlesh_task.util.LoadEmployeeTask;

import java.util.List;

public class EmployeeTaskFragment extends Fragment implements EmployeeDataCallback {

    private RecyclerView mRecyclerView;
    private EmployeeTaskAdapter mEmployeeTaskAdapter;
    private LoadEmployeeTask mLoadEmployeeTask;

    public static EmployeeTaskFragment getInstance() {
        EmployeeTaskFragment fragment = new EmployeeTaskFragment();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_task, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.recyclerView);

        if(mLoadEmployeeTask == null || mLoadEmployeeTask.getStatus() == AsyncTask.Status.FINISHED) {
            mLoadEmployeeTask = new LoadEmployeeTask(this, getActivity());
            mLoadEmployeeTask.execute();
        }

    }

    @Override
    public void onFailed() {
        Log.i("", "");
    }

    @Override
    public void onSuccess(List<EmployeeBean> employeeBeans) {
        mEmployeeTaskAdapter = new EmployeeTaskAdapter(employeeBeans);
        mRecyclerView.setAdapter(mEmployeeTaskAdapter);
    }


}
