package com.styledotme.kamlesh_task.util;

import android.content.Context;

import com.styledotme.kamlesh_task.data.EmployeeBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MakeDummyData {


    private String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("dummy.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public List<EmployeeBean> getDummyData(Context context) {

        List<EmployeeBean> employeeBeans = new ArrayList<>();

        String jsonString = loadJSONFromAsset(context);
        if(jsonString == null) {
            return employeeBeans;
        }
        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONArray m_jArry = obj.getJSONArray("employee");

            for (int i = 0; i < m_jArry.length(); i++) {
                EmployeeBean employee = new EmployeeBean();
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                if(jo_inside.has("band")) {
                    String band = jo_inside.getString("band");
                    employee.setBand(band);
                }
                if (jo_inside.has("name")){
                    String name = jo_inside.getString("name");
                    employee.setName(name);
                }
                if (jo_inside.has("userIconUrl")){
                    String userIconUrl = jo_inside.getString("userIconUrl");
                    employee.setUserIconUrl(userIconUrl);
                }
                if (jo_inside.has("profile")){
                    String profile = jo_inside.getString("profile");
                    employee.setProfile(profile);
                }
                if (jo_inside.has("taskCount")){
                    int taskCount = jo_inside.getInt("taskCount");
                    employee.setTaskCount(taskCount);
                }
                if (jo_inside.has("taskPercentage")){
                    String taskPercentage = jo_inside.getString("taskPercentage");
                    employee.setTaskPercentage(taskPercentage);
                }
                employeeBeans.add(employee);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return employeeBeans;
    }
}
