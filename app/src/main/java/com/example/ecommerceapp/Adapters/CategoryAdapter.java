package com.example.ecommerceapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecommerceapp.Objects.Category;
import com.example.ecommerceapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, int layout, List<Category> categoryList) {
        this.context = context;
        this.layout = layout;
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        ImageView imgCategoryImage;
        TextView txtCategoryTitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryAdapter.ViewHolder holder;
        if (convertView == null) {
            holder = new CategoryAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.imgCategoryImage = convertView.findViewById(R.id.imgCategoryImage);
            holder.imgCategoryImage.setScaleType(ImageView.ScaleType.FIT_XY);
            holder.txtCategoryTitle = convertView.findViewById(R.id.txtCategoryTitle);
            convertView.setTag(holder);
        } else {
            holder = (CategoryAdapter.ViewHolder) convertView.getTag();
        }


        Category category = categoryList.get(position);

        Picasso.get().load(category.getImage()).into(holder.imgCategoryImage);
        holder.txtCategoryTitle.setText(category.getTitle());
        return convertView;
    }
}
