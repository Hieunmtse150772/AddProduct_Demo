package com.example.addproduct_demo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.addproduct_demo.Adapter.ProductListAdapter;
import com.example.addproduct_demo.Model.Product;
import com.example.addproduct_demo.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {
    private Button add;
    ArrayList<Product> listProduct; //Mảng dữ liệu sản phẩm
    ArrayAdapter<Product> arrayAdapter;
    ListView listView;
    ArrayList<Product> myExampleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_layout);
        ArrayList<Product> image_details = getListData();
        myExampleList = new ArrayList<Product>();
        final ListView listView = (ListView) findViewById(R.id.list_view_parent);
        listView.setAdapter(new ProductListAdapter(this, image_details));

        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddProduct();
            }
        });
    }

    private void openAddProduct() {
        Intent intent = new Intent(this, AddProductAcitvity.class);
        startActivity(intent);
    }

    private ArrayList<Product> getListData() {
        loadData();
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");
        if (product != null) {
            myExampleList.add(product);
            addListToJson();
            View viewProduct = null;
        }
        return myExampleList;
    }
    public void addListToJson(){
        SharedPreferences sharedPreferences = getSharedPreferences("PRODUCT_LIST", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(myExampleList);
        editor.putString("produt list", json);
        editor.apply();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("PRODUCT_LIST", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("produt list", null);
        Type type = new TypeToken<ArrayList<Product>>() {}.getType();
        myExampleList = gson.fromJson(json, type);
        if (myExampleList == null){
            myExampleList = new ArrayList<>();
        }
    }
}