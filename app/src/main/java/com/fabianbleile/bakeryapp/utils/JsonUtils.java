package a.bakewithfun1.utils;

import a.bakewithfun1.Object.IngredientsObject.Ingredient;
import a.bakewithfun1.Object.RecipeObject;
import android.content.Context;
import android.util.Log;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils
{
  private static final String TAG = JsonUtils.class.getSimpleName();
  public static final long serialVersionUID = 840615255173834865L;
  
  public JsonUtils() {}
  
  JsonUtils(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}
  
  public static RecipeObject convertToRecipeObject(String paramString)
  {
    Object localObject1 = $change;
    if (localObject1 != null) {
      return (RecipeObject)((IncrementalChange)localObject1).access$dispatch("convertToRecipeObject.(Ljava/lang/String;)La/bakewithfun1/Object/RecipeObject;", new Object[] { paramString });
    }
    int k = 0;
    String str4 = "";
    Object localObject3 = "";
    String str5 = "";
    int m = 0;
    String str3 = "";
    int j = k;
    localObject1 = str4;
    Object localObject2 = localObject3;
    String str1 = str5;
    int i = m;
    String str2 = str3;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      j = k;
      localObject1 = str4;
      localObject2 = localObject3;
      str1 = str5;
      i = m;
      str2 = str3;
      k = localJSONObject.getInt("id");
      j = k;
      localObject1 = str4;
      localObject2 = localObject3;
      str1 = str5;
      i = m;
      str2 = str3;
      str4 = localJSONObject.getString("name");
      j = k;
      localObject1 = str4;
      localObject2 = localObject3;
      str1 = str5;
      i = m;
      str2 = str3;
      m = localJSONObject.getInt("servings");
      j = k;
      localObject1 = str4;
      localObject2 = localObject3;
      str1 = str5;
      i = m;
      str2 = str3;
      str3 = localJSONObject.getString("image");
      j = k;
      localObject1 = str4;
      localObject2 = localObject3;
      str1 = str5;
      i = m;
      str2 = str3;
      localObject3 = localJSONObject.getString("ingredients");
      j = k;
      localObject1 = str4;
      localObject2 = localObject3;
      str1 = str5;
      i = m;
      str2 = str3;
      str5 = localJSONObject.getString("steps");
      j = k;
      localObject1 = str4;
      localObject2 = localObject3;
      str1 = str5;
      i = m;
      str2 = str3;
      Log.d(TAG, "convertedToRecipeObject successfully");
      j = k;
      localObject1 = str4;
      localObject2 = localObject3;
      str1 = str5;
      i = m;
      str2 = str3;
    }
    catch (Throwable localThrowable)
    {
      str4 = TAG;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Could not parse malformed JSON in convertToRecipeObject: \"");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("\"");
      Log.e(str4, ((StringBuilder)localObject3).toString());
      localThrowable.printStackTrace();
    }
    return new RecipeObject(j, (String)localObject1, (String)localObject2, str1, i, str2);
  }
  
  public static String extraxtShortDescription(String paramString)
  {
    Object localObject = $change;
    if (localObject != null) {
      return (String)((IncrementalChange)localObject).access$dispatch("extraxtShortDescription.(Ljava/lang/String;)Ljava/lang/String;", new Object[] { paramString });
    }
    localObject = "";
    try
    {
      String str1 = new JSONObject(paramString).getString("shortDescription");
      localObject = str1;
      Log.d(TAG, "extraxtShortDescription successfully");
      return str1;
    }
    catch (Throwable localThrowable)
    {
      String str2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not parse malformed JSON in extraxtShortDescription: \"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\"");
      Log.e(str2, localStringBuilder.toString());
      localThrowable.printStackTrace();
    }
    return (String)localObject;
  }
  
  public static List<String> getAllIngredients(String paramString)
  {
    Object localObject1 = $change;
    if (localObject1 != null) {
      return (List)((IncrementalChange)localObject1).access$dispatch("getAllIngredients.(Ljava/lang/String;)Ljava/util/List;", new Object[] { paramString });
    }
    localObject1 = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        if (localJSONArray.length() > 0)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localObject2 = localJSONArray.getJSONArray(i);
            int j = 0;
            if (j >= ((JSONArray)localObject2).length()) {
              break label177;
            }
            ((List)localObject1).add(((JSONArray)localObject2).getJSONObject(j).getString("ingredient"));
            j += 1;
            continue;
          }
        }
        Log.d(TAG, "splitted JSON succesfully");
        return (List<String>)localObject1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not parse malformed JSON in splitJson: \"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        Log.e((String)localObject2, localStringBuilder.toString());
        localThrowable.printStackTrace();
        return (List<String>)localObject1;
      }
      label177:
      i += 1;
    }
  }
  
  public static List<IngredientsObject.Ingredient> parseResponseToIngredientsObject(String paramString)
  {
    Object localObject1 = $change;
    if (localObject1 != null) {
      return (List)((IncrementalChange)localObject1).access$dispatch("parseResponseToIngredientsObject.(Ljava/lang/String;)Ljava/util/List;", new Object[] { paramString });
    }
    localObject1 = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        if (localJSONArray.length() > 0)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            localObject2 = localJSONArray.getJSONObject(i);
            int k = ((JSONObject)localObject2).getInt("id");
            str = ((JSONObject)localObject2).getString("name");
            localObject2 = ((JSONObject)localObject2).getJSONArray("ingredients");
            int j = 0;
            if (j >= ((JSONArray)localObject2).length()) {
              break label238;
            }
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
            ((List)localObject1).add(new IngredientsObject.Ingredient(k, str, localJSONObject.getString("quantity"), localJSONObject.getString("measure"), localJSONObject.getString("ingredient")));
            j += 1;
            continue;
          }
        }
        Log.d(TAG, "parsed StringResponse to IngredientsObject succesfully");
        return (List<IngredientsObject.Ingredient>)localObject1;
      }
      catch (Throwable localThrowable)
      {
        String str = TAG;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Could not parse malformed StringResponse to IngredientsObject getJson: \"");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("\"");
        Log.e(str, ((StringBuilder)localObject2).toString());
        localThrowable.printStackTrace();
        return (List<IngredientsObject.Ingredient>)localObject1;
      }
      label238:
      i += 1;
    }
  }
  
  public static String[] splitIngDetail(String paramString, Context paramContext)
  {
    Object localObject1 = $change;
    if (localObject1 != null) {
      return (String[])((IncrementalChange)localObject1).access$dispatch("splitIngDetail.(Ljava/lang/String;Landroid/content/Context;)[Ljava/lang/String;", new Object[] { paramString, paramContext });
    }
    String str1 = "";
    String str2 = "";
    Object localObject3 = "";
    paramContext = str1;
    localObject1 = str2;
    Object localObject2 = localObject3;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramContext = str1;
      localObject1 = str2;
      localObject2 = localObject3;
      str1 = localJSONObject.getString("quantity");
      paramContext = str1;
      localObject1 = str2;
      localObject2 = localObject3;
      str2 = localJSONObject.getString("measure");
      paramContext = str1;
      localObject1 = str2;
      localObject2 = localObject3;
      localObject3 = localJSONObject.getString("ingredient");
      paramContext = str1;
      localObject1 = str2;
      localObject2 = localObject3;
      Log.d(TAG, "splitIngDetail successfully");
      paramContext = str1;
      localObject1 = str2;
      localObject2 = localObject3;
    }
    catch (Throwable localThrowable)
    {
      str2 = TAG;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Could not parse malformed JSON in splitIngDetail: \"");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("\"");
      Log.e(str2, ((StringBuilder)localObject3).toString());
      localThrowable.printStackTrace();
    }
    return new String[] { localObject2, paramContext, localObject1 };
  }
  
  public static String[] splitIngredients(String paramString, int paramInt)
  {
    Object localObject1 = $change;
    int i = 0;
    if (localObject1 != null) {
      return (String[])((IncrementalChange)localObject1).access$dispatch("splitIngredients.(Ljava/lang/String;I)[Ljava/lang/String;", new Object[] { paramString, new Integer(paramInt) });
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localObject2 = new JSONArray(paramString);
        if (((JSONArray)localObject2).length() > 0) {
          if (i < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(i);
            localObject1 = null;
          }
        }
        switch (paramInt)
        {
        case 1: 
          localObject1 = ((JSONObject)localObject3).getString("ingredient");
          break;
        case 0: 
          localObject1 = ((JSONObject)localObject3).toString();
          localArrayList.add(localObject1);
          i += 1;
          continue;
          Log.d(TAG, "splitted Ingredients succesfully");
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = TAG;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Could not parse malformed JSON in splitIngredients: \"");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append("\"");
        Log.e((String)localObject2, ((StringBuilder)localObject3).toString());
        localThrowable.printStackTrace();
      }
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
  }
  
  public static String[] splitJson(String paramString)
  {
    Object localObject = $change;
    int i = 0;
    if (localObject != null) {
      return (String[])((IncrementalChange)localObject).access$dispatch("splitJson.(Ljava/lang/String;)[Ljava/lang/String;", new Object[] { paramString });
    }
    localObject = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      if (localJSONArray.length() > 0) {
        while (i < localJSONArray.length())
        {
          ((List)localObject).add(localJSONArray.getJSONObject(i).toString());
          i += 1;
        }
      }
      Log.d(TAG, "splitted JSON succesfully");
    }
    catch (Throwable localThrowable)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not parse malformed JSON in splitJson: \"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\"");
      Log.e(str, localStringBuilder.toString());
      localThrowable.printStackTrace();
    }
    return (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
  }
  
  public static String[] splitStepDetail(String paramString, Context paramContext)
  {
    Object localObject1 = $change;
    if (localObject1 != null) {
      return (String[])((IncrementalChange)localObject1).access$dispatch("splitStepDetail.(Ljava/lang/String;Landroid/content/Context;)[Ljava/lang/String;", new Object[] { paramString, paramContext });
    }
    Object localObject5 = "";
    String str2 = "";
    Object localObject2 = "";
    localObject1 = "";
    Object localObject3 = localObject5;
    String str1 = str2;
    Object localObject4 = localObject2;
    paramContext = (Context)localObject1;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject3 = localObject5;
      str1 = str2;
      localObject4 = localObject2;
      paramContext = (Context)localObject1;
      localObject5 = localJSONObject.getString("id");
      localObject3 = localObject5;
      str1 = str2;
      localObject4 = localObject2;
      paramContext = (Context)localObject1;
      str2 = localJSONObject.getString("shortDescription");
      localObject3 = localObject5;
      str1 = str2;
      localObject4 = localObject2;
      paramContext = (Context)localObject1;
      String str3 = localJSONObject.getString("description");
      localObject2 = localObject1;
      localObject3 = localObject5;
      str1 = str2;
      localObject4 = str3;
      paramContext = (Context)localObject1;
      StringBuilder localStringBuilder;
      if (!localJSONObject.getString("videoURL").isEmpty())
      {
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject1;
        localObject2 = localJSONObject.getString("videoURL");
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject2;
        localObject1 = TAG;
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject2;
        localStringBuilder = new StringBuilder();
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject2;
        localStringBuilder.append("Parsed videoURL: \"");
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject2;
        localStringBuilder.append(localJSONObject.getString("videoURL"));
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject2;
        localStringBuilder.append("\"");
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject2;
        Log.e((String)localObject1, localStringBuilder.toString());
      }
      localObject1 = localObject2;
      localObject3 = localObject5;
      str1 = str2;
      localObject4 = str3;
      paramContext = (Context)localObject2;
      if (!localJSONObject.getString("thumbnailURL").isEmpty())
      {
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject2;
        localObject1 = localJSONObject.getString("thumbnailURL");
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject1;
        localObject2 = TAG;
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject1;
        localStringBuilder = new StringBuilder();
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject1;
        localStringBuilder.append("Parsed thumbnailURL: \"");
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject1;
        localStringBuilder.append(localJSONObject.getString("thumbnailURL"));
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject1;
        localStringBuilder.append("\"");
        localObject3 = localObject5;
        str1 = str2;
        localObject4 = str3;
        paramContext = (Context)localObject1;
        Log.e((String)localObject2, localStringBuilder.toString());
      }
      localObject3 = localObject5;
      str1 = str2;
      localObject4 = str3;
      paramContext = (Context)localObject1;
      Log.d(TAG, "splitStepDetail successfully");
      localObject3 = localObject5;
      str1 = str2;
      localObject4 = str3;
      paramContext = (Context)localObject1;
    }
    catch (Throwable localThrowable)
    {
      localObject2 = TAG;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("Could not parse malformed JSON in splitStepDetail: \"");
      ((StringBuilder)localObject5).append(paramString);
      ((StringBuilder)localObject5).append("\"");
      Log.e((String)localObject2, ((StringBuilder)localObject5).toString());
      localThrowable.printStackTrace();
    }
    return new String[] { localObject3, str1, localObject4, paramContext, "" };
  }
  
  public static String[] splitSteps(String paramString)
  {
    Object localObject = $change;
    int i = 0;
    if (localObject != null) {
      return (String[])((IncrementalChange)localObject).access$dispatch("splitSteps.(Ljava/lang/String;)[Ljava/lang/String;", new Object[] { paramString });
    }
    localObject = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      if (localJSONArray.length() > 0) {
        while (i < localJSONArray.length())
        {
          ((List)localObject).add(localJSONArray.getJSONObject(i).toString());
          i += 1;
        }
      }
      Log.d(TAG, "splitted Steps succesfully");
    }
    catch (Throwable localThrowable)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not parse malformed JSON in splitSteps: \"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\"");
      Log.e(str, localStringBuilder.toString());
      localThrowable.printStackTrace();
    }
    return (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_5_apk-dex2jar.jar!\a\bakewithfun1\utils\JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */