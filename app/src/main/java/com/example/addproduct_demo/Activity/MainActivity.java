package com.example.addproduct_demo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.addproduct_demo.Model.Product;
import com.example.addproduct_demo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button add;
    ArrayList<Product> listProduct; //Mảng dữ liệu sản phẩm

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        add = findViewById(R.id.add);
        Product product = (Product) intent.getSerializableExtra("product");
        listProduct = new ArrayList<>();
        if(product != null){
            System.out.println("productID:" + product.productID + "productName: " + product.name + "quantity: " + product.quantity + "price: " + product.price + "maker: " + product.maker);
            listProduct.add(product);
            View viewProduct = null;
//            ((TextView) viewProduct.findViewById(R.id.productID)).setText(String.format("ID = %d", product.productID));
//            ((TextView) viewProduct.findViewById(R.id.productName)).setText(String.format("Tên SP : %s", product.name));
//            ((TextView) viewProduct.findViewById(R.id.price)).setText(String.format("Giá %d", product.price));
//            ((TextView) viewProduct.findViewById(R.id.quantity)).setText(String.format("Số lượng %d", product.quantity));
//            ((TextView) viewProduct.findViewById(R.id.maker)).setText(String.format("Nhà sản xuất %d", product.maker));
        }

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openAddProduct();
            }
        });
    }
    private void openAddProduct(){
        Intent intent = new Intent(this, AddProductAcitvity2.class);
        startActivity(intent);
    }
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        //có chỉ số position trong listProduct
        return listProduct.get(position);
    }
//    public View getView(int position, View convertView, ViewGroup parent) {
//        //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
//        //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
//        //Nếu null cần tạo mới
//
//        View viewProduct;
//        if (convertView == null) {
//            viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
//        } else viewProduct = convertView;
//
//        //Bind sữ liệu phần tử vào View
//        Product product = (Product) getItem(position);
//        ((TextView) viewProduct.findViewById(R.id.productID)).setText(String.format("ID = %d", product.productID));
//        ((TextView) viewProduct.findViewById(R.id.productName)).setText(String.format("Tên SP : %s", product.name));
//        ((TextView) viewProduct.findViewById(R.id.price)).setText(String.format("Giá %d", product.price));
//        ((TextView) viewProduct.findViewById(R.id.quantity)).setText(String.format("Số lượng %d", product.quantity));
//        ((TextView) viewProduct.findViewById(R.id.maker)).setText(String.format("Nhà sản xuất %d", product.maker));
//        return viewProduct;
//    }
}