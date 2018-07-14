package a.bakewithfun1.Object;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;

public class RecipeObject
  implements Parcelable
{
  public static final Parcelable.Creator<RecipeObject> CREATOR = new Parcelable.Creator()
  {
    public static final long serialVersionUID = 8880735298791338398L;
    
    public RecipeObject createFromParcel(Parcel paramAnonymousParcel)
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null) {
        return (RecipeObject)localIncrementalChange.access$dispatch("createFromParcel.(Landroid/os/Parcel;)La/bakewithfun1/Object/RecipeObject;", new Object[] { this, paramAnonymousParcel });
      }
      return new RecipeObject(paramAnonymousParcel);
    }
    
    public RecipeObject[] newArray(int paramAnonymousInt)
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null) {
        return (RecipeObject[])localIncrementalChange.access$dispatch("newArray.(I)[La/bakewithfun1/Object/RecipeObject;", new Object[] { this, new Integer(paramAnonymousInt) });
      }
      return new RecipeObject[paramAnonymousInt];
    }
  };
  public static final long serialVersionUID = -1283632262134743242L;
  public int id;
  public String image;
  public String ingredients;
  public String name;
  public int servings;
  public String steps;
  
  public RecipeObject(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    this.id = paramInt1;
    this.name = paramString1;
    this.ingredients = paramString2;
    this.steps = paramString3;
    this.servings = paramInt2;
    this.image = paramString4;
  }
  
  public RecipeObject(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.servings = paramParcel.readInt();
    this.image = paramParcel.readString();
    this.ingredients = paramParcel.readString();
    this.steps = paramParcel.readString();
  }
  
  RecipeObject(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}
  
  public int describeContents()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("describeContents.()I", new Object[] { this })).intValue();
    }
    return 0;
  }
  
  public int getId()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getId.()I", new Object[] { this })).intValue();
    }
    return this.id;
  }
  
  public String getImage()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (String)localIncrementalChange.access$dispatch("getImage.()Ljava/lang/String;", new Object[] { this });
    }
    return this.image;
  }
  
  public String getIngredients()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (String)localIncrementalChange.access$dispatch("getIngredients.()Ljava/lang/String;", new Object[] { this });
    }
    return this.ingredients;
  }
  
  public String getName()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (String)localIncrementalChange.access$dispatch("getName.()Ljava/lang/String;", new Object[] { this });
    }
    return this.name;
  }
  
  public int getServings()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return ((Number)localIncrementalChange.access$dispatch("getServings.()I", new Object[] { this })).intValue();
    }
    return this.servings;
  }
  
  public String getSteps()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (String)localIncrementalChange.access$dispatch("getSteps.()Ljava/lang/String;", new Object[] { this });
    }
    return this.steps;
  }
  
  public void setId(int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setId.(I)V", new Object[] { this, new Integer(paramInt) });
      return;
    }
    this.id = paramInt;
  }
  
  public void setImage(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setImage.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    this.image = paramString;
  }
  
  public void setIngredients(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setIngredients.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    this.ingredients = paramString;
  }
  
  public void setName(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setName.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    this.name = paramString;
  }
  
  public void setServings(int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setServings.(I)V", new Object[] { this, new Integer(paramInt) });
      return;
    }
    this.servings = paramInt;
  }
  
  public void setSteps(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setSteps.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    this.steps = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("writeToParcel.(Landroid/os/Parcel;I)V", new Object[] { this, paramParcel, new Integer(paramInt) });
      return;
    }
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.servings);
    paramParcel.writeString(this.image);
    paramParcel.writeString(this.ingredients.toString());
    paramParcel.writeString(this.steps.toString());
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_7_apk-dex2jar.jar!\a\bakewithfun1\Object\RecipeObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */