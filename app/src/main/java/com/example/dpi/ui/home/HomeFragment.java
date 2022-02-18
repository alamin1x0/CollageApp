package com.example.dpi.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dpi.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);

        setSliderViews();

        map = view.findViewById(R.id.mapp);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=Dinajpur Polytechnic Institute"));
                Intent chooser = Intent.createChooser(intent,"Lauch Maps");
                startActivity(chooser);
            }
        });

        return view;
    }

    private void setSliderViews() {

        for (int i = 0; i< 5; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/dinajpur-polytechnicinstitute.appspot.com/o/Home%2F95c9b974ea0ca665ff1feb2ee7953d50.jpg?alt=media&token=e5c15305-a184-422b-8ccf-e61302f18674");
                    break;

                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/dinajpur-polytechnicinstitute.appspot.com/o/Home%2F994b39558b52637d475aeb1517495c3b.jpg?alt=media&token=d83254cd-4176-40d3-b352-f6851c1858c6");
                    break;

                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/dinajpur-polytechnicinstitute.appspot.com/o/Home%2F0e5b1ab6cd72b30e4124a491c332e21a.jpg?alt=media&token=46500c6f-c0cc-40cd-9590-fe3a2514f6c4");
                    break;

                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/dinajpur-polytechnicinstitute.appspot.com/o/Home%2Fe819240bc87d251582d9bba1dc1ba9d8.jpg?alt=media&token=5b15c44f-2495-44ad-8def-8c96dee6cd92");
                    break;

                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/dinajpur-polytechnicinstitute.appspot.com/o/Home%2F71f4f21edd37941681afbfb837ba14d3.jpg?alt=media&token=8463b750-d5a2-4aeb-850f-e7ae52a093d8");
                    break;

            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);

        }
    }
}