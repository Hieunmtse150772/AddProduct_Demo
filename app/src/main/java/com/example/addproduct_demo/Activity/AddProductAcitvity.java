package com.example.addproduct_demo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.addproduct_demo.Model.Product;
import com.example.addproduct_demo.R;

public class AddProductAcitvity extends AppCompatActivity {
    private EditText productID;
    private EditText productName;
    private EditText quantity;
    private EditText price;
    private EditText maker;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_layout);
        productID = findViewById(R.id.productID);
        productName = findViewById(R.id.productName);
        quantity = findViewById(R.id.quantity);
        price = findViewById(R.id.price);
        maker = findViewById(R.id.maker);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProductList(productID, productName, quantity, price, maker);
            }
        });
    }
    private void openProductList(EditText productID, EditText productName, EditText quantity, EditText price, EditText maker){
        Intent intent = new Intent(this, ProductListActivity.class);
        Product product = new Product(productID.getText().toString(), productName.getText().toString(),
                Integer.parseInt(quantity.getText().toString()), Integer.parseInt(price.getText().toString()), maker.getText().toString());
        intent.putExtra("product", product);
        startActivity(intent);
    }
}