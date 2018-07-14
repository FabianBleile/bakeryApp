package com.fabianbleile.bakeryapp.Activity;

import a.bakewithfun1.Fragment.StepFragment;
import a.bakewithfun1.Fragment.StepFragment.OnImageClickListener;
import a.bakewithfun1.utils.JsonUtils;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;

public class StepActivity
  extends AppCompatActivity
  implements StepFragment.OnImageClickListener
{
  private static final String TAG = StepActivity.class.getSimpleName();
  public static final long serialVersionUID = -1774857016786507337L;
  public String[] mData;
  public int mDataLength;
  public String mDescription;
  public String mId;
  public String mShortDescription;
  public int mStepNumber;
  public int recipeId;
  public String[] stepObject;
  public String thumbnailUrl;
  public String videoUrl;
  
  public StepActivity() {}
  
  StepActivity(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}
  
  private void parseStepObject(String[] paramArrayOfString, StepFragment paramStepFragment)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("parseStepObject.([Ljava/lang/String;La/bakewithfun1/Fragment/StepFragment;)V", new Object[] { this, paramArrayOfString, paramStepFragment });
      return;
    }
    this.mId = paramArrayOfString[0];
    this.mShortDescription = paramArrayOfString[1];
    this.mDescription = paramArrayOfString[2];
    this.videoUrl = paramArrayOfString[3];
    this.thumbnailUrl = paramArrayOfString[4];
    paramStepFragment.setmId(this.mId, this.recipeId);
    paramStepFragment.setmShortDescription(this.mShortDescription);
    paramStepFragment.setmDescription(this.mDescription);
    paramStepFragment.setVideoUrl(this.videoUrl);
    paramStepFragment.setThumbnailUrl(this.thumbnailUrl);
    paramStepFragment.setmStepCount(this.mDataLength);
    setTitle(this.mShortDescription);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = $change;
    if (localObject != null)
    {
      ((IncrementalChange)localObject).access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2131296285);
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SharedPreferences: ");
    localStringBuilder.append(MainActivity.sharedpreferences.getString("recipesStringKey", "null"));
    Log.i((String)localObject, localStringBuilder.toString());
    if (paramBundle == null)
    {
      paramBundle = new StepFragment();
      localObject = getIntent();
      this.mData = ((Intent)localObject).getStringArrayExtra("data");
      this.mDataLength = this.mData.length;
      this.mStepNumber = ((Intent)localObject).getIntExtra("adapterPosition", 0);
      this.recipeId = ((Intent)localObject).getIntExtra("recipeId", 0);
      this.stepObject = JsonUtils.splitStepDetail(this.mData[this.mStepNumber], getBaseContext());
      parseStepObject(this.stepObject, paramBundle);
      getSupportFragmentManager().beginTransaction().add(2131165332, paramBundle).commit();
    }
  }
  
  public void onNextSelected(int paramInt)
  {
    Object localObject = $change;
    if (localObject != null)
    {
      ((IncrementalChange)localObject).access$dispatch("onNextSelected.(I)V", new Object[] { this, new Integer(paramInt) });
      return;
    }
    localObject = new StepFragment();
    this.stepObject = JsonUtils.splitStepDetail(this.mData[paramInt], getBaseContext());
    parseStepObject(this.stepObject, (StepFragment)localObject);
    getSupportFragmentManager().beginTransaction().replace(2131165332, (Fragment)localObject).commit();
  }
  
  public void onPreviousSelected(int paramInt)
  {
    Object localObject = $change;
    if (localObject != null)
    {
      ((IncrementalChange)localObject).access$dispatch("onPreviousSelected.(I)V", new Object[] { this, new Integer(paramInt) });
      return;
    }
    if (paramInt == -1)
    {
      finish();
      return;
    }
    localObject = new StepFragment();
    this.stepObject = JsonUtils.splitStepDetail(this.mData[paramInt], getBaseContext());
    parseStepObject(this.stepObject, (StepFragment)localObject);
    getSupportFragmentManager().beginTransaction().replace(2131165332, (Fragment)localObject).commit();
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_9_apk-dex2jar.jar!\a\bakewithfun1\Activity\StepActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */