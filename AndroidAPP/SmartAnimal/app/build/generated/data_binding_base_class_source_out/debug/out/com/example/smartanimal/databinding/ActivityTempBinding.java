// Generated by view binder compiler. Do not edit!
package com.example.smartanimal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.smartanimal.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTempBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Guideline guideline28;

  @NonNull
  public final Guideline guideline29;

  @NonNull
  public final Guideline guideline30;

  @NonNull
  public final Guideline guideline31;

  @NonNull
  public final Guideline guideline32;

  @NonNull
  public final Guideline guideline33;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final TextView temp1;

  @NonNull
  public final TextView temp2;

  @NonNull
  public final TextView temp3;

  @NonNull
  public final TextView temp4;

  @NonNull
  public final Button tempBackButton;

  @NonNull
  public final Button tempRefreshButton;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  private ActivityTempBinding(@NonNull ConstraintLayout rootView, @NonNull Guideline guideline28,
      @NonNull Guideline guideline29, @NonNull Guideline guideline30,
      @NonNull Guideline guideline31, @NonNull Guideline guideline32,
      @NonNull Guideline guideline33, @NonNull ImageView imageView2, @NonNull TextView temp1,
      @NonNull TextView temp2, @NonNull TextView temp3, @NonNull TextView temp4,
      @NonNull Button tempBackButton, @NonNull Button tempRefreshButton,
      @NonNull TextView textView10, @NonNull TextView textView7, @NonNull TextView textView8,
      @NonNull TextView textView9) {
    this.rootView = rootView;
    this.guideline28 = guideline28;
    this.guideline29 = guideline29;
    this.guideline30 = guideline30;
    this.guideline31 = guideline31;
    this.guideline32 = guideline32;
    this.guideline33 = guideline33;
    this.imageView2 = imageView2;
    this.temp1 = temp1;
    this.temp2 = temp2;
    this.temp3 = temp3;
    this.temp4 = temp4;
    this.tempBackButton = tempBackButton;
    this.tempRefreshButton = tempRefreshButton;
    this.textView10 = textView10;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTempBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTempBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_temp, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTempBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.guideline28;
      Guideline guideline28 = ViewBindings.findChildViewById(rootView, id);
      if (guideline28 == null) {
        break missingId;
      }

      id = R.id.guideline29;
      Guideline guideline29 = ViewBindings.findChildViewById(rootView, id);
      if (guideline29 == null) {
        break missingId;
      }

      id = R.id.guideline30;
      Guideline guideline30 = ViewBindings.findChildViewById(rootView, id);
      if (guideline30 == null) {
        break missingId;
      }

      id = R.id.guideline31;
      Guideline guideline31 = ViewBindings.findChildViewById(rootView, id);
      if (guideline31 == null) {
        break missingId;
      }

      id = R.id.guideline32;
      Guideline guideline32 = ViewBindings.findChildViewById(rootView, id);
      if (guideline32 == null) {
        break missingId;
      }

      id = R.id.guideline33;
      Guideline guideline33 = ViewBindings.findChildViewById(rootView, id);
      if (guideline33 == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.temp1;
      TextView temp1 = ViewBindings.findChildViewById(rootView, id);
      if (temp1 == null) {
        break missingId;
      }

      id = R.id.temp2;
      TextView temp2 = ViewBindings.findChildViewById(rootView, id);
      if (temp2 == null) {
        break missingId;
      }

      id = R.id.temp3;
      TextView temp3 = ViewBindings.findChildViewById(rootView, id);
      if (temp3 == null) {
        break missingId;
      }

      id = R.id.temp4;
      TextView temp4 = ViewBindings.findChildViewById(rootView, id);
      if (temp4 == null) {
        break missingId;
      }

      id = R.id.temp_back_button;
      Button tempBackButton = ViewBindings.findChildViewById(rootView, id);
      if (tempBackButton == null) {
        break missingId;
      }

      id = R.id.temp_refresh_button;
      Button tempRefreshButton = ViewBindings.findChildViewById(rootView, id);
      if (tempRefreshButton == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityTempBinding((ConstraintLayout) rootView, guideline28, guideline29,
          guideline30, guideline31, guideline32, guideline33, imageView2, temp1, temp2, temp3,
          temp4, tempBackButton, tempRefreshButton, textView10, textView7, textView8, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
