package com.styledotme.kamlesh_task.util;

import android.content.Context;
import android.os.AsyncTask;

import com.styledotme.kamlesh_task.callback.EmployeeDataCallback;
import com.styledotme.kamlesh_task.data.EmployeeBean;

import java.util.List;

public class LoadEmployeeTask  extends AsyncTask<Void,Void, List<EmployeeBean>> {

    private EmployeeDataCallback mEmployeeDataCallback;
    private Context mContext;

    public LoadEmployeeTask(EmployeeDataCallback employeeDataCallback, Context context) {
        this.mEmployeeDataCallback = employeeDataCallback;
        this.mContext = context;
    }

    @Override
    protected List<EmployeeBean> doInBackground(Void... voids) {
        return new MakeDummyData().getDummyData(mContext);
    }

    @Override
    protected void onPostExecute(List<EmployeeBean> employeeBeans) {
        super.onPostExecute(employeeBeans);
        if(mEmployeeDataCallback != null) {
            if(employeeBeans.size() == 0 ) {
                mEmployeeDataCallback.onFailed();
            }
            else if(employeeBeans.size() > 0 ) {
                mEmployeeDataCallback.onSuccess(employeeBeans);
            }
        }
    }
}
