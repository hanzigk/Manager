package chinasoft.com.fragmentitem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import chinasoft.com.logindemo.R;
/**
 * Created by lenovo on 2017/8/6.
 */

public class FragmentItem2 extends Fragment {
    private ListView list;
    private View rootView;
    private int[] images;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(rootView ==null){
            rootView = inflater.inflate(R.layout.item_list,container,false);
            list = (ListView) rootView.findViewById(R.id.list);
            list.setAdapter(new BaseAdapter() {
                @Override
                public int getCount() {
                    return 2;//设置默认商品详情三张图片
                   //return list.getCount();
                }

                @Override
                public Object getItem(int i) {

                    return null;
                }

                @Override
                public long getItemId(int i) {
                    return i;
                }

                @Override
                public View getView(int i, View view, ViewGroup viewGroup) {
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setImageResource(images[i]);
                    return imageView;
                }
            });
        }else {
            ViewGroup v=((ViewGroup)(rootView.getParent()));
            if(v!=null){
                v.removeView(rootView);
            }
        }
        return rootView ;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setImage(int image[]) {
        images = image;
    }

}
