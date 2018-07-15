package com.fabianbleile.bakeryapp;

import com.fabianbleile.bakeryapp.Activity.MainActivity;
import com.fabianbleile.bakeryapp.Object.IngredientsObject.Ingredient;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class IngredientsWidget
  extends AppWidgetProvider
{
  private static final int DEFAULT_RECIPEID = 0;
  public static String EXTRA_INGREDIENT = "com.fabianbleile.bakeryapp.widget.INGREDIENT";
  private static String ingredientsListserializedJson;
  public static List<IngredientsObject.Ingredient> mAllIngredientList = new ArrayList();
  public static List<IngredientsObject.Ingredient> mCurrentRecipeIngredients = new ArrayList();
  private static String mCurrentRecipeName;
  private static int realRecipeId = 0;
  public static final long serialVersionUID = -6733568050697504734L;
  
  public IngredientsWidget() {}
  
  IngredientsWidget(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
  {
    this();
  }
  
  public static boolean deserialize()
  {
    Object localObject = $change;
    if (localObject != null) {
      return ((Boolean)((IncrementalChange)localObject).access$dispatch("deserialize.()Z", new Object[0])).booleanValue();
    }
    localObject = new TypeToken()
    {
      public static final long serialVersionUID = -3499182682589970240L;
    }.getType();
    try
    {
      if (ingredientsListserializedJson.isEmpty()) {
        if (ingredientsListserializedJson == null) {
          break label101;
        }
      }
      mAllIngredientList = (List)new Gson().fromJson(ingredientsListserializedJson, (Type)localObject);
      Log.d("widget", "deserialized succesfully");
      return true;
    }
    catch (Throwable localThrowable)
    {
      Log.e("widget", "deserialized not possible");
      return false;
    }
    label101:
    return false;
  }
  
  public static void setmCurrentRecipeIngredients(List<IngredientsObject.Ingredient> paramList)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setmCurrentRecipeIngredients.(Ljava/util/List;)V", new Object[] { paramList });
      return;
    }
    mCurrentRecipeIngredients = paramList;
  }
  
  public static void setmCurrentRecipeName(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setmCurrentRecipeName.(Ljava/lang/String;)V", new Object[] { paramString });
      return;
    }
    mCurrentRecipeName = paramString;
  }
  
  public static void splitAllIngredientsToGetCurrentRecipeIngredients()
  {
    Object localObject1 = $change;
    int m = 0;
    if (localObject1 != null)
    {
      ((IncrementalChange)localObject1).access$dispatch("splitAllIngredientsToGetCurrentRecipeIngredients.()V", new Object[0]);
      return;
    }
    localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" in fori AllIngredientList ");
    ((StringBuilder)localObject2).append(mAllIngredientList.size());
    Log.i("realRecipeId", ((StringBuilder)localObject2).toString());
    int i = 0;
    int k = -1;
    int j = 0;
    while (j < mAllIngredientList.size())
    {
      localObject2 = (IngredientsObject.Ingredient)mAllIngredientList.get(j);
      int n = ((IngredientsObject.Ingredient)localObject2).getRecipeId() - 1;
      if (n != k)
      {
        i = 1;
        localArrayList1.add(Integer.valueOf(1));
        localArrayList2.add(((IngredientsObject.Ingredient)localObject2).getRecipeName());
      }
      else
      {
        i += 1;
        localArrayList1.set(n, Integer.valueOf(i));
      }
      k = n;
      j += 1;
    }
    i = 0;
    j = m;
    while (j < realRecipeId)
    {
      i += ((Integer)localArrayList1.get(j)).intValue();
      j += 1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(localArrayList1);
    Log.i("realRecipeId", ((StringBuilder)localObject2).toString());
    k = ((Integer)localArrayList1.get(realRecipeId)).intValue();
    j = i;
    while (j < k + i)
    {
      ((List)localObject1).add((IngredientsObject.Ingredient)mAllIngredientList.get(j));
      j += 1;
    }
    setmCurrentRecipeName((String)localArrayList2.get(realRecipeId));
    setmCurrentRecipeIngredients((List)localObject1);
  }
  
  public static void updateAppWidget(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt)
  {
    Object localObject1 = $change;
    if (localObject1 != null)
    {
      ((IncrementalChange)localObject1).access$dispatch("updateAppWidget.(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;I)V", new Object[] { paramContext, paramAppWidgetManager, new Integer(paramInt) });
      return;
    }
    Object localObject2 = paramContext.getString(2131427360);
    localObject1 = new RemoteViews(paramContext.getPackageName(), 2131296291);
    boolean bool = deserialize();
    if (bool)
    {
      splitAllIngredientsToGetCurrentRecipeIngredients();
      ((RemoteViews)localObject1).setTextViewText(2131165214, mCurrentRecipeName);
    }
    else
    {
      ((RemoteViews)localObject1).setTextViewText(2131165214, (CharSequence)localObject2);
    }
    ((RemoteViews)localObject1).setImageViewResource(2131165354, 2131099759);
    ((RemoteViews)localObject1).setImageViewResource(2131165352, 2131099756);
    localObject2 = new Intent(paramContext, WidgetService.class);
    ((Intent)localObject2).putExtra("appWidgetId", paramInt);
    ((Intent)localObject2).setData(Uri.parse(((Intent)localObject2).toUri(1)));
    if (bool) {
      ((RemoteViews)localObject1).setRemoteAdapter(paramInt, 2131165270, (Intent)localObject2);
    }
    ((RemoteViews)localObject1).setPendingIntentTemplate(2131165354, PendingIntent.getActivity(paramContext, 0, new Intent(paramContext, MainActivity.class), 134217728));
    paramAppWidgetManager.updateAppWidget(paramInt, (RemoteViews)localObject1);
  }
  
  public void onDisabled(Context paramContext)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onDisabled.(Landroid/content/Context;)V", new Object[] { this, paramContext });
      return;
    }
  }
  
  public void onEnabled(Context paramContext)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onEnabled.(Landroid/content/Context;)V", new Object[] { this, paramContext });
      return;
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    IncrementalChange localIncrementalChange = $change;
    int i = 0;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onUpdate.(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", new Object[] { this, paramContext, paramAppWidgetManager, paramArrayOfInt });
      return;
    }
    ingredientsListserializedJson = MainActivity.sharedpreferences.getString("recipesStringKey", "null");
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      updateAppWidget(paramContext, paramAppWidgetManager, paramArrayOfInt[i]);
      i += 1;
    }
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_8_apk-dex2jar.jar!\a\bakewithfun1\IngredientsWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */