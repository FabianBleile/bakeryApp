package a.bakewithfun1;

import a.bakewithfun1.Object.IngredientsObject.Ingredient;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;
import java.util.List;

public class IngredientViewsFactory
  implements RemoteViewsService.RemoteViewsFactory
{
  private static List<IngredientsObject.Ingredient> mIngredientList = IngredientsWidget.mCurrentRecipeIngredients;
  public static final long serialVersionUID = 5301393528768029421L;
  private int appWidgetId;
  private Context context;
  
  public IngredientViewsFactory(Context paramContext, Intent paramIntent)
  {
    this.context = null;
    this.context = paramContext;
    this.appWidgetId = paramIntent.getIntExtra("appWidgetId", 0);
  }
  
  IngredientViewsFactory(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}
  
  public int getCount()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getCount.()I", new Object[] { this })).intValue();
    }
    return mIngredientList.size();
  }
  
  public long getItemId(int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getItemId.(I)J", new Object[] { this, new Integer(paramInt) })).longValue();
    }
    return paramInt;
  }
  
  public RemoteViews getLoadingView()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (RemoteViews)localIncrementalChange.access$dispatch("getLoadingView.()Landroid/widget/RemoteViews;", new Object[] { this });
    }
    return null;
  }
  
  public RemoteViews getViewAt(int paramInt)
  {
    Object localObject = $change;
    if (localObject != null) {
      return (RemoteViews)((IncrementalChange)localObject).access$dispatch("getViewAt.(I)Landroid/widget/RemoteViews;", new Object[] { this, new Integer(paramInt) });
    }
    localObject = new RemoteViews(this.context.getPackageName(), 2131296292);
    String str = ((IngredientsObject.Ingredient)mIngredientList.get(paramInt)).getIngredient();
    ((RemoteViews)localObject).setTextViewText(16908308, str);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString(IngredientsWidget.EXTRA_INGREDIENT, str);
    localIntent.putExtras(localBundle);
    ((RemoteViews)localObject).setOnClickFillInIntent(16908308, localIntent);
    return (RemoteViews)localObject;
  }
  
  public int getViewTypeCount()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getViewTypeCount.()I", new Object[] { this })).intValue();
    }
    return 1;
  }
  
  public boolean hasStableIds()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Boolean)localIncrementalChange.access$dispatch("hasStableIds.()Z", new Object[] { this })).booleanValue();
    }
    return true;
  }
  
  public void onCreate()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onCreate.()V", new Object[] { this });
      return;
    }
  }
  
  public void onDataSetChanged()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onDataSetChanged.()V", new Object[] { this });
      return;
    }
  }
  
  public void onDestroy()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onDestroy.()V", new Object[] { this });
      return;
    }
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_8_apk-dex2jar.jar!\a\bakewithfun1\IngredientViewsFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */