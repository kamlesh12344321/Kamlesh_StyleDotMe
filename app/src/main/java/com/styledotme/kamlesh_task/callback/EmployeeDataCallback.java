package com.styledotme.kamlesh_task.callback;

import com.styledotme.kamlesh_task.data.EmployeeBean;

import java.util.List;

public interface EmployeeDataCallback {
    void onFailed();
    void onSuccess(List<EmployeeBean> employeeBeans);
}
