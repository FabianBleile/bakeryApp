package com.fabianbleile.bakeryapp.Object;

import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;
import java.util.ArrayList;
import java.util.List;

public class IngredientsObject
{
  public static final long serialVersionUID = -3111078837377570120L;
  public List<Ingredient> allRecipeIngredients = new ArrayList();
  
  public IngredientsObject(List<Ingredient> paramList)
  {
    this.allRecipeIngredients = paramList;
  }
  
  IngredientsObject(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
  {
    this((List)paramArrayOfObject[2]);
  }
  
  public static class Ingredient
  {
    public static final long serialVersionUID = 54566467132107937L;
    public String ingredient;
    public String measure;
    public String quantity;
    public int recipeId;
    public String recipeName;
    
    public Ingredient(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.recipeId = paramInt;
      this.quantity = paramString2;
      this.measure = paramString3;
      this.ingredient = paramString4;
      this.recipeName = paramString1;
    }
    
    Ingredient(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}
    
    public String getIngredient()
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null) {
        return (String)localIncrementalChange.access$dispatch("getIngredient.()Ljava/lang/String;", new Object[] { this });
      }
      return this.ingredient;
    }
    
    public String getMeasure()
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null) {
        return (String)localIncrementalChange.access$dispatch("getMeasure.()Ljava/lang/String;", new Object[] { this });
      }
      return this.measure;
    }
    
    public String getQuantity()
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null) {
        return (String)localIncrementalChange.access$dispatch("getQuantity.()Ljava/lang/String;", new Object[] { this });
      }
      return this.quantity;
    }
    
    public int getRecipeId()
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null) {
        return ((Number)localIncrementalChange.access$dispatch("getRecipeId.()I", new Object[] { this })).intValue();
      }
      return this.recipeId;
    }
    
    public String getRecipeName()
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null) {
        return (String)localIncrementalChange.access$dispatch("getRecipeName.()Ljava/lang/String;", new Object[] { this });
      }
      return this.recipeName;
    }
  }
}