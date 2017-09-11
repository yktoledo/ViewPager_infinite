package com.example.viewpager6.banner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.viewpager6.R;
import com.example.viewpager6.entity.BannerItem;
import com.example.viewpager6.utils.ViewFindUtils;
import com.flyco.banner.widget.Banner.BaseIndicatorBanner;

public class SimpleImageBannerString extends BaseIndicatorBanner<String, SimpleImageBannerString> {
    private ColorDrawable colorDrawable;

    public SimpleImageBannerString(Context context) {
        this(context, null, 0);
    }

    public SimpleImageBannerString(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleImageBannerString(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        colorDrawable = new ColorDrawable(Color.parseColor("#555555"));
    }

    @Override
    public void onTitleSlect(TextView tv, int position) {
        final String item = mDatas.get(position);
    }

    @Override
    public View onCreateItemView(int position) {
        View inflate = View.inflate(mContext, R.layout.adapter_simple_image, null);
        ImageView iv = ViewFindUtils.find(inflate, R.id.iv);

        final String imgUrl = mDatas.get(position);
        int itemWidth = mDisplayMetrics.widthPixels;
        int itemHeight = (int) (itemWidth * 360 * 1.0f / 640);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setLayoutParams(new LinearLayout.LayoutParams(itemWidth, itemHeight));


        if (!TextUtils.isEmpty(imgUrl)) {
            Glide.with(mContext)
                    .load(imgUrl)
                    .override(itemWidth, itemHeight)
                    .centerCrop()
                    .placeholder(colorDrawable)
                    .into(iv);
        } else {
            iv.setImageDrawable(colorDrawable);
        }

        return inflate;
    }
}
