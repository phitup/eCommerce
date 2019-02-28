package com.example.ecommerceapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerceapp.Adapters.CategoryAdapter;
import com.example.ecommerceapp.Adapters.ProductAdapter;
import com.example.ecommerceapp.ExpandableHeightGridView;
import com.example.ecommerceapp.Objects.Category;
import com.example.ecommerceapp.Objects.Products;
import com.example.ecommerceapp.Picasso.PicassoImageLoadingService;
import com.example.ecommerceapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;

import ss.com.bannerslider.Slider;

import static android.support.constraint.Constraints.TAG;

public class ShopFragment extends Fragment {
    Slider slider;
    ExpandableHeightGridView gridProducts;
    TwoWayView twoWayViewCategory;
    ProductAdapter gridProductAdapter;
    CategoryAdapter categoryAdapter;
    ArrayList<Products> arrayProduct;
    ArrayList<Category> arrayCategory;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop,container,false);

        //Tạo banner
        Slider.init(new PicassoImageLoadingService(getContext()));
        slider = view.findViewById(R.id.bannerSlider);
        slider.setAdapter(new com.example.ecommerceapp.Adapters.SliderAdapter());

        //Danh sách sản phẩm
        gridProducts = (ExpandableHeightGridView) view.findViewById(R.id.gridProducts);
        twoWayViewCategory = view.findViewById(R.id.twoWayViewCategory);

        db.collection("category").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    arrayCategory = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Category category = new Category(document.getString("Title"),
                                document.getString("Image"));
                                arrayCategory.add(category);
                    }
                    categoryAdapter = new CategoryAdapter(getContext(),R.layout.category_items,arrayCategory);
                    twoWayViewCategory.setAdapter(categoryAdapter);
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });

        db.collection("products").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    arrayProduct = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Products products = new Products(document.getString("Name"),
                                document.getString("Detail"),
                                document.getString("Price"),
                                document.getString("Image"),
                                document.getString("Category"));
                        arrayProduct.add(products);
                    }
                    gridProductAdapter = new ProductAdapter(getContext(),R.layout.list_products,arrayProduct);
                    gridProducts.setAdapter(gridProductAdapter);
                    gridProducts.setExpanded(true);
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });



        return view;
    }
}
