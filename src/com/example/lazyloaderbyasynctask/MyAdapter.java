package com.example.lazyloaderbyasynctask;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	
	 private LayoutInflater mInflater;
	 
	 private List<MyListItem> items = new ArrayList<MyListItem>();
	
	 public MyAdapter(Context context, List<MyListItem> _items) {
		 mInflater = LayoutInflater.from(context);
		 items = _items;
		 
	}
	 
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	class ViewHolder{
		TextView textView;
		ImageView imageView;
		
		public ViewHolder(View view) {
			textView = (TextView) view.findViewById(R.id.textView);
			imageView = (ImageView) view.findViewById(R.id.imageView);
		}
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = convertView;
		ViewHolder holder;
		if(view==null){
			view = mInflater.inflate(R.layout.adpter_item, parent, false);
			holder = new ViewHolder(view);
			view.setTag(holder);
		}else{
			holder = (ViewHolder) view.getTag();
		}
		
		holder.textView.setText(items.get(position).getImageName());
		holder.imageView.setImageBitmap(items.get(position).getBitmap());
		
		return view;
	}

}
