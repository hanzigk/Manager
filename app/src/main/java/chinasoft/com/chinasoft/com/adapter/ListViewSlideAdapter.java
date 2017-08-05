package chinasoft.com.chinasoft.com.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chinasoft.com.logindemo.R;
import chinasoft.com.util.MyCheckBox;

/**
 * Created by Ｓａｎｄｙ on 2017/8/5.
 * 侧滑Item的Adapter
 */

public class ListViewSlideAdapter extends BaseAdapter {
    private List<String> bulbList;
    private Context context;
    private OnClickListenerEditOrDelete onClickListenerEditOrDelete;
    private MyCheckBox checkBox;
    public ListViewSlideAdapter(Context context, List<String> bulbList){
        this.bulbList=bulbList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return bulbList.size();
    }

    @Override
    public Object getItem(int position) {
        return bulbList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final String bulb=bulbList.get(position);
        View view;
        final ViewHolder viewHolder;
        if(null == convertView) {
            view = View.inflate(context, R.layout.slidelist_item, null);
            viewHolder=new ViewHolder();
            viewHolder.tvName=(TextView)view.findViewById(R.id.tvName);
            viewHolder.img=(ImageView)view.findViewById(R.id.imgLamp);
            viewHolder.tvDelete=(TextView)view.findViewById(R.id.delete);
            viewHolder.tvEdit=(TextView)view.findViewById(R.id.tvEdit);
            viewHolder.checkBox=(MyCheckBox)view.findViewById(R.id.check2);
            view.setTag(viewHolder);//store up viewHolder
        }else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }

        viewHolder.img.setImageResource(R.mipmap.ic_launcher);
        viewHolder.tvName.setText(bulb);
        viewHolder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListenerEditOrDelete!=null){
                    onClickListenerEditOrDelete.OnClickListenerDelete(position);
                }
            }
        });
        viewHolder.tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListenerEditOrDelete!=null){
                    onClickListenerEditOrDelete.OnClickListenerEdit(position);
                }
            }
        });

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.checkBox.toggle();
            }
        });

        return view;
    }

    private class ViewHolder{
        TextView tvName,tvEdit,tvDelete;
        ImageView img;
        MyCheckBox checkBox;
    }

    public interface OnClickListenerEditOrDelete{
        void OnClickListenerEdit(int position);
        void OnClickListenerDelete(int position);
    }

    public void setOnClickListenerEditOrDelete(OnClickListenerEditOrDelete onClickListenerEditOrDelete1){
        this.onClickListenerEditOrDelete=onClickListenerEditOrDelete1;
    }

}