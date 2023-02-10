package com.example.addproduct_demo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.addproduct_demo.Model.Product;
import com.example.addproduct_demo.R;

import java.util.ArrayList;

public class ProductListAdapter extends BaseAdapter {
    private ArrayList<Product> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ProductListAdapter(Context aContext,  ArrayList<Product> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.product_view_layout, null);
            holder = new ViewHolder();
            holder.productIDView = (TextView) convertView.findViewById(R.id.productID);
            holder.productNameView = (TextView) convertView.findViewById(R.id.productName);
            holder.quantityView = (TextView) convertView.findViewById(R.id.quantity);
            holder.priceView = (TextView) convertView.findViewById(R.id.price);
            holder.makerView = (TextView) convertView.findViewById(R.id.maker);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = this.listData.get(position);
        holder.productIDView.setText("Product ID: " + product.getProductID());
        holder.productNameView.setText("ProductName: " + product.getName());
        holder.quantityView.setText("Quantity: " + product.getQuantity());
        holder.priceView.setText("Price: " + product.getPrice());
        holder.makerView.setText("Maker: " + product.getMaker());
        return convertView;
    }


    static class ViewHolder {
        TextView productIDView;
        TextView productNameView;
        TextView quantityView;
        TextView priceView;
        TextView makerView;

    }

}
