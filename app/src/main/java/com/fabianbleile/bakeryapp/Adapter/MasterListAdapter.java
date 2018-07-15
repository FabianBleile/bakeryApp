package com.fabianbleile.bakeryapp.Adapter;

import com.fabianbleile.bakeryapp.utils.JsonUtils;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;

public class MasterListAdapter
  extends RecyclerView.Adapter<MasterListAdapterViewHolder>
{
  private static final int INGREDIENTS = 0;
  private static final int STEPS = 1;
  public static final long serialVersionUID = 1739572618461670132L;
  private final MasterListAdapterOnClickHandler mClickHandler;
  private Context mContext;
  private String[] mData;
  public LayoutInflater mInflater;
  public int matchIngSteps;
  
  public MasterListAdapter(Context paramContext, String[] paramArrayOfString, int paramInt, MasterListAdapterOnClickHandler paramMasterListAdapterOnClickHandler)
  {
    this.mContext = paramContext;
    this.mData = paramArrayOfString;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.matchIngSteps = paramInt;
    this.mClickHandler = paramMasterListAdapterOnClickHandler;
  }
  
  MasterListAdapter(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
  {
    this((Context)paramArrayOfObject[2], (String[])paramArrayOfObject[3], ((Number)paramArrayOfObject[4]).intValue(), (MasterListAdapterOnClickHandler)paramArrayOfObject[5]);
  }
  
  public int getItemCount()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getItemCount.()I", new Object[] { this })).intValue();
    }
    return this.mData.length;
  }
  
  public void onBindViewHolder(MasterListAdapterViewHolder paramMasterListAdapterViewHolder, int paramInt)
  {
    Object localObject = $change;
    if (localObject != null)
    {
      ((IncrementalChange)localObject).access$dispatch("onBindViewHolder.(La/bakewithfun1/Adapter/MasterListAdapter$MasterListAdapterViewHolder;I)V", new Object[] { this, paramMasterListAdapterViewHolder, new Integer(paramInt) });
      return;
    }
    switch (this.matchIngSteps)
    {
    default: 
      return;
    case 1: 
      if (paramInt != 0)
      {
        paramMasterListAdapterViewHolder = paramMasterListAdapterViewHolder.mIngredientsOrStep_tv;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(".  ");
        ((StringBuilder)localObject).append(JsonUtils.extraxtShortDescription(this.mData[paramInt]));
        paramMasterListAdapterViewHolder.setText(((StringBuilder)localObject).toString());
        return;
      }
      paramMasterListAdapterViewHolder.mIngredientsOrStep_tv.setText(JsonUtils.extraxtShortDescription(this.mData[paramInt]));
      return;
    }
    paramMasterListAdapterViewHolder.mIngredientsOrStep_tv.setText(JsonUtils.splitIngDetail(this.mData[paramInt], this.mContext)[0]);
    paramMasterListAdapterViewHolder.mQuantity_tv.setText(JsonUtils.splitIngDetail(this.mData[paramInt], this.mContext)[1]);
    paramMasterListAdapterViewHolder.mMeasure_tv.setText(JsonUtils.splitIngDetail(this.mData[paramInt], this.mContext)[2]);
  }
  
  public MasterListAdapterViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (MasterListAdapterViewHolder)localIncrementalChange.access$dispatch("onCreateViewHolder.(Landroid/view/ViewGroup;I)La/bakewithfun1/Adapter/MasterListAdapter$MasterListAdapterViewHolder;", new Object[] { this, paramViewGroup, new Integer(paramInt) });
    }
    paramInt = 2131296290;
    switch (this.matchIngSteps)
    {
    default: 
      break;
    case 1: 
      paramInt = 2131296312;
      break;
    case 0: 
      paramInt = 2131296290;
    }
    return new MasterListAdapterViewHolder(LayoutInflater.from(this.mContext).inflate(paramInt, paramViewGroup, false));
  }
  
  public void setData(String[] paramArrayOfString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setData.([Ljava/lang/String;)V", new Object[] { this, paramArrayOfString });
      return;
    }
    this.mData = paramArrayOfString;
    notifyDataSetChanged();
  }
  
  public static abstract interface MasterListAdapterOnClickHandler
  {
    public abstract void onClick(String[] paramArrayOfString, int paramInt1, int paramInt2);
  }
  
  public class MasterListAdapterViewHolder
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    public static final long serialVersionUID = 3114715021188168962L;
    public final TextView mIngredientsOrStep_tv;
    public final TextView mMeasure_tv;
    public final TextView mQuantity_tv;
    
    public MasterListAdapterViewHolder(View paramView)
    {
      super();
      this.mIngredientsOrStep_tv = ((TextView)paramView.findViewById(2131165269));
      this.mMeasure_tv = ((TextView)paramView.findViewById(2131165279));
      this.mQuantity_tv = ((TextView)paramView.findViewById(2131165295));
      paramView.setOnClickListener(this);
    }
    
    MasterListAdapterViewHolder(InstantReloadException paramInstantReloadException)
    {
      this((View)MasterListAdapter.this[3]);
    }
    
    public void onClick(View paramView)
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null)
      {
        localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramView });
        return;
      }
      int i = getAdapterPosition();
      MasterListAdapter.access$100(MasterListAdapter.this).onClick(MasterListAdapter.access$000(MasterListAdapter.this), MasterListAdapter.this.matchIngSteps, i);
    }
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_9_apk-dex2jar.jar!\a\bakewithfun1\Adapter\MasterListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */