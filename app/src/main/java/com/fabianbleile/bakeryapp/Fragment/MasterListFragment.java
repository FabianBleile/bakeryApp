package com.fabianbleile.bakeryapp.Fragment;

import com.fabianbleile.bakeryapp.Activity.DetailActivity;
import com.fabianbleile.bakeryapp.Activity.MainActivity;
import com.fabianbleile.bakeryapp.Activity.StepActivity;
import com.fabianbleile.bakeryapp.Adapter.MasterListAdapter;
import com.fabianbleile.bakeryapp.Adapter.MasterListAdapter.MasterListAdapterOnClickHandler;
import com.fabianbleile.bakeryapp.utils.JsonUtils;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;

public class MasterListFragment
  extends Fragment
  implements MasterListAdapter.MasterListAdapterOnClickHandler
{
  private static final int INGREDIENTS = 0;
  private static final int STEPS = 1;
  private static final String TAG = MasterListFragment.class.getSimpleName();
  public static final long serialVersionUID = 4489416512190927640L;
  public MasterListAdapter mIngAdapter;
  public LinearLayoutManager mIngLLM;
  public RecyclerView mIngRecyclerView;
  public String mIngredients;
  public MasterListAdapter mStepAdapter;
  public LinearLayoutManager mStepLLM;
  public RecyclerView mStepRecyclerView;
  public String mSteps;
  public int matchIngSteps;
  
  public MasterListFragment() {}
  
  MasterListFragment(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
  {
    this();
  }
  
  public void onClick(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    Object localObject = $change;
    if (localObject != null)
    {
      ((IncrementalChange)localObject).access$dispatch("onClick.([Ljava/lang/String;II)V", new Object[] { this, paramArrayOfString, new Integer(paramInt1), new Integer(paramInt2) });
      return;
    }
    if (paramInt1 == 1)
    {
      localObject = new Intent(getContext(), StepActivity.class);
      ((Intent)localObject).putExtra("data", paramArrayOfString);
      ((Intent)localObject).putExtra("adapterPosition", paramInt2);
      ((Intent)localObject).putExtra("recipeId", DetailActivity.getmId());
      startActivity((Intent)localObject);
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (View)localIncrementalChange.access$dispatch("onCreateView.(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", new Object[] { this, paramLayoutInflater, paramViewGroup, paramBundle });
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2131296288, paramViewGroup, false);
    this.mIngRecyclerView = ((RecyclerView)paramLayoutInflater.findViewById(2131165267));
    this.mIngLLM = new LinearLayoutManager(getContext(), 1, false);
    this.mIngRecyclerView.setLayoutManager(this.mIngLLM);
    this.mIngRecyclerView.setHasFixedSize(true);
    setmIngredients(MainActivity.getmIngredients());
    paramViewGroup = JsonUtils.splitIngredients(this.mIngredients, 0);
    this.mIngAdapter = new MasterListAdapter(getContext(), paramViewGroup, 0, this);
    this.mIngRecyclerView.setAdapter(this.mIngAdapter);
    this.mStepRecyclerView = ((RecyclerView)paramLayoutInflater.findViewById(2131165335));
    this.mStepLLM = new LinearLayoutManager(getContext(), 0, false);
    this.mStepRecyclerView.setLayoutManager(this.mStepLLM);
    this.mStepRecyclerView.setHasFixedSize(true);
    setmSteps(MainActivity.getmSteps());
    paramViewGroup = JsonUtils.splitSteps(this.mSteps);
    this.mStepAdapter = new MasterListAdapter(getContext(), paramViewGroup, 1, this);
    this.mStepRecyclerView.setAdapter(this.mStepAdapter);
    return paramLayoutInflater;
  }
  
  public void setMatchIngSteps(int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setMatchIngSteps.(I)V", new Object[] { this, new Integer(paramInt) });
      return;
    }
    this.matchIngSteps = paramInt;
  }
  
  public void setmIngredients(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setmIngredients.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    this.mIngredients = paramString;
  }
  
  public void setmSteps(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setmSteps.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    this.mSteps = paramString;
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_4_apk-dex2jar.jar!\a\bakewithfun1\Fragment\MasterListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */