package com.fabianbleile.bakeryapp.utils;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils
{
  private static final String RECIPE_BASE_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
  private static final String TAG = NetworkUtils.class.getSimpleName();
  public static final long serialVersionUID = -6257143524046623802L;
  
  public NetworkUtils() {}
  
  NetworkUtils(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}
  
  public static URL buildUrl()
  {
    Object localObject1 = $change;
    if (localObject1 != null) {
      return (URL)((IncrementalChange)localObject1).access$dispatch("buildUrl.()Ljava/net/URL;", new Object[0]);
    }
    Object localObject2 = Uri.parse("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json").buildUpon().build();
    localObject1 = null;
    try
    {
      localObject2 = new URL(((Uri)localObject2).toString());
      localObject1 = localObject2;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Built URI ");
    localStringBuilder.append(localObject1);
    Log.v(str, localStringBuilder.toString());
    return (URL)localObject1;
  }
  
  public static final Uri buildVideoUri(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (Uri)localIncrementalChange.access$dispatch("buildVideoUri.(Ljava/lang/String;)Landroid/net/Uri;", new Object[] { paramString });
    }
    return Uri.parse(paramString).buildUpon().build();
  }
  
  public static String getResponseFromHttpUrl(URL paramURL)
    throws IOException
  {
    Object localObject1 = $change;
    if (localObject1 != null) {
      return (String)((IncrementalChange)localObject1).access$dispatch("getResponseFromHttpUrl.(Ljava/net/URL;)Ljava/lang/String;", new Object[] { paramURL });
    }
    paramURL = (HttpURLConnection)paramURL.openConnection();
    try
    {
      localObject1 = new Scanner(paramURL.getInputStream());
      ((Scanner)localObject1).useDelimiter("\\A");
      if (((Scanner)localObject1).hasNext())
      {
        localObject1 = ((Scanner)localObject1).next();
        return (String)localObject1;
      }
      return null;
    }
    finally
    {
      paramURL.disconnect();
    }
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_5_apk-dex2jar.jar!\a\bakewithfun1\utils\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */