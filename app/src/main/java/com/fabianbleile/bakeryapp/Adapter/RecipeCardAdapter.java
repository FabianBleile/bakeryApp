package com.fabianbleile.bakeryapp.Adapter;

import com.fabianbleile.bakeryapp.Object.RecipeObject;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;

public class RecipeCardAdapter
  extends RecyclerView.Adapter<RecipeCardAdapterViewHolder>
{
  public static final long serialVersionUID = -6798004214048662374L;
  private final RecipeAdapterOnClickHandler mClickHandler;
  public Context mContext;
  public List<RecipeObject> mRecipeObjects;
  
  public RecipeCardAdapter(Context paramContext, RecipeAdapterOnClickHandler paramRecipeAdapterOnClickHandler)
  {
    this.mClickHandler = paramRecipeAdapterOnClickHandler;
    this.mContext = paramContext;
  }
  
  RecipeCardAdapter(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
  {
    this((Context)paramArrayOfObject[2], (RecipeAdapterOnClickHandler)paramArrayOfObject[3]);
  }
  
  private int getRecipeImageResource(int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getRecipeImageResource.(I)I", new Object[] { this, new Integer(paramInt) })).intValue();
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 3: 
      return 2131099733;
    case 2: 
      return 2131099761;
    case 1: 
      return 2131099732;
    }
    return 2131099755;
  }
  
  public int getItemCount()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getItemCount.()I", new Object[] { this })).intValue();
    }
    if (this.mRecipeObjects == null) {
      return 0;
    }
    return this.mRecipeObjects.size();
  }
  
  public void onBindViewHolder(RecipeCardAdapterViewHolder paramRecipeCardAdapterViewHolder, int paramInt)
  {
    Object localObject = $change;
    if (localObject != null)
    {
      ((IncrementalChange)localObject).access$dispatch("onBindViewHolder.(La/bakewithfun1/Adapter/RecipeCardAdapter$RecipeCardAdapterViewHolder;I)V", new Object[] { this, paramRecipeCardAdapterViewHolder, new Integer(paramInt) });
      return;
    }
    localObject = ((RecipeObject)this.mRecipeObjects.get(paramInt)).getName();
    paramRecipeCardAdapterViewHolder.mRecipeName.setText((CharSequence)localObject);
    Picasso.with(this.mContext).load(getRecipeImageResource(paramInt)).into(paramRecipeCardAdapterViewHolder.mRecipeImage);
  }
  
  public RecipeCardAdapterViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (RecipeCardAdapterViewHolder)localIncrementalChange.access$dispatch("onCreateViewHolder.(Landroid/view/ViewGroup;I)La/bakewithfun1/Adapter/RecipeCardAdapter$RecipeCardAdapterViewHolder;", new Object[] { this, paramViewGroup, new Integer(paramInt) });
    }
    return new RecipeCardAdapterViewHolder(LayoutInflater.from(this.mContext).inflate(2131296308, paramViewGroup, false));
  }
  
  public void setData(List<RecipeObject> paramList)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setData.(Ljava/util/List;)V", new Object[] { this, paramList });
      return;
    }
    this.mRecipeObjects = paramList;
    notifyDataSetChanged();
  }
  
  public static abstract interface RecipeAdapterOnClickHandler
  {
    public abstract void onClick(RecipeObject paramRecipeObject);
  }
  
  public class RecipeCardAdapterViewHolder
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    public static final long serialVersionUID = 6809970077870928824L;
    public final ImageView mRecipeImage;
    public final TextView mRecipeName;
    
    public RecipeCardAdapterViewHolder(View paramView)
    {
      super();
      this.mRecipeName = ((TextView)paramView.findViewById(2131165300));
      this.mRecipeImage = ((ImageView)paramView.findViewById(2131165298));
      paramView.setOnClickListener(this);
    }
    
    RecipeCardAdapterViewHolder(InstantReloadException paramInstantReloadException)
    {
      super();
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
      paramView = (RecipeObject)RecipeCardAdapter.this.mRecipeObjects.get(i);
      RecipeCardAdapter.access$000(RecipeCardAdapter.this).onClick(paramView);
    }
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_9_apk-dex2jar.jar!\a\bakewithfun1\Adapter\RecipeCardAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */