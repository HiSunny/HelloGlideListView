package sunny.example.helloglidelistview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

	private ListView listView;
	private ArrayList<Item> arrayList;
	private Item item;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ListView)findViewById(R.id.listView);
		arrayList = new ArrayList<Item>();
		
		for(int i = 0;i < Urls.imageUrls.length;i++){
			item = new Item(Urls.imageUrls[i]);
			arrayList.add(item);
		}
		ItemAdapter adapter = new ItemAdapter(this,R.layout.image_item,arrayList);
		listView.setAdapter(adapter);
	}

	
}
