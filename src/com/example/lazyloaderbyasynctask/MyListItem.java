package com.example.lazyloaderbyasynctask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class MyListItem {
	private String imageName;
	private String imageURL;
	private Bitmap bitmap;
	private MyAdapter adapter;
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public MyListItem(String _imageName, String _imageURL) {
		imageName = _imageName;
		imageURL = _imageURL;
		bitmap = null;
	}
	
	public void downLoadImage(MyAdapter _adapter) {
		adapter = _adapter;
		if(imageURL!=null&&!imageURL.equals("")){
			new loadImagefromURL().execute(imageURL);
		}
	}
	
	class loadImagefromURL extends AsyncTask<String, String, Bitmap> {

		@Override
		protected Bitmap doInBackground(String... params) {
			Bitmap bitmap = downloadImage(params[0]);
			return bitmap;
		}
		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			bitmap = result;
			if(adapter!=null){
				adapter.notifyDataSetChanged();
			}
		}
	}
	
	private Bitmap downloadImage(String url) {
		Bitmap bitmap = null;
		try {
			InputStream in = new java.net.URL(url).openStream();
			bitmap = BitmapFactory.decodeStream(in);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return bitmap;			
	}
}
