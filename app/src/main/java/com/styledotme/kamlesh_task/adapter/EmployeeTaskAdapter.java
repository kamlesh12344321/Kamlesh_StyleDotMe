package com.styledotme.kamlesh_task.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.styledotme.kamlesh_task.R;
import com.styledotme.kamlesh_task.data.EmployeeBean;
import com.styledotme.kamlesh_task.util.EmployeeUtil;
import com.styledotme.kamlesh_task.util.PicassoUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmployeeTaskAdapter extends RecyclerView.Adapter {

    private List<EmployeeBean> mEmployeeBeans;

    public EmployeeTaskAdapter(List<EmployeeBean> employeeBeans) {
        this.mEmployeeBeans = employeeBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_employee_task, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        TaskViewHolder taskViewHolder = (TaskViewHolder)holder;
        EmployeeBean bean = mEmployeeBeans.get(position);

        PicassoUtil.loadImage(taskViewHolder.member_imageView, bean.getUserIconUrl(), R.drawable.avatar);
        taskViewHolder.member_name.setText(bean.getName());

        // Band
        String band = bean.getBand();
        switch (band) {
            case EmployeeUtil.A:
                taskViewHolder.member_profile.setBackground(EmployeeUtil.getBackgroundDrawable(taskViewHolder.itemView.getResources(), R.drawable.band_a));
                break;
            case EmployeeUtil.B:
                taskViewHolder.member_profile.setBackground(EmployeeUtil.getBackgroundDrawable(taskViewHolder.itemView.getResources(), R.drawable.band_b));
                break;
            case EmployeeUtil.C:
                taskViewHolder.member_profile.setBackground(EmployeeUtil.getBackgroundDrawable(taskViewHolder.itemView.getResources(), R.drawable.band_c));
                break;
        }

        // Profile
        if(EmployeeUtil.isEmpty(bean.getProfile())) {
            taskViewHolder.member_profile.setVisibility(View.GONE);
        } else {
            taskViewHolder.member_profile.setVisibility(View.VISIBLE);
            taskViewHolder.member_profile.setText(bean.getProfile());
        }

        // Tasks
        if(bean.getTaskCount() == 0) {
            taskViewHolder.member_task.setVisibility(View.GONE);
        } else {
            taskViewHolder.member_task.setVisibility(View.VISIBLE);
            if(bean.getTaskCount() == 1) {
                taskViewHolder.member_task.setText(bean.getTaskCount()+" Task");
            } else {
                taskViewHolder.member_task.setText(bean.getTaskCount()+" Tasks");
            }
        }

        // Percentage
        if(EmployeeUtil.isEmpty(bean.getTaskPercentage()) || bean.getTaskPercentage().equals("0")) {
            taskViewHolder.task_percent.setVisibility(View.GONE);
        } else {
            taskViewHolder.task_percent.setVisibility(View.VISIBLE);
            taskViewHolder.task_percent.setText(bean.getTaskPercentage()+"%");
        }

    }

    @Override
    public int getItemCount() {
        return mEmployeeBeans.size();
    }

    private static class TaskViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView member_imageView;
        private TextView member_name;
        private TextView member_profile;
        private TextView member_task;
        private TextView task_percent;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            member_imageView = itemView.findViewById(R.id.member_imageView);
            member_name = itemView.findViewById(R.id.member_name);
            member_profile = itemView.findViewById(R.id.member_profile);
            member_task = itemView.findViewById(R.id.member_task);
            task_percent = itemView.findViewById(R.id.task_percent);
        }
    }
}
