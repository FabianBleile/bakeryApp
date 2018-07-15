package com.fabianbleile.bakeryapp.Activity;

import com.fabianbleile.bakeryapp.Adapter.RecipeCardAdapter;
import com.fabianbleile.bakeryapp.Adapter.RecipeCardAdapter.RecipeAdapterOnClickHandler;
import com.fabianbleile.bakeryapp.IngredientsWidget;
import com.fabianbleile.bakeryapp.Object.RecipeObject;
import com.fabianbleile.bakeryapp.R;
import com.fabianbleile.bakeryapp.utils.JsonUtils;
import com.fabianbleile.bakeryapp.utils.NetworkUtils;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
  
  public static String getmIngredients()
  {
    return mIngredients;
  }
  
  public static String getmSteps()
  {
    return mSteps;
  }
  
  private void updateWidget()
  {
    Intent intent = new Intent(this, IngredientsWidget.class);
    ((Intent)intent).setAction("android.appwidget.action.APPWIDGET_UPDATE");
    ((Intent)intent).putExtra("appWidgetIds", AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), IngredientsWidget.class)));
    sendBroadcast((Intent)intent);
  }
  
  public void onClick(RecipeObject paramRecipeObject)
  {
    mIngredients = paramRecipeObject.getIngredients();
    mSteps = paramRecipeObject.getSteps();
    Intent intent = new Intent(this, DetailActivity.class);
    ((Intent)intent).putExtra("RecipeObject", paramRecipeObject);
    startActivity((Intent)intent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_main);
    this.mRecyclerView = ((RecyclerView)findViewById(R.id.recipe_recycler_view));
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
    this.mAdapter = new RecipeCardAdapter(this, this);
    this.mRecyclerView.setLayoutManager(linearLayoutManager);
    this.mRecyclerView.setHasFixedSize(true);
    this.mRecyclerView.setAdapter(mAdapter);
    this.mRecipeLoader = new LoaderManager.LoaderCallbacks()
    {
      public static final long serialVersionUID = -1639365154612919725L;
      
      public Loader<String[]> onCreateLoader(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        new AsyncTaskLoader(MainActivity.this)
        {
          public static final long serialVersionUID = 6024280350627036881L;
          public String[] mRecipeData = null;
          
          public void deliverResult(String[] paramAnonymous2ArrayOfString)
          {
            if (paramAnonymous2ArrayOfString != null)
            {
              this.mRecipeData = paramAnonymous2ArrayOfString;
              super.deliverResult(this.mRecipeData);
            }
          }
          
          public String[] loadInBackground()
          {
            try
            {
              String networkResponse = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl());
              Object localObject2 = JsonUtils.parseResponseToIngredientsObject((String)networkResponse);
              localObject2 = new Gson().toJson(localObject2);
              MainActivity.sharedpreferences = MainActivity.this.getSharedPreferences("MyPrefs", 0);
              SharedPreferences.Editor localEditor = MainActivity.sharedpreferences.edit();
              localEditor.putString("recipesStringKey", (String)localObject2);
              localEditor.apply();
              mRecipeData = JsonUtils.splitJson(networkResponse);
              return (String[]) mRecipeData;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            return null;
          }
          
          public void onStartLoading()
          {
            if (this.mRecipeData != null)
            {
              deliverResult(this.mRecipeData);
              return;
            }
            forceLoad();
          }
        };
      }

      @Override
      public void onLoadFinished(@NonNull Loader loader, Object o) {
        int i = 0;
        if (paramAnonymousArrayOfString != null)
        {
          paramAnonymousLoader = new ArrayList();
          while (i < paramAnonymousArrayOfString.length)
          {
            RecipeObject recipeObject = JsonUtils.convertToRecipeObject(paramAnonymousArrayOfString[i]);
            paramAnonymousLoader.add(recipeObject);
            JsonUtils.splitIngredients(((RecipeObject)recipeObject).getIngredients(), 1);
            i += 1;
          }
          MainActivity.this.mAdapter.setData(paramAnonymousLoader);
          MainActivity.access$000(MainActivity.this);
      }

      @Override
      public void onLoaderReset(@NonNull Loader loader) {

          getSupportLoaderManager().initLoader(1, null, this.mRecipeLoader);
      }
    }
  }
}