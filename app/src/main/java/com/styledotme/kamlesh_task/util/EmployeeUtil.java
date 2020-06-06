package com.styledotme.kamlesh_task.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class EmployeeUtil {

    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";

    public static boolean isEmpty(CharSequence str) {
        return (str == null || str.length() == 0);
    }

    public static Drawable getBackgroundDrawable(Resources resources, int drawable) {
        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk <= android.os.Build.VERSION_CODES.LOLLIPOP) {
            return resources.getDrawable(drawable);
        } else {
            return resources.getDrawable(drawable, null);
        }
    }

    public static int getColor(Resources resources, int colorRes) {
        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk <= android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
            return resources.getColor(colorRes);
        } else {
            return resources.getColor(colorRes, null);
        }
    }

    public static final void doColorSpanForFirstString(Context context, String firstString,
                                                       String lastString, TextView txtSpan, int colorResId) {

        String changeString = (firstString != null ? firstString : "");

        String totalString = changeString + lastString;
        Spannable spanText = new SpannableString(totalString);
        spanText.setSpan(new ForegroundColorSpan(getColor(context.getResources(), colorResId)), 0, changeString.length(), 0);

        txtSpan.setText(spanText);
    }
    public static final void doColorSpanForSecondString(Context context, String firstString,
                                                        String lastString, TextView txtSpan, int colorResId) {
        String changeString = (lastString != null ? lastString : "");
        String totalString = firstString + changeString;
        Spannable spanText = new SpannableString(totalString);
        spanText.setSpan(new ForegroundColorSpan(getColor(context.getResources(), colorResId)), String.valueOf(firstString)
                .length(), totalString.length(), 0);
        spanText.setSpan(new StyleSpan(Typeface.BOLD), String.valueOf(firstString)
                        .length(), totalString.length(), 0);
        txtSpan.setText(spanText);
    }
}
