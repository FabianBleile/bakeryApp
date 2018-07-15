package com.fabianbleile.bakeryapp.Activity;

import com.fabianbleile.bakeryapp.Fragment.StepFragment;
import com.fabianbleile.bakeryapp.Fragment.StepFragment.OnImageClickListener;
import com.fabianbleile.bakeryapp.R;
import com.fabianbleile.bakeryapp.utils.JsonUtils;
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
  
  private void parseStepObject(String[] paramArrayOfString, StepFragment paramStepFragment)
  {
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
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_step);

    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SharedPreferences: ");
    localStringBuilder.append(MainActivity.sharedpreferences.getString("recipesStringKey", "null"));
    Log.i((String)TAG, localStringBuilder.toString());
    if (paramBundle == null)
    {
      paramBundle = new StepFragment();
      Intent intent = getIntent();
      this.mData = ((Intent)intent).getStringArrayExtra("data");
      this.mDataLength = this.mData.length;
      this.mStepNumber = ((Intent)intent).getIntExtra("adapterPosition", 0);
      this.recipeId = ((Intent)intent).getIntExtra("recipeId", 0);
      this.stepObject = JsonUtils.splitStepDetail(this.mData[this.mStepNumber], getBaseContext());
      parseStepObject(this.stepObject, paramBundle);
      getSupportFragmentManager().beginTransaction().add(2131165332, paramBundle).commit();
    }
  }
  
  public void onNextSelected(int paramInt)
  {
    Fragment fragment = new StepFragment();
    this.stepObject = JsonUtils.splitStepDetail(this.mData[paramInt], getBaseContext());
    parseStepObject(this.stepObject, (StepFragment)fragment);
    getSupportFragmentManager().beginTransaction().replace(2131165332, (Fragment)fragment).commit();
  }
  
  public void onPreviousSelected(int paramInt)
  {
    if (paramInt == -1)
    {
      finish();
      return;
    }
    Fragment fragment = new StepFragment();
    this.stepObject = JsonUtils.splitStepDetail(this.mData[paramInt], getBaseContext());
    parseStepObject(this.stepObject, (StepFragment)fragment);
    getSupportFragmentManager().beginTransaction().replace(2131165332, (Fragment)fragment).commit();
  }
}