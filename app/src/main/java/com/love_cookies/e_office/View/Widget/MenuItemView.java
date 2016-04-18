package com.love_cookies.e_office.View.Widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.e_office.R;

/**
 * Created by xiekun on 2016/04/18 0018.
 *
 * 主页的按钮
 */
public class MenuItemView extends FrameLayout {

    ImageView itemIcon;
    TextView itemTitle;

    public MenuItemView(Context context) {
        super(context);
    }

    public MenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context, attrs);
    }

    public MenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context, attrs);
    }

    public MenuItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initLayout(context, attrs);
    }

    private void initLayout(Context context, AttributeSet attrs) {
        LayoutInflater factory = LayoutInflater.from(context);
        factory.inflate(R.layout.view_home_item, this);

        itemIcon = (ImageView)findViewById(R.id.item_icon);
        itemTitle = (TextView)findViewById(R.id.item_title);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.MenuItem);

        Drawable icon = typedArray.getDrawable(R.styleable.MenuItem_Icon);
        itemIcon.setImageDrawable(icon);

        CharSequence title = typedArray.getText(R.styleable.MenuItem_Title);
        itemTitle.setText(title);
    }

}
