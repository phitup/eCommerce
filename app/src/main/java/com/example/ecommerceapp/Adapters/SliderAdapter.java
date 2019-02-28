package com.example.ecommerceapp.Adapters;

import com.example.ecommerceapp.Objects.Products;

import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class SliderAdapter extends ss.com.bannerslider.adapters.SliderAdapter {
    @Override
    public int getItemCount() {
        return 3;
    }

    Products products = new Products();
    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        switch (position) {
            case 0:
                viewHolder.bindImageSlide("https://cf.shopee.vn/file/6974b8307da0f0fc85892cd10051ab8d");
                break;
            case 1:
                viewHolder.bindImageSlide("https://cf.shopee.vn/file/35a83ce216d62ad75a1e973df63ce816");
                break;
            case 2:
                viewHolder.bindImageSlide("https://cf.shopee.vn/file/bf813c632cf35919aa5e12d966ff5503");
                break;
        }
    }
}