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

public final class ActivityHumidityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Guideline guideline34;

  @NonNull
  public final Guideline guideline35;

  @NonNull
  public final Guideline guideline36;

  @NonNull
  public final Guideline guideline37;

  @NonNull
  public final Guideline guideline38;

  @NonNull
  public final Guideline guideline39;

  @NonNull
  public final TextView humidity1;

  @NonNull
  public final TextView humidity2;

  @NonNull
  public final TextView humidity3;

  @NonNull
  public final TextView humidity4;

  @NonNull
  public final Button humidityBackButton;

  @NonNull
  public final Button humidityRefreshButton;

  @NonNull
  public final ImageView imageView7;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView17;

  @NonNull
  public final TextView textView18;

  private ActivityHumidityBinding(@NonNull ConstraintLayout rootView,
      @NonNull Guideline guideline34, @NonNull Guideline guideline35,
      @NonNull Guideline guideline36, @NonNull Guideline guideline37,
      @NonNull Guideline guideline38, @NonNull Guideline guideline39, @NonNull TextView humidity1,
      @NonNull TextView humidity2, @NonNull TextView humidity3, @NonNull TextView humidity4,
      @NonNull Button humidityBackButton, @NonNull Button humidityRefreshButton,
      @NonNull ImageView imageView7, @NonNull TextView textView15, @NonNull TextView textView16,
      @NonNull TextView textView17, @NonNull TextView textView18) {
    this.rootView = rootView;
    this.guideline34 = guideline34;
    this.guideline35 = guideline35;
    this.guideline36 = guideline36;
    this.guideline37 = guideline37;
    this.guideline38 = guideline38;
    this.guideline39 = guideline39;
    this.humidity1 = humidity1;
    this.humidity2 = humidity2;
    this.humidity3 = humidity3;
    this.humidity4 = humidity4;
    this.humidityBackButton = humidityBackButton;
    this.humidityRefreshButton = humidityRefreshButton;
    this.imageView7 = imageView7;
    this.textView15 = textView15;
    this.textView16 = textView16;
    this.textView17 = textView17;
    this.textView18 = textView18;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHumidityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHumidityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_humidity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHumidityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.guideline34;
      Guideline guideline34 = ViewBindings.findChildViewById(rootView, id);
      if (guideline34 == null) {
        break missingId;
      }

      id = R.id.guideline35;
      Guideline guideline35 = ViewBindings.findChildViewById(rootView, id);
      if (guideline35 == null) {
        break missingId;
      }

      id = R.id.guideline36;
      Guideline guideline36 = ViewBindings.findChildViewById(rootView, id);
      if (guideline36 == null) {
        break missingId;
      }

      id = R.id.guideline37;
      Guideline guideline37 = ViewBindings.findChildViewById(rootView, id);
      if (guideline37 == null) {
        break missingId;
      }

      id = R.id.guideline38;
      Guideline guideline38 = ViewBindings.findChildViewById(rootView, id);
      if (guideline38 == null) {
        break missingId;
      }

      id = R.id.guideline39;
      Guideline guideline39 = ViewBindings.findChildViewById(rootView, id);
      if (guideline39 == null) {
        break missingId;
      }

      id = R.id.humidity1;
      TextView humidity1 = ViewBindings.findChildViewById(rootView, id);
      if (humidity1 == null) {
        break missingId;
      }

      id = R.id.humidity2;
      TextView humidity2 = ViewBindings.findChildViewById(rootView, id);
      if (humidity2 == null) {
        break missingId;
      }

      id = R.id.humidity3;
      TextView humidity3 = ViewBindings.findChildViewById(rootView, id);
      if (humidity3 == null) {
        break missingId;
      }

      id = R.id.humidity4;
      TextView humidity4 = ViewBindings.findChildViewById(rootView, id);
      if (humidity4 == null) {
        break missingId;
      }

      id = R.id.humidity_back_button;
      Button humidityBackButton = ViewBindings.findChildViewById(rootView, id);
      if (humidityBackButton == null) {
        break missingId;
      }

      id = R.id.humidity_refresh_button;
      Button humidityRefreshButton = ViewBindings.findChildViewById(rootView, id);
      if (humidityRefreshButton == null) {
        break missingId;
      }

      id = R.id.imageView7;
      ImageView imageView7 = ViewBindings.findChildViewById(rootView, id);
      if (imageView7 == null) {
        break missingId;
      }

      id = R.id.textView15;
      TextView textView15 = ViewBindings.findChildViewById(rootView, id);
      if (textView15 == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView17;
      TextView textView17 = ViewBindings.findChildViewById(rootView, id);
      if (textView17 == null) {
        break missingId;
      }

      id = R.id.textView18;
      TextView textView18 = ViewBindings.findChildViewById(rootView, id);
      if (textView18 == null) {
        break missingId;
      }

      return new ActivityHumidityBinding((ConstraintLayout) rootView, guideline34, guideline35,
          guideline36, guideline37, guideline38, guideline39, humidity1, humidity2, humidity3,
          humidity4, humidityBackButton, humidityRefreshButton, imageView7, textView15, textView16,
          textView17, textView18);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
