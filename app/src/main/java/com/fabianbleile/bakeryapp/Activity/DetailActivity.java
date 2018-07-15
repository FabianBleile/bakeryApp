package com.fabianbleile.bakeryapp.Activity;

import com.fabianbleile.bakeryapp.Object.RecipeObject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;
import com.fabianbleile.bakeryapp.R;

public class DetailActivity
  extends AppCompatActivity
{
  private static final int INGREDIENTS = 0;
  private static final int STEPS = 1;
  private static final String TAG = DetailActivity.class.getSimpleName();
  public static int mId = 0;
  public static String mIngredients;
  public static String mName;
  public static String mSteps;
  public static final long serialVersionUID = -2292382022989214589L;
  
  public DetailActivity() {}
  
  private void closeOnError(String paramString)
  {
    finish();
  }
  
  public static int getmId()
  {
    return mId;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_detail);
    paramBundle = getIntent();
    if (paramBundle == null) {
      closeOnError("intent");
    }
    paramBundle = (RecipeObject)paramBundle.getParcelableExtra("RecipeObject");
    mIngredients = paramBundle.getIngredients();
    mSteps = paramBundle.getSteps();
    mName = paramBundle.getName();
    mId = paramBundle.getId();
    setTitle(mName);
  }
}