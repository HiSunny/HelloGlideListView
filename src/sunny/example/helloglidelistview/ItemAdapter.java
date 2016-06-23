package sunny.example.helloglidelistview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import java.util.ArrayList;

import com.bumptech.glide.Glide;

import android.widget.ImageView;

public class ItemAdapter extends ArrayAdapter<Item>{

	private List<Item> list;
	private int resource;
	
	public ItemAdapter(Context context, int resource,List<Item> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		list = new ArrayList<Item>();
		this.list = objects;
		 this.resource = resource;
		
	}


	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		ViewHolder viewHolder;
		 View view;
	
		if(convertView == null){
			viewHolder = new ViewHolder();
			view = LayoutInflater.from(getContext()).inflate(resource, null);
			viewHolder.imageView = (ImageView)view.findViewById(R.id.image_item);			
			view.setTag(viewHolder);
		}else{
			view = convertView;
			viewHolder = (ViewHolder)view.getTag();
		}
		
		String imageUrl = Urls.imageUrls[position];
		
		Glide.with(getContext())
		.load(imageUrl)
		.centerCrop()
		.crossFade()
		.into(viewHolder.imageView);
		
		return view;
		
	}//.override(int width,int height).placeholder(R.drawable.ic_launcher).error(R.drawable.ic_launcher)

	class ViewHolder{
		ImageView imageView;
	}
}
