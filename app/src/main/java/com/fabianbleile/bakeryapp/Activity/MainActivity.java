package com.fabianbleile.bakeryapp.Activity;

import a.bakewithfun1.Adapter.RecipeCardAdapter;
import a.bakewithfun1.Adapter.RecipeCardAdapter.RecipeAdapterOnClickHandler;
import a.bakewithfun1.IngredientsWidget;
import a.bakewithfun1.Object.RecipeObject;
import a.bakewithfun1.utils.JsonUtils;
import a.bakewithfun1.utils.NetworkUtils;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;
import com.google.gson.Gson;
import java.util.ArrayList;

public class MainActivity
  extends AppCompatActivity
  implements RecipeCardAdapter.RecipeAdapterOnClickHandler
{
  public static final String MYPREFERENCES = "MyPrefs";
  public static final String RECIPES_STRING_KEY = "recipesStringKey";
  private static final int RECIPE_LOADER_ID = 1;
  private static final String TAG = MainActivity.class.getSimpleName();
  public static String mIngredients;
  public static String mSteps;
  public static final long serialVersionUID = -6713439992535851786L;
  public static SharedPreferences sharedpreferences;
  public RecipeCardAdapter mAdapter;
  private LoaderManager.LoaderCallbacks<String[]> mRecipeLoader;
  public RecyclerView mRecyclerView;
  
  public MainActivity() {}
  
  MainActivity(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}
  
  public static String getmIngredients()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (String)localIncrementalChange.access$dispatch("getmIngredients.()Ljava/lang/String;", new Object[0]);
    }
    return mIngredients;
  }
  
  public static String getmSteps()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (String)localIncrementalChange.access$dispatch("getmSteps.()Ljava/lang/String;", new Object[0]);
    }
    return mSteps;
  }
  
  private void updateWidget()
  {
    Object localObject = $change;
    if (localObject != null)
    {
      ((IncrementalChange)localObject).access$dispatch("updateWidget.()V", new Object[] { this });
      return;
    }
    localObject = new Intent(this, IngredientsWidget.class);
    ((Intent)localObject).setAction("android.appwidget.action.APPWIDGET_UPDATE");
    ((Intent)localObject).putExtra("appWidgetIds", AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), IngredientsWidget.class)));
    sendBroadcast((Intent)localObject);
  }
  
  public void onClick(RecipeObject paramRecipeObject)
  {
    Object localObject = $change;
    if (localObject != null)
    {
      ((IncrementalChange)localObject).access$dispatch("onClick.(La/bakewithfun1/Object/RecipeObject;)V", new Object[] { this, paramRecipeObject });
      return;
    }
    mIngredients = paramRecipeObject.getIngredients();
    mSteps = paramRecipeObject.getSteps();
    localObject = new Intent(this, DetailActivity.class);
    ((Intent)localObject).putExtra("RecipeObject", paramRecipeObject);
    startActivity((Intent)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2131296284);
    this.mRecyclerView = ((RecyclerView)findViewById(2131165299));
    paramBundle = new LinearLayoutManager(this, 1, false);
    this.mAdapter = new RecipeCardAdapter(this, this);
    this.mRecyclerView.setLayoutManager(paramBundle);
    this.mRecyclerView.setHasFixedSize(true);
    this.mRecyclerView.setAdapter(this.mAdapter);
    this.mRecipeLoader = new LoaderManager.LoaderCallbacks()
    {
      public static final long serialVersionUID = -1639365154612919725L;
      
      public Loader<String[]> onCreateLoader(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
          return (Loader)localIncrementalChange.access$dispatch("onCreateLoader.(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;", new Object[] { this, new Integer(paramAnonymousInt), paramAnonymousBundle });
        }
        new AsyncTaskLoader(MainActivity.this)
        {
          public static final long serialVersionUID = 6024280350627036881L;
          public String[] mRecipeData = null;
          
          public void deliverResult(String[] paramAnonymous2ArrayOfString)
          {
            IncrementalChange localIncrementalChange = $change;
            if (localIncrementalChange != null)
            {
              localIncrementalChange.access$dispatch("deliverResult.([Ljava/lang/String;)V", new Object[] { this, paramAnonymous2ArrayOfString });
              return;
            }
            if (paramAnonymous2ArrayOfString != null)
            {
              this.mRecipeData = paramAnonymous2ArrayOfString;
              super.deliverResult(this.mRecipeData);
            }
          }
          
          public String[] loadInBackground()
          {
            Object localObject1 = $change;
            if (localObject1 != null) {
              return (String[])((IncrementalChange)localObject1).access$dispatch("loadInBackground.()[Ljava/lang/String;", new Object[] { this });
            }
            try
            {
              localObject1 = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl());
              Object localObject2 = JsonUtils.parseResponseToIngredientsObject((String)localObject1);
              localObject2 = new Gson().toJson(localObject2);
              MainActivity.sharedpreferences = MainActivity.this.getSharedPreferences("MyPrefs", 0);
              SharedPreferences.Editor localEditor = MainActivity.sharedpreferences.edit();
              localEditor.putString("recipesStringKey", (String)localObject2);
              localEditor.apply();
              localObject1 = JsonUtils.splitJson((String)localObject1);
              return (String[])localObject1;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            return null;
          }
          
          public void onStartLoading()
          {
            IncrementalChange localIncrementalChange = $change;
            if (localIncrementalChange != null)
            {
              localIncrementalChange.access$dispatch("onStartLoading.()V", new Object[] { this });
              return;
            }
            if (this.mRecipeData != null)
            {
              deliverResult(this.mRecipeData);
              return;
            }
            forceLoad();
          }
        };
      }
      
      public void onLoadFinished(Loader<String[]> paramAnonymousLoader, String[] paramAnonymousArrayOfString)
      {
        Object localObject = $change;
        int i = 0;
        if (localObject != null)
        {
          ((IncrementalChange)localObject).access$dispatch("onLoadFinished.(Landroid/support/v4/content/Loader;[Ljava/lang/String;)V", new Object[] { this, paramAnonymousLoader, paramAnonymousArrayOfString });
          return;
        }
        if (paramAnonymousArrayOfString != null)
        {
          paramAnonymousLoader = new ArrayList();
          while (i < paramAnonymousArrayOfString.length)
          {
            localObject = JsonUtils.convertToRecipeObject(paramAnonymousArrayOfString[i]);
            paramAnonymousLoader.add(localObject);
            JsonUtils.splitIngredients(((RecipeObject)localObject).getIngredients(), 1);
            i += 1;
          }
          MainActivity.this.mAdapter.setData(paramAnonymousLoader);
          MainActivity.access$000(MainActivity.this);
        }
      }
      
      public void onLoaderReset(Loader<String[]> paramAnonymousLoader)
      {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null)
        {
          localIncrementalChange.access$dispatch("onLoaderReset.(Landroid/support/v4/content/Loader;)V", new Object[] { this, paramAnonymousLoader });
          return;
        }
      }
    };
    getSupportLoaderManager().initLoader(1, null, this.mRecipeLoader);
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_9_apk-dex2jar.jar!\a\bakewithfun1\Activity\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */