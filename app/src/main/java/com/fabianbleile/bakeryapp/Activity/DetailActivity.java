package com.fabianbleile.bakeryapp.Activity;

import a.bakewithfun1.Object.RecipeObject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;

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
  
  DetailActivity(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}
  
  private void closeOnError(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("closeOnError.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    finish();
  }
  
  public static int getmId()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getmId.()I", new Object[0])).intValue();
    }
    return mId;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2131296283);
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


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_9_apk-dex2jar.jar!\a\bakewithfun1\Activity\DetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */