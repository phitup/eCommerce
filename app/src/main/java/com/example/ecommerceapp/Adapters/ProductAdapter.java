package com.example.ecommerceapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecommerceapp.Objects.Products;
import com.example.ecommerceapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Products> productsList;

    public ProductAdapter(Context context, int layout, List<Products> productsList) {
        this.context = context;
        this.layout = layout;
        this.productsList = productsList;
    }


    @Override
    public int getCount() {
        return productsList.size();
    }

    @Override
    public Object getItem(int position) {
        return productsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        ImageView imgProductImage;
        TextView txtProductName;
        TextView txtProductPrice;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.imgProductImage = convertView.findViewById(R.id.imgProductImage);
            holder.imgProductImage.setScaleType(ImageView.ScaleType.FIT_XY);
            holder.txtProductName = convertView.findViewById(R.id.txtProductName);
            holder.txtProductPrice = convertView.findViewById(R.id.txtProductPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        Products products = productsList.get(position);

        Picasso.get().load(products.getProductImage()).into(holder.imgProductImage);
        holder.txtProductName.setText(products.getProductName());
        holder.txtProductPrice.setText(products.getProductPrice());

        return convertView;
    }

}

