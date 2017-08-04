package chinasoft.com.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Ｓａｎｄｙ on 2017/8/4.
 */

public class MyListView extends ListView {
    public MyListView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int mExpandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, mExpandSpec);
    }
}
